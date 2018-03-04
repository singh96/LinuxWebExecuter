package controllers;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;


@RestController
public class FileController {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void getTextFile(HttpServletResponse response,
                            @RequestParam("fileName") String fileName,
                            @RequestParam("pwd") String pwd) throws IOException {
        StringBuffer buffer = new StringBuffer();

        //When absolute path for file is provided
        if(fileName.charAt(0) == '/') {
            buffer.append(fileName);
        } else {
            buffer.append(pwd).append("/").append(fileName);
        }

        createFileStream(response, buffer.toString());
    }


    private void createFileStream(HttpServletResponse response, String fileNameWithPath) throws IOException {
        File file = null;
        file = new File(fileNameWithPath);

        if(!file.exists()){
            String errorMessage = "Error Ocuured, Plz check the path";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            //Using default file type
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
        response.setContentLength((int)file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}

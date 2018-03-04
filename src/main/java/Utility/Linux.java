package Utility;

import java.io.*;

public class Linux {

    private static Writer writer = null;
    private static final String PATH = "/home/kiit/";
    private static final String FILE_NAME = "test.sh";

    public String executeCommand(String pwd, String command) {
        try {
            createBashScript(pwd, command);
            return runScript();
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Error Occured";
        }
    }

    private void createBashScript(String pwd, String command) throws IOException {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(PATH + FILE_NAME), "utf-8"));
            writer.write("cd " + pwd + "\n");
            writer.append(command + "\n");
            writer.close();
    }


    private String runScript() throws IOException  {

        Process process = null;
        process = Runtime.getRuntime().exec(PATH + "./" + FILE_NAME);

        StringBuilder out = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line = null;
        while ((line = br.readLine()) != null){
                out.append(line).append("\n");
            }
        process.destroyForcibly();
        return out.toString();
    }
}

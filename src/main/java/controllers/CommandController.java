package controllers;

import Utility.Linux;
import dto.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class CommandController {

    private static final Logger logger = LogManager.getLogger(CommandController.class.getName());

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        System.out.println(logger.getName());
        logger.info("Processed request from homepage");
        return new ModelAndView("Home");
    }


    @RequestMapping(value = "/executeCommand", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Result getCommandResult(@RequestParam("pwd") String pwd,
                                   @RequestParam("command") String command) {


        // To handle change directory command because REST calls are stateless
        if (command.startsWith("cd")) {

            String arr[] = command.split(" ");

            if (arr[1].equals("..")) {
                pwd = pwd.substring(0, pwd.lastIndexOf('/'));
            }

            // For absolute path
            else if (arr[1].charAt(0) == '/') {
                pwd = arr[1];
            }

            // For Relative path
            else {
                pwd = pwd + "/" + command.split(" ")[1];
            }
        }

        //An extra check
        if (!pwd.startsWith("/home/kiit/share")) {
            return new Result("<h3 style='color:red;'>Permission denied \n " +
                    "Only files inside /home/kiit/share folder accessible, redirecting to /home/kiit/share </h3>",
                    "/home/kiit/share");
        }
        return new Result(new Linux().executeCommand(pwd, command), pwd);
    }
}
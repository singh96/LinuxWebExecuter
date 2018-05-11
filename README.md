# Linux Web Executer

This is a simple web interface to control a remote linux machine. This includes executing commands, pulling a file from a remote machine over internet.

### Prerequisites

  * An IDE for JAVA like IntellIj.
  * Apache Tomcat
  * Ngrok
  * Gradle
  
### Installing

* Download and install [IntelliJ](https://www.jetbrains.com/idea/)
* Download [Apache tomcat](http://tomcat.apache.org/download-80.cgi) and configure server in IntelliJ on port 8080.
* Download [Ngrok](https://ngrok.com/)
* Setup gradle on linux machine.

### Steps

* Clone and open the project in IntelliJ.
* Run the project using tomcat.
* Go to the ngrok downloaded directory and run **./ngrok http 8080**, you will get public URL. Use this url to access your linux system remotely.

## Built With

* [Spring MVC](https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management

## License

This project is licensed under the Apache License - see the [LICENSE.md](LICENSE.md) file for details.

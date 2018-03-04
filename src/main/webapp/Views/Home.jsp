<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Home</title>
    <script type="text/javascript" src="js/home.js"></script>
</head>

<body>

<div style="width: 100%;">
<br>
<a href="/linuxRemote/download?fileName=setupEnvironment.sh&pwd=/home/kiit/share" onclick="location.href='/linuxRemote/download?fileName=setup.out&pwd=/home/kiit/share';" target="_blank">Download Script to setup Environment</a>
<br/><br/>
</div>

<pre>PWD:  <p id="pwd">/home/kiit/share</p></pre>
<br/><br/>


<div style="width: 100%;">
    <div style="float:left; width: 70%">
        <form onSubmit="return getCommandResult()" >
            Command : <input type = "text" id = "comm"  required/>
            <input type = "submit" value="Execute" />
        </form>
    </div>


    <div style="float:right;">
        <form action="/linuxRemote/download" >
            File Path : <input type = "text" name = "fileName"  required/>
            <input type="submit" value="Download" />
            <input type="hidden" value="" id = "filePwd" name="pwd" />
            <script type="text/javascript">
                var elem = document.getElementById("filePwd");
                elem.value = document.getElementById("pwd").innerText;
            </script>
        </form>
    </div>
</div>
<br/>
<br/>
<pre id="result"/>
</body>
</html>

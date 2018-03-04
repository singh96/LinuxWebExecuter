


function exxecuteCommandUsingPostAJAX(comm, pwd) {
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var data = JSON.parse(this.responseText);
            document.getElementById("result").innerHTML = data['result'];
            document.getElementById("pwd").innerHTML = data['pwd'];
        }
    };
    xhttp.open("POST", "/linuxRemote/executeCommand", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("pwd=" + pwd + "&command=" + comm);
}


function getCommandResult() {
    var comm = document.getElementById("comm").value;
    var pwd = document.getElementById("pwd").innerText;
    exxecuteCommandUsingPostAJAX(comm, pwd);
    return false;
}
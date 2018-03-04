package dto;

public class Result {

    private String result;
    private String pwd;

    private Result() {

    }


    public Result(String result, String pwd) {
        this.result = result;
        this.pwd = pwd;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

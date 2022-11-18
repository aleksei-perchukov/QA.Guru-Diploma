package tests.api.archive;

public class LoginRequestPojoModel {
    private String state;
    private String consumer;
    private String host;
    private String email;
    private String password;
    private String captcha;
    private String captcha_type;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha_type() {
        return captcha_type;
    }

    public void setCaptcha_type(String captcha_type) {
        this.captcha_type = captcha_type;
    }
}

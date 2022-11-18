package tests.api.archive;

public class LoginResponsePojoModel {
    private String token, state, time, sign, utm_nooverride;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUtm_nooverride() {
        return utm_nooverride;
    }

    public void setUtm_nooverride(String utm_nooverride) {
        this.utm_nooverride = utm_nooverride;
    }
}

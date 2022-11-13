package api.model;

public class UserBodyRequestPojoModel {
    private String
            email,
            password,
            name,
            job;
    //E-mail
    public final String getEmail(){
        return email;
    }
    public final void setEmail(final String email) {
        this.email = email;
    }
    //Password
    public final String getPassword(){
        return password;
    }
    public final void setPassword(final String password) {
        this.password = password;
    }
    //Name
    public final String getName(){
        return name;
    }
    public final void setName(final String name) {
        this.name = name;
    }
    //Job
    public final String getJob(){
        return job;
    }
    public final void setJob(final String job) {
        this.job = job;
    }
}

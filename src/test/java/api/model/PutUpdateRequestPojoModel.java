package api.model;

public class PutUpdateRequestPojoModel {
    private String
            name,
            job;

    //Name
    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    //Job
    public final String getJob() {
        return job;
    }

    public final void setJob(final String job) {
        this.job = job;
    }
}

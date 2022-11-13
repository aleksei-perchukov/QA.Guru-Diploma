package api.model;
public class UserBodyResponsePojoModel {
    private String
            id,
            token,
            name,
            error,
            job,
            updatedAt;
    public data data;
    public support support;

    //ID
    public final String getId(){
        return id;
    }
    public final void setId(final String id) {
        this.id = id;
    }
    //Token
    public final String getToken(){
        return token;
    }
    public final void setToken(final String token) {
        this.token = token;
    }
    //Error
    public final String getError(){
        return error;
    }
    public final void setPassword(final String error) {
        this.error = error;
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
    public final void setJob(final String job) {this.job = job;}
    public final String getUpdatedAt(){
        return updatedAt;
    }
    public final void setUpdatedAt(final String updatedAt) {
        this.updatedAt = updatedAt;
    }




    public class data {
        private String id,
                name,
                year,
                color,
                pantone_value,
                updatedAt;

        //data.id
        public final String getId() {
            return id;
        }

        public final void setId(final String id) {
            this.id = id;
        }

        //data.name
        public final String getName() {
            return name;
        }

        public final void setName(final String name) {
            this.name = name;
        }

        //data.year
        public final String getYear() {
            return year;
        }

        public final void setYear(final String year) {
            this.year = year;
        }

        //data.color
        public final String getColor() {
            return color;
        }

        public final void setColor(final String color) {
            this.color = color;
        }

        //data.pantone_value
        public final String getPantone_value() {
            return pantone_value;
        }

        public final void setPantone_value(final String pantone_value) {
            this.pantone_value = pantone_value;
        }
        //updatedAt
        public final String getUpdatedAt() {
            return updatedAt;
        }
        public final void setUpdatedAt(final String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
    public class support {
        private String url,
                text;

        //Support.url
        public final String getUrl() {
            return url;
        }

        public final void setUrl(final String url) {
            this.url = url;
        }

        //Support.text
        public final String getText() {
            return text;
        }

        public final void setText(final String text) {
            this.text = text;
        }
    }
}

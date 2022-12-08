package tests.api.models;

import lombok.Data;

@Data
public class UserBodyResponsePojoModel {
    private String
            id,
            token,
            name,
            error,
            job,
            updatedAt;

    @lombok.Data
    public class Data {
        private String id,
                name,
                year,
                color,
                pantone_value,
                updatedAt;
    }
    Data data = new Data();

    @lombok.Data
    public class Support {
        private String url,
                text;
    }
    Support support = new Support();
}

package tests.api.models;

import lombok.Data;

@Data
public class UserBodyRequestPojoModel {
    private String
            email,
            password,
            name,
            job;
}


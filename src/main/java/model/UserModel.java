package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserModel {
    private String name;
    private String job;
}


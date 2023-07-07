package Builder;

import model.UserModel;

public class BuilderUser {

    public BuilderUser() {
    }

    public static UserModel userCreateBuilder(String name, String job) {
        return UserModel.builder()
                .name(name)
                .job(job)
                .build();

    }
}


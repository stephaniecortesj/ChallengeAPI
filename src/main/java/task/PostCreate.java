package task;

import Builder.BuilderUser;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;
@AllArgsConstructor
public class PostCreate implements Interaction {
    private final String name;
    private final String job;

    public static Performable createUserTask(String name, String job) {
        return instrumented(PostCreate.class, name, job);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(BuilderUser.userCreateBuilder(name, job)))
        );
        System.out.println(SerenityRest.lastResponse().body().asString());
    }


}

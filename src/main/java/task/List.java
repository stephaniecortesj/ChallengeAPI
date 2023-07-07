package task;

import interactions.GetLista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class List implements Task {
    public static Performable users(){
      return Tasks.instrumented(List.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetLista.usersExisting());
    }
}


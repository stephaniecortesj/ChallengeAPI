package task;

import interactions.GetLista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Listar implements Task {
    public static Performable usuarios(){
      return Tasks.instrumented(Listar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetLista.usuariosExistentes());
    }
}


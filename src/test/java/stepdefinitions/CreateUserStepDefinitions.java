package stepdefinitions;

import exceptions.GetFailedName;
import exceptions.GetFailedResponseCode;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import questions.ValidateName;
import questions.ValidateResponse;
import task.PostCreate;

import static exceptions.GetFailedName.FAILED_NAME;
import static exceptions.GetFailedResponseCode.FAILED_RESPONSE_CODE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CreateUserStepDefinitions {

    private final EnvironmentVariables environmentVariables;

    public CreateUserStepDefinitions(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @When("(.*) sends (.*) and (.*)$")
    public void createUser(String nameActor, String name, String job) {
        theActorCalled(nameActor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl"))).
                attemptsTo(PostCreate.createUserTask(name, job));
    }
    @Then("I get response code (.*)$")
    public void getResponseCode(Integer responseCode) {
        theActorInTheSpotlight().should(seeThat(ValidateResponse.byCode(responseCode))
                .orComplainWith(GetFailedResponseCode.class, FAILED_RESPONSE_CODE + responseCode));
    }
    @Then("valid that the user (.*) is created correctly")
    public void userCreatedCorrectly(String name) {
        theActorInTheSpotlight().should(seeThat(ValidateName.byName(name))
                .orComplainWith(GetFailedName.class, FAILED_NAME +name));
    }


}

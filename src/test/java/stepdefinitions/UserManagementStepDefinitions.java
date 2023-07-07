package stepdefinitions;

import exceptions.GetFailedName;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static exceptions.GetFailedName.FAILED_NAME;
import static exceptions.GetFailedStatus.FAILED_STATE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import exceptions.GetFailedStatus;
import questions.ValidateUser;
import questions.ValidateCode;
import task.List;

public class UserManagementStepDefinitions {


    private final EnvironmentVariables environmentVariables;

    public UserManagementStepDefinitions(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @When("^(.*) querying existing users$")
    public void makeInquiry(String nameActor) {
        theActorCalled(nameActor)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl"))).
                attemptsTo(List.users());
    }

    @Then("^I get the status (.*)$")
    public void validateStatus(int codeStatus) {
        theActorInTheSpotlight().should(seeThat(ValidateCode.byStatus(codeStatus))
                .orComplainWith(GetFailedStatus.class, FAILED_STATE +codeStatus));
    }

    @Then("^valid user list exists (.*)$")
    public void validateUser(String userName) {
        theActorInTheSpotlight().should(seeThat(ValidateUser.byName(userName))
                .orComplainWith(GetFailedName.class, FAILED_NAME +userName));
    }
}

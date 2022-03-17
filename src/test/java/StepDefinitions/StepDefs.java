package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logPageTest.BasePageTest;

public class StepDefs{
	
	BasePageTest bps = new BasePageTest();
	
	@Given("User is on login page TestAutomasi")
	public void user_is_on_login_page_test_automasi() {
		bps.createChromeDriver();
	}

	@When("User enter valid userName {string}")
	public void user_enter_valid_user_name(String string) {
		bps.enterUserName();
	}

	@And("User enter valid password {string}")
	public void user_enter_valid_password(String string) {
		bps.enterPassword();
	}

	@And("User click button Login")
	public void user_click_button_login() {
		bps.clk();
	}

	@Then("User redirected to dashboard")
	public void user_redirected_to_dashboard() {
		bps.verifLogSuccess();
		bps.quitChromeDriver();
	}

	@When("User enter invalid userName {string}")
	public void user_enter_invalid_user_name(String string) {
		bps.enterInvUserName();
	}

	@Then("User accept error message register {string}")
	public void user_accept_error_message_register(String string) {
		bps.errorNotRegis();
		bps.quitChromeDriver();
	}

	@When("User enter invalid password {string}")
	public void user_enter_invalid_password(String string) {
		bps.enterInvPassword();
	}

	@Then("User accept error message incorect password {string}")
	public void user_accept_error_message_incorect_password(String string) {
		bps.errorMPassword();
		bps.quitChromeDriver();
	}

}

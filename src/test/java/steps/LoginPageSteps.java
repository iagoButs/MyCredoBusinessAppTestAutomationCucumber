package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    public LoginPage loginPage;
    public LoginPageSteps(){
        loginPage=new LoginPage();
    }
    @Given("user fills userInput {string}")
    public void fillUserName(String userName){
        loginPage.userNameInput.sendKeys(userName);
    }
    @Given("user fills passwordInputInput {string}")
    public void fillPasswordField(String password){
        loginPage.passwordInput.sendKeys(password);
    }
    @Then("flashMessage Text should be equals: {string}")
    public void assertFlashMessage(String text){
        Assert.assertEquals(loginPage.flashmessageText.getText(), text);
    }
    @Then("usernameField errorMessage should be: {string}")
    public LoginPageSteps assertUserNameErrorText(String text){
        Assert.assertEquals(loginPage.usernameErrorText.getText(), text);
        return this;
    }
    @Then("PasswordField errorMessage should be: {string}")
    public void assertPasswordErrorText(String text){
        Assert.assertEquals(loginPage.passwordErrorText.getText(), text);
    }

    @When("user Clicks into login Field")
    public LoginPageSteps clickIntoLoginField(){
        loginPage.userNameInput.click();
        return this;
    }
    @When("user Clicks into Password Field")
    public LoginPageSteps clickIntoPasswordField(){
        loginPage.passwordInput.click();
        return this;
    }

    @When("user Clicks Login Button")
    public LoginPageSteps clickLoginButton(){
        loginPage.LoginButton.click();
        return this;
    }

    @Given("user Clicks changeLanguage Buttons")
    public LoginPageSteps clickChangeLanguage(){
        loginPage.changeLanguageBtn.click();
        return this;
    }

    @Given("user Choose aplication language: {string}")
    public LoginPageSteps chooseLanguage(String language){
        switch (language){
            case "EN" -> {
                loginPage.enLanguageButton.click();
                loginPage.closeChooseLanguagePageButton.click();
            }
            case "KA" -> {
                loginPage.kaLanguageButton.click();
                loginPage.closeChooseLanguagePageButton.click();
            }
            case "RU" -> {
                loginPage.ruLanguageButton.click();
                loginPage.closeChooseLanguagePageButton.click();
            }
        }

        return this;
    }
}

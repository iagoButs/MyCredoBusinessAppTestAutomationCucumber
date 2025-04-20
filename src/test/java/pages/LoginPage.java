package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static utills.AppRunner.driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='changeLanguageButton']")
    public WebElement changeLanguageBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='enLanguageButton']")
    public WebElement enLanguageButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='kaLanguageButton']")
    public WebElement kaLanguageButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='ruLanguageButton']")
    public WebElement ruLanguageButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='closeButton']")
    public WebElement closeChooseLanguagePageButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='loginButton']")
    public WebElement LoginButton;
    @AndroidFindBy(id = "usernameInput")
    public WebElement userNameInput;
    @AndroidFindBy(id ="passwordInput")
    public WebElement passwordInput;
    @AndroidFindBy(id = "usernameErrorText")
    public WebElement usernameErrorText;
    @AndroidFindBy(id = "passwordErrorText")
    public WebElement passwordErrorText;
    @AndroidFindBy(id = "flashMessageText")
    public WebElement flashmessageText;

}

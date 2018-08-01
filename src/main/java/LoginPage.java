import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public LoginPage openLoginPage(){
        open("/");
        return this;
    }

    private SelenideElement userNameField = $("#UserName");
    private SelenideElement passwordField = $("#Password");
    private SelenideElement signInButton = $(byName("signin"));


    private void clickLoginButton(){
        signInButton.click();
    }

    private void setUserName(String userName){
        userNameField.setValue(userName);}

    private void setUserPassword(String userPassword){
        passwordField.setValue(userPassword);}

    public MainPage loginAs(String name, String password){
        setUserName(name);
        setUserPassword(password);
        clickLoginButton();
        return new MainPage();
    }

}

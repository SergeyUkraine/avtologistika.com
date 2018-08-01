import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DriverInfoPage {

    private SelenideElement lastNameField = $("#LastName");
    private SelenideElement firstNameField = $("#FirstName");
    private SelenideElement engLastNameField = $("#EnglishLastName");
    private SelenideElement engFirstNameField = $("#EnglishFirstName");
    private SelenideElement languageDropdown = $("#CultureId");
    private SelenideElement saveButton = $("#saveButton");

    private void setLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    private void setFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    private void setEnglishLastName(String englishLastName){
        engLastNameField.sendKeys(englishLastName);
    }

    private void setEnglishFirstName(String englishFirstName){
        engFirstNameField.sendKeys(englishFirstName);
    }

    private void selectLanguage(String language){
        languageDropdown.selectOptionContainingText(language);
    }

    private void clickSaveButton(){
        saveButton.click();
    }

    public DriversListPage setUserDataAndSaveIt(String lastName, String firstName, String engLastName, String engFirstName, String language){
        setLastName(lastName);
        setFirstName(firstName);
        setEnglishLastName(engLastName);
        setEnglishFirstName(engFirstName);
        selectLanguage(language);
        clickSaveButton();
        return new DriversListPage();
    }
}

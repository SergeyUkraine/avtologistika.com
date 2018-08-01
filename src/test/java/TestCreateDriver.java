import org.testng.annotations.Test;
import test.dataproviders.CreateDriverData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestCreateDriver extends BasicTestParameters{

    @Test(dataProvider = "validDriverData", dataProviderClass = CreateDriverData.class)
    public void testCanCreateDriver(String lastName, String firstName, String engLastName, String engFirstName, String language){

        //Create driver profile
        new LoginPage()
                .loginAs(login, password)
                .gotoDriversListPage()
                .gotoCreateDriverPage()
                .setUserDataAndSaveIt(lastName, firstName, engLastName, engFirstName, language)
                .searchDriver(lastName);

        //Check driver is created and added to the table via "search field"
        $$("tbody > tr").get(0).$$("tbody > tr > td").get(0).shouldHave(text(lastName));
        $$("tbody > tr").get(0).$$("tbody > tr > td").get(1).shouldHave(text(firstName));


        //Goto the driver profile page and check all saved data
        new DriversListPage()
                .openInfoPageOfFirstDriver();

        $("#LastName").shouldHave(value(lastName));
        $("#FirstName").shouldHave(value(firstName));
        $("#EnglishLastName").shouldHave(value(engLastName));
        $("#EnglishFirstName").shouldHave(value(engFirstName));
        $("#CultureId").shouldHave(text(language));

    }
}

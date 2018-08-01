import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement transportsDropdown = $(byXpath("//li[@class='dropdown']"));
    private SelenideElement driversItem = $(byLinkText("Drivers"));


    private void clickTransportDropdown(){
        transportsDropdown.click();
    }

    private void selectDriversItem(){
        driversItem.click();
    }

    public DriversListPage gotoDriversListPage(){
        clickTransportDropdown();
        selectDriversItem();
        return new DriversListPage();
    }
}

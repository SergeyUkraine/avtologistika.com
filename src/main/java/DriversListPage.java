import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DriversListPage {

    private SelenideElement createButton = $(byXpath("//div[@class='page-toolbar-actions']/div[1]/div/a"));
    private SelenideElement searchField = $("#searchText");
    private SelenideElement searchButton = $(byXpath("//div[@class='span12']/a[1]"));

    private void setSearchData(String searchData){
        searchField.setValue(searchData);
    }

    private void clickSearchButton(){
        searchButton.click();
    }

    private void clickOnFirstDriverName(){
        $$("tbody > tr").get(0).$$("tbody > tr > td").get(0).$("a").click();
    }

    public DriverInfoPage gotoCreateDriverPage(){
        createButton.click();
        return new DriverInfoPage();
    }

    public DriverInfoPage openInfoPageOfFirstDriver(){
        clickOnFirstDriverName();
        return new DriverInfoPage();
    }

    public DriversListPage searchDriver(String searchData){
        setSearchData(searchData);
        clickSearchButton();
        return this;
    }
}

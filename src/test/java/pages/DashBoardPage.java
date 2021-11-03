package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigReader;

public class DashBoardPage extends CommonMethods {
    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeBtn;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}

package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginTest extends CommonMethods {

    @Test(groups = "regression")
    public void  adminLogin(){
        LoginPage login = new LoginPage();
        sendText(login.usernamebox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordbox, ConfigReader.getPropertyValue("password"));
        click(login.loginBtn);

        //assertion
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
    }

    @DataProvider
    public Object[][] invalidData(){
       Object[][]data = {
            {"James","123!","Invalid credentials"},
            {"Admin1","Hum@nhrm123","Invalid credentials"},
            {"Admin","","Password cannot be empty"},
            {"","Hum@nhrm123","Username cannot be empty"}
        };
       return data;
    }
    @Test(dataProvider = "invalidData",groups="smoke")
    public void invalidLoginErrorMessageValidation(String username,String password){
        LoginPage loginPage= new LoginPage();
        loginPage.login(username, password);
    }

}

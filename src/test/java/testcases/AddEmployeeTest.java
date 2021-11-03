package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class AddEmployeeTest extends CommonMethods {

    @Test(groups = "smoke")
    public void addEmployee(){
        LoginPage loginpage = new LoginPage();
        loginpage.login(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));

        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.pimOption);
        click(dashBoardPage.addEmployeeBtn);

        //add employee page
        AddEmployeePage addEmployeePage= new AddEmployeePage();
        sendText(addEmployeePage.firtName, "test9123");
        sendText(addEmployeePage.middleName,"93240test");
        sendText(addEmployeePage.lastName,"test90weftest90");
        click(addEmployeePage.saveBtn);

        click(dashBoardPage.pimOption);
        click(dashBoardPage.addEmployeeBtn);


        List<WebElement> rowData = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));

        for(int i=0;i< rowData.size();i++){
            System.out.println("I am inside the loop ");
            String rowText= rowData.get(i).getText();
            System.out.println((rowText));
        }
    }
}

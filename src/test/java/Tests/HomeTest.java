package Tests;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTest extends TestsBase{

    HomePage page;
    SoftAssert softAssert = new SoftAssert();




    @Test
    public void Tc1() throws InterruptedException {

        page = new HomePage(driver);
        reportTest = report.createTest("Zamzam");

        Actions actions = new Actions(driver);

        WebElement footer = driver.findElement(By.cssSelector("footer[class=\"main_footer\"]"));
        actions.moveToElement(footer);
        actions.release().perform();


        WebElement searchArea = driver.findElement(By.cssSelector("section[class=\"innerbanner\"]"));
        actions.moveToElement(searchArea);
        actions.release().perform();

        page.chooseCity();
        page.chooseDate();
        page.chooseRoom();

        Select selectRoom = new Select (driver.findElement(By.xpath("//select[@id=\"roomCount\"]")));
        selectRoom.selectByVisibleText("2 Rooms");

        Select selectNationality = new Select (driver.findElement(By.xpath("//select[@id=\"searchNationality\"]")));
        selectNationality.selectByVisibleText("Egypt");

        page.search();

        page.booking();


        WebElement checkVisibility = driver.findElement(By.cssSelector("button[id=\"checkAvailabilityBtn\"]"));
        actions.moveToElement(checkVisibility);
        actions.release().perform();
        page.checkVisibility();



        System.out.println(page.getErrorMsg());
        reportTest.pass("the text is correctly pass");




        softAssert.assertAll();
    }
}

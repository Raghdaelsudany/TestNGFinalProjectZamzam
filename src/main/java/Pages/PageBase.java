package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void click(By Locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        WebElement element = driver.findElement(Locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void write(By Locator,String text){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        WebElement element = driver.findElement(Locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public String returnText(By Locator){
        return driver.findElement(Locator).getText();
    }

    public boolean returnVisibility(By Locator){
        return driver.findElement(Locator).isEnabled();
    }

    public void act(By Locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        WebElement element = driver.findElement(Locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }


}

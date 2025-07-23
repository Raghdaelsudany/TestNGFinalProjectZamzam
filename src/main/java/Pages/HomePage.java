package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private final By footerLocator = By.cssSelector("footer[class=\"main_footer\"]");
    private final By faceBookLocator = By.tagName("a[href=\"https://www.facebook.com/zamzamtrips\"]");
    private final By inputCityLocator = By.cssSelector("input[id=\"HotelCity\"]");
    private final By chooseCityLocator = By.cssSelector("ul[id=\"ui-id-1\"] li:nth-child(29) div");
    private final By calenderLocator = By.cssSelector("input[id=\"hotelStayDates\"]");
    private final By checkInLocator = By.cssSelector("div[class=\"flatpickr-calendar rangeMode animate multiMonth open arrowTop arrowCenter\"] div[class=\"flatpickr-innerContainer\"] div[class=\"flatpickr-days\"] div:nth-child(1) span:nth-child(21)");
    private final By checkOutLocator = By.cssSelector("div[class=\"flatpickr-calendar rangeMode animate multiMonth open arrowTop arrowCenter\"] div[class=\"flatpickr-innerContainer\"] div[class=\"flatpickr-days\"] div:nth-child(1) span:nth-child(28)");
    private final By chooseRoomLocator = By.cssSelector("input[id=\"paxAndRoomDetail\"]");
    private final By searchHotelLocator = By.cssSelector("button[id=\"searchBtn\"]");
    private final By bookLocator = By.cssSelector("button[id=\"bookBtn_1067450\"]");
    private final By checkVisibilityLocator = By.cssSelector("button[id=\"checkAvailabilityBtn\"]");
    private  final By errorMsgLocator = By.cssSelector("h5[class=\"pt-3 pb-3\"]");


    public void chooseCity(){
        click(inputCityLocator);
        click(chooseCityLocator);
    }

    public void chooseDate(){
        click(calenderLocator);
        click(checkInLocator);
        click(checkOutLocator);
    }

    public void chooseRoom(){
        click(chooseRoomLocator);
    }

    public void search(){
        click(searchHotelLocator);
    }

    public void booking() throws InterruptedException {
        Thread.sleep(1000);
        click(bookLocator);
    }

    public void checkVisibility() throws InterruptedException {
        Thread.sleep(2000);
        click(checkVisibilityLocator);
    }

    public String getErrorMsg(){
       return returnText(errorMsgLocator);
    }



}

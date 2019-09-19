package MavenHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.session.ChromeFilter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

    // Enter the Text
    public void enterText (By by, String text) {
        find(by).sendKeys(text);
    }
    // Get the Text
    public void getTextFromElement (By by) {
        find(by).getText();
    }
    // Clicking on Element
    public void clickOnElement (By by){
        find(by).click();
    }
    //Click on Element
    public static void waitForClickable (By by, long time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //Wait for Alert Message
    public static void waitForAlertPresent (long time) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //Wait for the element to load and become visible
    public static void waitForElementVisible (By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    //Generate random date and time in ddMMyyHHmmss format
    public static String randomDate () {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }
    //
    public static WebElement find (By by) {
        return driver.findElement(by);
    }
    //To Generate dynamic email
    public String generateEmail(){
        return "patel.mitesh20" + randomDate() + "@gmail.com";
    }
    //Extract Text from element
    public String extractText (By by) {
        return find(by).getText();
    }
    //Select by Visible Text from Dropdown menu
    public static void selectByVisibleText (By by, String text){
        Select select = new Select(find(by));
        select.selectByVisibleText(text);
    }
    //Select by Value from Dropdown Menu
    public static void selectByValue (By by, String value) {
        Select select = new Select(find(by));
        select.selectByValue(value);
        select.getFirstSelectedOption();
    }
    //Select by Index from Dropdown Menu
    public static void selectByIndex (By by, int index){
        Select select = new Select(find(by));
        select.selectByIndex(index);
    }
    //Get properties from from testdataConfig
    static Properties props;
    static FileInputStream inputStream;
    public String getProperty(String key) {
        props = new Properties();
        try {
            inputStream = new FileInputStream("src\\main\\Resources\\BrowserDriver\\testdataConfig.properties");
            props.load(inputStream);
            inputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }
    //Open Window in Fullscreen
    public void manageWindow (){
        driver.manage().window().fullscreen();
    }
    //Manage time out Implicity
    public void implicityWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //Open Chrome Browser
    public void openChrome () {
        driver = new ChromeDriver();}
    // Open NopCommerce Website
    public void openNopComm (){
        driver.get("https://demo.nopcommerce.com/");
    }
    //Generate Random Double Number
    public static double generateRandomNumber () {
        double x = Math.random();
        return x;
    }
    //Generate Random Float Number
    public static float generateRandomFloat () {
        Random random = new Random();
        return random.nextFloat();
    }
    // to generate Random Number in Date Format ddMMyy
    public static String getRandomNumberDate() {
        DateFormat format = new SimpleDateFormat("ddMMyy");
        return format.format(new Date());
    }
    //Get Attribute
    public static String getAttributeValue(By by,String text){
        return driver.findElement(by).getAttribute(text);
    }
    //Get Css Value
    public static String getCssValue(By by,String value){
        return driver.findElement(by).getCssValue(value);
    }
    // to wait
    public static void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try { Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace(); }
    }
}





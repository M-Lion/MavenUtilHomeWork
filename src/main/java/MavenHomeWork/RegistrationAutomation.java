package MavenHomeWork;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationAutomation extends Utils {

    @BeforeMethod

    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

        //Open the Browser
        openChrome();
        //Maximise the Browser window screen
        manageWindow();
        //Set implicity wait for driver object
        implicityWait();
        //Open the website
        openNopComm();
    }

    @Test(priority = 0)
    public void UserShouldBeAbleToRegisterSuccessfully(){

        //Click on Register Button
        clickOnElement(By.linkText("Register"));
        //Enter First Name
        enterText(By.id("FirstName"),getProperty("FirstName"));
        //Enter Last Name
        enterText(By.id("LastName"),getProperty("LastName"));
        //click Dropdown date from Dob
        clickOnElement(By.xpath("//div[@class = \"date-picker-wrapper\"]"));
        //select DATE from Dropdown
        clickOnElement(By.xpath("//option[@value = \"24\"]"));
        //click Dropdown MONTH from Dob
        clickOnElement(By.xpath("//select[@name = \"DateOfBirthMonth\"]"));
        //Select Month In Dropdown
        selectByIndex(By.xpath("//select[@name = \"DateOfBirthMonth\"]"),7);
        //Click Year Dropdown
        clickOnElement(By.xpath("//select[@name = \"DateOfBirthYear\"]"));
        //Select Year in Dropdown
        selectByValue(By.xpath("//select[@name = \"DateOfBirthYear\"]"),"1982");
        //Enter Email
        enterText(By.name("Email"),generateEmail());
        //Enter Password
        enterText(By.id("Password"),getProperty("Password"));
        //Enter Confirm Password
        enterText(By.xpath("//input[@data-val-equalto-other='*.Password']"),getProperty("ConfirmPassword"));
        //Click on Register
        clickOnElement(By.xpath("//input[@class='button-1 register-next-step-button']"));
        //Expected Result
        String expectedResults = ("Your registration completed");
        //Actual Result
        String actualResults = extractText(By.xpath("//div[@class='result']"));
        //Comparision between Actual Result and Expected Result
        Assert.assertEquals(actualResults,expectedResults);
    }

    @Test (priority = 1)
    public void UserShouldBeAbleToRefferAProductToFriend(){
        //Click on Register Button
        clickOnElement(By.linkText("Register"));
        //Enter First Name
        enterText(By.xpath("//input[@data-val-required='First name is required.']"),getProperty("FirstName"));
        //Enter Last Name
        enterText(By.id("LastName"),getProperty("LastName"));
        //click Dropdown date from Dob
        clickOnElement(By.xpath("//div[@class = \"date-picker-wrapper\"]"));
        //select DATE from Dropdown
        clickOnElement(By.xpath("//option[@value = \"24\"]"));
        //click Dropdown MONTH from Dob
        clickOnElement(By.xpath("//select[@name = \"DateOfBirthMonth\"]"));
        //Select Month In Dropdown
        selectByIndex(By.xpath("//select[@name = \"DateOfBirthMonth\"]"),7);
        //Click Year Dropdown
        clickOnElement(By.xpath("//select[@name = \"DateOfBirthYear\"]"));
        //Select Year in Dropdown
        selectByValue(By.xpath("//select[@name = \"DateOfBirthYear\"]"),"1982");
        //Enter Email
        enterText(By.name("Email"),generateEmail());
        //Enter Password
        enterText(By.id("Password"),getProperty("Password"));
        //Enter Confirm Password
        enterText(By.xpath("//input[@data-val-equalto-other='*.Password']"),getProperty("ConfirmPassword"));
        //Click on Register
        clickOnElement(By.xpath("//input[@class='button-1 register-next-step-button']"));
        //Back to Homepage
        clickOnElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        //Click on Macbook Pro 13 inch
        clickOnElement(By.xpath("//img[@alt='Picture of Apple MacBook Pro 13-inch']"));
        //Click on Email a Friend
        clickOnElement(By.xpath("//input[@value='Email a friend']"));
        //Type Friend's Email
        enterText(By.name("FriendEmail"),generateEmail());
        //Type Personal Message
        enterText(By.xpath("//textarea[@class='your-email']"),"Gift for you Bro... :)");
        //Click on Send Email
        clickOnElement(By.xpath("//input[@class='button-1 send-email-a-friend-button']"));
        //Expected Result
        String expectedResults = ("Your message has been sent.");
        //Actual Result
        String actualResults = extractText(By.xpath("//div[@class='result']"));
        //Comparision between Actual Result and Expected Result
        Assert.assertEquals(actualResults,expectedResults);
    }

    @ Test (priority = 2)
    public void UserShouldBeNavigateToCameraAndPhotoPage(){
        //Click on Electronics
        clickOnElement(By.xpath("//h2/a[@title='Show products in category Electronics']"));
        //Click on Camera & Photo
        clickOnElement(By.xpath("//div/h2/a[@title='Show products in category Camera & photo']"));
        //Expected Result
        String expectedResult = ("Nikon D5500 DSLR");
        //Actual Result
        String actualResult = extractText(By.linkText("Nikon D5500 DSLR"));
        //Comparision of Expected Result and Actual Result
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test (priority = 3)
    public void UserShouldBeAbleToSelectJewelleryBetween$700To$3000 (){
        //Click on Jewellery
        clickOnElement(By.linkText("Jewelry"));
        //Select $700 to $3000
        clickOnElement(By.xpath("//a[@href='//demo.nopcommerce.com/jewelry?price=700-3000']"));
        //Expected Result
        String expectedResult = extractText(By.className("product-title"));
        //Actual Result
        String actualResult = extractText(By.linkText("Vintage Style Engagement Ring"));
        //Comparision of Expected Result and Actual Result
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test (priority = 4)
    public void UserShouldBeAbleToAddTwoBooksInShoppingBasket (){

        //Click on Books
        clickOnElement(By.linkText("Books"));
        //Click on First Book
        clickOnElement(By.xpath("//img[@src='//demo.nopcommerce.com/images/thumbs/0000068_fahrenheit-451-by-ray-bradbury_415.jpeg']"));
        //Add First book to Cart
        clickOnElement(By.id("add-to-cart-button-37"));
        //Select Second Book
        clickOnElement(By.xpath("//img[@src = \"//demo.nopcommerce.com/images/thumbs/0000069_first-prize-pies_415.jpeg\"]"));
        //Add Another Book to Cart
        clickOnElement(By.id("add-to-cart-button-38"));
        //Click on Shopping Cart
        clickOnElement(By.id("topcartlink"));
        //driver.findElement(By.linkText("Shopping cart")).click();
        //Expected Result A
        String expectedResult5a = ("Fahrenheit 451 by Ray Bradbury");
        //Actual Result A
        String actualResult5a = extractText(By.xpath("//a[@class = \"product-name\"]"));
        //Comparision with Expected and Actual Result
        Assert.assertEquals(expectedResult5a,actualResult5a);
        //Expected Result B
        String expectedResult5b = ("First Prize Pies");
        //Actual Result B
        String actualResult5b = extractText(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[4]/a"));
        //Comparision with Expected and Actual Result
        Assert.assertEquals(expectedResult5b,actualResult5b) ;


    }



//@AfterMethod
    //  public void browserClose() {
    //driver.quit();

}



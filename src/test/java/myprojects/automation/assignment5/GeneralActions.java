package myprojects.automation.assignment5;


import myprojects.automation.assignment5.model.ProductData;
import myprojects.automation.assignment5.utils.Properties;
import myprojects.automation.assignment5.utils.logging.CustomReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By allProduct = By.xpath("//a[@class='all-product-link pull-xs-left pull-md-right h4']");
    private By openProduct = By.linkText("Blouse");
    private By addCart = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    private By goToRegistration = By.xpath("html/body/div[1]/div/div/div[2]/div/div[2]/div/a");
    private By ordering = By.cssSelector("div>a[href='http://prestashop-automation.qatestlab.com.ua/ru/order']");
    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By email = By.name("email");
    private By step2 = By.xpath("html/body/section/div/section/div/div[1]/section[1]/div/div/div[1]/form/footer/button");
    private By address = By.xpath(".//div//input[@name='address1']");
    private By postcode = By.xpath(".//div//input[@name='postcode']");
    private By city = By.xpath(".//div//input[@name='city']");
    private By step3 = By.cssSelector("#checkout-delivery-step");
    private By step4 = By.xpath("html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/button");
    private By paymentByCheque = By.cssSelector("#payment-option-1");
    private By readAgree = By.xpath("html/body/section/div/section/div/div[1]/section[4]/div/form/ul/li/div[1]/span/input");
    private By orderWithPayment =  By.xpath(".//div//button[@type='submit'][@class='btn btn-primary center-block']");
    private By confirmation = By.xpath(".//div//h3[@class='h1 card-title']");
    private By womenButton = By.xpath(".//a//img[@class='logo img-responsive']");
    private By detailsProduct = By.xpath(".//li//a[@href='#product-details']");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openRandomProduct() throws InterruptedException {
        driver.findElement(this.allProduct).click();
        driver.findElement(this.openProduct).click();
        driver.findElement(this.addCart).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToRegistration));
        driver.findElement(this.goToRegistration).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("div>input[name='product-quantity-spin']")).getText().contains("1"));
        Assert.assertTrue(driver.findElement(By.linkText("Blouse")).getText().contains("Blouse"));
        Assert.assertTrue(driver.findElement(By.xpath("html/body/main/section/div/div/section/div/div[1]/div[1]/div[2]/ul/li/div/div[2]/div[2]/span"))
                .getText().contains("26,99 ₴"));
        // TODO implement logic to open random product before purchase
        //throw new UnsupportedOperationException();

    }
    public void createOrder (String name, String name1, String emaile) throws InterruptedException{
        driver.findElement(this.ordering).click();
        driver.findElement(this.firstName).sendKeys(name);
        driver.findElement(this.lastName).sendKeys(name1);
        driver.findElement(this.email).sendKeys(emaile);
    }

    public void createOrder2 (String address1, String postcode1, String city1) throws InterruptedException{
        driver.findElement(this.step2).click();
        driver.findElement(this.address).sendKeys(address1);
        driver.findElement(this.postcode).sendKeys(postcode1);
        driver.findElement(this.city).sendKeys(city1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(step3));
        driver.findElement(this.step3).click();
        driver.findElement(this.step4).click();
        driver.findElement(this.paymentByCheque).click();
        driver.findElement(this.readAgree).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderWithPayment));
        driver.findElement(this.orderWithPayment).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmation));
        Assert.assertTrue(driver.findElement(By.xpath(".//div//h3[@class='h1 card-title']")).getText().contains("ВАШ ЗАКАЗ ПОДТВЕРЖДЁН"));
        Assert.assertTrue(driver.findElement(By.xpath(".//section//div[@class='col-xs-2']")).getText().contains("1"));
        Assert.assertTrue(driver.findElement(By.xpath(".//section//div[@class='col-sm-4 col-xs-9 details']")).getText().contains("Blouse"));
        Assert.assertTrue(driver.findElement(By.xpath(".//section//div[@class='col-xs-5 text-sm-right text-xs-left']"))
                .getText().contains("26,99 ₴"));
    }
    public void verificationNumber () throws InterruptedException{
        driver.findElement(this.womenButton).click();
        driver.findElement(this.openProduct).click();
        driver.findElement(this.detailsProduct).click();
        Assert.assertFalse(driver.findElement(By.cssSelector(".product-quantities")).getText().contains("291"));

    }

    /**
     * Extracts product information from opened product details page.
     *
     * @return
     */
    //public ProductData getOpenedProductInfo() throws InterruptedException {
   // }
}
        //CustomReporter.logAction("Get information about currently opened product");}



        // TODO extract data from opened page
        //throw new UnsupportedOperationException();



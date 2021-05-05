package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebUIActions {
    WebDriver driver;
   public  WebUIActions(WebDriver driver)
    {
        this.driver=driver;
    }


    public boolean validateOnElement(ExpectedCondition<WebElement> validate_type)
    {
        // ExpectedCondition <WebElement> x =null;
        /*switch (validate_type)
        {
            case "precense":
                new WebDriverWait(driver,30).until(ExpectedConditions.
                        presenceOfElementLocated(element));
                break;
            case"clickable":
                new WebDriverWait(driver,30).until(ExpectedConditions.
                        elementToBeClickable(element));
                break;

        }*/
        try {
            new WebDriverWait(driver, 50).until(validate_type);
            return  true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public void  ClickOn(By element, By expected_element)// check on element can click on it but not clickable
    {
        if (validateOnElement(ExpectedConditions.elementToBeClickable(element)))
        {
            driver.findElement(element).click();
        }
        if (expected_element!=null)
        {
            validateOnElement(ExpectedConditions.presenceOfElementLocated(expected_element));
        }
    }
    public void Navigate_To_Page_And_Validate(ExpectedCondition<WebElement> validate_type,String url)
    {
        boolean valid;
        driver.navigate().to(url);
        valid=validateOnElement(validate_type);
        Assert.assertEquals(valid,true,"Navigation Failed to this Website"+url);

    }
}

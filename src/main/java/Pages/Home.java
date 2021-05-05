package Pages;

import Actions.WebUIActions;
import Pages.Create_Document_Page;
import Wrappers.propertyFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Home {
    WebDriver driver;
    //String homepageurl="https://www.levelset.com/";
    By create_document_button_locater= By.xpath("//a[contains(.,'Create a Document ')]");
    By payment_help_label=By.xpath("//h2[text()='Payment Help is Here']");
    public Home(WebDriver driver)
    {
       this.driver=driver;
    }
     /*public WebDriver Init_Driver()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return  driver;

    }*/
    public void navigate_To_Homepage() {

        //driver.get(homepageurl);
        /*do{
            driver.get(homepageurl);
            element=(new WebDriverWait(driver,40)).until(ExpectedConditions.presenceOfElementLocated(payment_help_label));
            i++;

        }while (element==null&&i<3);*/
       /* try {
            new WebDriverWait(driver,40).until(ExpectedConditions.
                    presenceOfElementLocated(payment_help_label));
        }
        catch(Exception e)
        {
            System.out.println("Test Fail");
        }*/
       /* WebUIActions action_in_home_page = new WebUIActions(driver);

        action_in_home_page.validateOnElement(payment_help_label, ExpectedConditions.
                presenceOfElementLocated(payment_help_label));*/
        WebUIActions navigate_to_home= new WebUIActions(driver);

        navigate_to_home.Navigate_To_Page_And_Validate(ExpectedConditions.presenceOfElementLocated(payment_help_label),propertyFileManager.readPropertyFile("url"));

    }

    public void press_Create_Document()
    {
       // WebElement element ;
       /* try
        {
            element=(new WebDriverWait(driver,30)).until(ExpectedConditions.
                    elementToBeClickable(create_document_button_locater));
           // element.click();
        }
        catch(Exception e)
        {
            System.out.println("Test Fail");
        }
        driver.findElement(create_document_button_locater).click(); //ha4ofha tanii
        try
        {
            new WebDriverWait(driver,30).until(ExpectedConditions.
                    presenceOfElementLocated(new Pages.Create_Document_Page(driver).send_document_button));
        }
        catch (Exception e)
        {
            System.out.println("Test Fail");
        }*/

     //new Pages.Create_Document_Page(driver).validate_Document_page();

        By element=create_document_button_locater;
        By expected_element=new Create_Document_Page(driver).send_document_button;
        WebUIActions action_in_home_page=new WebUIActions(driver);
        action_in_home_page.ClickOn(element,expected_element);

    }
   /* public boolean validateOnElement(By element,ExpectedCondition <WebElement> validate_type)
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
        /*try {
            new WebDriverWait(driver, 50).until(validate_type);
            return  true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public void  ClickOn(By element,By expected_element)
    {
      if (validateOnElement(element,ExpectedConditions.elementToBeClickable(element)))
      {
          driver.findElement(element).click();
      }
      validateOnElement(expected_element,ExpectedConditions.presenceOfElementLocated(expected_element));
    }*/




}

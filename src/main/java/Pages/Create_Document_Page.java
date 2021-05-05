package Pages;

import Actions.WebUIActions;
import Wrappers.jsonFileManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Document_Page {
      WebDriver driver;
    jsonFileManager jr=new jsonFileManager("Test2.json");
    String [] JsonData= jr.jsonReader();
    String [] Data=JsonData[0].split(",");
    public Create_Document_Page(WebDriver driver)
    {

        this.driver=driver;
    }
  // public By send_document_button=By.xpath("//label[@class='btn btn-sm btn-toggle active']");
    public By send_document_button=By.xpath(Data[0]);
    String free_text_path="//div[text()='%s']/..//span[text()='Free']";
    String document_button_path="//div[contains(@class,\"product-title-container card-header\")]//div[text()='%s']";
    //By header_title_path=By.xpath("//div[@class=\"document-general-type-info\"]//div[@class=\"title\"]");
    By header_title_path=By.xpath(Data[1]);

   /* public void validate_Document_page()
    {
        /*WebElement element;
        int i=0;
        do{

            element=(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(send_document_button));
            i++;

        }while (element==null&&i<3);
        try
        {
            new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(send_document_button));
        }
        catch(Exception e)
        {
            System.out.println("Test Fail");
        }
    }*/


    public String check_Free_text(String path)
    {
        WebUIActions actions_in_document_page=new WebUIActions(driver);
        path = String.format(free_text_path, path);
        if (actions_in_document_page.validateOnElement(ExpectedConditions.presenceOfElementLocated(By.xpath(path))))
        {
            String actual = driver.findElement(By.xpath(path)).getText();
            return actual;
        }
        else {return  null;}
           /*try {
               path = String.format(free_text_path, path);
               new WebDriverWait(driver,30).
                       until(ExpectedConditions.presenceOfElementLocated(new  By.ByXPath(path)));

               String actual = driver.findElement(By.xpath(path)).getText();
               return actual;
           }
           catch(Exception e)
           {
               return  null;
           }*/




    }
    public void clickon_document_button(String path)
    {
        WebUIActions actions_in_document_page=new WebUIActions(driver);
        path = String.format(document_button_path, path);
        actions_in_document_page.ClickOn(By.xpath(path),null);
        /*try {
            path = String.format(document_button_path, path);
           new WebDriverWait(driver,30).
                    until(ExpectedConditions.elementToBeClickable(new  By.ByXPath(path)));
            driver.findElement(By.xpath(path)).click();
        }
        catch (Exception e)
        {
            System.out.println("Test Fail");
        }*/

    }
    public String check_header_title()
    {
        WebUIActions actions_in_document_page=new WebUIActions(driver);
        if (actions_in_document_page.validateOnElement(ExpectedConditions.
                presenceOfElementLocated(header_title_path)))
        {
            String header = driver.findElement(header_title_path).getText();
            return header;
        }
        else {return null;}
        /*try {
            new WebDriverWait(driver,50).
                    until(ExpectedConditions.presenceOfElementLocated(header_title_path));
            String header = driver.findElement(header_title_path).getText();
            return header;
        }
        catch (Exception e)
        {
            return null;
        }*/

    }

}

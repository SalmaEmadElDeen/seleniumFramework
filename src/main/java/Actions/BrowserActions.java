package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions {
    WebDriver driver;
    public WebDriver InitializeWebDriver(String browser)
    {
        try
        {
            if (browser.equals("Chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                return driver;
            }
            if (browser.equals("FireFox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                return driver;
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to Initialize WebDriver");
        }
        return  null;
    }
    public void MaximizeBrowserScreen()
    {
        driver.manage().window().maximize();
    }
    public void quitBrowzerScreen()
    {
        driver.quit();
    }
}

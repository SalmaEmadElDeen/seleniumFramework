import Actions.BrowserActions;
import Pages.Create_Document_Page;
import Pages.Home;
import Wrappers.jsonFileManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Create_Document_Test {
    WebDriver driver;
    Create_Document_Page d_page;
    Home home;
    BrowserActions browzer_action= new BrowserActions();
    //@Parameters("browzer")
    @BeforeClass
    void Set_Up() throws Exception
    {

       /* WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();*/
       driver= browzer_action.InitializeWebDriver("Chrome");
       browzer_action.MaximizeBrowserScreen();
        home=new Home(driver);
        d_page=new Create_Document_Page(driver);
        home.navigate_To_Homepage();
        /*jsonFileManager jr=new jsonFileManager("Test2.json");
        jr.jsonReader();*/
    }


     @Test(dataProvider = "GetDocuments")
    public void test_Document_Free_Price(String doc)
    {
        home.press_Create_Document();
        String actual=d_page.check_Free_text(doc);
        Assert.assertEquals(actual,"Free");
       d_page.clickon_document_button(doc);
       String header=d_page.check_header_title();
        Assert.assertEquals(header,doc);

    }
    /*@Test
    public void check_noticeof_intent()
    {
      // home.navigate_To_Homepage();
        home.press_Create_Document();
        String actual=d_page.check_Free_text("Notice of Intent to Lien");
        Assert.assertEquals(actual,"Free");
        d_page.clickon_document_button("Notice of Intent to Lien");
        String header=d_page.check_header_title();
        Assert.assertEquals(header,"Notice of Intent to Lien");

    }
    @Test
    public void check_Lien_Bond_Claim()
    {
       // home.navigate_To_Homepage();
        home.press_Create_Document();
        String actual = d_page.check_Free_text("Lien / Bond Claim");
        Assert.assertEquals(actual, "Free");
        d_page.clickon_document_button("Lien / Bond Claim");
        String header=d_page.check_header_title();
        Assert.assertEquals(header,"Lien / Bond Claim");
    }
    @Test
    public void check_Lien_Waiver()
    {
       // home.navigate_To_Homepage();
        home.press_Create_Document();
        String actual=d_page.check_Free_text("Lien Waiver");
        Assert.assertEquals(actual,"Free");
        d_page.clickon_document_button("Lien Waiver");
        String header=d_page.check_header_title();
        Assert.assertEquals(header,"Lien Waiver");
    }*/
    @DataProvider(name = "GetDocuments")
    public Object[] get_Documents()
    {
       return new Object[]
               {
                       "20-Day Preliminary Notice",
                       "Notice of Intent to Lien",
                       "Lien / Bond Claim",
                       "Lien Waiver"


               };
    }
     @AfterClass
    public void After_Class()
    {
        browzer_action.quitBrowzerScreen();
    }
}

package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    HelperContact contact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){
        wd=new ChromeDriver();
        logger.info("All tests start in ChromeDriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        helperUser = new HelperUser(wd);
        contact = new HelperContact(wd);
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void stop(){
        //wd.quit();
    }

    public HelperContact contact() {
        return contact;
    }
}

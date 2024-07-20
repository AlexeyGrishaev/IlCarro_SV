package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;

    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        helperUser = new HelperUser(wd);
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }


    public void stop() {
        wd.quit();
    }
}

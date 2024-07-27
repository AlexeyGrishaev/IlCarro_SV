package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    HelperCar helperCar;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("The link -->"+wd.getCurrentUrl());
        logger.info("Test run in Chrome Browser");
        helperUser = new HelperUser(wd);
        helperCar = new HelperCar(wd);
    }

    public HelperCar getHelperCar() {
        return helperCar;
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }


    public void stop() {
        wd.quit();
    }
}

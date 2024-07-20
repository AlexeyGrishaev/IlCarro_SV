package test;

import main.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
   static ApplicationManager app = new ApplicationManager();
   @BeforeSuite
    public void tearDown(){
        app.init();
    }
    @AfterSuite
    public void setUp(){
        app.stop();

    }
}

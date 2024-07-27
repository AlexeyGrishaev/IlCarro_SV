package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert checked is element button   'Logout' is present ");
    }
    @Test
    public void loginSuccessModel(){
        logger.info("Test data --> Email: locker@gmail.com Password: Qwerty1234!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert checked is element button   'Logout' is present ");
    }
    @Test
    public void loginWrongEmailMessage(){
        logger.info("Test data --> Email: ocker@gmail.com Password: Qwerty1234!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ocker@gmail.com","Qwerty1234!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        Assert.assertFalse(app.getHelperUser().isLogged());
        logger.info("Assert checked is element button   'Logout' is present ");

    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test data --> Email: lockergmail.com Password: Qwerty1234!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lockergmail.com","Qwerty1234!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertFalse(app.getHelperUser().btnYallaIsNotActive());
        logger.info("Assert checked is element button yalla is active ");

    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data --> Email: locker@gmail.com Password: werty1234!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("locker@gmail.com","werty1234!");
        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }
    @Test
    public void loginUnregistered(){
        logger.info("Test data --> Email: 12345locker@gmail.com Password: Qwerty1234!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("12345locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOKButton();
    }
}

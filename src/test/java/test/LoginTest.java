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
    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginWrongEmailMessage(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ocker@gmail.com","Qwerty1234!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        Assert.assertFalse(app.getHelperUser().isLogged());

    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lockergmail.com","Qwerty1234!");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertFalse(app.getHelperUser().btnYallaIsNotActive());

    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("locker@gmail.com","werty1234!");
        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }
    @Test
    public void loginUnregistered(){
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

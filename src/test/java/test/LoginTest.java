package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
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
        app.getHelperUser().openLoginFrom();
        app.getHelperUser().fillLoginForm("locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submitLoginForm();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOKButton();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginFrom();
        app.getHelperUser().fillLoginForm("locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submitLoginForm();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOKButton();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginWrongEmailMessage(){
        app.getHelperUser().openLoginFrom();
        app.getHelperUser().fillLoginForm("ocker@gmail.com","Qwerty1234!");
        app.getHelperUser().submitLoginForm();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        Assert.assertFalse(app.getHelperUser().isLogged());
        app.getHelperUser().clickOKButton();
    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginFrom();
        app.getHelperUser().fillLoginForm("lockergmail.com","Qwerty1234!");
        app.getHelperUser().submitLoginForm();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertFalse(app.getHelperUser().btnYallaIsNotActive());
        app.getHelperUser().clickOKButton();
    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginFrom();
        app.getHelperUser().fillLoginForm("locker@gmail.com","werty1234!");
        app.getHelperUser().submitLoginForm();


        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOKButton();
    }
    @Test
    public void loginUnregistered(){
        app.getHelperUser().openLoginFrom();
        app.getHelperUser().fillLoginForm("12345locker@gmail.com","Qwerty1234!");
        app.getHelperUser().submitLoginForm();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        app.getHelperUser().clickOKButton();
    }
}

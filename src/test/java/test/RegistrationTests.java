package test;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){

//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .setName("Peleq")
                .setLastName("Lu")
                .setEmail("peleg"+z+"lu@gmail.com")
                .setPassword("Qwerty1234!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }
    @Test
    public void registrationEmptyName(){
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .setName("")
                .setLastName("Lu")
                .setEmail("peleg"+z+"lu@gmail.com")
                .setPassword("Qwerty1234!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");
    }
    @Test
    public void registrationEmptyLastName(){
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .setName("Peleq")
                .setLastName("")
                .setEmail("peleg"+z+"lu@gmail.com")
                .setPassword("Qwerty1234!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Last name is required");
    }

    @Test
    public void registrationEmptyEmail(){
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .setName("Peleq")
                .setLastName("Lu")
                .setEmail("")
                .setPassword("Qwerty1234!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
    }
    @Test
    public void registrationWrongEmail(){
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .setName("Peleq")
                .setLastName("Lu")
                .setEmail("peleg"+z+"lugmail.com")
                .setPassword("Qwerty1234!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
    }
    @Test
    public void registrationWrongPassword(){
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .setName("Peleq")
                .setLastName("Lu")
                .setEmail("peleg"+z+"@lugmail.com")
                .setPassword("qwe");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Password must contain minimum 8 symbols"));
    }
    @Test
    public void registrationEmptyPassword(){
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .setName("Peleq")
                .setLastName("Lu")
                .setEmail("peleg"+z+"@lugmail.com")
                .setPassword("");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOKButton();
    }
}

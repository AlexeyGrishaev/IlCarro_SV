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
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOKButton();
    }
}

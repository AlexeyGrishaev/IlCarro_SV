package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchCarTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        app.getHelperCar().openSerchForm();
    }
    @Test
    public void searchCurrentMonthSuccess(){
        int i = new Random().nextInt(1000)+1000;
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel","7/27/2024","7/30/2024");
        app.getHelperCar().getScreen("src/test/screenshots"+i+".png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppears());
    }
    @Test
    public void searchCurrentYearSuccess(){
        int i = new Random().nextInt(1000)+1000;
        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel","8/28/2024","9/24/2024");
        app.getHelperCar().getScreen("src/test/screenshots"+i+".png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppears());
    }
    @Test
    public void searchCurrentAnyPeriodSuccess(){
        int i = new Random().nextInt(1000)+1000;
        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel","10/21/2024","6/11/2025");
        app.getHelperCar().getScreen("src/test/screenshots"+i+".png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppears());
    }
}

package main;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }
    public void openCarForm(){
        pause(500);
        click(By.xpath("//a[text()=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"),car.getManufacture());
        type(By.xpath("//*[@id='model']"), car.getModel());
        type(By.xpath("//input[@id='year']"), car.getYear());
        select(By.xpath("//*[@id='fuel']"),car.getFuel());
        type(By.xpath("//*[@id='seats']"), String.valueOf(car.getSeats()));
        type(By.id("class"),car.getCarClass());
        type(By.id("serialNumber"),car.getCarRegNumber());
        type(By.id("price"), String.valueOf(car.getPrice()));
        type(By.id("about"), car.getAbout());
    }

    private void select(By locator, String fuel) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(fuel);
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"), location);
        click(By.cssSelector("div.pac-item"));

    }
    public void attachPhoto(String link){
        wd.findElement(By.cssSelector("#photos")).sendKeys(link);
    }

    public void returnToHome() {
        click(By.xpath("//button[text()='Search cars']"));
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);
        pause(500);
        clearTextBox(By.id("dates"));


        click(By.id("dates"));

        //5/30/2024,
        String[] from = dataFrom.split("/");;
        String locatorFrom = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locatorFrom));

        String[] to = dataTo.split("/");;
        String locatorTo = "//div[text()=' "+to[1]+" ']";
        click(By.xpath(locatorTo));


    }

    private void typeCity(String city) {

        type(By.id("city"),city);
        click(By.xpath("//div[@class='pac-item']"));


    }

    public boolean isListOfCarsAppears() {
        pause(3500);
        return isElementPresent(By.xpath("//a[contains(@class,'car-container')]"));
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        pause(500);
        clearTextBox(By.id("dates"));
        click(By.id("dates"));


        //M/dd/YYYY

        LocalDate now = LocalDate.now();
        int month = now.getMonthValue();

        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/dd/yyyy"));


        int diffMonth = from.getMonthValue()-month;

        if(diffMonth>0){
            clickNextMonth(diffMonth);
        };
        click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));



        diffMonth = to.getMonthValue()-from.getMonthValue();
        if(diffMonth>0){
            clickNextMonth(diffMonth);
        }


        click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));
    }

    private void clickNextMonth(int diffMonth) {
        for (int i = 0; i < diffMonth; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }


    public void searchAnyPeriod(String city, String dataFrom, String dataTo) {
        typeCity(city);
        pause(500);
        clearTextBox(By.id("dates"));
        click(By.id("dates"));
        LocalDate now = LocalDate.now();


        int month = now.getMonthValue();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/dd/yyyy"));


        int diffYear = from.getYear()-now.getYear();

        if(diffYear>0){
            clickNextMonth(12+from.getMonthValue()-now.getMonthValue());
        }

        int diffmonth = from.getMonthValue()- now.getMonthValue();

        if(diffmonth>0){
            clickNextMonth(diffmonth);
        }
        click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

        diffYear = to.getYear()-from.getYear();
        if(diffYear>0){
            clickNextMonth(12+to.getMonthValue()-from.getMonthValue());
        }


        diffmonth = to.getMonthValue()- from.getMonthValue();

        if(diffmonth>0){
            clickNextMonth(diffmonth);
        }
        click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));

    }


    public void openSerchForm() {
        click(By.xpath("//a[@href='/search']"));
    }
}

package main;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@type='email']"), email);
        type(By.xpath("//input[@type='password']"), password);
    }
    public void fillLoginForm(User user) {
        type(By.xpath("//input[@type='email']"), user.getEmail());
        type(By.xpath("//input[@type='password']"), user.getPassword());
    }



    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void clickOKButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));

        }
    }



    public String getErrorText() {
        return wd.findElement(By.xpath("//*[contains(@class,'error')]")).getText();
    }

    public boolean btnYallaIsNotActive() {
        boolean res = isElementPresent(By.xpath("//button[disabled]"));
        WebElement element = wd.findElement(By.xpath("//button[@type='submit']"));
        boolean result = element.isEnabled();
        return !result && res;
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastName());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());

    }

    public void checkPolicy() {
        //click(By.xpath("//label[@for='terms-of-use']"));
        JavascriptExecutor js = (JavascriptExecutor) wd;

        js.executeScript("document.querySelector('#terms-of-use').click()");
    }
    public void checkPolicyXY() {
        if(!wd.findElement(By.id("terms-of-use")).isSelected()){
        WebElement label = wd.findElement(By.xpath("label[@for='terms-of-use']"));
        Rectangle rectangle = label.getRect();
        int w = rectangle.getWidth();
        int xOffSet = -w/2;

        Actions actions = new Actions(wd);
        actions.moveToElement(label,xOffSet,0).click().release().perform();}
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOKButton();

    }
}

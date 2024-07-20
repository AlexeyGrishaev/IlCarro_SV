package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginFrom() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@type='email']"), email);
        type(By.xpath("//input[@type='password']"), password);
    }

    public void submitLoginForm() {
        click(By.xpath("//button[@type='submit']"));

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

    public String getMessage() {
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public String getErrorText() {
        return wd.findElement(By.xpath("//div[@class='error']")).getText();
    }

    public boolean btnYallaIsNotActive() {
        boolean res = isElementPresent(By.xpath("//button[disabled]"));
        WebElement element = wd.findElement(By.xpath("//button[@type='submit']"));
        boolean result = element.isEnabled();
        return !result && res;
    }
}

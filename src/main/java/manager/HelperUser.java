package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegForm() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginRegForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegSuccess() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void login(User user) {
        openLoginRegForm();
        fillLoginRegFormUser(user);
        submitLogin();
    }

    public void submitReg() {
        click(By.xpath("//button[2]"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void signOut() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void fillLoginRegFormUser(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isErrorWrongFormat() {
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();
        String error = alert.getText();
        System.out.println(error);
        alert.accept();
        return error.contains("Wrong email or password format");
    }
}

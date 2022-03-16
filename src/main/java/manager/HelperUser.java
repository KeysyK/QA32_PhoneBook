package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegForm() {
        click(By.cssSelector("[href='/login']"));
    }
    public void fillLoginRegForm(String email, String password){
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);
    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegSuccess() {
        return isElementpresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitReg() {
        click(By.xpath("//button[2]"));
    }
}

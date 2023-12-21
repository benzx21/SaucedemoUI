package SauceDemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static SauceDemo.utilities.Credentials.userCredentials;

public class LoginPage extends BasePage {
    private final Page page;

    public final Locator username;
    public final Locator password;
    public final Locator loginBtn;
    public final Locator backBtn;
    public final Locator errorMessage;
    public final Locator logOutBtn;
    public final Locator rememberDetails;
    public final Locator forgotPassword;
    public final Locator changePasswordLink;
    public final Locator newPassword;
    public final Locator changePasswordBtn;


    public LoginPage(Page page) {
        super(page);
        this.page = page;

        this.username = page.locator("[data-test=\"username\"]");
        this.password = page.locator("[data-test=\"password\"]");
        this.loginBtn =page.locator("[data-test=\"login-button\"]");
        this.backBtn = page.locator("zero-button[type=button]");
        this.errorMessage = page.locator("div.message");
        this.logOutBtn = page.locator("[data-test=\"login-button\"]");
        this.forgotPassword = page.locator("text=Forgot Password");
        this.changePasswordLink = page.locator("text=Change Password");
        this.newPassword = page.locator("input#new-password");
        this.changePasswordBtn = page.locator("zero-button[type=submit]");
        this.rememberDetails = page.locator("text=Remember Details");
    }


    public void login(String user) {
        page.waitForTimeout(2000);
        username.type(userCredentials(user).get("Username"));
        password.type(userCredentials(user).get("Password"));
        loginBtn.click();
    }

    public void updatePassword(String user, String newPassword) {
        username.type(userCredentials(user).get("Username"));
        password.type(userCredentials(user).get("Password"));
        this.newPassword.type(newPassword);
        changePasswordBtn.click();
    }

    public void userClickOn(String buttonType) {
        switch (buttonType) {
            case "login":
                loginBtn.click();
                break;
            case "change password":
                changePasswordLink.click();
                break;
                case "Log Out":
                logOutBtn.click();
                break;
            case "back":
                backBtn.click();
                break;


        }

    }
}
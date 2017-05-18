/**
 * Created by k.smotrov on 03.05.2017.
 */
package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseHelper {
    public static FirefoxDriver wd;

    @BeforeSuite
    public void setUp() throws Exception {
        FirefoxBinary binary = new FirefoxBinary(new File("D:\\Program Files\\Mozilla Firefox\\firefox.exe"));
        wd = new FirefoxDriver(binary, new FirefoxProfile());
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wd.get("http://app.dev.pvv.zags.adc.vpn:8080/login");
        login("admin", "admin");


    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private void login(String nameUser, String passUser) {


        String fildUser = "//div/form/div[1]/div[3]/div[2]/input";
        String fildPas = "//div/form/div[1]/div[4]/div[2]/input";
        String submitLoginButton = "//div/form/div[1]/div[4]/div[2]/div/button";

        type(fildUser, nameUser);
        type(fildPas, passUser);
        click(submitLoginButton);
    }

    public void click(String locator) {
        wd.findElement(By.xpath(locator)).click();
    }

    public void type(String locator, String text) {
        wd.findElement(By.xpath(locator)).click();
        wd.findElement(By.xpath(locator)).clear();
        wd.findElement(By.xpath(locator)).sendKeys(text);
    }
}

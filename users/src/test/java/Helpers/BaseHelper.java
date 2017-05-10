package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by k.smotrov on 14.04.2017.
 */
public class BaseHelper {
    public FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        FirefoxBinary binary = new FirefoxBinary(new File("D:\\Program Files\\Mozilla Firefox\\firefox.exe"));
        wd = new FirefoxDriver(binary, new FirefoxProfile());
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://pvvdev-app.dev.zags.adc.vpn:8080/login");
        login("admin", "admin");


    }

    @AfterMethod
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

        wd.findElement(By.xpath(fildUser)).click();
        wd.findElement(By.xpath(fildUser)).clear();
        wd.findElement(By.xpath(fildUser)).sendKeys(nameUser);
        wd.findElement(By.xpath(fildPas)).click();
        wd.findElement(By.xpath(fildPas)).clear();
        wd.findElement(By.xpath(fildPas)).sendKeys(passUser);
        wd.findElement(By.xpath(submitLoginButton)).click();
    }


}

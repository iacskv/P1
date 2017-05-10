package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by k.smotrov on 03.05.2017.
 */
public class LoadDataHelper extends BaseHelper{

    public Wait<WebDriver> wait;


    public void waitingCanClick(String locator) {
        wait = new WebDriverWait(wd, 30, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }




    public String waitingLogText() {
        int i = 0;
        String a="";
        JavascriptExecutor js = (JavascriptExecutor)wd;
        while ( a.equals("")  ){

            a = js.executeScript("return document.getElementById('x-auto-38-input').getAttributeNode('class').ownerElement.value;").toString();
            i++;
            if (i> 100000){
                return "Не дождались";
            }
        }
        return a;
    }
}

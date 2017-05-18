package Helpers;

import model.DocForLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import static Locators.LoadDataFormLocators.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 03.05.2017.
 */
public class LoadDataHelper extends BaseHelper {

    public DocForLoad docAttr;

    public String waitingLogText() {
        int i = 0;
        String a = "";
        JavascriptExecutor js = (JavascriptExecutor) wd;
        while (a.equals("")) {

            a = js.executeScript("return document.getElementById('x-auto-38-input').getAttributeNode('class').ownerElement.value;").toString();
            i++;
            if (i > 100000) {
                return "Не дождались";
            }
        }
        return a;
    }

    protected void gotoLoadDataPage() {
        //вкладка площадка ввода
        click(PVV_SPAN);

        // клик по кнопке загрузка данных
        click(LOAD_BTN);
    }

    protected void fillLoadNewDocGroupFofm(DocForLoad docAtt) throws InterruptedException {
        // выбор типа книги
        click(TYPE_DOC);
        click("//div[8]/div/div[text()='" + docAtt.typeDoc + "']");//по пункту списка (200-2003)

        // выбор типа АГС
        click(TYPE_AGS);
        click("//div[8]/div/div[text()='" + docAtt.typeAgs + "']");//рождение

        //выбор года
        click(YEAR);
        click("//div[8]/div/div[text()='" + docAtt.year + "']");//2003

        // выбор ЗАГС
        click(TYPE_ZAGS);
        click("//div[8]/div/div[text()='" + docAtt.typeZags + "']");//адмиралтейский

        //ввод первого номера
        type(F_NUM, docAtt.fNum);

        //ввод последнего номера
        type(L_NUM, docAtt.lNum);
    }

    protected void submitLoad() throws InterruptedException {
        //клик по кнопке загрузка
        Thread.sleep(1000);
        click(LOAD_RUN_BTN);
    }

    protected void checkInfoBox() {
        assertThat(wd.findElement(By.xpath(INFO_BOX_NUM)), notNullValue());
        System.out.println("инфобокс на месте");
        assertThat(wd.findElement(By.xpath(INFO_BOX_NUM_SPAN)).getText(), equalTo("Неверные значения номеров актовых записей"));
        System.out.println("заголовок ок");
        assertThat(wd.findElement(By.xpath(INFO_BOX_NUM_TEXT)).getText(), equalTo("Не больше 500 актовых записей за раз"));
        System.out.println("текст инфобокса ок");
    }

    protected void checkFNumFieldAlert() {
        assertThat(wd.findElement(By.xpath(F_NUM_ALRT)), notNullValue());

        System.out.println("алерт поля 'Начальный номер' на месте");
    }

    protected void checkLNumFieldAlert() {
        assertThat(wd.findElement(By.xpath(L_NUM_ALRT)), notNullValue());

        System.out.println("алерт поля 'Конечный номер' на месте");
    }


    @AfterMethod
        public void gotoMainPage(){
            click(MAIN_SPAN);
    }
}

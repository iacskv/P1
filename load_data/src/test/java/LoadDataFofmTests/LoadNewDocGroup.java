package LoadDataFofmTests;

import Helpers.LoadDataHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static Locators.LoadDataFormLocators.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 03.05.2017.
 */
public class LoadNewDocGroup extends LoadDataHelper {

        @Test
    public void testLoadNewDocGroup() throws InterruptedException {


        //вкладка площадка ввода
        click(PVV_SPAN);

        // клик по кнопке загрузка данных
        click(LOAD_BTN);

        // выбор типа книги
        click(TYPE_DOC);
        click("//div[8]/div/div");//по пункту списка (200-2003)

        // выбор типа АГС
        click(TYPE_AGS);
        click("//div[8]/div/div[4]");//рождение

        //выбор года
        click(YEAR);
        click("//div[8]/div/div[1]");//2003

        // выбор ЗАГС
        click(TYPE_ZAGS);
        click("//div[8]/div/div[1]");//адмиралтейский

        //ввод первого номера
        type(F_NUM,"1");

        //ввод последнего номера
        type(L_NUM, "1");

        //клик по кнопке загрузка
        Thread.sleep(1000);
        System.out.println(wd.findElementByXPath("html/body/div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[2]/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button").getAttribute("aria-disabled"));
        click(LOAD_RUN_BTN);

        //проверка текста в поле ЛОог загрузки
        //Thread.sleep(3000);
        waitingLogText();

        JavascriptExecutor js = (JavascriptExecutor)wd;
        String textarea = waitingLogText();
        assertThat(textarea, startsWith("Загрузка запущена"));
        System.out.println(textarea);

        //шлогрлдцощлиоуцка

     }

}

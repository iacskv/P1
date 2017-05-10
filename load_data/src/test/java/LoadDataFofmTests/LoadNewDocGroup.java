package LoadDataFofmTests;

import Helpers.LoadDataHelper;
import model.DocForLoad;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Locators.LoadDataFormLocators.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 03.05.2017.
 */
public class LoadNewDocGroup extends LoadDataHelper {

    
    @DataProvider
    public Iterator<Object[]> validDoc(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"Книга записей актов (2000-2003)","Запись акта о рождении","2003","Адмиралтейский (1994-2003)","1","1"});
        return list.iterator();
    }

    @Test (dataProvider = "validDoc")
    public void testLoadNewDocGroup(String type_doc, String type_ags, String year, String type_zags, String f_num, String l_num) throws InterruptedException {

        DocForLoad doc = new DocForLoad(type_doc, type_ags, year, type_zags, f_num, l_num);


        //вкладка площадка ввода
        click(PVV_SPAN);

        // клик по кнопке загрузка данных
        click(LOAD_BTN);

        // выбор типа книги
        click(TYPE_DOC);
        click("//div[8]/div/div[text()='"+ doc.type_doc + "']");//по пункту списка (200-2003)

        // выбор типа АГС
        click(TYPE_AGS);
        click("//div[8]/div/div[text()='" + doc.type_ags + "']");//рождение

        //выбор года
        click(YEAR);
        click("//div[8]/div/div[text()='" + doc.year + "']");//2003

        // выбор ЗАГС
        click(TYPE_ZAGS);
        click("//div[8]/div/div[text()='" + doc.type_zags + "']");//адмиралтейский

        //ввод первого номера
        type(F_NUM,f_num);

        //ввод последнего номера
        type(L_NUM, l_num);

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

package LoadDataFofmTests;

import Helpers.LoadDataHelper;
import model.DocForLoad;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
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
    public Iterator<Object[]> validDoc() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        //list.add(new Object[]{new DocForLoad("Книга записей актов (2000-2003)","Запись акта о рождении","2003","Адмиралтейский (1994-2003)","1","1")});
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/LOAD_BORN_ADMIR_KRON_OUT.txt")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new DocForLoad(split[0], split[1], split[2], split[3], split[4], split[5])});
            line = reader.readLine();
        }
        return list.iterator();

    }

    @Test(dataProvider = "validDoc")
    public void testLoadNewDocGroup(DocForLoad docAtt) throws InterruptedException {

        //вкладка площадка ввода
        click(PVV_SPAN);

        // клик по кнопке загрузка данных
        click(LOAD_BTN);

        // выбор типа книги
        click(TYPE_DOC);
        click("//div[8]/div/div[text()='" + docAtt.type_doc + "']");//по пункту списка (200-2003)

        // выбор типа АГС
        click(TYPE_AGS);
        click("//div[8]/div/div[text()='" + docAtt.type_ags + "']");//рождение

        //выбор года
        click(YEAR);
        click("//div[8]/div/div[text()='" + docAtt.year + "']");//2003

        // выбор ЗАГС
        click(TYPE_ZAGS);
        click("//div[8]/div/div[text()='" + docAtt.type_zags + "']");//адмиралтейский

        //ввод первого номера
        type(F_NUM, docAtt.f_num);

        //ввод последнего номера
        type(L_NUM, docAtt.l_num);

        //клик по кнопке загрузка
        Thread.sleep(1000);
        click(LOAD_RUN_BTN);

        //проверка текста в поле Лог загрузки

        waitingLogText();

        JavascriptExecutor js = (JavascriptExecutor) wd;
        String textarea = waitingLogText();
        assertThat(textarea, startsWith("Загрузка запущена"));
        System.out.println(textarea);




    }

}

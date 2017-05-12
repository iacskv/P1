package LoadDataFofmTests;

import Helpers.LoadDataHelper;
import model.DocForLoad;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/LOAD_BORN_ADMIR_KRON_OUT.txt")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new DocForLoad(split[0], split[1], split[2], split[3], split[4], split[5])});
            line = reader.readLine();
        }
        return list.iterator();

    }

    @BeforeMethod
    public void initLoadDataForm(){
        //переход на страницу загрузки
        gotoLoadDataPage();
    }

    @Test(dataProvider = "validDoc")
    public void testLoadNewDocGroup(DocForLoad docAtt) throws InterruptedException {



        //заполнение полей формы
        fillLoadNewDocGroupFofm(docAtt);

        //запуск загрузки
        submitLoad();

        //ожидание конца загрузки группы документов
        waitingLogText();

        //проверка текста в поле Лог загрузки
        String textarea = waitingLogText();

        assertThat(textarea, startsWith("Загрузка запущена"));
        System.out.println(" -------------------------------- ");
        System.out.println(textarea);
        System.out.println();
    }

}

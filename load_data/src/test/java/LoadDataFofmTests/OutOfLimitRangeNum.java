package LoadDataFofmTests;

import Helpers.LoadDataHelper;
import model.DocForLoad;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Locators.LoadDataFormLocators.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by k.smotrov on 12.05.2017.
 */
public class OutOfLimitRangeNum extends LoadDataHelper{

    @BeforeMethod
    public void initLoadDataForm(){
        //данные для проверки
        String typedoc = "Книга записей актов (2000-2003)";
        String typeags = "Запись акта о рождении";
        String year = "2003";
        String typezags = "Адмиралтейский (1994-2003)";
        String fNum = "";
        String lNum = "";

        docAttr = new DocForLoad(typezags, typeags, year, typedoc, fNum, lNum);

        //переход на страницу загрузки
        gotoLoadDataPage();
    }




    @Test //больше 500 док внутри 1-999999
    public void testOutOfLimitRangeNum() throws InterruptedException {

        docAttr.setfNum("1");
        docAttr.setlNum("502");

        //переход на страницу загрузки
        gotoLoadDataPage();

        //заполнение формы
        fillLoadNewDocGroupFofm (docAttr);

        //запуск загрузки
        submitLoad();

        // проверка на наличие инфобокса, его заголовка и текста
        System.out.println("--------------");
        checkInfoBox();

        //закрытие инфобокса
        click(INFO_BOX_NUM_BTN);

        // проверка алертов у полей номеров
        checkFNumFieldAlert();
        checkLNumFieldAlert();
    }

    @Test //Начальный номер больше 999999
    public void testFNumTooBig() throws InterruptedException {

        docAttr.setfNum("1000000");
        docAttr.setlNum("1");

        //переход на страницу загрузки
        gotoLoadDataPage();

        //заполнение формы
        fillLoadNewDocGroupFofm (docAttr);

        //проверка алерта Начального номера
        System.out.println("--------------");
        System.out.println("Начальный номер = " + docAttr.fNum);
        System.out.println("Конечный номер = " + docAttr.lNum);
        checkFNumFieldAlert();
    }

    @Test //Конечный номер больше 999999
    public void testLNumTooBig() throws InterruptedException {

        docAttr.setfNum("1");
        docAttr.setlNum("1000000");


        //переход на страницу загрузки
        gotoLoadDataPage();

        //заполнение формы
        fillLoadNewDocGroupFofm (docAttr);

        //проверка алерта Начального номера
        System.out.println("--------------");
        System.out.println("Начальный номер = " + docAttr.fNum);
        System.out.println("Конечный номер = " + docAttr.lNum);
        checkLNumFieldAlert();
    }

    @Test //Начальный и Конечный номера больше 999999
    public void testAllNumTooBig() throws InterruptedException {

        docAttr.setfNum("1000000");
        docAttr.setlNum("1000000");


        //переход на страницу загрузки
        gotoLoadDataPage();

        //заполнение формы
        fillLoadNewDocGroupFofm (docAttr);

        // проверка алертов у полей номеров
        System.out.println("--------------");
        System.out.println("Начальный номер = " + docAttr.fNum);
        System.out.println("Конечный номер = " + docAttr.lNum);
        checkFNumFieldAlert();

    }

}

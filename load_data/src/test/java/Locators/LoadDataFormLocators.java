package Locators;

/**
 * Created by k.smotrov on 03.05.2017.
 */
public abstract class LoadDataFormLocators {

    //поля формы
    public static String PVV_SPAN = "//div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span";
    public static String LOAD_BTN = "//div[1]/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button";
    public static String TYPE_DOC = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[1]/div[1]/div/input";
    public static String TYPE_AGS = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[2]/div[1]/div/input";
    public static String YEAR = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[3]/div[1]/div/input";
    public static String TYPE_ZAGS = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/div[4]/div[1]/div/input";
    public static String F_NUM = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/fieldset/div/div[1]/div[1]/div/input";
    public static String L_NUM = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/fieldset/div/div[2]/div[1]/div/input";
    public static String LOAD_RUN_BTN = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[2]/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button";

    //значки алертов значений полей
    public static String F_NUM_ALRT = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/fieldset/div/div[1]/div[1]/img";
    public static String L_NUM_ALRT = "//div[1]/div/div[2]/div/table/tbody/tr/td[1]/fieldset/div/div/div[2]/div[1]/form/fieldset/div/div[2]/div[1]/img";

    //инфобокс "неверные значения"
    public static String INFO_BOX_NUM = "//body/div[8]";
    public static String INFO_BOX_NUM_SPAN = "//body/div[8]/div[1]/div/div/div/span";
    public static String INFO_BOX_NUM_TEXT = "//body/div[8]/div[2]/div[1]/div/div/div/div[2]/span";
    public static String INFO_BOX_NUM_BTN = "//body/div[8]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em/button";

    //маска "Загрузка данных..." при загрузке документов из ЗАГС
    public static String MASK = "//body/div[1]/div/div[2]/div[3]/div";

    //вкладка "Главная"
    public static String MAIN_SPAN = "html/body/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span";
}

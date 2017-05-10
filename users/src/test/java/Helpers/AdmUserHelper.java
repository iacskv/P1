package Helpers;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by k.smotrov on 11.04.2017.
 */
public class AdmUserHelper extends BaseHelper {



    //
    //методы создания нового юзера
    //

        protected void initCreateNewUser() {
        String newUserButton = "//div[1]//button[text() = 'Создать']";

        wd.findElement(By.xpath(newUserButton)).click();
    }

    protected void gotoUsersList() {
        wd.findElement(By.xpath("//div[1]//button[text() = 'Пользователи']")).click();
    }

    protected void gotoAdminUsersSpan() {
        wd.findElement(By.xpath("//div[1]//span[text() = 'Администрирование']")).click();
    }

    protected void fillNewUserForm(String loginNewUser, String passNewUser, String confPassNewUser, String lastName, String firstName, String middleName,
                                   String address, String tel, String rang, String room, String notes) {
        String fildNewUserLogin = ".//*/fieldset[1]//div[label[text()='Логин']]//input";
        String fildNewUserPas = ".//*/fieldset[1]//div[label[text()='Пароль']]//input";
        String fildNewUserPasAgain = ".//*/fieldset[1]//div[label[text()='Подтверждение']]//input";
        String fildLastName = ".//*/fieldset[2]//div[label[text()='Фамилия:']]//input";
        String fildFirstName = ".//*/fieldset[2]//div[label[text()='Имя:']]//input";
        String fildMiddleName = ".//*/fieldset[2]//div[label[text()='Отчество:']]//input";
        String fildAdress = ".//*/fieldset[2]//div[label[text()='Адрес:']]//input";
        String fildTel = ".//*/fieldset[2]//div[label[text()='Телефон:']]//input";
        String fildRang = ".//*/fieldset[2]//div[label[text()='Должность:']]//input";
        String fildRoom = ".//*/fieldset[2]//div[label[text()='Кабинет:']]//input";
        String fildDesc = ".//*/fieldset[2]//div[label[text()='Описание:']]//textarea";


        wd.findElement(By.xpath(fildNewUserLogin)).click();
        wd.findElement(By.xpath(fildNewUserLogin)).clear();
        wd.findElement(By.xpath(fildNewUserLogin)).sendKeys(loginNewUser);

        wd.findElement(By.xpath(fildNewUserPas)).click();
        wd.findElement(By.xpath(fildNewUserPas)).clear();
        wd.findElement(By.xpath(fildNewUserPas)).sendKeys(passNewUser);

        wd.findElement(By.xpath(fildNewUserPasAgain)).click();
        wd.findElement(By.xpath(fildNewUserPasAgain)).clear();
        wd.findElement(By.xpath(fildNewUserPasAgain)).sendKeys(confPassNewUser);

        wd.findElement(By.xpath(fildLastName)).click();
        wd.findElement(By.xpath(fildLastName)).clear();
        wd.findElement(By.xpath(fildLastName)).sendKeys(lastName);

        wd.findElement(By.xpath(fildFirstName)).click();
        wd.findElement(By.xpath(fildFirstName)).clear();
        wd.findElement(By.xpath(fildFirstName)).sendKeys(firstName);

        wd.findElement(By.xpath(fildMiddleName)).click();
        wd.findElement(By.xpath(fildMiddleName)).clear();
        wd.findElement(By.xpath(fildMiddleName)).sendKeys(middleName);

        wd.findElement(By.xpath(fildAdress)).click();
        wd.findElement(By.xpath(fildAdress)).clear();
        wd.findElement(By.xpath(fildAdress)).sendKeys(address);

        wd.findElement(By.xpath(fildTel)).click();
        wd.findElement(By.xpath(fildTel)).clear();
        wd.findElement(By.xpath(fildTel)).sendKeys(tel);

        wd.findElement(By.xpath(fildRang)).click();
        wd.findElement(By.xpath(fildRang)).clear();
        wd.findElement(By.xpath(fildRang)).sendKeys(rang);

        wd.findElement(By.xpath(fildRoom)).click();
        wd.findElement(By.xpath(fildRoom)).clear();
        wd.findElement(By.xpath(fildRoom)).sendKeys(room);

        wd.findElement(By.xpath(fildDesc)).click();
        wd.findElement(By.xpath(fildDesc)).clear();
        wd.findElement(By.xpath(fildDesc)).sendKeys(notes);


    }

    protected void selectRoleToUser() {

        String flagAdminRole = ".//*/fieldset//div[4]/table/tbody/tr/td[1]/div/div";

        wd.findElement(By.xpath(flagAdminRole)).click();
    }

    protected void submitFillNewUserForm() {
        wd.findElement(By.xpath(".//*/div[8]//button[text() = 'Создать пользователя']")).click();
    }

    protected void confirmInfoBoxNewUser() {
        wd.findElement(By.xpath(".//*/div[9]//table//em/button")).click();
    }

    protected void closeNewUserForm() {
        wd.findElement(By.xpath(".//*/div[8]//button[text() = 'Закрыть']")).click();
    }

    //
    // методы удаления юзара
    //

    protected void confirmInfoBoxDeletedUser() {
        wd.findElement(By.xpath("//div[8]//table//button[text()=\"Ok\"]")).click();
    }

    protected void confirmInitDeleteingUser() {
        wd.findElement(By.xpath("//div[8]//table//table//table//button[text()=\"Да\"]")).click();
    }

    protected void initDeleteingUser() {
        wd.findElement(By.xpath("//div[1]//table//table//table//button[text()=\"Удалить\"]")).click();
    }

    protected void sortUserById() {
        //сортировка по убыванию id
        wd.findElement(By.xpath("//div[1]//table//span[text()='id пользователя']")).click();
        wd.findElement(By.xpath("//div[1]//table//span[text()='id пользователя']")).click();
    }

    protected String takeNameUser1() {
        String user1LoginSell = "//div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[3]/div";

        return wd.findElement(By.xpath(user1LoginSell)).getText();
    }

    protected String takeNameUser1InfBox() {
    return wd.findElement(By.xpath("//div[8]//div[2]/span")).getText();
    }
}

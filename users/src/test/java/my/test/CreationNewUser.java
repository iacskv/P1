package my.test;

import Helpers.AdmUserHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreationNewUser extends AdmUserHelper {


    @Test
    public void creationNewUser() {

        gotoAdminUsersSpan();
        gotoUsersList();
        initCreateNewUser();
        fillNewUserForm("user1", "pass", "pass", "Фамилия", "Имя", "Отчество",
                "Адрес, Улица, Дом", "+7 921 9998877", "Должность", "Комната", "Описание");
        selectRoleToUser();
        submitFillNewUserForm();
        Assert.assertEquals(wd.findElement(By.xpath("//div[9]/div[2]/div[1]/div/div/div/div[2]/span")).getText(), "Пользователь user1 успешно создан.");
        confirmInfoBoxNewUser();
        closeNewUserForm();
    }

}

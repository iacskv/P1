package my.test;

import Helpers.AdmUserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletionUser extends AdmUserHelper {


    @Test
    public void deletionUser() {

        gotoAdminUsersSpan();
        gotoUsersList();
        sortUserById();
        Assert.assertEquals(takeNameUser1(), "user1");
        initDeleteingUser();
        Assert.assertEquals(takeNameUser1InfBox(), "Вы уверены, что хотите удалить пользователя user1?");
        confirmInitDeleteingUser();
        Assert.assertEquals(takeNameUser1InfBox(), "Пользователь user1 был успешно удален.");
        confirmInfoBoxDeletedUser();
    }


}

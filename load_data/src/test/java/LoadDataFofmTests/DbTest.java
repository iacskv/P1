package LoadDataFofmTests;

import Helpers.DbHelper;
import org.testng.annotations.Test;

/**
 * Created by k.smotrov on 11.05.2017.
 */
public class DbTest {

    @Test (enabled = false)
    public void dbTest(){
        DbHelper.jdbcTemplate().queryForObject("select 1 from dual",Long.class);
    }
}

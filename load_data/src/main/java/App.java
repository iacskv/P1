import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * Created by k.smotrov on 15.05.2017.
 */
public class App {
    private static DataSource dataSource;
    private static String inputarenaJdbcUrl = "jdbc:oracle:thin:@pvvdev-db.dev.zagz.adc.spb:1521:pvvdev";
    private static String inputarenaJdbcUsername = "inputarena";
    private static String inputarenaJdbcPassword = "inputarena";
    private static String inputarenaJdbcClass = "oracle.jdbc.driver.OracleDriver";

    private static DataSource getDataSource() {

        if (dataSource == null) {
            HikariConfig config = new HikariConfig();

            config.setJdbcUrl(inputarenaJdbcUrl);
            config.setUsername(inputarenaJdbcUsername);
            config.setPassword(inputarenaJdbcPassword);
            config.setDriverClassName(inputarenaJdbcClass);
            config.setPoolName("dsInputArena");
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(10);
            config.setConnectionTestQuery("select 1 from dual");

            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }

//    public static JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate(getDataSource());
//    }
    public static void main(String[] args) {
        getDataSource();

    }
}

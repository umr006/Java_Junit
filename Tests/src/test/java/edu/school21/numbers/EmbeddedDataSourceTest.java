package edu.school21.numbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;
import javax.sql.DataSource;


public class EmbeddedDataSourceTest {

    private EmbeddedDatabase db = null;

    @BeforeEach
    public void init() {
        db = new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(HSQL)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .addScripts("data.sql")
                .build();
    }

    @Test
    public void initTest() throws SQLException {
        assertNotNull(db.getConnection());
    }

    @AfterEach
    public void conDown () {
        db.shutdown();
    }

}

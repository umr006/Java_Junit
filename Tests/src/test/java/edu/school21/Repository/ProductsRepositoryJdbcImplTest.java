package edu.school21.Repository;

import edu.school21.Models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

//INSERT INTO products VALUES (1, 'Product 1', 10);
//INSERT INTO products VALUES (2, 'Product 2', 20);
//INSERT INTO products VALUES (3, 'Product 3', 30);
//INSERT INTO products VALUES (4, 'Product 4', 40);
//INSERT INTO products VALUES (5, 'Product 5', 50);
//INSERT INTO products VALUES (6, 'Product 6', 60);

public class ProductsRepositoryJdbcImplTest {

    private DataSource ds;
    private ProductsRepositoryJdbcImpl productsRepositoryJdbc;


    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1, "Product 1", BigDecimal.valueOf(10)),
            new Product(2, "Product 2", BigDecimal.valueOf(20)),
            new Product(3, "Product 3", BigDecimal.valueOf(30)),
            new Product(4, "Product 4", BigDecimal.valueOf(40)),
            new Product(5, "Product 5", BigDecimal.valueOf(50)),
            new Product(6, "Product 6", BigDecimal.valueOf(60))
    );
    final Product EXPECTED_FIND_FIND_ID = new Product(2, "Product 2", BigDecimal.valueOf(20));
    final Product EXPECTED_UPDATE_PRODUCT = new Product(3, "Product 12", BigDecimal.valueOf(120));
    final Product EXPECTED_SAVE_PRODUCT = new Product(7, "Product 7", BigDecimal.valueOf(70));

    @BeforeEach
    public void init() throws SQLException {
        ds = new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(HSQL)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .addScripts("data.sql")
                .build();
        productsRepositoryJdbc = new ProductsRepositoryJdbcImpl(ds);
    }

    @Test
    public void testFindAll() {
        List<Product> actual = productsRepositoryJdbc.findAll();
         assertEquals(EXPECTED_FIND_ALL_PRODUCTS, actual);
    }

    @Test
    public void testFindById() {
        assertEquals(EXPECTED_FIND_FIND_ID, productsRepositoryJdbc.findById(2L).get());
    }
}

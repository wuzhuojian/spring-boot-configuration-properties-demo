package com.example.demo;

import com.example.demo.config.AppProperties;
import com.example.demo.model.Security;
import org.apache.juli.FileHandler;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigPropertiesDemoApplicationTests {

    @Autowired
    AppProperties appProperties;

    static String fileName = "debug";

    static String filePath = "logs/" + fileName + ".log";

    static File file = new File(filePath);

    @BeforeClass
    public static void before() {
        System.out.println("开始测试-----------------");
        delete(new File("logs/"));
    }

    @Test
    public void contextLoads() throws IOException {

        assertEquals("ConfigurationPropertiesDemoApp", appProperties.getName());

        List<Security> securitys = appProperties.getSecurity();

        Security security1 = securitys.get(0);
        Security security2 = securitys.get(1);

        assertEquals("callicoder1", security1.getUsername());
        assertEquals("callicoder2", security2.getUsername());

        Assert.assertThat(readAll(filePath), containsString("AppProperties Start"));
    }

    private String readAll(String path) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String string = reader.readLine();
            while (string != null) {
                builder.append(string + System.getProperty("line.separator"));
                string = reader.readLine();
            }
        }

        return builder.toString();
    }

    private static void delete(File f) {
        if (f.exists() == false) {
            return;
        }
        if (f.isFile()) {
            f.delete();
        } else if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                delete(files[i]);
            }
            f.delete();
        }
    }

    @AfterClass
    public static void after() {
        System.out.println("结束测试-----------------");
        delete(new File("logs/"));
    }

}

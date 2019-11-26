package com.example.demo;

import com.example.demo.config.AppProperties;
import com.example.demo.model.Security;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active= default"})
public class ConfigPropertiesDemoApplicationTests {

    @Autowired
    AppProperties appProperties;

    @BeforeClass
    public static void before() throws IOException {
        System.out.println("ConfigPropertiesDemoApplicationTests.before Start");
        Files.deleteIfExists(Paths.get("logs/debug.log"));
        System.out.println("ConfigPropertiesDemoApplicationTests.before End");
    }

    @AfterClass
    public static void after() throws IOException {
        System.out.println("ConfigPropertiesDemoApplicationTests.after Start");
        System.out.println("ConfigPropertiesDemoApplicationTests.after End");
    }

    @Test
    public void contextLoads() throws IOException {

        ConfigPropertiesDemoApplication.main(new String[] {});

        assertEquals("ConfigurationPropertiesDemoApp", appProperties.getName());

        List<Security> securitys = appProperties.getSecurity();

        Security security1 = securitys.get(0);
        Security security2 = securitys.get(1);

        assertEquals("callicoder1", security1.getUsername());
        assertEquals("callicoder2", security2.getUsername());

        Assert.assertThat(Files.readAllLines(Paths.get("logs/debug.log")).toString(), containsString("AppProperties Start"));

        File file = ResourceUtils.getFile("classpath:META-INF/spring-configuration-metadata.json");
        File expectFile = ResourceUtils.getFile("file:./expect/spring-configuration-metadata.json");
        assertTrue(file.exists());

        String contents = Files.readAllLines(Paths.get(file.getPath())).toString();
        String expectContents = Files.readAllLines(Paths.get(expectFile.getPath())).toString();

        assertEquals(expectContents, contents);
    }

}

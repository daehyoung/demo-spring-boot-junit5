package kr.luxsoft.datasink;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.luxsoft.datasink.properties.DataSinkProperties;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ExtendWith(SpringExtension.class)
//@ComponentScan("kr.luxsoft")
@SpringBootTest(classes=TestContext.class)
//@TestPropertySource("classpath:application.properties")
//@ContextConfiguration( classes=TestContext.class, loader=AnnotationConfigContextLoader.class)
//(classes= {DataSinkProperties.class})
public class TestDataSink {

	@Autowired 
	DataSinkProperties properties;
	
	@Autowired
	DataSink sink;
	
	@DisplayName("contextLoads()")
	@Test
	public void contextLoads() {
		log.debug(" name :: {}",properties.getName());
	}
	
	@Tag("test")
	@Test
	void test() {
		assertAll("person",
	            () -> assertEquals("output", properties.getName()),
	            () -> assertEquals(false, properties.isSingleOutput())
	        );
	}
	
	@Test
	@Disabled("Disabled until bug #42 has been resolved")
	void disabledTest() {
		log.info("disabledTest()");
	}
	
	@EnabledOnOs(OS.MAC)
	void testOnMac1() {
		log.info("testOnMac1()");
	}
	
	@EnabledOnOs(OS.WINDOWS)
	void testOnWindows() {
		log.info("testOnWindows()");
	}
	

	
	
	@BeforeAll
    static void initAll() {
		log.info("initAll()");
    }

    @BeforeEach
    void init() {
    	log.info("init()");
    }

    @AfterEach
    void tearDown() {
    	log.info("tearDown()");
    }

    @AfterAll
    static void tearDownAll() {
    	log.info("tearDownAll()");
    }
    
}

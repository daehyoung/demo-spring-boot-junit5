package kr.luxsoft.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.luxsoft.datasink.properties.DataSinkProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@ComponentScan("kr.luxsoft")
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(properties="loggig.level.kr.luxsoft=DEBUG")
public class DemoConfigApplicationTests {
	

	@Autowired 
	DataSinkProperties properties;
	
	@Test
	void contextLoads() {
		log.info(" contextLoads()" );
	}
	
	@Test
	public void test() {
		log.debug(" name :: {}",properties.getName());
	}

}

# demo-spring-boot-junit5

##  spring-boot-starter-test dependency를  pom에 추가 

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

## 




## integration test : context를 loading 하기 위해 @ExtendWith(SpringExtension.class)를 Test class에 추가

```
package kr.luxsoft.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoUnitTestApplicationTests {


	@Test
	void contextLoads() {
	}
	
	@Test
	void test() {
		
	}
}

```

## 사용하기 원하는 Context class(DemoUnitTestApplication)를 지정한다.
```

 @SpringBootTest(classes=DemoUnitTestApplication.class)
```


## Test에 사용할 properties파일을 설정한다.

@TestPropertySource("classpath:application.properties")





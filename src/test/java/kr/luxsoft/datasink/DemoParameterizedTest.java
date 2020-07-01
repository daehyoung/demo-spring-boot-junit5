package kr.luxsoft.datasink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=TestContext.class)
public class DemoParameterizedTest {

	
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void testWithValueSource(int argument) {
	    assertTrue(argument > 0 && argument < 4);
	}
	
	
	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithExplicitLocalMethodSource(String argument) {
	    assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
	    return Stream.of("apple", "banana");
	}
	
	
	@ParameterizedTest
	@CsvSource({
	    "apple,         1",
	    "banana,        2",
	    "'lemon, lime', 0xF1"
	})
	
	
	void testWithCsvSource(String fruit, int rank) {
		log.debug(" testWithCsvSource() :: {} {}",fruit,rank);
	    assertNotNull(fruit);
	    assertNotEquals(0, rank);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
	void testWithCsvFileSource(String country, int reference) {
	    assertNotNull(country);
	    assertNotEquals(0, reference);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "01.01.2017", "31.12.2017" })
	void testWithExplicitJavaTimeConverter(
	        @JavaTimeConversionPattern("dd.MM.yyyy") LocalDate argument) {

	    assertEquals(2017, argument.getYear());
	}
	
	
}

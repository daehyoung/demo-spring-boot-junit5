package kr.luxsoft.datasink;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;

import kr.luxsoft.datasink.builder.QueryBuilder;

@Setter
@Getter
@RequiredArgsConstructor
@Component
public class DataSink {

	QueryBuilder builder;
	String template;
	String name;
		
}

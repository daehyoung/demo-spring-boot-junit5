package kr.luxsoft.datasink.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ConfigurationProperties(prefix="datasink")
public class DataSinkProperties {
	String name;
	boolean singleOutput;
}

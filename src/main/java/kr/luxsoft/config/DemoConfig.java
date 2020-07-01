package kr.luxsoft.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import kr.luxsoft.datasink.properties.DataSinkProperties;
@Configuration
@EnableConfigurationProperties({DataSinkProperties.class})
public class DemoConfig {

}

package in.phani.infludb.influx2springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "influx")
@Configuration
@Getter
@Setter
public class InfluxDbConfig{
    private String url;
    private String token;
    private String org;
}

package in.phani.infludb.influx2springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Influx2springbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Influx2springbootApplication.class, args);
    }

}

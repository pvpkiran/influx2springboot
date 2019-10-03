package in.phani.infludb.influx2springboot.config;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

    @Bean
    public InfluxDBClient getInfluxConnection(InfluxDbConfig influxDbConfig){
        return InfluxDBClientFactory.create(influxDbConfig.getUrl(), influxDbConfig.getToken().toCharArray());
    }
}

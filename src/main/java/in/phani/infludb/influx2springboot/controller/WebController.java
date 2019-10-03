package in.phani.infludb.influx2springboot.controller;

import com.influxdb.query.FluxRecord;
import in.phani.infludb.influx2springboot.service.InfluxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/influx")
public class WebController {

  private final InfluxService influxService;

    public WebController(InfluxService influxService) {
        this.influxService = influxService;
    }

    @GetMapping("/load")
    public void initialize(){
        influxService.writeDataToInflux();
    }

    @GetMapping("/findall")
    public List<List<FluxRecord>> findall(){
        return influxService.findAll();
    }
}

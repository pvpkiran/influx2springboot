package in.phani.infludb.influx2springboot.service;

import com.google.common.collect.Lists;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApi;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import in.phani.infludb.influx2springboot.utils.RandomPointsGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluxService {

    private final InfluxDBClient influxDBClient;
    private final RandomPointsGenerator randomPointsGenerator;

    public InfluxService(InfluxDBClient influxDBClient,
                         RandomPointsGenerator randomPointsGenerator) {
        this.influxDBClient = influxDBClient;
        this.randomPointsGenerator = randomPointsGenerator;
    }
    public void writeDataToInflux(){
        try (WriteApi writeApi = influxDBClient.getWriteApi()) {
            List<Point> points = randomPointsGenerator.generatePoints();
            writeApi.writePoints(points);
        }
    }

    public List<List<FluxRecord>> findAll() {
        String flux = "from(bucket:\"online-store\") |> range(start: 0)";

        QueryApi queryApi = influxDBClient.getQueryApi();

        List<FluxTable> tables = queryApi.query(flux);
        List<List<FluxRecord>> recordsList = Lists.newArrayList();
        for (FluxTable fluxTable : tables) {
            List<FluxRecord> records = fluxTable.getRecords();
            for (FluxRecord fluxRecord : records) {
                System.out.println(fluxRecord.getTime() + ": " + fluxRecord.getValueByKey("_value"));
            }
            recordsList.add(records);
        }
        return recordsList;
    }
}

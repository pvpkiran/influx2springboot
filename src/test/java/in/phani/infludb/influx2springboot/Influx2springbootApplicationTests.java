package in.phani.infludb.influx2springboot;

import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Influx2springbootApplicationTests {
    public static void main(String[] args) {

        List<String> types = Lists.newArrayList("Electronics",
                "Food",
                "Clothes",
                "Books",
                "Sports",
                "Kitchen",
                "Travel",
                "Baby",
                "Shoes",
                "Songs",
                "Movies",
                "Home",
                "Garden",
                "Adventure",
                "Leisure");

        List<String> cities = Lists.newArrayList("Tokyo",
                "Delhi",
                "Shanghai",
                "Sao Paulo",
                "Mumbai",
                "Mexico CityÂ ",
                "Beijing",
                "OsakaÂ ",
                "CairoÂ ",
                "New York",
                "Dhaka",
                "Karachi",
                "Buenos Aires",
                "Kolkata",
                "Istanbul",
                "Chongqing",
                "Lagos",
                "Manila",
                "Rio de Janeiro",
                "Guangzhou",
                "Los Angeles",
                "MoscowÂ ",
                "Kinshasa",
                "Tianjin",
                "Paris",
                "Shenzhen",
                "Jakarta",
                "London",
                "Bangalore",
                "Lima",
                "ChennaiÂ ",
                "Seoul",
                "BogotÃ¡",
                "NagoyaÂ ",
                "Johannesburg",
                "Bangkok",
                "Hyderabad",
                "Chicago",
                "Lahore",
                "Tehran",
                "Wuhan",
                "Chengdu",
                "Dongguan",
                "Nanjing",
                "Ahmadabad",
                "Hong Kong",
                "Ho Chi Minh CityÂ ",
                "Foshan",
                "Kuala Lumpur",
                "Baghdad",
                "Santiago",
                "Hangzhou",
                "RiyadhÂ ",
                "Shenyang",
                "Madrid",
                "Xi'an",
                "Toronto",
                "Miami",
                "Pune Â ",
                "Belo Horizonte",
                "Dallas",
                "Surat",
                "Houston",
                "Singapore",
                "Philadelphia",
                "Kitakyushu",
                "Luanda",
                "Suzhou",
                "Haerbin",
                "Barcelona",
                "Atlanta",
                "KhartoumÂ ",
                "Dar es Salaam",
                "Saint PetersburgÂ ",
                "Washington, D.C.",
                "Abidjan",
                "Guadalajara",
                "Yangon",
                "AlexandriaÂ ",
                "Ankara",
                "Kabul",
                "Qingdao",
                "Chittagong",
                "Monterrey",
                "Sydney",
                "Dalian",
                "Xiamen",
                "Zhengzhou",
                "Boston",
                "Melbourne",
                "BrasÃ­lia",
                "Jiddah",
                "Phoenix",
                "Ji'nanÂ ",
                "MontrÃ©al",
                "Shantou",
                "Nairobi",
                "MedellÃ­n",
                "Fortaleza",
                "Kunmin"
                );
        Random typeRandom = new Random();
        int randomIndex = typeRandom.nextInt(types.size());
        String randomElement = types.get(randomIndex);

        List<ChronoUnit> units = Lists.newArrayList(ChronoUnit.DAYS,
                ChronoUnit.SECONDS,
                ChronoUnit.HOURS,
                ChronoUnit.MILLIS,
                ChronoUnit.MINUTES);
        Random unitRandom = new Random();

        IntStream.range(1, types.size()).forEach(i -> {
            Random brandRandom = new Random();
            Random priceRandom = new Random();
            Random cityRandom = new Random();

            for(int j=0;j<100;j++){
                int cityRandomIndex = cityRandom.nextInt(cities.size());
                String city = cities.get(cityRandomIndex);

                int brandInt = brandRandom.nextInt(100);
                int unitRandomIndex = unitRandom.nextInt(units.size());
                ChronoUnit unit = units.get(unitRandomIndex);

                Instant instant = Instant.now().minus(brandInt, unit);

                double price = priceRandom.nextInt(100000);
                String brand = "brand-"+ brandInt;
                Point point = Point.measurement("order")
                        .addTag("type", randomElement)
                        .addTag("brand", brand)
                        .addField("location", city)
                        .addField("price", price)
                        .time(instant.toEpochMilli(), WritePrecision.NS);
                System.out.println("point = " + point);
            }
        });
    }
}

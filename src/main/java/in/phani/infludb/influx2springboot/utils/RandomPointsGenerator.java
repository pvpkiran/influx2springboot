package in.phani.infludb.influx2springboot.utils;

import com.google.common.collect.Lists;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class RandomPointsGenerator {
    public List<Point> generatePoints(){
        List<Point> points = Lists.newArrayList();
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

        IntStream.range(0, types.size()).forEach(i -> {
            Random unitRandom = new Random();
            Random brandRandom = new Random();
            Random priceRandom = new Random();
            Random cityRandom = new Random();

            IntStream.range(0,100).forEach(j ->{
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
                points.add(point);
            });
        });
        return points;
    }
}

package Project7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherService {

    public static WeatherData getWeather(String city) {

        try {

            String encodedCity =
                    URLEncoder.encode(
                            city,
                            StandardCharsets.UTF_8);

            String weatherUrl =
                    "https://wttr.in/"
                            + encodedCity
                            + "?format=j1";

            URL url =
                    URI.create(weatherUrl)
                            .toURL();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    url.openStream()));

            StringBuilder response =
                    new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            String json = response.toString();

            double temperature =
                    Double.parseDouble(
                            extract(
                                    json,
                                    "\"temp_C\":\"",
                                    "\""));

            int humidity =
                    Integer.parseInt(
                            extract(
                                    json,
                                    "\"humidity\":\"",
                                    "\""));

            double windSpeed =
                    Double.parseDouble(
                            extract(
                                    json,
                                    "\"windspeedKmph\":\"",
                                    "\""));

            String condition =
                    extract(
                            json,
                            "\"weatherDesc\":[{\"value\":\"",
                            "\"");

            return new WeatherData(
                    city,
                    temperature,
                    humidity,
                    windSpeed,
                    condition);

        } catch (Exception e) {

            System.out.println(
                    "Unable to retrieve weather data.");

            e.printStackTrace();

            return null;
        }
    }

    private static String extract(
            String source,
            String start,
            String end) {

        int startIndex =
                source.indexOf(start);

        if (startIndex == -1) {
            return "0";
        }

        startIndex += start.length();

        int endIndex =
                source.indexOf(
                        end,
                        startIndex);

        return source.substring(
                startIndex,
                endIndex);
    }
}
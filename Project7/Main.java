package Project7;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "==================================");
        System.out.println(
                " WEATHER FORECAST APPLICATION");
        System.out.println(
                "==================================");

        System.out.println(
                "\nDetecting user location...");

        String city =
                LocationService.detectCity();

        if (city == null ||
                city.isBlank()) {

            System.out.println(
                    "Unable to detect location.");
            return;
        }

        System.out.println(
                "Detected City: " + city);

        WeatherData weather =
                WeatherService.getWeather(city);

        if (weather != null) {

            System.out.println(weather);

        } else {

            System.out.println(
                    "Weather information unavailable.");
        }
    }
}
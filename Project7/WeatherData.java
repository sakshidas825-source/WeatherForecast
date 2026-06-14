package Project7;

public class WeatherData {

    private String city;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String condition;

    public WeatherData(String city,
                       double temperature,
                       int humidity,
                       double windSpeed,
                       String condition) {

        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
    }

    @Override
    public String toString() {

        return "\n========== WEATHER REPORT ==========\n" +
                "City        : " + city + "\n" +
                "Temperature : " + temperature + " °C\n" +
                "Humidity    : " + humidity + "%\n" +
                "Wind Speed  : " + windSpeed + " km/h\n" +
                "Condition   : " + condition + "\n" +
                "====================================";
    }
}
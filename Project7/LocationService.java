package Project7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class LocationService {

    public static String detectCity() {

        try {

            URL url = URI
                    .create("https://ipapi.co/city/")
                    .toURL();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    url.openStream()));

            String city = reader.readLine();

            reader.close();

            return city;

        } catch (Exception e) {

            System.out.println("Location detection failed.");
            e.printStackTrace();

            return null;
        }
    }
}
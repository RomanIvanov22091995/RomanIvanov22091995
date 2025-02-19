import org.wethersdk.WeatherSDK;


public class SdkApp {
    public static void main(String[] args) {
        WeatherSDK sdk = new WeatherSDK("your_api_key_here", "your_username");

        String weatherData = sdk.getWeather("London");
        System.out.println(weatherData);
    }
}


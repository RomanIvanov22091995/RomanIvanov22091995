# Weather SDK for Java

This SDK is simple interface for access to API OpenWeatherMap and get weather data.

* We don't use some frameworks and libraries except lombok.

## Installing

Add dependency in your  `pom.xml`:

```xml
<dependency>
    <groupId>com.weathersdk</groupId>
    <artifactId>weather-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

This SDK uses [Lombok](https://projectlombok.org/) for automatic boilerplate code generation. Ensure Lombok is installed in your IDE.
```xml
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<version>1.18.30</version>
<scope>provided</scope>
</dependency>
```

## Using

### Import SDK in your project:

```
import com.weathersdk.WeatherSDK;
import com.weathersdk.exceptions.*;
```
* to use the app need to buy license 

### Initialize SDK with your API-key and username:

```
 WeatherSDK sdk = new WeatherSDK("your_api_key_here", "your_username");
        
        //choose need location by city
        String weatherData = sdk.getWeather("London");
        System.out.println(weatherData);
```

## Response example

### Example JSON-response from API:

```
{
  "coord": { "lon": -0.13, "lat": 51.51 },
  "weather": [
    {
      "id": 800,
      "main": "Clear",
      "description": "clear sky",
      "icon": "01d"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 282.55,
    "feels_like": 281.86,
    "temp_min": 280.37,
    "temp_max": 284.26,
    "pressure": 1023,
    "humidity": 100
  },
  "visibility": 10000,
  "wind": { "speed": 1.5, "deg": 350 },
  "clouds": { "all": 1 },
  "dt": 1560350645,
  "sys": {
    "type": 1,
    "id": 1414,
    "country": "GB",
    "sunrise": 1560281377,
    "sunset": 1560333478
  },
  "timezone": 3600,
  "id": 2643743,
  "name": "London",
  "cod": 200
}
```

### Лицензия
Этот проект распространяется под лицензией MIT.
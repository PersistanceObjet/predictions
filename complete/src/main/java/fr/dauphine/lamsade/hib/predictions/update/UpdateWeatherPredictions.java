/**
 *
 * @author mehdi
 */
package fr.dauphine.lamsade.hib.predictions.update;
// This Class is used to insert Weather Forecast Data to Our Database 
import fr.dauphine.lamsade.hib.predictions.webservices.Application;
import fr.dauphine.lamsade.hib.predictions.webservices.WeatherClient;
import hello.wsdl.Forecast;
import hello.wsdl.ForecastReturn;
import hello.wsdl.GetCityForecastByZIPResponse;
import hello.wsdl.Temp;
import java.sql.*;
import java.text.SimpleDateFormat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import java.util.logging.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UpdateWeatherPredictions {
    
private static final Logger LOGGER = Logger.getLogger(UpdateWeatherPredictions.class.getCanonicalName());
    public static void main(String args[]) throws Exception {
        SpringApplication.run(Application.class);
    }

    public static void insert(GetCityForecastByZIPResponse response) throws Exception {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/prediction";
        Connection conn = DriverManager.getConnection(url, "postgres", "mehdi");
        String zipCode=null;
        ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();
        
        if (forecastReturn.isSuccess()) {
            
			LOGGER.info("Forecast for " + forecastReturn.getCity() + ", " + forecastReturn.getState());

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {

				Temp temperature = forecast.getTemperatures();

				LOGGER.info(String.format("%s %s %s°-%s°", format.format(forecast.getDate().toGregorianCalendar().getTime()),
						forecast.getDesciption(), temperature.getMorningLow(), temperature.getDaytimeHigh()));
				LOGGER.info("");        
                                 String sql = "INSERT INTO Employees set Temperature=? Humidity=? Weather=? Prediction_Date=? Region=? Country=? City=?  WHERE WebSite_Id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, temperature.getMorningLow());
        pstmt.setString(1, "NA");
        pstmt.setInt(1, forecast.getWeatherID());
        pstmt.setString(1, forecast.getDate().toString());
        pstmt.setString(1, zipCode);
        pstmt.setString(1, zipCode);
        pstmt.setString(1, zipCode);
        pstmt.setInt(1, 1);
         // cast to the pg extension interface
        org.postgresql.PGStatement pgstmt = (org.postgresql.PGStatement) pstmt;

        // on the third execution start using server side statements
        pgstmt.setPrepareThreshold(3);

        for (int i = 1; i <= 5; i++) {
            pstmt.setInt(1, i);
            boolean usingServerPrepare = pgstmt.isUseServerPrepare();
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            System.out.println("Execution: " + i + ", Used server side: " + usingServerPrepare + ", Result: " + rs.getInt(1));
            rs.close();
        }

        pstmt.close();
        conn.close();
			}
		} else {
			LOGGER.info("No forecast received");
                        System.out.println("NO");
		}
       

       

    }

    @Bean
    CommandLineRunner lookup(WeatherClient weatherClient) {
        return args -> {
            String zipCode = "28080";

            if (args.length > 0) {
                zipCode = args[0];
            }
            GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipCode);
            //weatherClient.printResponse(response);
            insert(response);

        };
    }
}

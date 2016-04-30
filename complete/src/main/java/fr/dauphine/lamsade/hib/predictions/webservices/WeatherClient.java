/**
 *
 * @author mehdi
 */
package fr.dauphine.lamsade.hib.predictions.webservices;

import java.text.SimpleDateFormat;

import hello.wsdl.Forecast;
import hello.wsdl.ForecastReturn;
import hello.wsdl.GetCityForecastByZIP;
import hello.wsdl.GetCityForecastByZIPResponse;
import hello.wsdl.Temp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WeatherClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(WeatherClient.class);

	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {

		GetCityForecastByZIP request = new GetCityForecastByZIP();
		request.setZIP(zipCode);

		log.info("Requesting forecast for " + zipCode);

                //System.out.println("iziizi");
		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://wsf.cdyne.com/WeatherWS/Weather.asmx",
						request,
						new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));

		return response;
	}

	public void printResponse(GetCityForecastByZIPResponse response) {
            //System.out.println("izi1");
		ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();
            //System.out.println("izi2");
		if (forecastReturn.isSuccess()) {
			log.info("Forecast for " + forecastReturn.getCity() + ", " + forecastReturn.getState());

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {

				Temp temperature = forecast.getTemperatures();

				log.info(String.format("%s %s %s°-%s°", format.format(forecast.getDate().toGregorianCalendar().getTime()),
						forecast.getDesciption(), temperature.getMorningLow(), temperature.getDaytimeHigh()));
				log.info("");
                                 System.out.println(String.format("%s %s %s°-%s°", format.format(forecast.getDate().toGregorianCalendar().getTime()),
						forecast.getDesciption(), temperature.getMorningLow(), temperature.getDaytimeHigh()));
			}
		} else {
			log.info("No forecast received");
                        System.out.println("NO");
		}
	}

}

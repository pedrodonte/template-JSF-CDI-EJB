
package fr.treeptik.meteo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WeatherSoap", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WeatherSoap {


    /**
     * Gets Information for each WeatherID
     * 
     * @return
     *     returns fr.treeptik.meteo.ArrayOfWeatherDescription
     */
    @WebMethod(operationName = "GetWeatherInformation", action = "http://ws.cdyne.com/WeatherWS/GetWeatherInformation")
    @WebResult(name = "GetWeatherInformationResult", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
    @RequestWrapper(localName = "GetWeatherInformation", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "fr.treeptik.meteo.GetWeatherInformation")
    @ResponseWrapper(localName = "GetWeatherInformationResponse", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "fr.treeptik.meteo.GetWeatherInformationResponse")
    public ArrayOfWeatherDescription getWeatherInformation();

    /**
     * Allows you to get your City Forecast Over the Next 7 Days, which is updated hourly. U.S. Only
     * 
     * @param zip
     * @return
     *     returns fr.treeptik.meteo.ForecastReturn
     */
    @WebMethod(operationName = "GetCityForecastByZIP", action = "http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP")
    @WebResult(name = "GetCityForecastByZIPResult", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
    @RequestWrapper(localName = "GetCityForecastByZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "fr.treeptik.meteo.GetCityForecastByZIP")
    @ResponseWrapper(localName = "GetCityForecastByZIPResponse", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "fr.treeptik.meteo.GetCityForecastByZIPResponse")
    public ForecastReturn getCityForecastByZIP(
        @WebParam(name = "ZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
        String zip);

    /**
     * Allows you to get your City's Weather, which is updated hourly. U.S. Only
     * 
     * @param zip
     * @return
     *     returns fr.treeptik.meteo.WeatherReturn
     */
    @WebMethod(operationName = "GetCityWeatherByZIP", action = "http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP")
    @WebResult(name = "GetCityWeatherByZIPResult", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
    @RequestWrapper(localName = "GetCityWeatherByZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "fr.treeptik.meteo.GetCityWeatherByZIP")
    @ResponseWrapper(localName = "GetCityWeatherByZIPResponse", targetNamespace = "http://ws.cdyne.com/WeatherWS/", className = "fr.treeptik.meteo.GetCityWeatherByZIPResponse")
    public WeatherReturn getCityWeatherByZIP(
        @WebParam(name = "ZIP", targetNamespace = "http://ws.cdyne.com/WeatherWS/")
        String zip);

}

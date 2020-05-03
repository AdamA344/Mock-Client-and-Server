/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Gab
 */
public class Sample 
{
    String  city        = null;
    Double  temperature = null;
    Double  humidity    = null;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperture) {
        this.temperature = temperture;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Sample{" + "city=" + city + ", temperture=" + temperature + ", humidity=" + humidity + '}';
    }

    
    
}

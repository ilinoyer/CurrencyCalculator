package sample;

/**
 * Created by sojer on 12.10.2017.
 */
public class Currency {

    private String currencyName;
    private int converter;
    private String code;
    private double rateOfExchange;


    public Currency(String currencyName, int converter, String code, double rateOfExchange) {
        this.currencyName = currencyName;
        this.converter = converter;
        this.rateOfExchange = rateOfExchange;
        this.code = code;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getConverter() {
        return converter;
    }

    public void setConverter(int converter) {
        this.converter = converter;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRateOfExchange() {
        return rateOfExchange;
    }

    public void setRateOfExchange(double rateOfExchange) {
        this.rateOfExchange = rateOfExchange;
    }
}

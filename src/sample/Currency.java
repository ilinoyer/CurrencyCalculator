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

    public void SetCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int GetConverter() {
        return converter;
    }

    public void SetConverter(int converter) {
        this.converter = converter;
    }

    public String GetCode() {
        return code;
    }

    public void SetCode(String code) {
        this.code = code;
    }

    public double GetRateOfExchange() {
        return rateOfExchange;
    }

    public void SetRateOfExchange(double rateOfExchange) {
        this.rateOfExchange = rateOfExchange;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyName='" + currencyName + '\'' +
                ", converter=" + converter +
                ", code='" + code + '\'' +
                ", rateOfExchange=" + rateOfExchange +
                '}';
    }
}

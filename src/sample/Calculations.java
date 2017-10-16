package sample;

/**
 * Created by sojer on 15.10.2017.
 */
public class Calculations {
    CurrencyCollection collection;

    Calculations(CurrencyCollection collection)
    {
        this.collection = collection;
    }

    double CalculateTransaction(String currencyFrom, String currencyTo, double amount)
    {
     double result = 0;
     currencyFrom = currencyFrom.substring(0,3);
     currencyTo = currencyTo.substring(0,3);

     Currency currFrom = collection.GetCurrencyElementByCode(currencyFrom);
     Currency currTo = collection.GetCurrencyElementByCode(currencyTo);

     result = (amount * currFrom.GetRateOfExchange() * currFrom.GetConverter() * currTo.GetConverter()) / (currTo.GetRateOfExchange());
     result *= 100;
     result = Math.round(result);
     result /= 100;

     return result;
    }
}

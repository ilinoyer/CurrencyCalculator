package sample;

import java.util.ArrayList;

/**
 * Created by sojer on 13.10.2017.
 */
public class CurrencyCollection {
    private ArrayList<Currency> currencyList;

    public CurrencyCollection()
    {
        this.currencyList = new ArrayList<Currency>();
    }

    public void AddElementToCollection(Currency newCurrency)
    {
        this.currencyList.add(newCurrency);
    }

    public int GetCollectionSize()
    {
       return this.currencyList.size();
    }
}

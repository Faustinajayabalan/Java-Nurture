import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App: Stock price updated to " + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App: Stock price updated to " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockPrice(1500.50);
        stockMarket.setStockPrice(1750.75);
    }
}
package DesignPatterns.Observer;

import DesignPatterns.Observer.Observable.StocksObservableImpl;
import DesignPatterns.Observer.Observer.EmailNotificationAlertObserver;
import DesignPatterns.Observer.Observer.MobileNotificationAlertObserver;

public class Main {

  public static void main() {
    StocksObservableImpl stockObservableObj = new StocksObservableImpl();
    
    MobileNotificationAlertObserver mobileNotifAlertObserver1 = new MobileNotificationAlertObserver(stockObservableObj,"7409204545");
    EmailNotificationAlertObserver emailNotifAlertObserver2 = new EmailNotificationAlertObserver(stockObservableObj, "patsy@gmail.com");
    EmailNotificationAlertObserver emailNotifAlertObserver3 = new EmailNotificationAlertObserver(stockObservableObj, "ryuk@gmail.com");

    System.out.println("current stock: " + stockObservableObj.getStockCount());
    
    // add only 1 observer for now
    stockObservableObj.add(mobileNotifAlertObserver1);
    
    // update stock
    stockObservableObj.setStockCount(2);

    // add another observer
    stockObservableObj.add(emailNotifAlertObserver2);

    // update stock
    stockObservableObj.setStockCount(4);

    // add another observer
    stockObservableObj.add(emailNotifAlertObserver3);

    // update stock
    stockObservableObj.setStockCount(5);

  }
}

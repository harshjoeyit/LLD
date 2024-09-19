package DesignPatterns.Observer.Observable;

import java.util.ArrayList;
import DesignPatterns.Observer.Observer.NotificationAlertObserver;

public class StocksObservableImpl implements StocksObservable {

  private ArrayList<NotificationAlertObserver> observers = new ArrayList<NotificationAlertObserver>();
  // sockCount indicates the count of inventory
  private int stockCount;

  @Override
  public void add(NotificationAlertObserver obs) {
    this.observers.add(obs);
    System.out.println("added observer no. " + observers.size());
  }

  @Override
  public void remove(NotificationAlertObserver obs) {
    this.observers.remove(obs);
  }

  @Override
  public void notifySubscribers() {
    for(int i=0; i<this.observers.size(); i++) {
      this.observers.get(i).update();
    }
  }

  @Override
  public void setStockCount(int count) {
    
    System.out.println("updating stock, new quantity: " + count);

    this.stockCount = count;
    if (this.stockCount > 0) {
      // notify subscribers when item is back in stock
      notifySubscribers();
    }
  }

  @Override
  public int getStockCount() {
    return this.stockCount;
  }
}

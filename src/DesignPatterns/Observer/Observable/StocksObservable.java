package DesignPatterns.Observer.Observable;

import DesignPatterns.Observer.Observer.NotificationAlertObserver;

public interface StocksObservable {

  // adds observer to this list 
  public void add(NotificationAlertObserver obs);

  // removes observer from the list
  public void remove(NotificationAlertObserver obs);

  // notifies all the observers that data has been updated
  public void notifySubscribers();

  // updates the data
  public void setStockCount(int count);

  public int getStockCount();
}

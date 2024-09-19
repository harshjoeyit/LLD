package DesignPatterns.Observer.Observer;

import DesignPatterns.Observer.Observable.StocksObservable;

public class MobileNotificationAlertObserver implements NotificationAlertObserver {

  StocksObservable so;
  String phoneNo;

  public MobileNotificationAlertObserver(StocksObservable so, String phoneNo) {
    this.so = so;
    this.phoneNo = phoneNo;
  }

  @Override
  public void update() {
    this.sendMobileNotif(phoneNo, "Item back in stock. Hurry! only " + so.getStockCount() + " items available");
  }

  public void sendMobileNotif(String phoneNo, String msg) {
    System.out.println("Mobile notification sent to " + this.phoneNo + " with message " + msg);
  }
}

package DesignPatterns.Observer.Observer;

import DesignPatterns.Observer.Observable.StocksObservable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver {

  StocksObservable so;
  String email;

  public EmailNotificationAlertObserver(StocksObservable so, String email) {
    this.so = so;
    this.email = email;
  }

  @Override
  public void update() {
    this.sendEmail(email, "Item back in stock. Hurry!");
  }

  public void sendEmail(String email, String msg) {
    System.out.println("Email sent to " + this.email + " with message " + msg);
  }
}

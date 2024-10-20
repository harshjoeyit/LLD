package DesignPatterns.Builder;

import DesignPatterns.Builder.Car.Builder;

/* 
 * You might add a Director class if the object creation process has a 
 * predefined sequence of steps. 
 * For example, if the construction of a specific model of Car always 
 * needs an engine and wheels before anything else, the Director can 
 * control this sequence.
*/
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Car constructSportsCar() {
        return builder.setEngine("V8")
                      .setWheels(4)
                      .setAirbags(true)
                      .setColor("Blue")
                      .build();
    }
}

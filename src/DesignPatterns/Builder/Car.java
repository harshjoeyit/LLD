package DesignPatterns.Builder;

public class Car {
    private String engine;
    private int wheels;
    private boolean airbags;
    private String color;

    // Private constructor
    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.airbags = builder.airbags;
        this.color = builder.color;
    }

    @Override
    public String toString() {
        return "Car with " + engine + " engine, " + wheels + " wheels, color " + color + 
               ", airbags: " + (airbags ? "Yes" : "No");
    }

    // Static inner Builder class
    public static class Builder {
        private String engine;
        private int wheels;
        private boolean airbags;
        private String color;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setAirbags(boolean airbags) {
            this.airbags = airbags;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        // Build method that returns the final product
        public Car build() {
            return new Car(this);
        }
    }
}

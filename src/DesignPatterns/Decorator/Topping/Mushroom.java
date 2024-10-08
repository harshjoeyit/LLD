package DesignPatterns.Decorator.Topping;

import DesignPatterns.Decorator.Pizza.BasePizza;

public class Mushroom extends ToppingDecorator {

    public Mushroom(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 15;
    }
}

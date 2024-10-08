package DesignPatterns.Decorator.Topping;

import DesignPatterns.Decorator.Pizza.BasePizza;

public class ExtraCheese extends ToppingDecorator {
    
    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        // cost of base pizza + cost of extra cheese
        return this.pizza.cost() + 10;
    }
}

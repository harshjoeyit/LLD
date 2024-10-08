package DesignPatterns.Decorator;

import DesignPatterns.Decorator.Pizza.BasePizza;
import DesignPatterns.Decorator.Pizza.FarmhousePizza;
import DesignPatterns.Decorator.Topping.ExtraCheese;
import DesignPatterns.Decorator.Topping.Mushroom;

public class Main {
    public static void main() {
        // order a farmhouse pizza with extra cheese
        BasePizza pizza = new ExtraCheese(new FarmhousePizza());
        
        System.out.println("farmhouse pizza with extra cheese cost:" + pizza.cost());
        
        // modify the order to include mushrooms
        pizza = new Mushroom(pizza);

        System.out.println("farmhouse pizza with extra cheese and mushrooms cost:" + pizza.cost());
    }
}

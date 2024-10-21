package Examples.Calculator;

public class Main {
    public static void main() {
        Number n1 = new Number(10);
        Number n2 = new Number(5);
        ArithmeticExpression a1 = new Expression(n1, "/", n2);  // 10/5 = 2

        Number n3 = new Number(6);
        Number n4 = new Number(2);
        ArithmeticExpression a2 = new Expression(n3, "*", n4);   // 6*2 = 12
    
        ArithmeticExpression a3 = new Expression(a1, "+", a2);   // 2+12 = 14

        System.out.println("value: " + a3.calc());
    }
}

package Examples.Calculator;

public class Expression implements ArithmeticExpression {
    ArithmeticExpression left;
    ArithmeticExpression right;
    String symbol;

    public Expression(ArithmeticExpression left, String symbol, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    @Override
    public double calc() {
        if (this.symbol.equals("+")) {
            return left.calc() + right.calc();

        } else if (this.symbol.equals("-")) {
            return left.calc() - right.calc();

        } else if (this.symbol.equals("*")) {
            return left.calc() * right.calc();

        } else if (this.symbol.equals("/")) {
            return left.calc() / right.calc();

        } else {
            System.out.println("Invalid operator " + this.symbol);
        }

        return 0;
     }
}

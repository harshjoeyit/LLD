package DesignPatterns.InterpretorPattern;

public class MultiplyNonTerminalExpression implements Expression {
    Expression leftExpr;
    Expression rightExpr;

    public MultiplyNonTerminalExpression(Expression leftExpr, Expression rightExpr) {
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
    }

    @Override
    public int interpret(Context context) {
        //
        return  this.leftExpr.interpret(context) * this.rightExpr.interpret(context);
    }
}

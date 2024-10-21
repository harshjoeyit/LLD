package DesignPatterns.InterpretorPattern;

public class AddNonTerminalExpression implements Expression {
    Expression leftExpr;
    Expression rightExpr;

    public AddNonTerminalExpression(Expression leftExpr, Expression rightExpr) {
        this.leftExpr = leftExpr;
        this.rightExpr = rightExpr;
    }

    @Override
    public int interpret(Context context) {
        // add
        return this.leftExpr.interpret(context) + this.rightExpr.interpret(context);
    }
}

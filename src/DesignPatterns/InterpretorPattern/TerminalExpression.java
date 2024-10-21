package DesignPatterns.InterpretorPattern;

public class TerminalExpression implements Expression {
    String val;

    public TerminalExpression(String val) {
        this.val = val;
    }

    @Override
    public int interpret(Context context) {
        return context.get(this.val);
    }
}

package DesignPatterns.InterpretorPattern;

public class Main {
    public static void main() {
        Expression a = new TerminalExpression("a");
        Expression b = new TerminalExpression("b");
        Expression c = new TerminalExpression("c");

        Context ctx = new Context();
        ctx.set("a", 3);
        ctx.set("b", 1);
        ctx.set("c", 5);

        // find ((a + b) * (c)) as per context
        AddNonTerminalExpression add = new AddNonTerminalExpression(a, b);
        MultiplyNonTerminalExpression mul = new MultiplyNonTerminalExpression(add, c);

        System.out.println("interpreted: " + mul.interpret(ctx));
    }
}

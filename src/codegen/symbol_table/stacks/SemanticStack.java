package codegen.symbol_table.stacks;

import java.util.Stack;

public class SemanticStack {
    private static Stack<Object> semanticStack = new Stack<>();

    public static Object push(Object item) {
        return semanticStack.push(item);
    }

    public static Object pop() {
        return semanticStack.pop();
    }

    public static Object top() {
        return semanticStack.peek();
    }
}

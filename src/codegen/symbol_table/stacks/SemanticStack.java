package codegen.symbol_table.stacks;

import java.util.Stack;

public class SemanticStack extends Stack<Object> {
    private static SemanticStack instance = new SemanticStack();

    private SemanticStack() {}

    public static SemanticStack getInstance() {
        return instance;
    }
}

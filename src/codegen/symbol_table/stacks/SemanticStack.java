package codegen.symbol_table;

import java.util.Stack;

public class SemanticStack extends Stack<SymbolTable> {
    private static SemanticStack instance = new SemanticStack();

    private SemanticStack() {}

    public static SemanticStack getInstance() {
        return instance;
    }
}

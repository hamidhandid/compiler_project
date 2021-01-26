package codegen.symbol_table.stacks;

import codegen.symbol_table.SymbolTable;

import java.util.Stack;

public class SymbolTableStack extends Stack<SymbolTable> {
    private static SymbolTableStack instance = new SymbolTableStack();

    private SymbolTableStack() {}

    public static SymbolTableStack getInstance() {
        return instance;
    }
}

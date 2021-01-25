package codegen.symbol_table.stacks;

import codegen.symbol_table.SymbolTable;

import java.util.Stack;

public class TableStack extends Stack<SymbolTable> {
    private static TableStack instance = new TableStack();

    private TableStack() {}

    public static TableStack getInstance() {
        return instance;
    }
}

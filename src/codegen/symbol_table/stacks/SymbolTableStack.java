package codegen.symbol_table.stacks;

import codegen.symbol_table.SymbolTable;

import java.util.Stack;

public class SymbolTableStack {
    private static Stack<SymbolTable> symbolTableStack = new Stack<>();

    public static SymbolTable push(SymbolTable item) {
        return symbolTableStack.push(item);
    }

    public static SymbolTable pop() {
        return symbolTableStack.pop();
    }

    public static SymbolTable top() {
        return symbolTableStack.peek();
    }
}

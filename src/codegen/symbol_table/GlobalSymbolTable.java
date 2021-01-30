package codegen.symbol_table;

public class GlobalSymbolTable {
    private static SymbolTable symbolTable = new SymbolTable("$global");

    public static SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public static void print() {
        System.out.print("Global Symbol Table = ");
        symbolTable.print();
    }
}

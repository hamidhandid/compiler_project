package codegen.symbol_table;

import codegen.symbol_table.dscp.Descriptor;

import java.util.Map;

public class SymbolTable {
    private Map<String, Descriptor> symbolTable;

    public SymbolTable(Map<String, Descriptor> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public boolean contains(Descriptor descriptor) {
        return symbolTable.containsKey(descriptor.getName());
    }

    public void addDescriptor(Descriptor descriptor) {
        symbolTable.put(descriptor.getName(), descriptor);
    }

    public Descriptor getDescriptor(String name) {
        return symbolTable.get(name);
    }


    public Map<String, Descriptor> getSymbolTable() {
        return symbolTable;
    }
}

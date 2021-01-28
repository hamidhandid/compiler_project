package codegen.symbol_table;

import codegen.symbol_table.dscp.Descriptor;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private String scopeName;

    public SymbolTable(String scopeName) {
        this.scopeName = scopeName;
    }

    private Map<String, Descriptor> symbolTable = new HashMap<>();

    public boolean contains(String name) {
        return symbolTable.containsKey(name);
    }

    public void addDescriptor(String variableName, Descriptor descriptor) {
        symbolTable.put(variableName, descriptor);
    }

    public Descriptor getDescriptor(String name) {
        return symbolTable.get(name);
    }

    public boolean containsDescriptor(String descriptorName) {
        for (String key : symbolTable.keySet()) {
            Descriptor des = symbolTable.get(key);
            if (des.getName().equals(descriptorName)) {
                return true;
            }
        }
        return false;
    }


    public Map<String, Descriptor> getSymbolTable() {
        return symbolTable;
    }

    public void print() {
        System.out.println("symbol table = " + getSymbolTable().toString());
    }
}

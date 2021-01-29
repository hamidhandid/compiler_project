package codegen.utils;

import codegen.symbol_table.GlobalSymbolTable;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.stacks.SymbolTableStack;

public class DescriptorChecker {
    public static void checkContainsDescriptor(Descriptor descriptor) {
        System.out.println("name of des = " + descriptor.getName());
        if (!SymbolTableStack.top().containsDescriptor(descriptor.getName())) {
            try {
                throw new Exception("Symbol table does not have descriptor with name " + descriptor.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkNotContainsDescriptor(String name) {
        if (SymbolTableStack.top().contains(name)) {
            try {
                throw new Exception("Symbol table has descriptor with name " + name + " before");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkNotContainsDescriptorGlobal(String name) {
        if (GlobalSymbolTable.getSymbolTable().contains(name)) {
            try {
                throw new Exception("Global Symbol table has descriptor with name " + name + " before");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

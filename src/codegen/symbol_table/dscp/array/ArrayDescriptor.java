package codegen.symbol_table.dscp.array;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public abstract class ArrayDescriptor extends Descriptor {
    public ArrayDescriptor(String name, Type type, boolean isLocal) {
        super(name, type, isLocal);
    }
}

package codegen.symbol_table.dscp.array;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public abstract class ArrayDescriptor extends Descriptor {
    private int size;
    private String realName;

    public ArrayDescriptor(String name, Type type, boolean isLocal) {
        super(name, type, isLocal);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSize() {
        return size;
    }

    public String getRealName() {
        return realName;
    }
}

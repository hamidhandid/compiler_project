package codegen.symbol_table.dscp.function;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public class FunctionDescriptor extends Descriptor {
    private String labelFrom;

    public FunctionDescriptor(String addressName, Type type) {
        super(addressName, type, false);
    }

    public void setLabelFrom(String labelFrom) {
        this.labelFrom = labelFrom;
    }
}

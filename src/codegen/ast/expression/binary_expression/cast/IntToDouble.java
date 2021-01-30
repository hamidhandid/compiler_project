package codegen.ast.expression.binary_expression.cast;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public class IntToDouble extends Cast {
    public IntToDouble(Descriptor operand, Type type) {
        super(operand, type, "i2s");
    }

    @Override
    public void compile() {
        convert(operand, type, "cvt.s.w", "s.s", "l.s");
    }
}

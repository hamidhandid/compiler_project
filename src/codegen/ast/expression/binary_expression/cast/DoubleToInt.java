package codegen.ast.expression.binary_expression.cast;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public class DoubleToInt extends Cast {
    public DoubleToInt(Descriptor operand, Type type) {
        super(operand, type, "s2i");
    }

    @Override
    public void compile() {
        convert(operand, type, "cvt.w.s", "s.s", "l.s");
    }
}

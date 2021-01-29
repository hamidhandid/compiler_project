package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.BinaryExpression;
import codegen.symbol_table.dscp.Descriptor;

public class Remainder extends BinaryExpression {
    public Remainder(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "%");
    }

    @Override
    public void compile() {
        super.compile();
    }
}

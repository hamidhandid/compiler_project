package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.BinaryExpression;
import codegen.symbol_table.dscp.Descriptor;

public class Subtract extends BinaryExpression {
    public Subtract(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "-");
    }

    @Override
    public void compile() {
        super.compile();
    }
}

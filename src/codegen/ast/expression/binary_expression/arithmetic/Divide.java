package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.BinaryExpression;
import codegen.symbol_table.dscp.Descriptor;

public class Divide extends BinaryExpression {
    public Divide(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "/");
    }

    @Override
    public void compile() {
        super.compile();
    }
}

package codegen.ast.expression.binary_expression.logical.logical_expressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;
import codegen.symbol_table.dscp.Descriptor;

public class Or extends LogicalExpression {

    public Or(Descriptor firstOperand, Descriptor secondOperand) {
        super(firstOperand, secondOperand, "||");
    }

    @Override
    public void compile() {
        super.compile();
    }
}

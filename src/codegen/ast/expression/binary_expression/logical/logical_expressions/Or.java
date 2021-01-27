package codegen.ast.expression.binary_expression.logical.logical_expressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;

public class Or extends LogicalExpression {

    public Or(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand, "||");
    }

    @Override
    public void compile() {
        super.compile();
    }
}

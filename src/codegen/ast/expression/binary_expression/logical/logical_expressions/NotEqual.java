package codegen.ast.expression.binary_expression.logical.logical_expressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;

public class NotEqual extends LogicalExpression {

    public NotEqual(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "!=";
    }

    @Override
    public void compile() {
        super.compile();
    }
}

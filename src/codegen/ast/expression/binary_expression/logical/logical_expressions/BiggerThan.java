package codegen.ast.expression.binary_expression.logical.logical_expressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;

public class BiggerThan extends LogicalExpression {

    public BiggerThan(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand, ">");
    }

    @Override
    public void compile() {
        super.compile();
    }
}

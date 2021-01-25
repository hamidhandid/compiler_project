package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.BinaryExpression;

public class Subtract extends BinaryExpression {
    public Subtract(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "-";
    }

    @Override
    public void compile() {
        super.compile();
    }
}

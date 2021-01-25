package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.BinaryExpression;

public class Add extends BinaryExpression {
    public Add(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "+";
    }

    @Override
    public void compile() {
        super.compile();
    }
}

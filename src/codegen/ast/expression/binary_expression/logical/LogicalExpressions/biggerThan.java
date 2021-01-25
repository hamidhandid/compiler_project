package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.arithmetic.BinaryExpression;
import codegen.symbol_table.stacks.SemanticStack;

public class biggerThan extends LogicalExpression {

    public biggerThan(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = ">";
    }

    @Override
    public void compile() {
        super.compile();
    }
}

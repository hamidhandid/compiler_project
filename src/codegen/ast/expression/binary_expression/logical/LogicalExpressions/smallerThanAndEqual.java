package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.arithmetic.BinaryExpression;
import codegen.symbol_table.stacks.SemanticStack;

public class biggerThanAndEqual extends LogicalExpression {

    public biggerThanAndEqual(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "<=";
    }

    @Override
    public void compile() {
        super.compile();
    }
}

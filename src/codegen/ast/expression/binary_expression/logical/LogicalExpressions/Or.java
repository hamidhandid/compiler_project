package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.arithmetic.BinaryExpression;
import codegen.symbol_table.stacks.SemanticStack;

public class Or extends BinaryExpression {

    public Or(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "||";
    }

    @Override
    public void compile() {
        super.compile();
    }
}

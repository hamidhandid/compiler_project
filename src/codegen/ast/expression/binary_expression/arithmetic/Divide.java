package codegen.ast.expression.binary_expression;

import codegen.symbol_table.stacks.SemanticStack;

public class Divide extends BinaryExpression {
    super.surrogate = "/";
    public Divide(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void compile() {
//        super.compile();
        generate_code(surrogate);
    }
}


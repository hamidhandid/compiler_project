package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.Compilable;

public abstract class BinaryExpression implements Compilable {

    protected Expression firstOperand;
    protected Expression secondOperand;
    protected String surrogate;
    public BinaryExpression(Expression firstOperand, Expression secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    protected void generate_code(String surrogate){
        SemanticStack.getInstance().push(firstOperand + secondOperand);
        // move number1
        // move number2
        firstType = firstOperand.getType();
        secondType = secondOperand.getType();
        if (firstType!.equals(secondType))
            throw new RuntimeException("TypeError: unsupported operand type(s) for " + surrogate + ": " + firstType + ", " + secondType);
        switch (surrogate) {
                case "+":
                    // set_opcode: +
                    break;
                case "-":
                    // set_opcode: -
                    break;
                case "*":
                    // set_opcode: *
                    break;
                case "/":
                    // set_opcode: /
                    break;
            
    }

    @Override
    public void compile() {}
}

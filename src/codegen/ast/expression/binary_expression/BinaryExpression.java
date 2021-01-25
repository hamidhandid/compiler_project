package codegen.ast.expression.binary_expression;

import codegen.ast.Compilable;
import codegen.ast.expression.Expression;
import codegen.symbol_table.stacks.SemanticStack;

public abstract class BinaryExpression implements Compilable {

    protected int firstOperand;
    protected int secondOperand;
    protected String surrogate;
    public BinaryExpression(int firstOperand, int secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    protected void generate_code(String surrogate){
        SemanticStack.getInstance().push(firstOperand + secondOperand);
        // move number1
        // move number2
        // firstType = firstOperand.getType();
        // secondType = secondOperand.getType();

        // Uncomment upperside when getType was okay & remove lowerside
        String firstType = "int";
        String secondType = "int";
        if (!firstType.equals(secondType))
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
    public void compile() { }
    }
}

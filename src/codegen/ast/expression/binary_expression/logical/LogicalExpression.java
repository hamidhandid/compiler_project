package codegen.ast.expression.binary_expression.logical;

import scanner.classes.Type;

public class LogicalExpression implements Comparable {

    protected void OR(){

    }
    
    protected void AND(){

    }
    
    protected void compare(){
        // set number1
        // set number2
        // firstType = firstOperand.getType();
        // secondType = firstOperand.getType();
        if (!firstType.equals(secondType))
            throw new RuntimeException("TypeError: unsupported operand type(s) for " + surrogate + ": " + firstType + ", " + secondType);

        if (firstType == Type.INTEGER_NUMBER){
            // Set Opcode
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

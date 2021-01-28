package codegen.ast.expression.binary_expression.logical;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.BinaryExpression;
import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public abstract class LogicalExpression extends BinaryExpression implements Comparable {

    public LogicalExpression(Descriptor firstOperand, Descriptor secondOperand, String operation) {
        super(firstOperand, secondOperand, operation);
    }
    
    protected void compare(){
       /* // set number1
       // set number2
       // firstType = firstOperand.getType();
       // secondType = firstOperand.getType();
       if (!firstType.equals(secondType))
           throw new RuntimeException("TypeError: unsupported operand type(s) for " + surrogate + ": " + firstType + ", " + secondType);

       if (firstType == Type.INTEGER_NUMBER){
           // Set Opcode
       } */
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void compile() {
        super.compile();
    }
}

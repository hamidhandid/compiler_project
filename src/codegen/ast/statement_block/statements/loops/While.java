package codegen.ast.statement_block.statements.loops;

import codegen.CodeGenerator;
import codegen.ast.statement_block.Statement;
import codegen.symbol_table.dscp.Descriptor;
import codegen.utils.AssemblyFileWriter;

public class While extends Statement {
    private Descriptor conditionValue;
    private static String startOfConditionLabel;
    private static String endOfWhileLabel;

    public While(Descriptor conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public void compile() {
        AssemblyFileWriter.appendComment("while code for " + conditionValue);
        AssemblyFileWriter.appendCommandToCode("la", "$t0", conditionValue.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t0)");
        endOfWhileLabel = CodeGenerator.generateNewLabel();
        AssemblyFileWriter.appendCommandToCode("beqz", "$t1", endOfWhileLabel);
    }

    public static void startCondition() {
        startOfConditionLabel = CodeGenerator.generateNewLabel();
        AssemblyFileWriter.appendComment("start condition of while");
        AssemblyFileWriter.addLabel(startOfConditionLabel);
    }

    public static void completeWhile() {
        AssemblyFileWriter.appendComment("end of while");
        AssemblyFileWriter.appendCommandToCode("j", startOfConditionLabel);
        AssemblyFileWriter.addLabel(endOfWhileLabel);
    }

}

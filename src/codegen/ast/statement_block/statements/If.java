package codegen.ast.statement_block.statements;

import codegen.CodeGenerator;
import codegen.ast.statement_block.Statement;
import codegen.symbol_table.dscp.Descriptor;
import codegen.utils.AssemblyFileWriter;

public class If extends Statement {
    private Descriptor value;
    private static String afterIfLabel;
    private static String afterElseLabel;

    public If(Descriptor value) {
        this.value = value;
    }

    //TODO (Handle complete if and complete else with replacing the code string)
    @Override
    public void compile() {
        afterIfLabel = CodeGenerator.generateNewLabel();
        afterElseLabel = CodeGenerator.generateNewLabel();
        AssemblyFileWriter.appendComment("if code for " + value);
        AssemblyFileWriter.appendCommandToCode("la", "$t0", value.getName());
        AssemblyFileWriter.appendCommandToCode("lw", "$t1", "0($t0)");
        AssemblyFileWriter.appendCommandToCode("beqz", "$t1", afterIfLabel);
    }

    public static void completeIf() {
        AssemblyFileWriter.appendComment("complete if code");
        AssemblyFileWriter.appendCommandToCode("j", afterElseLabel);
    }

    public static void elseCode() {
        AssemblyFileWriter.addLabel(afterIfLabel);
        AssemblyFileWriter.appendComment("else code");
    }

    public static void completeElse() {
        AssemblyFileWriter.appendComment("complete else code");
        AssemblyFileWriter.addLabel(afterElseLabel);
    }
}

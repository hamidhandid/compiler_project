package codegen;

public class CodeGenerator implements parser.CodeGenerator {

    @Override
    public void doSemantic(String sem) {
        switch (sem) {
            case "add":
                System.out.println("code gen of add");
                break;
            case "mult":
                System.out.println("code gen of mult");
                break;
            default:
                System.out.println("alaki");
        }
    }
}

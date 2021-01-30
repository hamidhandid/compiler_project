package codegen.symbol_table.stacks.records;

import java.util.*;

public class Records {
    private static Map<String , ArrayList<RecordVariable>> recordInformation = new HashMap<>();

    public static void put(String recordName, ArrayList<RecordVariable> recordVars) {
        recordInformation.put(recordName, recordVars);
    }

    public static void addVar(String recordName, RecordVariable var) {
        recordInformation.get(recordName).add(var);
    }

    public static boolean contains(String recordName) {
        return recordInformation.containsKey(recordName);
    }

    public static ArrayList<RecordVariable> getVars(String recName) {
        return recordInformation.get(recName);
    }

    public static boolean containsVariable(String recordName, RecordVariable variableName) {
        List<RecordVariable> varNames = recordInformation.get(recordName);
        return varNames.contains(variableName);
    }

    public static void noRecordWithThisName(String name) {
        try {
            throw new Exception("No Record With Name of " + name);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}



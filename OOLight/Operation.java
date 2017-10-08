import java.util.Optional;
import java.util.regex.*;

public class Operation {
    int from;
    int init;
    int coefficient;
    int power;
    int shift;
    private static Operation operation;

    int getNextPos(int curPos, int width){
        int base = curPos;
        for(int i = 0;i<power;i++){
            curPos *= base;
        }
        curPos += shift;
        curPos *= coefficient;
        curPos %= width;
        return curPos;
    }


    public static Operation parseOperation(String strOperation){
        Operation operation = new Operation();
        operation.from = Operation.getValue("F",strOperation);
        operation.init = Operation.getValue("I",strOperation);
        operation.coefficient = Operation.getValue("C",strOperation);
        operation.power = Operation.getValue("P",strOperation);
        operation.shift = Operation.getValue("S",strOperation);
        return null;

    }

    public static int getValue(String mark, String content){
        String regex = mark + "\\d+";
        Pattern  p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        m.find();
        int start = m.start()+1;
        int end = m.end();
        String strValue = content.substring(start,end);
        int value = Integer.parseInt(strValue);
        return value;

    }

}

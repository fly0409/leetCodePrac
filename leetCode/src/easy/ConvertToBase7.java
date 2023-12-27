package easy;

import java.util.ArrayList;
import java.util.List;

public class ConvertToBase7 {
    public static String convertToBase7(int num) {
        boolean negative = false;
        if(num < 0 ){
            num = -num;
            negative = true;
        }
        List<Integer> digit = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (num/7 > 0){
            digit.add(num%7);
            num = num/7;
        }
        digit.add(num%7);

        for (Integer ele : digit){
            sb.append(ele);
        }
        if(negative){
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-48));
    }
}

package easy;

public class AddBinary {
    public static String addBinary(String a, String b) {
        return int2Binstr(bin2Int(a)+bin2Int(b));
    }


    public static int bin2Int(String a){
        int val = 0;
        int weight = 1;
        for (int i = a.length(); i >0 ; i--) {
            if (a.charAt(i-1) == '1') {
                val += weight;
            }
            weight*=2;

        }

        return val;
    }

    public static String int2Binstr(int val){
        StringBuilder sb = new StringBuilder();
        if(val==0){
            return "0";
        }
        while(val/2>0){
            if(val%2 ==1){
                sb.append('1');
            }else{
                sb.append('0');
            }
            val=val/2;
        }
        sb.append('1');
        sb.reverse();

        return sb.toString();
    }



    public static void main(String[] args) {
//        System.out.println(int2Binstr(11));
        System.out.println(addBinary("111","10"));
    }
}

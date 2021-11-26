package easy;

public class AddBinary2 {
    public static String addBinary(String a, String b) {

        int maxlength = a.length()>b.length()? a.length():b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        while(maxlength >0){
            System.out.println("ok");
            int count = 0;
            if(aIndex>=0){
                count +=a.charAt(aIndex)=='1'? 1 : 0;
            }
            if(bIndex>=0) {
                count +=b.charAt(bIndex)=='1'? 1 : 0;
            }
            count += carry;
            System.out.println(count);
            switch (count){
                case(0):
                    sb.append(0);
                    carry=0;
                    break;
                case(1):
                    sb.append(1);
                    carry=0;
                    break;
                case(2):
                    sb.append(0);
                    carry=1;
                    break;
                case(3):
                    sb.append(1);
                    carry=1;
                    break;
            }
            aIndex--;
            bIndex--;
            maxlength--;

        }
        if(carry==1){
            sb.append(1);
        }
        if(sb.length()==0){
            return "0";
        }

        return sb.reverse().toString();
    }







    public static void main(String[] args) {

        System.out.println(addBinary("100","110010"));

    }
}

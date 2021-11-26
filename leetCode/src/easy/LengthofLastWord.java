package easy;

public class LengthofLastWord {

    public static int lengthOfLastWord(String s) {
        s=s.trim();
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }

    public static int lengthOfLastWord2(String s) {
        int length = 0;

        // We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                length++;
            } else {  // it's a white space instead
                //  Did we already started to count a word ? Yes so we found the last word
                if (length > 0) return length;
            }
        }
        return length;
    }


    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        System.out.println(lengthOfLastWord2(s));
    }
}

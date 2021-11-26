public class Table {

    public static void main(String[] args) {
        int input = 20;//自己設的
        int n = input/2;
        int row = 2;
        int rowCount;
        int colCount;
        String str;

        for (int i = 0; i < n*n; i++) {
            rowCount = 1+ (i/n);
            row = 2 * rowCount;
            colCount = 1+ 2*(i %n);
            str = ((i)%n==0)?"\n"+row+"|\t":"\t";
            System.out.print(str+row*colCount);
        }
    }
}

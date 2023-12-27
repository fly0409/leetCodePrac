package easy;

public class CountPrimes {

    public static int countPrimes(int n) {
        boolean[] notPrimeArr = new boolean[n+1];
        int count = 0;
        for(int i = 2; i < notPrimeArr.length-1 ; i++){
            if(notPrimeArr[i]){
                continue;
            }
            count++;
            for(int j = i + i ; j <= n ; j+=i){
                notPrimeArr[j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countPrimes(10);
        System.out.println(count);
    }
}

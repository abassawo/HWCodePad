package nyc.c4q.abassawo;

public class Main {

    public static void main(String[] args) {
        printBitString(156);
        countOnesinBitStr(156);
        isBitPalindromic(9);
        printBitString(9);
    }

    public static void printBitString(int num){
        System.out.println(Integer.toBinaryString(num));
    }

    public static int countOnesinBitStr(int num){
        int count = 0;
        String bit = Integer.toBinaryString(num);
        for (int i = 0; i < bit.length() ; i++) {
            if(bit.charAt(i) == ('1')){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }


    public static boolean isBitPalindromic(int sum){
        String bit = Integer.toBinaryString(sum);
        String reves = "";
        for (int i = bit.length() - 1; i >= 0; i--) {
            reves += bit.charAt(i);
        }
        if(bit.equals(reves)) {
            return true;
        }
        return false;
    }

}

public class prime20 {
    public static void main(String[] args) {
        int count=0,number=2;
        System.out.println("20 số nguyên tố đầu tiên");
        while(count<20){
            if(prime(number)){
                System.out.println(number);
                count++;
            }number++;
        }
    }

    public static boolean prime(int number) {
        if(number<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}

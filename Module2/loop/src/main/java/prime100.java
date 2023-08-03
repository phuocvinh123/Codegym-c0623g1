public class prime100 {
    public static void main(String[] args) {
        int number=2;
        System.out.println(" số nguyên tố nhỏ hơn 100");
        while(number<100){
            if(prime(number)){
                System.out.println(number);
            }number++;
        }
    }

    public static boolean prime(int number){
        if(number<=1){
            return false;
        }
        for(int i=2;i<Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }return true;



    }
}

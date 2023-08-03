import java.util.Scanner;

public class findValueInArray {
    public static void main(String[] args) {
        String[]arr={"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor"};
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name you want to search");
        String search=scanner.nextLine();
        boolean name =false;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(search)){
                System.out.println("Position of the students in the list " + search +"is: "+i);
                name=true;
                break;
            }
        }
        if(!name){
            System.out.println("Not found" + search + " in the list.");
        }
    }
}

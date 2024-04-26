import java.util.*;
public class Task1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int v=0,c=0,g=0;
        System.out.println("------------------------------------");
        System.out.println("|         Number Game              |");
        System.out.println("------------------------------------");
        System.out.println("Your Limit is 5");
        while(true){
            c++;
            v=r.nextInt(100)+1;
        System.out.println("------------------------------------");
            System.out.print("Enter Number : ");
            g= sc.nextInt();
            if(g==v){
                if(c==1)
                    System.out.println("Your score is 100");
                else if(c==2)
                    System.out.println("Your score is 80");
                else if(c==3)
                    System.out.println("Your score is 60");
                else if(c==4)
                    System.out.println("Your score is 40");
                else
                    System.out.println("Your score is 30");
            }
            if(g>v)
                System.out.println("too high");
            if(g<v)
                System.out.println("too low");
            System.out.println("Random number is "+v);
            if(c>=5){
                System.out.println("------------------------------------");
                System.out.println("Limit reached");
                break;
            }
        }
            System.out.println("------------------------------------");
            System.out.println("|   Thanks for Using Number Game   |");
            System.out.println("------------------------------------");
    }
}

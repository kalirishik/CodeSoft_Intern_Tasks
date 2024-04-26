import java.util.*;
class ATM{
        int amount=1000;
        public void setWithdraw(int amount){
            System.out.println("-----------------------------");
            int v=this.amount-amount;
            if(v<1000)
                System.out.println(" Minimum Balance 1000 is required");
            else{
                this.amount-=amount;
                System.out.println(" "+amount+" has been withdrawed");
            }
        }
        public void setDeposit(int amount){
            this.amount+=amount;
            System.out.println("-----------------------------");
            System.out.println(" "+amount+" has been deposited");
        }
        public int getCheckBalance(){
            return this.amount;
        }
}
class UserAccount extends ATM{
        public void withdrawAmount(int amount){
            setWithdraw(amount);
        }
        public void depositAmount(int amount){
            setDeposit(amount);
        }
        public void checkBalance(){
            System.out.println("-----------------------------");
            System.out.println(" Your Balance is "+getCheckBalance());
        }
}
public class Task3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        UserAccount u=new UserAccount();
        int ch=4;
        System.out.println("-----------------------------");
        System.out.println("-------| ATM INTERFACE |-----");
        do{
            System.out.println("-----------------------------");
            System.out.println("|     1.Withdraw Amount     |");
            System.out.println("|     2.Deposit  Amount     |");
            System.out.println("|     3.Check   Balance     |");
            System.out.println("|     4.Exit                |");
            System.out.println("-----------------------------");
            System.out.print("  Enter Option : ");
            ch=sc.nextInt();
            int a=0;
            switch(ch){
                case 1:
                    System.out.println("-----------------------------");
                    System.out.print(" Enter Amount to Withdraw : ");
                    a=sc.nextInt();
                    u.withdrawAmount(a);
                    break;
                case 2:
                    System.out.println("-----------------------------");
                    System.out.print(" Enter Amount to Deposit : ");
                    a=sc.nextInt();
                    u.depositAmount(a);
                    break;
                case 3:
                    u.checkBalance();
                    break;
                case 4:
                    System.out.println("-----------------------------");
                    System.out.println("--| Thanks for Using ATM |---");
                    System.out.println("-----------------------------");
                    break;
                default:
                    System.out.println("Enter Valid Choice");
            }
        }while(ch!=4);
    }
}

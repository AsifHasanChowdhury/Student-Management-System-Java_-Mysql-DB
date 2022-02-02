import java.util.Scanner;
public class BRACStudentRecord {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    
    Managing ha=new Managing();
           
        for(;;){
            System.out.println("Press 1 to Add Information of a Student");
            System.out.println("Press 2 to Edit Information of a Student");
            System.out.println("Press 3 to Print Information of all Student");
            System.out.println("Press 4 to Log In into the System");
            System.out.println("Press 6 to Stop the Program");
            
            int a=sc.nextInt();
            sc.nextLine();

            if(a==1){
                
                System.out.println("Please Enter Student Name");
                String s=sc.nextLine();
                System.out.println("Please assign New ID for Student");
                int p=sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter Student Mail Id");
                String q=sc.nextLine();
                System.out.println("Please enter password");
                String r=sc.nextLine();
                
                ha. AddRecord(s,p,q,r);
             
            }
            if(a==3){
                System.out.println("*****All Information of the enrolled student*****");
                ha.PrintRecord();
            }
        
            if(a==4){

                ha.LoginSystem();
               
            }

            if(a==6){
                System.out.println("System is Off");
                System.out.println();
                break;
                        
            }
        }
    }
    
}

import java.util.Scanner;
public class Managing {
    Node head;
    Node tail;
//    String name;
//    int id;
//    String cg;
      int size;
      int i=0;
      int j=0;
      int k=0;
      int count=0;
      private String Student_name;
      private int Student_id;

    SectionModule section1=new SectionModule();
    SectionModule section2=new SectionModule();
    SectionDatabase database=new SectionDatabase();

    Scanner sc=new Scanner(System.in);

    public Managing(){
    
    }
      
    public void AddRecord(String x,int y,String z,String w){
        
        Node p;
        
        if(size==0){
            
           head=new Node(x,y,z,w,null);
           tail=head;
           tail.next=null;
           size=size+1;
           System.out.println();
           System.out.println("Size of Student "+size);
           System.out.println("Info Added");
           System.out.println("**First Student");
           System.out.println();
        }
        
        else if(size>0){
               p=new Node(x,y,z,w,null);
               tail.next=p;
               p.next=null;
               tail=p;
               tail.next=null;
               size=size+1;
               System.out.println("Size of Student "+size);
               System.out.println("Info Added");
        }
               /* sort not necessary
               for(Node n=head; n!=null;n=n.next){ //sorting process of info
                   for(Node s=n.next; s!=null;s=s.next){
                       if(s.id<n.id){
                           String tempname=n.name;
                           int tempid=n.id;
                           String tempmail_id=n.mail_id;
                           String temppass=n.password;

                           n.name=s.name;
                           n.id=s.id;
                           n.mail_id=s.mail.id;
                           s.name=tempname;
                           s.id=tempid;
                           s.cg=tempcg;
                           
                       }
                   }
                   */
               
        }
        
    
    
    
        public Node nodeAt(int idx){ //needed the method to delete info

            Node p=null;

         int countnode=0;
         for(Node n=head; n!=null; n=n.next){
         if(idx==countnode){

           p=n;
         return p;

        }
         else{
           countnode++;
         }
    //    return null; // please remove this line!
      }

        return p;
      }
     
    
     public void PrintRecord(){   //printing info
         
         
         for(Node n=head; n!=null;n=n.next){
             System.out.println("***Student Information***");
             System.out.println("Student Name "+n.name);
             System.out.println("Student ID "+n.id);
             System.out.println("Student Mail_ID "+n.mail_id);
             System.out.println();
         }
     }
     
     public boolean Search(int x){      // written to confirmation of editing info
         boolean flag=false;
         for(Node n=head;n!=null;n=n.next){
             if(n.id==x){
                 flag=true;
             }
         }
         return flag;
     }
     

     
     public void LoginSystem(){
         System.out.println("Please Enter the Mail ID and Password to login");
         System.out.println("Provide Email ID: ");
         String x=sc.next();
         System.out.println("Provide Password");
         String y=sc.next();
       boolean flag=true;
       if(x.equals("ZM") && y.equals("12")){
        System.out.println("Logged In As Faculty");
        System.out.println();
        flag=false;
        printSectionRecord();

       }
       else if(flag==true){
        for(Node n=head; n!=null; n=n.next){
            if(x.equals(n.mail_id) && y.equals(n.password)){
                System.out.println("Student Login Successful");
                Student_name=n.name;
                Student_id=n.id;
                courseStatusModule(n.name,n.id);
                flag=false;
            }
        }
    }
        if(flag==true){
            System.out.println("You Are redirected to Login Page because Credentials Didn't Match");

        }

     }

     public void courseStatusModule(String name, int id){
        

         System.out.println("1  Section-01   "+"Sunday: 12:30 pm 1:00 pm  "+section1.getSectionSize()+" Seats Remaining");
         System.out.println("2  Section-02   "+"Sunday: 2:30 pm 4:00 pm  "+section2.getSectionSize()+" Seats Remaining");
         System.out.println("Press 1 to Choose Section 1");
         System.out.println("Press 2 to Choose Section 2");
      //   System.out.println("Press 10 to Return To Main Pannel");
         int  x=sc.nextInt();
         secureSectionSeat(x,name,id);
     }



     public void secureSectionSeat(int x,String name,int id){
         String Confirmation;

         if(x==1){
             Confirmation=section1.checkSectionSize();
             if(Confirmation.equals("YES")){
                 //System.out.println(name);
                 SectionRecord secRecord=new SectionRecord(name,id);
                 int l=0;

                 for(;l<section1.sectionRecord.length;l++){

                     if(section1.Section_IDTRACK[l]==id){
                         System.out.println("You Are Enrolled Already");
                         count=count+1;
                         //     courseStatusModule(Student_name, Student_id);
                         break;

                     }

                     else if(section2.Section_IDTRACK[l]==id){
                         System.out.println("You Are Enrolled Already");
                         count=count+1;
                         //    courseStatusModule(Student_name, Student_id);
                         break;
                     }
                     else {
                         count=0;
                     }
                 }

                 if(count==0){
                     if(i<9){
                         section1.reduceSize();
                         section1.sectionRecord[i]=secRecord;
                         section1.Section_IDTRACK[i]=id;
                         System.out.println("You Are Enrolled At Section 1  "+section1.sectionRecord[i].name);
                         //    System.out.println("1  Section-01   "+"Sunday: 12:30 pm 1:00 pm  "+section1.getSectionSize()+" Seats Remaining");
                         //    System.out.println("2  Section-02   "+"Sunday: 2:30 pm 4:00 pm  "+section2.getSectionSize()+" Seats Remaining");
                         i++;
                         courseStatusModule(Student_name, Student_id);

                     }
                     else{
                         System.out.println("No Seat Available ,Try Section 1");
                         System.out.println("1  Section-01   "+"Sunday: 12:30 pm 1:00 pm  "+section1.getSectionSize()+" Seats Remaining");
                         System.out.println("2  Section-02   "+"Sunday: 2:30 pm 4:00 pm  "+section2.getSectionSize()+" Seats Remaining");
                         courseStatusModule(Student_name, Student_id);
                     }
                 }
             }

         }


         else if(x==2){
            Confirmation=section2.checkSectionSize();
            if(Confirmation.equals("YES")){
                //System.out.println(name);
                  SectionRecord secRecord=new SectionRecord(name,id);
    int l=0;    
             
                for(;l<section2.sectionRecord.length;l++){
                   
                    if(section1.Section_IDTRACK[l]==id){
                        System.out.println("You Are Enrolled Already");
                        count=count+1;
                   //     courseStatusModule(Student_name, Student_id);
                        break;
                       
                    }

                    else if(section2.Section_IDTRACK[l]==id){
                        System.out.println("You Are Enrolled Already");
                        count=count+1;
                    //    courseStatusModule(Student_name, Student_id);
                        break;
                    }
                    else {
                        count=0;                    
                    }
                }
           
            if(count==0){
                if(k<9){
                section2.reduceSize();
                section2.sectionRecord[k]=secRecord;
                section2.Section_IDTRACK[k]=id;
                System.out.println("You Are Enrolled At Section 2  "+section2.sectionRecord[k].name);
            //    System.out.println("1  Section-01   "+"Sunday: 12:30 pm 1:00 pm  "+section1.getSectionSize()+" Seats Remaining");
            //    System.out.println("2  Section-02   "+"Sunday: 2:30 pm 4:00 pm  "+section2.getSectionSize()+" Seats Remaining");
                    k++;
                courseStatusModule(Student_name, Student_id);

                }
                else{
                    System.out.println("No Seat Available ,Try Section 2");
                    System.out.println("1  Section-01   "+"Sunday: 12:30 pm 1:00 pm  "+section1.getSectionSize()+" Seats Remaining");
                    System.out.println("2  Section-02   "+"Sunday: 2:30 pm 4:00 pm  "+section2.getSectionSize()+" Seats Remaining");
                    courseStatusModule(Student_name, Student_id);
                }
            }
            }

         }

        }

        
        

        public void printSectionRecord(){


            System.out.println("Kindly Choose the Section number to check Section Status ");
            System.out.println("Press 1 to check Section 1 Status ");
            System.out.println("Press 2 to check Section 2 Status ");
            System.out.println("Press Any Key except 1 & 2 to return to main menu");
            int x=sc.nextInt();

            if(x==1) {
                int count1=0;
                System.out.println("This is Section 1 Students List ");
                for (Node n = head; n != null; n = n.next) {
                    for (int i = 0; i < section1.Section_IDTRACK.length; i++) {
                        if(count1==0){
                            System.out.println("Student ID"+"          "+"Student Name");
                            count1++;
                        }
                        if (n.id == section1.Section_IDTRACK[i]) {

                            System.out.println(n.id+"                     "+n.name);

                        }
                    }
                }

                if(count1==0){
                    System.out.println("NO Students Enrolled at Section 2");
                    printSectionRecord();
                }
                else if(count1>0){
                    printSectionRecord();
                }
            }

            if (x==2){
                int count2=0;
                System.out.println("This is Section 2 Students List ");
                for (Node n = head; n != null; n = n.next) {
                    for (int i = 0; i < section2.Section_IDTRACK.length; i++) {
                        if(count2==0){
                            System.out.println("Student ID"+"          "+"Student Name");
                            count2++;
                        }
                        if (n.id == section2.Section_IDTRACK[i]) {

                            System.out.println(n.id+"                     "+n.name);

                        }
                    }
                }
                if(count2==0){
                    System.out.println("NO Students Enrolled at Section 2");
                    printSectionRecord();
                }
                else if(count2>0){
                    printSectionRecord();
                }


            }

            else if (x!=1 || x!=2){
                System.out.println("The section ID doesnot Exist");
             //   BRACStudentRecord.main(null);


            }

    }

}

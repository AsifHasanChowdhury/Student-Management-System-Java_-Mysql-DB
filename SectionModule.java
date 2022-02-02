
public class SectionModule {

    int sectionSize=1;

    SectionRecord [] sectionRecord=new SectionRecord [1];
    int [] Section_IDTRACK=new int[1];
    

    public SectionModule(){
       
    }

    public int getSectionSize(){
        return sectionSize;
    }


    public String checkSectionSize(){
        String Enroll_Status;
       if(sectionSize>0){ 
       
        Enroll_Status="YES";
    }
        else{
            Enroll_Status="NO";
        }

        return Enroll_Status;
    }

    public void reduceSize(){
        sectionSize=sectionSize-1;
    }
    
}

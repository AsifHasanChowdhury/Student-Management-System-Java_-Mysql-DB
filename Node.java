
public class Node {
    
  public String name;
  public int id;
  public String mail_id;
  public String password;
  public Node next;

  
  public Node(String x,int y,String z, String w, Node n){
    name=x;
    id=y;
    mail_id=z;
    password=w;
    next = n;
  }
  
}


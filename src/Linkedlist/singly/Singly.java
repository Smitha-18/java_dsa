package Linkedlist.singly;

class node
{
    int data;
    node next;
    public node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

class sll
{
  node head;
  public  sll()
  {
    head=null;
  }
    public void inserthead(int data)
    {
        node newnode=new node(data);
        newnode.next=head;
        head=newnode;
    }
  public void insertAtTail(int data)
  {
      node newnode=new node(data);
      if (head==null)
      {
          head=newnode;
          return;
      }
      node temp=head;
      while(temp.next!=null)  //temp will stop at the last
      {
          temp=temp.next;
      }
      temp.next=newnode;
  }
    public  void deletehead()
    {

        node todelete=head;
        head=head.next;
        todelete.next=null;
    }

    public void delete(int data)
  {
      if(head==null){
          return;
      }
      if  (head.data==data)
      {
          head=head.next;
          return;
      }
      node temp=head;
      while(temp.next!=null &&  temp.next.data!=data)
      {
          temp=temp.next;
      }
      if (temp.next==null)
      {
          System.out.println("data not found");
      }
      else
      {
          temp.next=temp.next.next;
      }
  }

  int getSize()
  {
      int size=0;
      node temp=head;
      while(temp!=null)
      {
          size++;
          temp=temp.next;
      }
      return size;
  }
  public void insert_a(int data,int pos)
  {
      node newnode=new node(data);
      if(head==null)
      {
          head=newnode;
          return;
      }
      node temp=head;
      if(pos<0 || pos>getSize())
      {
          System.out.printf("Invalid position %d\n", pos);
          return;
      }
      else if (pos==0)
      {
           newnode.next=head;
           head=newnode;
      }
      for(int i=0;temp!=null && i<pos-1;i++)
      {
          temp=temp.next;
      }
      newnode.next=temp.next;
      temp.next=newnode;

  }

  public void print() {
      node temp = head;
      while (temp != null)  //temp will go till the n value is completely 0
      {
          System.out.print(temp.data + " ");
          temp = temp.next;
      }
  }
}

public class Singly {
    public static void  main(String []args)
    {
        sll s1=new sll();
        s1.inserthead(60);
        s1.insertAtTail(10);
        s1.insertAtTail(20);
        s1.insertAtTail(30);
        s1.delete(20);
        s1.insert_a(40,1);
        s1.insert_a(100,50);
        s1.print();
    }
}



import java.util.Scanner;
import java.util.StringTokenizer;
class customer
{
String name;
String date;
public void read()
{
Scanner input =new Scanner(System.in);
name=input.next();
date=input.next();
}
public void display()
{
System.out.print(name+",");
String delims="/";
StringTokenizer st=new StringTokenizer(date,delims);
while(st.hasMoreElements()){
System.out.print(st.nextElement()+",");
}
System.out.println();
}
public static void main(String[] args)
{
System.out.println("Enter the customer detail");
customer[] cus=new customer[30];
Scanner sc =new Scanner(System.in);
System.out.println("enter the number of customer");
int n=sc.nextInt();
for(int i=0;i<n;i++)
{
cus[i]=new customer();
cus[i].read();
}
for(int i=0;i<n;i++)
cus[i].display();
}
}
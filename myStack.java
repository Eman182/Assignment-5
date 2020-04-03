package eg.edu.alexu.csd.datastructure.stack.csX22;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class myStack {

	public static void main(String[] args)  {
		StackMethods s=new StackMethods();
		while(true) {
		System.out.println("Choose the action you want: ");
		System.out.println("1-Push");
		System.out.println("2-Pop");
		System.out.println("3-Peek");
		System.out.println("4-Get size");
		System.out.println("5-Check if empty");
		Scanner p=new Scanner(System.in);
		int x=0;
		try {
		x=p.nextInt();
		}
		catch (InputMismatchException k) {
			System.out.println("");
		}
		if(x==1) {
			System.out.println("Enter the element you want to push : ");
			Scanner o=new Scanner(System.in);
			Object element =o.nextLine();
			s.push(element);
			System.out.println(element +" is pushed successfully");
		}
		else if(x==2) {
			int flag=0;
			Object h=0;
			try {
				h=s.pop();
			}
			catch(RuntimeException m) {
				flag=1;
				System.out.println(m.getMessage());
			}
			if(flag==0) {
				System.out.println(h +" is poped successfully");
			}
		}
		else if(x==3) {
			int flag=0;
			try {
				s.peek();
			}
			catch(RuntimeException e) {
				flag=1;
				System.out.println(e.getMessage());
			}
			if(flag==0) {
				System.out.println("The top element is "+s.peek());
			}
		}
		else if(x==4) {
			System.out.println("The size is "+s.size());
		}
		else if(x==5) {
			System.out.println(s.isEmpty());
		}
		else {
			System.err.println("Invalid choice");
		}
		}
	}
		

}

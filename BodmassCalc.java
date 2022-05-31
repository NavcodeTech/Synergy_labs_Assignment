package linkedListPra;

import java.util.*;
public class BodmassCalc {

	static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();
         
        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
             
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
            stack.push(c - '0');
             
            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop();   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner sc=new Scanner(System.in);
         String expr=sc.nextLine();
         String post_expr=convert_to_postExpr(expr);
         int val=evaluatePostfix(post_expr);
         System.out.println(val);
	}
	public static String convert_to_postExpr(String s)
	{
		 String result = "";
         
	        // initializing empty stack
	        Stack<Character> stack = new Stack<>();
	         
	        for (int i = 0; i<s.length(); ++i)
	        {
	            char c = s.charAt(i);
	             
	            // If the scanned character is an
	            // operand, add it to output.
	            if (Character.isLetterOrDigit(c))
	                result += c;
	              
	            // If the scanned character is an '(',
	            // push it to the stack.
	            else if (c == '(')
	                stack.push(c);
	             
	            //  If the scanned character is an ')',
	            // pop and output from the stack
	            // until an '(' is encountered.
	            else if (c == ')')
	            {
	                while (!stack.isEmpty() &&
	                        stack.peek() != '(')
	                    result += stack.pop();
	                 
	                    stack.pop();
	            }
	            else // an operator is encountered
	            {
	                while (!stack.isEmpty() && check_Prec(c) <= check_Prec(stack.peek())){
	                   
	                    result += stack.pop();
	             }
	                stack.push(c);
	            }
	      
	        }
	      
	        // pop all the operators from the stack
	        while (!stack.isEmpty()){
	            if(stack.peek() == '(')
	            return "Invalid Expression";
	            
	            result += stack.pop();
	         }
	        return result;
	}
	static int check_Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }

}

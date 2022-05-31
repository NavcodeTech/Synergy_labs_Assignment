package linkedListPra;
import java.util.*;
public class StringComb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String str = sc.nextLine();
        int n = str.length(); 
        StringComb obj = new StringComb(); 
        obj.find(str, 0, n-1); 
	}
	private void find(String str,int l,int r)
	{
		if(l==r)
		{
         System.out.println(str);
		}
		else
		{
			for(int i=l;i<=r;i++)
			{
			str=swap(str,l,i);
			find(str,l+1,r);
			str=swap(str,l,i);
			}
		}
		
	}
	private static String swap(String s,int l,int r)
	{
		char arr[]=s.toCharArray();
		char temp = arr[l] ; 
        arr[l] = arr[r]; 
        arr[r] = temp; 
        return String.valueOf(arr); 
	}

}

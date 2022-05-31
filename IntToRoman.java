package linkedListPra;
import java.util.*;
public class IntToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        find(num);
	}
	public static void find(int num) {

        System.out.println("Integer: " + num);
        int[] values = {500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
            if(num==0)
            	break;
        }
        System.out.println("Roman: " + roman.toString());
    }
}

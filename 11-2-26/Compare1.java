package Cores;

interface Comparator <T> {
	int compare(T a, T b);
}

class IntegerCompare implements Comparator<Integer>{
	public int compare(Integer a, Integer b){
		return a - b;}
}
class StringCompare implements Comparator<String>{
	public int compare(String a, String b){
		int len= Math.min(a.length(), b.length());
		for(int i = 0; i < len; i++){ 
			if(a.charAt(i) != b.charAt(i)) { 
				return a.charAt(i) - b.charAt(i); }
			}
		return a.length()-b.length();
		}
	}
public class Compare1{
public static void main(String[]args) {
	Comparator<Integer>intCmp=new IntegerCompare();
	System.out.println(intCmp.compare(10, 20));
	Comparator<String>strCmp=new StringCompare();
	System.out.println(strCmp.compare("ABC", "BCD"));
}
}


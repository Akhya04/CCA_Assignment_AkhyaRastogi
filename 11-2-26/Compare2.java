package Cores;
interface Comparator2<T> {
    int compare(T a, T b);
}
class GeneralCompares<T> implements Comparator2<T> {
    public int compare(T a, T b) {
    	if(a==null && b==null)return 0;
    	if(a==null)return -1;
    	if(b==null)return 1;
        if (a instanceof Integer && b instanceof Integer) {
            Integer x = (Integer) a;
            Integer y = (Integer) b;
            return x - y;
        }
        if (a instanceof String && b instanceof String) {
            String s1 = (String) a;
            String s2 = (String) b;
            int len = Math.min(s1.length(), s2.length());
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.charAt(i) - s2.charAt(i);
                }
            }
            return s1.length() - s2.length();
        }
        else {
            throw new IllegalArgumentException("Unsupported Data Type");
        }
    }
}
public class Compare2{
    public static void main(String[] args) {
        GeneralCompares<Integer> intCmp = new GeneralCompares<>();
        System.out.println(intCmp.compare(10, 20));
        GeneralCompares<String> strCmp = new GeneralCompares<>();
        System.out.println(strCmp.compare("ABC", "BCD"));
        System.out.println(intCmp.compare(null, 5));
        System.out.println(strCmp.compare("ABC", null));
    }
}


import java.util.*;

class LoopArrayPractice{
	public static void main (String[] args) {
		int[] n ={1,2,3,4,5};
		middleValue(n);
		String[] x = {"abc", "adc", "aec"};
		String[] y = {"abc", "adc", "bec"};
		numMatches(x, y);
	}
public static void middleValue(int[] n){

int m = n.length;

System.out.println(n[m/2]);
}
    public static void numMatches(String[]b, String a)
    {
            int counter = 0;
            for (int i = 0; i < b.length; i++)
                if (a.equals(b[i]))
                    counter++;

           System.out.println(counter);
    }
	public static void inOrder(int[] rah){	
		for (int i = 1; i < rah.length; i++) {
			if (rah[i] < rah[i - 1]) {
				return false;
			}
		}
		return true;
	}

}

import java.util.*;

class Sorting {

	public static void main(String[] args) {
		//number list to sort
		ArrayList<Integer> c = new ArrayList<>();
		for (int i = 0; i < 100; i++){
			c.add(1 + (int)(Math.random() * 100));
		}
		System.out.print(c);

		//timer start
		long start = System.nanoTime();
		//sort
		System.out.print(bobaSort(c));
		//timer end
		long end = System.nanoTime();
		long sum = end - start;

		//result
		System.out.print("this list took " + sum + " nanosecond to sort.");
	}
	public static ArrayList<Integer> bobaSort(ArrayList<Integer> a) {

		//setting locked interger (finished sorting)
		int q = 0;

		//repeat loop on this condition
		boolean repeat;

		while (q < a.size() - 1) {

			//reset repeat counter
			repeat = false;
			//idk how but adding this for loop fixes allows it to work
			for (int o = 0; o < a.size() - q - 1; o++) {
				for (int i = 0; i < a.size() - q - 1; i++) {

					//placeholder
					int z = 0;

					if (a.get(i) > a.get(i + 1)) {
						z = a.get(i);
						a.set(i, a.get(i + 1));
						a.set(i + 1, z);

						// repeat loop
						repeat = true;
					}
				}
			}
			//stops the loop
			if (repeat = false){
				break;
			}

		q++;	
		}

		return a;
	}
}
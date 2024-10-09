import java.util.*
class 20QuestionProject {
	public 20questions(){
		
		//string array of all possible answers
		String[] pa = new String[]

		//arraylist of possible answer
		ArrayList<String> a = new ArrayList<String>();
		//animals
		a.add("snake");
		a.add("fish");
	
		//mammal
		a.add("monkey");
		a.add("bear");
		//plant
		a.add("sunflower");
		a.add("grass");
		//tree
		a.add("apple tree");
		a.add("pine tree");
			

		//answer	
		String ans = "";

		//questions asked
		int qa = 0;

		//booleans
		


	}
	public String askQuestion() {
		if (qa == 0){
			String q = "Is it a Plant?";
			qa++;
		} 
		else if (qa == 1) {
			if (a.contains("monkey" && "bear" && "fish" && "snake") == true){
				q = "is it a mamall";
				qa++
			}
			else (a.contains("sunflower" && "grass" && "apple tree" && "pine tree" && "fern tree") == true){
				q = "is it a tree?"
				qa++

		}
		else if (qa == 2) {
			if (a.contains("monkey" && "bear") == true) {
				q = "does it eat bananas?"
				q++;
			}

			else if (a.contains("fish" && "snake") == true){
				q = "does it live in the water?";
				q++;
			}

			else if (a.contains("sunflower" && "grass") == true){
				q = "is it tall"
				q++;	
			}	
			else if (a.contains("apple tree" && "pine tree") == true){
				q = "does it have fruit"
				q++;
			}

		return q;
	}

	public void updateAnswers() {
		if (qa == 0){
			
		}


	}


	public static void main(String[] args) {
		System.out.println(a);
		System.out.print("Choose a fuggin word");
		askQuestion
		Scanner s = new Scanner(System.in);
		String inp = s.nextBooelean();
		while a.length > 1 {
			askQuestion
		}
	}
}
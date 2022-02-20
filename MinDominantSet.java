package PE1;
import java.util.ArrayList;
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Nir Frankel
Student Number: 210610459
Course Section: M
*/

public class MinDominantSet {
	int [][] buildings; 
	ArrayList<Integer[]> combination; 
	private int size;

	/**
	 * This constructor initializes the ArrayList combination of type Integer[].
	 */
	
	public MinDominantSet () {
		this.combination = new ArrayList<Integer[]>();
	}
	/**
	 * This constructor creates the 
	 * 
	 * @param size represents the number of buildings on campus.
	 * @param buildings is a two dimensional array [size][size] which contains 0 or 1. It represents the distance between buildings
	 * If an element at [i][j] is zero then the distance between i and j is greater than 100m. If the element at [i][j] is 1 then 
	 * the distance between i and j is less than or equal to 100m.
	 */
	public MinDominantSet (int size, int [][] buildings) {
		this.size = size;
		this.buildings = buildings;
		this.combination =  new ArrayList<Integer[]>();
	}

	/**
	 * Combination Method that receives two inputs that are integers n and r, and creates all the combinations of selecting r items from n items
	 * The numbers here are buildings represented by integers starting at zero. This method stores the combination in the instance variable
	 * combination of this class.
	 * 
	 * @param n - Integer greater than or equal to 0
	 * @param r - Integer not greater than n
	 * @pre n must be greater than or equal to r
	 */
	void combination(int n, int r) {
		Integer[] combo = new Integer[r];
		combinationHelper(combo, 0, n-1, 0);
	}
	
	/**
	 * Helper function to combination, recursively creates an array that is added to ArrayList combination
	 * This function works on the principle of binomial coefficient. 
	 * Where C(n,r) = [n!/(r!(n-r)!)] 
	 * When examining this function recursively it can be written as:
	 * C(n,r) = (n-1/r)+(n-1/r-1)
	 * We have implemented this but in reverse. It begins at start and will stop at end. This means the count will be sequential, starting from 0.
	 * The recursive call ends once the index reaches the end and has cycled through the entire array.
	 * 
	 * @param combo - Individual combinations that are dependent on the inputs n and r from the combination method
	 * @param start - The first point of ArrayList combination at 0
	 * @param end - Last position in the ArrayList combination at position n-1.
	 * @param index - Sliding index that is shifted by 1 through each recursive call. Used to cycle through all values of the array.
	 * @pre - start must be less than or equal to end
	 */
	
	private void combinationHelper(Integer[] combo, int start, int end, int index) { 
		if (index == combo.length) {
			Integer[] combinations = combo.clone();
//			Integer[] combinationFor = new Integer[combo.length]; // For loop version of the previous line //
//			for(int i = 0; i < combo.length; i++) {
//				combinationFor[i] = combo[i];
//			}
			combination.add(combinations);
		}
	
		else if (start <= end) {
			combo[index] = start;
			combinationHelper(combo, start + 1, end, index + 1);
			combinationHelper(combo, start + 1, end, index);
		}
	}

	/**
	 * This method takes in the number of vending machines that the university is willing to provide and determines
	 * if they can cover all of the buildings. If yes it returns true, otherwise false.
	 * 
	 * 
	 * @param numMachine an integer representing the number of machines the university is willing to provide
	 * this means that the length of the array at each element of combination arrayList is the same as the number 
	 * of machines that are provided.
	 * @return boolean value of true or false depending on if the number of machines can cover the number of buildings
	 * @pre - numMachine must be less than or equal to size 
	 */
	
	public boolean isEnough(int numMachine) {
		boolean isEnough = true;
		combination(size, numMachine);
		boolean[] isReachable = new boolean[size];
		boolean[] resetReachable = new boolean[size];
		Integer[] currentCombo = new Integer[numMachine];
		
		for(int combination_i = 0; combination_i < combination.size(); combination_i++) {
			isReachable = resetReachable;
			isEnough = true;
			currentCombo = combination.get(combination_i);

			for(int bRow = 0; bRow < buildings.length; bRow++) {

				for(int combo_i = 0; combo_i < combination.get(combination_i).length; combo_i++) {

					if(buildings[bRow][currentCombo[combo_i]] == 1) {
						isReachable[bRow] = true;
						break;
					}
				}
			}
			
			if(isComboEnough(isReachable, isEnough) == true) {
				return true;
			}
			isEnough = false;
		}
		return false;
	}
	/**
	 * This function receives the array of boolean value isReachable and determines if at every point in the array
	 * isReachable is equal to true.
	 * 
	 * @param isReachable - array of boolean values
	 * @param isEnough - boolean value
	 * @return - the boolean value isEnough
	 */
	private boolean isComboEnough(boolean[] isReachable, boolean isEnough) {
		for(int i = 0; i < size; i++){
			if(isReachable[i] == false) {
				isEnough = false;
				break;
			}
		}
		return isEnough;
	}
	
	/**
	 * This method prints the content of the combination.
	 * we don't need this method to solve this problem, 
	 * however it is there to help you see the content of 
	 * the list, when you check for the correctness of your
	 * code.  
	 */
	void print() {

		for (int i = 0; i < combination.size(); i++) {
			for (int j = 0; j < combination.get(i).length; j++) {
				System.out.print(combination.get(i)[j]+ "\t"); 
			}
			System.out.println(); 		
		}
	}
			 
} // end of MinDominantSet


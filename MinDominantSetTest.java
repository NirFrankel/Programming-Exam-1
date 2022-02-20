package PE1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class MinDominantSetTest {

	@Test //-- for students -- task 0
	void MinDominantSetTester1() {
		MinDominantSet obj = new MinDominantSet(); 
		int actual = obj.combination.size(); 
		assertEquals(0, actual, "The default constructor is not correct!");
	}
	
	@Test // -- for student - task 1
	void combinationTester1() {
		int n = 5; 
		int [] combinations = {5, 10, 10, 5, 1};
		boolean equal = true; 
		MinDominantSet obj; 
		for (int i = 1 ; i <= n; i++) {
			obj  = new MinDominantSet();
			obj.combination(n, i);
			equal = obj.combination.size() == combinations[i-1]; 
			if (!equal) break;
		}
		assertEquals(true, equal, "The combination method is not correct when n = 5!");
	}
	@Test // -- for student - task 1
	void combinationTester4() {
		int n = 5; 
		int r = 3;  
		int comb = 10; // the number of combinations will be 10
		int[][] combinations = {
			{0,	1, 2}, 
			{0, 1, 3},	
			{0,	1, 4},
			{0,	2,	3},
			{0,	2,	4},	
			{0,	3,	4},	
			{1,	2,	3},	
			{1,	2,	4},	
			{1,	3,	4},	
			{2,	3,	4}};
		boolean [] equals = new boolean[comb];
		MinDominantSet obj = new MinDominantSet();
		obj.combination(n, r);
		for (int i = 0; i < comb; i++)
			equals[i] = false;
		// to hold the combinations of 3
		int [] ar = new int[r];
		for (int i = 0 ; i < comb; i++) {
			for(int j = 0; j < r; j++)
				ar[j] = obj.combination.get(i)[j];
			boolean equal = false;
			for (int j = 0; j < comb; j++)
				if (java.util.Arrays.equals(ar, combinations[j]))
						equal = true;
			if (equal) equals[i] = true;
		}
		boolean equal = true; 
		for (int i = 0; i < 10; i++)
			if (!equals[i]) equal = false;
		
		assertEquals(true, equal, "The combination method is not correct for C(5, 3)");
	}
	
	@Test // -- for student - task 1
	void combinationTester2() {
		int n = 4; 
		int r = 3;  
		int comb = 4; // the number of combinations will be 4
		int[][] combinations = {
			{0,	1, 2}, 
			{0, 1, 3},	
			{0,	2,	3},
			{1,	2,	3},};
		boolean [] equals = new boolean[comb];
		MinDominantSet obj = new MinDominantSet();
		obj.combination(n, r);
		for (int i = 0; i < comb; i++)
			equals[i] = false;
		// to hold the combinations of 3
		int [] ar = new int[r];
		for (int i = 0 ; i < comb; i++) {
			for(int j = 0; j < r; j++)
				ar[j] = obj.combination.get(i)[j];
			boolean equal = false;
			for (int j = 0; j < comb; j++)
				if (java.util.Arrays.equals(ar, combinations[j]))
						equal = true;
			if (equal) equals[i] = true;
		}
		boolean equal = true; 
		for (int i = 0; i < 4; i++)
			if (!equals[i]) equal = false;
		
		assertEquals(true, equal, "The combination method is not correct for C(5, 3)");
	}

	@Test // -- for student - task 2
	void MinDominantSetTester4() {
		int size = 5; 
 		int [] []  building= {
				{1,	1,	1,	0,	0},
				{1,	1,	0,	0,	0},
				{1,	0,	1,	1,	1},
				{0,	0,	1,	1,	0},
				{0,	0,	1,	0,	1}};

		MinDominantSet obj = new MinDominantSet(size, building); 
		boolean equal = true;
		for (int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				if (obj.buildings[i][j] != building[i][j])
					equal = false;
		equal = equal && obj.combination.size() == 0;
		assertEquals(true, equal, "The ovrloaded constructor is not correct!");
	}


	@Test // -- for students - task 3
	void isEnoughTester5() {
		int numMachine = 2;  
		int size = 5; 
		int [] []  building= {
				{1,	1,	1,	0,	0},
				{1,	1,	0,	0,	0},
				{1,	0,	1,	1,	1},
				{0,	0,	1,	1,	0},
				{0,	0,	1,	0,	1}};

		MinDominantSet obj = new MinDominantSet(size, building); 
		boolean equal = obj.isEnough(numMachine);
		
		assertEquals(true, equal, "The isEnough method is not correct for numMachine = 2 and 5 buildings!");
	}
	
	@Test // -- for students - task 3
	void isEnoughTester6() {
		int numMachine = 1;  
		int size = 7; 
		int [] []  building= {
				{1,	1,	1,	0,	0, 1, 0},
				{1,	1,	0,	0,	0, 1, 1},
				{1,	0,	1,	1,	1, 0, 0},
				{0,	0,	1,	1,	0, 1, 1},
				{0,	0,	1,	0,	1, 0, 1},
				{1, 0,  0,  0,  1, 1, 0},
				{0, 0,  1,  1,  0, 1, 0}
				};

		MinDominantSet obj = new MinDominantSet(size, building); 
		boolean equal = obj.isEnough(numMachine);
		
		assertEquals(true, equal, "The isEnough method is not correct for numMachine = 2 and 5 buildings!");
	}

}

package com.udemy.iterative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Algorithm algorithm = new Algorithm(new int[] {5});
		/*System.out.println(algorithm.sumIterative(5));
		System.out.println(algorithm.sumRecursive(5));
		
		algorithm.headbuildLayer(4);
		algorithm.tailbuildLayer(4);
		
		System.out.println(algorithm.calculateFactorial(2));
		System.out.println(16%8);
		
		System.out.println(algorithm.gcdRecursive(100, 30));
		*/
		//algorithm.solveHanoi(3,'A','B','C');
		//System.out.println(algorithm.findKthLargestItem(new int[] {1,-2,5,8,7,6},0,5,1));
		//algorithm.sortRedWhiteBlue(new int[] {2,0,2,1,1,0,0,2,2,1,2,2,2,1,1,1,1,0,0,0});
		//algorithm.quickSort(new int[] {57,-2,5,0,8,28,7,6},0,7);
		//algorithm.mergeSortHelper(new int[] {57,-2,5,0,8,28,7,6});
		//algorithm.countingSort(new int[] {-2,5,0,8,9,7,6},-2,9);
		//System.out.println(algorithm.bruteForceStringMatch("hvjvhgjvbutterfly", "fly"));
        //System.out.println(algorithm.BoyerMoore("hvjvhgjvbutterfly", "fly"));
		//System.out.println(algorithm.reverseString("6757"));
		/*List<String> suffixes = algorithm.getSuffixes("Hello");
		for(String suffix: suffixes) {
			System.out.println(suffix);
		}
		System.out.println(suffixes.size());*/
		
		/*List<String> prefixes = algorithm.getPrefixes("Hello");
		for(String prefix: prefixes) {
			System.out.println(prefix);
		}
		System.out.println(prefixes.size());*/
	
		//System.out.println(algorithm.longestCommonPrefix("Hellk", "Helloklnm"));
		
		//System.out.println(algorithm.longestRepeatedSubstring("Hellohellooioj"));
		
		//algorithm.NQueens(new int[4][4]);
		
		//algorithm.pathSum1D(new int[] {1,5,6,24,2,11,10});
		//System.out.println(algorithm.magicIndex(new int[]{-40,-20,-1,1,2,3,5,6,8,12,13},0,10));
		
		/*List<String> strings = new ArrayList<String>();
		strings.add("apple");
		strings.add("bezos");
		strings.add("nodrog");
		strings.add("laugh");
		strings.add("gordon");
		strings.add("george");
		strings.add("plepa");
		strings.add("gez");
		strings.add("sobez");
		
		
		algorithm.sortStringsAnagram(strings);*/
		
		//System.out.println(algorithm.searchRotatedArray(new int[] {15,16,19,20,25,1,3,4,5,7,10,14},10));
		/*int mazeTable[][] = {
				{1,1,1,1,1},
				{1,0,0,1,0},
				{1,1,1,1,0},
				{1,1,1,0,1},
				{1,1,1,1,1}
		};
		algorithm.pathExists(mazeTable,4,4);
		System.out.println(algorithm.bfsPathExist(mazeTable, 0, 0, 4, 4));*/
		
		//algorithm.reverseArraySorting(new int[] {7,4},-9);
		//algorithm.convertNum("123456789");
		//algorithm.convertText("aabcddefgggghij");
		//System.out.println(algorithm.countNumberOfNumbers(546844474));
		//algorithm.integerReversion(456);
		//System.out.println(algorithm.percentageOfStrings(new String[] {"hey", "there", "jackie"}, new String[] {"hey", "there", "kelse"}));
		
		//System.out.println(Arrays.toString(algorithm.rankItems(new int[] {25, 7, 54, 90, 7})));
		
		//System.out.println(algorithm.naiveFib(60));
		//System.out.println(algorithm.memoFib(3));
		//System.out.println(algorithm.Knapsnack(3, 5, new int[]{0,4,2,3}, new int[]{0,10,4,7}));
		//System.out.println(algorithm.CoinChange(5, new int[] {1,2,3}));
		//System.out.println(algorithm.RodCutting(new int[] {0,3,5,6,8,9,10}, new int[] {0,2,5,7,3,7,18},10,6 ));
		/*Integer weight[] = { 2, 5, 4, 7, 1, 3, 8 }; 
        int c = 10; 
        int n = weight.length; 
        System.out.println("Number of bins required in Next Fit : " + algorithm.firstFit(weight, n, c)); */
		//System.out.println(algorithm.findMissingNumber(new int[] {1,2,4,5,6}));
		//System.out.println(algorithm.maxProfitOneTrasaction(new int[] {7,1,5,3,6,4}));
		//System.out.println(algorithm.maxProfitManyTransactions(new int[] {7,1,5,3,6,4}));
		//System.out.println(algorithm.dearrangementsHelper(3));
		//System.out.println(algorithm.dearrangementsHelperBottom(64));
		//System.out.println(algorithm.bottomUpDynamicDearrangementsSpace(64));
		//System.out.println(algorithm.makeMinChange(new int[] {1,2,5},5));
		//System.out.println(algorithm.helperlandPlanesTDDP(new int[] {155,55,2, 96,67,203,3}, 0));
		//System.out.println(algorithm.helperlandPlanesTDDP(new int[] {155,55,2,54,768,45,34,57,242,88,456,237,33,5,78, 96,67,203,3}, 0));
		//System.out.println(algorithm.helperlandPlanesBUDP(new int[] {155,55,2, 96,67,203,3}));
		//System.out.println(algorithm.landPlanesBUDPOptimized(new int[] {155,55,2, 96,67,203,3}));
		//System.out.println(algorithm.maxSubArray(new int[] {5,-4,8,-10,-2,4,-3,2,7,-8,3,-5,3}));
		//System.out.println(algorithm.maxSubArraySizeK(new int[] {2,1,2,5,1,3},3));
		//System.out.println(algorithm.removeElement(new int[] {3,2,2,3},3));
		//System.out.println(Arrays.toString(algorithm.productExceptSelf(new int[] {1,2,3,4})));
		//System.out.println(algorithm.findMissingRanges(new int[] {0,1,3,50,75}, 0, 99));
		//algorithm.transposeMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		//System.out.println(algorithm.characterCountSort("abbcaaaagyttt"));
		//System.out.println(algorithm.kthSmallestElement(new int[] {3,2,1,5,6,4}, 3));
		//algorithm.removeWhiteSpaces("the sky is  blue ");
		//System.out.println(algorithm.convertStringToInteger("34"));
		//System.out.println(algorithm.firstUniqueCharacter("hhheyello"));
		//System.out.println(algorithm.reverseInteger(34));
		//System.out.println(algorithm.containsDuplicate(new int[] {1,2,3,1}));
		//System.out.println(Arrays.toString(algorithm.moveZeros(new int[] {0,1,0,3,0,0,0,0,4,23,54,23,0,54,12})));
		//System.out.println(Arrays.toString(algorithm.sortColors(new int[] {2,0,1,2,2,1,2,1,0,0,0,2,1,1,2,1,2,2,1,1,2,0,1,0,2,1,1,0})));
		//System.out.println(Arrays.toString(algorithm.plusOne(new int[] {9,9,9})));
		//System.out.println(algorithm.threeSum(new int[] {-1,0,1,2,-1,-4}));
		//System.out.println(algorithm.containerWithMostWater(new int[] {1,8,6,2,5,4,8,3,7}));
		//algorithm.permutationOfString("abc");
		//System.out.println(algorithm.generateSubsets(new int[] {1,2,3}));
		//System.out.println(algorithm.permuteStringSecond("abc"));
		//algorithm.inplaceRotateMatrix(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		
		//System.out.println(algorithm.reverseStringFor("reverse"));
		//System.out.println(algorithm.minimumSizeSubArray(new int[] {2,3,1,2,4,3}, 7));
		//System.out.println(algorithm.longestSubstringWith2DistinctCharacters("ccaabbb"));
		
		TreeNode t = new TreeNode(8);
		t.left = new TreeNode(3);
		t.left.left = new TreeNode(1);
		t.left.right = new TreeNode(6);
		t.right = new TreeNode(10);
		t.right.left = null;
		t.right.right = new TreeNode(14);
		
		//System.out.println(algorithm.preOrderTraversal(t));
		//System.out.println(algorithm.postOrderTraversal(t));
		
		//algorithm.lexiographocalFunction();
		//System.out.println(algorithm.levelOrderTraversal(t));
		/*int max = Integer.MAX_VALUE;
		int[][] walls = new int[][] { 
			{max,-1,0,max},
			{max,max,max,-1},
			{max,-1,max,-1},
			{0,-1,max,max}
		};
		
		algorithm.wallAndGates(walls);*/
		
		//System.out.println(algorithm.meetingRooms(new int[][] {{0,30},{31,35},{40,60}}));
		//System.out.println(algorithm.mergeStrings("acbaaaacccccccccca", "abbbbbyuuuuuu"));
		
		int[][] print = new int[][] {
			{8,3,9,0,10},
			{3,5,17,1,1},
			{2,8,6,23,1},
			{15,7,3,2,9},
			{6,14,2,6,0}
		};
		
	 //    algorithm.printMatrixSum(print);
	     
	     
	    String[][] matrixSort = new String[][] {
	    	{"9","2","1","?","4","8"},
	    	{"5","?","3","7","6","5"},
	    	{"6","8","7","9","2","3"}
	    };
	    
	    algorithm.missingNumber(matrixSort);
	}

}

package com.udemy.iterative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


public class Algorithm {
	
	public void missingNumber(String[][] mat) {
		int[] missingNo = new int[mat.length/3+1];
		int sumOfMatrix = (9*10)/2;
		int index = 0;
	
		
		Map<String, List<String>> map = new TreeMap<>();
		String[][] ans = new String[mat.length][mat[0].length];
		
		for(int k=0; k<mat[0].length; k+=3) {
			int runningTotal = 0;
			for(int i=0; i<mat.length; i++) {
				for(int j=k; j<k+3; j++) {
					
					map.put("?",map.getOrDefault("?",new ArrayList<String>()));
					map.get("?").add(mat[i][j]);
					if(mat[i][j] != "?")
					runningTotal+= Integer.parseInt(mat[i][j]);
				}
			}
			missingNo[index] = sumOfMatrix - runningTotal;
			map.put(Integer.toString(missingNo[index]), map.remove("?"));
			index++;
		}
		
		 for (Map.Entry<String, List<String>> entry : map.entrySet())  
	            System.out.println("Key = " + entry.getKey() +  
	                         ", Value = " + entry.getValue()); 
		 
		 Iterator it = map.entrySet().iterator();
		 for(int k=0; k<mat[0].length; k+=3) {
			    Map.Entry entry = (Map.Entry)it.next();
			    String key = (String)entry.getKey();
			    List<String> value = (List<String>) entry.getValue();
			    int count = 0;
				for(int i=0; i<mat.length; i++) {
					for(int j=k; j<k+3; j++) {
						String s = value.get(count);
						if(s == "?") {
							s = key;
						}
						ans[i][j] = s;
						count++;
					}
				}
				
			}
		 
		 for(int i=0; i<ans.length; i++) {
			 for(int j=0; j<ans[0].length; j++) {
				 System.out.print(ans[i][j]+ " ");
			 }
			 System.out.println();
		 }
		 
		
		//Arrays.sort(missingNo);
		
		
		
		
			
		
		
		
		
	}
	
	public void printMatrixSum(int[][] nums) {
		//int[] rows = new int[nums.length];
		//int[] cols = new int[nums[0].length];
		
		
		
		/*for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				rows[i] += nums[i][j];
				cols[j] += nums[i][j];
			}
		}*/
		
		int rowSum =0;
		int colSum=0;
		
		for(int i=0; i<nums.length; i++) {
			rowSum=0;
			colSum=0;
			for(int j=0; j<nums[i].length; j++) {
				rowSum += nums[i][j];
				colSum += nums[j][i];
			}
			System.out.println(rowSum + " " + colSum);
		}
		/*
		for(int num: rows) {
			System.out.print(num+" ");
		}
		
		System.out.println();
		for(int num: cols) {
			System.out.print(num + " ");
		}*/
	}
	
	public int maxDepth(TreeNode root) {
	       if(root == null){
	           return 0;
	       }
	        
	      
	       int left = maxDepth(root.left)+1;
	       int right = maxDepth(root.right)+1;
	       
	       return Math.max(left,right);
	 }
	
	public boolean containsWords(List<String> words, String complexWord) {
		String wordLower = complexWord.toLowerCase();
		
		for(String s: words) {
			if(complexWord.contains(s)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;
        
        int[] cnt_arr = new int[256];
        for(char c : s.toCharArray()){
            cnt_arr[c]++;
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> cnt_arr[b] - cnt_arr[a]);
        for(int i = 0; i < 256; i++){
            pq.offer((char)i);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character c = pq.poll();
            for(int i = 0; i < cnt_arr[c]; i++){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
	
	public String mergeStrings(String s1, String s2) {
		int[] s1Count = new int[26];
		int[] s2Count = new int[26];
		
		for(Character s: s1.toCharArray()) {
			s1Count[s-'a']++;
		}
		
		for(Character s: s2.toCharArray()) {
			s2Count[s-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		int i=0;
		int j=0;
		
		while(i<s1.length() && j<s2.length()) {
			int s1CountTemp = s1Count[s1.charAt(i) - 'a'];
			int s2CountTemp = s2Count[s2.charAt(j) - 'a'];
			
			if(s1CountTemp > s2CountTemp) {
				sb.append(s1.charAt(i));
				i++;
			}
			else
			if(s1CountTemp < s2CountTemp) {
				sb.append(s2.charAt(j));
				j++;
			}	
			else {
				int compare = s1.compareTo(s2);
				if(compare < 0) {
					sb.append(s1.charAt(i));
					i++;
				}
				else
				if(compare > 0) {
					sb.append(s2.charAt(j));
					j++;
				}
				else {
					sb.append(s1.charAt(i));
					i++;
				}
				
			}
		}
		
		while(i<s1.length()) {
			sb.append(s1.charAt(i));
			i++;
		}
		
		
		while(j<s2.length()) {
			sb.append(s2.charAt(j));
			j++;
		}
		
		return sb.toString();
	}
	
	public int getMaximumGold(int[][] grid) {
	       if(grid.length == 0) return 0;
	        int max = 0;
	        int row = grid.length;
	        int col = grid[0].length;
	        
	        boolean[][] visited = new boolean[row][col];
	    
	        
	        for(int i=0; i<row; i++){
	            for(int j=0; j<col; j++){
	                if(grid[i][j] == 0) continue;
	                max = Math.max(max, findGold(grid,i,j,visited));
	            }
	        }
	        
	        return max;
	    }
	    
	    public int findGold(int[][] grid, int x, int y, boolean[][] visited){
	        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || visited[x][y] == true){
	            return 0;
	        }
	        
	        if(grid[x][y] == 0){
	            return 0;
	        }
	        
	        int sum=0;
	    
	        visited[x][y] = true;
	        
	        int[][] DIRS = {{1,0},
	                        {0,1},
	                        {-1,0},
	                        {0,-1}
	                       };
	        
	        for(int[] dir: DIRS){
	            int newRow = x + dir[0];
	            int newCol = y + dir[1];
	            
	            int tempSum = findGold(grid, newRow, newCol, visited);
	            sum = Math.max(sum, tempSum );
	        }
	        
	        visited[x][y] = false;
	        
	        return sum+grid[x][y];
	    }
	    
	    
	
	public boolean meetingRooms(int[][] rooms) {
		Arrays.sort(rooms, (a,b)->Integer.compare(a[0], b[0]));
		
		/*int[] cur = rooms[0];
		for(int[] room: rooms) {
			if(room[1] < cur[0]) {
				return false;
			}
			cur = room;	
		}*/
		
		for(int i=0; i<rooms.length-1; i++) {
			if(rooms[i][1] > rooms[i+1][0]) return false;
		}
		
		return true;
	}
	
	public int[][] wallAndGates(int[][] grid){
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] != -1 && grid[i][j] != 0) {
					grid[i][j] = bfsGate(grid,i,j, new boolean[grid.length][grid[0].length]);
				}
			}
		}
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == Integer.MAX_VALUE) {
					grid[i][j] = -99;
				}
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
		return grid;
		
	}
	
	private int bfsGate(int[][] grid, int i, int j, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] {i,j});
		int length = 0;
		
		int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int s=0; s<size; s++) {
				int[] temp = queue.poll();
				visited[temp[0]][temp[1]] = true;
				if(grid[temp[0]][temp[1]] == 0) {
					return length;
				}
				for(int[] dir: dirs) {
					int newX = temp[0] + dir[0];
					int newY = temp[1] + dir[1];
					if(isValidMoveWals(grid, newX, newY,visited)) {
						queue.offer(new int[] {newX, newY});
					}
				}
			}
			length++;
		}
		
		return Integer.MAX_VALUE;
	}
	
	public boolean isValidMoveWals(int[][] grid, int row, int col, boolean[][] visited) {
		return  row>=0 && col >=0 && row<grid.length && col<grid[0].length && visited[row][col] ==false && grid[row][col] != -1;
	}

	public boolean bfsPathExist(int[][] grid, int srow, int scol, int erow, int ecol) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{srow,scol});
		
		boolean[][] visited = new boolean[grid.length][grid[0].length]; 
		
		int[][] dirs = {
				{0,1},
				{1,0},
				{-1,0},
				{0,-1}
		};
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int[] temp = queue.poll();
				
				if(temp[0] == erow && temp[1] == ecol) {
					return true;
				}
				
				visited[temp[0]][temp[1]] = true;
				
				for(int dir[]: dirs) {
					int newX = temp[0]+ dir[0];
					int newY = temp[1] + dir[1];
					if(isValidMoveBFS(grid, newX, newY, visited)) {
						queue.offer(new int[] {newX, newY});
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isValidMoveBFS(int[][] grid, int row, int col, boolean[][] visited) {
		return  row>=0 && col >=0 && row<grid.length && col<grid[0].length && visited[row][col] ==false && grid[row][col] != 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<List<Integer>> levelOrderTraversal(TreeNode root){
		Queue<TreeNode> queue = new LinkedList();
		
		queue.offer(root);
		List<List<Integer>> result = new ArrayList<>();
		int count =1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tempList = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNode temp = queue.poll();
				
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				
				if(temp.right != null) {
					queue.offer(temp.right);
				}
				
				if(count % 2 ==0) {
				   tempList.add(0,temp.val);
				}else {
				   tempList.add(temp.val);
				}
				
				
			}
			result.add(tempList);
			count++;
		}
		
		return result;
		
	}
	
	public void lexiographocalFunction() {
		Character a = 'a';
		System.out.println(a.compareTo('z'));
		System.out.println(Character.compare('z', 'a'));
		System.out.println(Character.compare('a', 'a'));
	}
	
	 public List<Integer> postOrderTraversal(TreeNode t){
		 Stack<TreeNode> stack = new Stack<>();
		 List<Integer> result = new ArrayList<>();
		 stack.push(t);
		 
		 
		 TreeNode node;
		 while(!stack.isEmpty()) {
			 node = stack.pop();
			 result.add(0,node.val);
			 
			 if(node.left!=null) {
				 stack.push(node.left);
			 }
			 
			 if(node.right!=null) {
				 stack.push(node.right);
			 }
		 }
		 
		 return result;
		 
	 }
	
	 

	 
	 public List<Integer> preOrderTraversal(TreeNode t){
		 Stack<TreeNode> stack = new Stack<>();
		 List<Integer> result = new ArrayList<>();
		 stack.push(t);
		 
		 while(!stack.isEmpty()) {
			 TreeNode temp = stack.pop();
			 result.add(temp.val);
			 
			 if(temp.right!=null) {
				 stack.push(temp.right);
			 }
			 
			 if(temp.left!=null) {
				 stack.push(temp.left);
			 }
		 }
		 
		 return result;
		 
	 }
	
	 public List<Integer> findAnagrams(String s, String p) {
	       if(s.length()<p.length()) return new ArrayList<>();
	        
	       List<Integer> result = new ArrayList<>();
	       int[] charCount = new int[26];
	        
	       for(int i=0; i<p.length(); i++ ){
	           charCount[s.charAt(i)-'a']++;
	           charCount[p.charAt(i)-'a']--;
	       }
	        
	       for(int i=p.length(); i<s.length(); i++){
	           if(isAllZeros(charCount)){
	               result.add(i-p.length());
	           }
	           
	           charCount[s.charAt(i)-'a']++;
	           charCount[s.charAt(i-p.length())-'a']--;
	       }
	        
	        if(isAllZeros(charCount)){
	               result.add(s.length()-p.length());
	        }
	        
	        return result;
	          
	    }
	    
	    public boolean isAllZeros(int[] arr){
	        for(int i=0; i<arr.length; i++){
	            if(arr[i] != 0)return false;
	        }
	        return true;
	    }
	
	 public int lengthOfLongestSubstringWithoutRepeatingCharacters(String s) 
	    {
	        if(s.length() ==0)return 0;
	        Map<Character, Integer> map = new HashMap<>();
	        int left=0;
	        int cur=0;
	        int max=1;
	        
	        while(cur<s.length())
	        {
	            char ch = s.charAt(cur);
	            if(!map.containsKey(ch))
	             {
	                map.put(ch, cur++);
	             }           
	             else if(map.containsKey(ch))
	             {
	                int lastIndex = s.length()-1;
	                for(int val: map.values())
	                {
	                    lastIndex = Math.min(lastIndex, val);
	                }
	                
	                left = lastIndex+1;
	                map.remove(s.charAt(lastIndex));
	             }
	               
	            max = Math.max(max, cur-left);

	        }
	        return max;
	      
}
	
public int longestSubstringWith2DistinctCharacters(String s) {
	int max = 1;
	int i=0;
	int curr=0;
	
	Map<Character,Integer> map = new HashMap<>();
	
	while(curr<s.length()) {
		if(map.size() <=2) {
			map.put(s.charAt(curr), curr++);
		}
		
		if(map.size()>2) {
			int minIndex = s.length()-1;
			for(int val: map.values()) {
				minIndex = Math.min(minIndex, val);
			}
			
			i = minIndex+1;
			map.remove(s.charAt(minIndex));
		}
		
		max = Math.max(max, curr-i);
	}
	return max;
}
	
public int minimumSizeSubArray(int[] nums, int target) {
	int left=0;
    int runningSum =0;
    int minLength = Integer.MAX_VALUE;
    
    for(int i=0; i<nums.length; i++){
        runningSum+=nums[i];
        while(runningSum>=target){
            minLength = Math.min(minLength, i-left+1);
            runningSum-=nums[left];
            left++;
        }
    }
    
    return minLength == Integer.MAX_VALUE? 0:minLength;
}
	
public String reverseStringFor(String s) {
	char[] strCh = s.toCharArray();
	for(int i=0; i<strCh.length/2; i++) {
		char temp = strCh[i];
		strCh[i] = strCh[strCh.length-1-i];
		strCh[strCh.length-1-i] = temp;
	}
	
	return String.valueOf(strCh);
}
	
public void inplaceRotateMatrix(int[][] matrix) {
	for(int i=0; i<matrix.length; i++) {
		for(int j=i; j<matrix[0].length; j++) {
			int temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}
	
	for(int i=0; i<matrix.length; i++) {
		for(int j=0; j<matrix[0].length/2; j++) {
			  int temp = matrix[i][j];
			  matrix[i][j] = matrix[i][matrix.length-1-j];
			  matrix[i][matrix.length-1-j] = temp;
		}	
	}
	
	
	for(int i=0; i<matrix.length; i++){
		for(int j=0; j<matrix[0].length; j++) {
			System.out.print(matrix[i][j]);
		}
		System.out.println();
	}
}
	
public List<List<String>> permuteStringSecond(String s) {
	List<List<String>> subsets = new ArrayList<>();
	permuteStringSecond(s, new ArrayList<>(), subsets);
	return subsets;
}

public void permuteStringSecond(String s, List<Character> selected, List<List<String>> subsets) {
	if(selected.size() == s.length()) {
	subsets.add(new ArrayList(selected));
	}
	for(int i=0; i<s.length(); i++) {
		if(selected.contains(s.charAt(i))) continue;
		selected.add(s.charAt(i));
		permuteStringSecond(s, selected, subsets);
		selected.remove(selected.size()-1);
	}
}
	
public List<List<Integer>> generateSubsets(int[] nums) {
	List<List<Integer>> subsets = new ArrayList<>();
	generateSubsets(0,nums, new ArrayList<>(), subsets);
	return subsets;
}

public void generateSubsets(int index, int[] nums, List<Integer> selected, List<List<Integer>> subsets) {
	if(index == nums.length+1)return;
	subsets.add(new ArrayList(selected));
	for(int i=index; i<nums.length; i++) {
		selected.add(nums[i]);
		generateSubsets(i+1, nums, selected, subsets);
		selected.remove(selected.size()-1);
	}
}
	
public void permutationOfString(String s) {
	permuteString("",s);
}
	
public void permuteString(String selected, String remaining) {
	if(remaining.length() == 0) {
		System.out.println(selected);
		return;
	}
	else {
		for(int i=0; i<remaining.length(); i++) {
			permuteString(selected + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1, remaining.length()));
		}
	}
}
	
public int containerWithMostWater(int[] nums) {
	int left =0;
	int right = nums.length-1;
	int max = Integer.MIN_VALUE;
	
	while(left<right) {
		int ans = 0;
		ans = (right-left)*Math.min(nums[left], nums[right]);
		max = Math.max(ans, max);
		if(nums[left] < nums[right]) {
			left++;
		}
		else
		if(nums[left] > nums[right]) {
			right--;
		}else {
			left++;
		}
		
	}
	return max;
}
	
public List<List<Integer>> threeSum(int[] nums) {
	Arrays.sort(nums);
	List<List<Integer>> ans = new LinkedList<>();
	
	for(int i=0; i<nums.length-2; i++) {
		if(i==0 || (nums[i]!=nums[i-1])) {
			int left = i+1;
			int right = nums.length-1;
			int sum = 0-nums[i];
			while(left<right) {
				if(nums[left]+nums[right] == sum) {
					ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
					while(left<right && nums[left] == nums[left+1])left++;
					while(left<right && nums[right] == nums[right-1])right--;		
					left++;
					right--;
				}
				else
				if(nums[left]+nums[right] > sum) {
					right--;
				}else {
					left++;
				}
			}
		}
	}
	return ans;
}
	
public int[] plusOne(int[] nums) {
	int last = nums.length-1;
	if(nums[last] != 9) {
		nums[last]++;
		return nums;
	}
	
	while(last >=0) {
		if(nums[last] == 9) {
			nums[last]=0;
			last--;
		}
		else {
			nums[last]++;
			break;
		}
	}
	
	
	if(nums[0] == 0) {
		int[] result = new int[nums.length+1]; 
		result[0] =1;
		return result;
	}
	
	return nums;
}
	
public int[] sortColors(int[] nums) {
	int left = 0;
	int right = nums.length-1;
	int index=0;
	while(index<=right && index < nums.length) {
		if(nums[index] == 0) {
			swap(nums, index, left);
			index++;
			left++;
		}
		else if(nums[index] == 2) {
			swap(nums, index, right);
			right--;
		}else {
			index++;
		}
	}
	return nums;
}
	
public int[] moveZeros(int[] arr) {
	int reader = 0;
	int writer = 0;
	
	while(reader < arr.length && writer < arr.length) {
		if(arr[reader] != 0) {
			arr[writer] = arr[reader];
			writer++;
		}
		reader++;
	}
	
	while(writer < arr.length) {
		arr[writer]=0;
		writer++;
	}
	return arr;
}
	
public List<List<String>> groupAnagrams(String[] strs) {
	
	Map<String, List> map = new HashMap<>();
	
	for(String s: strs) {
		int[] count = new int[26];
		for(Character c: s.toCharArray()) count[c-'a']++;
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<26; i++) {
			sb.append(count[i]);
		}
		
		String key = sb.toString();
		if(!map.containsKey(key)) map.put(key, new ArrayList());
		
		map.get(key).add(s);
	}
	
	return new ArrayList<>(map.values());
}
	
 //Tower hopping problem
public boolean containsDuplicate(int[] arr) {
	Set<Integer> set = new HashSet<>();
	for(int a: arr) {
		if(!set.contains(a)) {
			set.add(a);
		}else {
			return true;
		}
	}
	return false;
}
	
public int reverseInteger(int num) {
	int ans=0;
	int counter=0;
	
	while(num>0) {
		int rem = num%10;
		ans = ans*10+rem;
		num=num/10;
	}
	
	return ans;
}
	
public int firstUniqueCharacter(String s) {
	Map<Character,Integer> map = new HashMap<>();
	for(Character c: s.toCharArray()) {
		map.put(c, map.getOrDefault(c,0)+1);
	}
	
	int index=0;
	for(Character c: s.toCharArray()) {
		if(map.get(c) == 1) {
			return index;
		}
		index++;
	}
	
	return -1;
}
	
public int convertStringToInteger(String num) {
	int mult = 10;
	int i = 0;
	int ans = 0;
	while(i<num.length()) {
		int digit = Character.getNumericValue(num.charAt(i));
		ans = ans * 10 + digit;
		i++;
	}
	return ans;
}
	
 public void removeWhiteSpaces(String s2) {
	 char[] s = s2.toCharArray();
	 int readPointer =0;
	 int writePointer = 0;
	 while(readPointer < s2.length()) {
		 
		 if(!Character.isWhitespace(s[readPointer])) {
			 s[writePointer] = s[readPointer];
			 writePointer++;
			 System.out.println(Arrays.toString(s));
		 }
		 
		 readPointer++;
	 }
	 
	 
 }	
 /*public String removeWhiteSpaces(String s) {
	 StringBuilder sb = new StringBuilder();
	 for(int i=0; i<s.length(); i++) {
		 if(s.charAt(i) != ' ') {
			 sb.append(s.charAt(i));
		 }
	 }
	 return sb.toString();
 }
	*/
 
  public int kthSmallestElement(int[] nums, int k) {
	  PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
	  for(int i=0; i<nums.length; i++) {
		  if(i<k) {
			  pq.add(nums[i]);
		  }else {
			  if(nums[i] < pq.peek()) {
				  pq.poll();
				  pq.add(nums[i]);
			  }
		  }
	  }
	  return pq.peek();
  } 
	
  public String characterCountSort(String s) {
	  Map<Character, Integer> count = new HashMap<>();
	  for(Character c: s.toCharArray()) {
		  count.put(c, count.getOrDefault(c, 0)+1);
	  }
	  
	  PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
	  pq.addAll(count.entrySet());
	  
	  StringBuilder sb = new StringBuilder();
	  while(!pq.isEmpty()) {
		  Map.Entry<Character, Integer> map  = pq.remove();
		  Character ch = map.getKey();
		  Integer tempInt = map.getValue();
		  while(tempInt>0) {
			  sb.append(ch);
			  tempInt--;
		  }
	  }
	  return sb.toString();
  }
	
   public boolean isTorplitzMatrix(int[][] matrix) {
	   for(int i=0; i<matrix.length-1; i++) {
		   for(int j=0; j<matrix[i].length-1; j++) {
			   if(matrix[i][j] != matrix[i+1][j+1])return false;
		   }
	   }
	   return true;
   }
	
   public void transposeMatrix(int[][] matrix) {
	   
	   int[][] A = new int[matrix.length][matrix[0].length];
	   for(int i=0; i<matrix.length; i++) {
		   for(int j=0; j<matrix[0].length; j++) {
			   A[i][j] = matrix[j][i];
		   }
	   }
	   
	   for(int i=0; i<matrix.length; i++) {
		   for(int j=0; j<matrix[0].length; j++) {
		       System.out.print(A[i][j]+" ");
		   }
		   System.out.println();
	   }
	   
   }
	
	/*public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	    List<String> result = new ArrayList<>();
		
		int prev = lower-1;
		for(int i=0; i<=nums.length; i++) {
			int currNum = i == nums.length?upper+1:nums[i];
			if(currNum - prev >=2) {
				if(prev+1 == currNum-1) {
					result.add(Integer.toString(prev+1));
				}else {
					result.add((prev+1) +"->"+(currNum-1));
				}
			}
			prev=currNum;
		}
        
		return result;
        
    }*/

/*public String[] missingRanges(int[] arr, int lower, int upper) {
    ArrayList<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    if(lower!=arr[0]) {
		sb.append(lower+"->"+arr[0]);
		result.add(sb.toString());
	}
	for(int i=1; i<arr.length; i++) {
		sb = new StringBuilder();
		
		if(arr[i-1] != (arr[i]-1)) {
			sb.append(arr[i-1]+1);
			if(i<arr.length && (arr[i+1] == (arr[i]+1))) {
				
			}
		}
	}
}*/
	
public int[] productExceptSelf(int[] arr) {
	int prod = 1;
	for(int a: arr) prod*=a;
	int[] result = new int[arr.length];
	for(int i=0; i<result.length; i++) {
		result[i] = prod/arr[i];
	}
	
	return result;
}
	
public int removeElementFront(int[] arr, int val) {
	int j=0;//writer
	for(int i=0; i<arr.length; i++) {//reader
		if(arr[i] != val) {
			arr[j] = arr[i];
			j++;
		}
	}
	return j;
}
	
public int removeElement(int[] arr, int val) {
	int i=arr.length-1;
	int count=0;
	for(int j=arr.length-1; j>=0; j--) {
		if(arr[j] == val) {
			swap(arr,i,j);
			i--;
			count++;
		}
	}
	System.out.println(Arrays.toString(arr));
	return arr.length - count;
}
	
public int maxSubArraySizeK(int[] nums, int k) {
	
	int sum = 0;
	int i=0;
	int j=0;
	int max = Integer.MIN_VALUE;
	
	for(int l=0; l<k; l++) {
		sum+=nums[l];
	}
	
	System.out.println(j);
	System.out.println(sum);
	j=k-1;
	while(j<nums.length-1) {
		sum = sum - nums[i];
		i++;
		j++;
		sum = sum + nums[j];
	
		max =Math.max(sum, max);
	}
	
	return max;
}
	
public int maxSubArray(int[] arr) {
	int max = 0;
	for(int j=0; j<arr.length; j++) {
		max = Math.max(max, this.maxSubArray(arr,j));
	}
	return max;
}
	
 public int maxSubArray(int[] arr, int index) {
	 if(index <=0) {
		 return arr[0];
	 }
	 return Math.max(arr[index], maxSubArray(arr,index-1)+arr[index]);
 } 
	
 public int landPlanes(int[] planes, int i) {
	 if(i>=planes.length) return 0;
	 
	 int chooseToLand = planes[i]+landPlanes(planes, i+2);
	 int chooseNotToLand = landPlanes(planes, i+1);
	 return Math.max(chooseToLand, chooseNotToLand);
	 
 }
 
 public int helperlandPlanesTDDP(int[] planes, int i) {
	 int[] memo = new int[planes.length];
	 Arrays.fill(memo, -1);
	 return landPlanesTDDP(planes,i, memo);
 }
 
 public int landPlanesTDDP(int[] planes, int i, int[] memo) {
	 if(i>=planes.length) return 0;
	 if(memo[i] != -1) return memo[i];
	 
	 int chooseToLand = planes[i]+landPlanes(planes, i+2);
	 int chooseNotToLand = landPlanes(planes, i+1);
	 int max = Math.max(chooseToLand, chooseNotToLand);
	 memo[i] = max;
	 return max;
	 
 }
 
 public int helperlandPlanesBUDP(int[] planes) {
	 int[] memo = new int[planes.length];
	 return landPlanesBUDP(planes, memo);
 }
 
 public int landPlanesBUDP(int[] planes, int[] memo) {
	
	for(int j=planes.length-1; j>=0; j--) {
		int landPlane = planes[j] + (j+2>=planes.length-1?0:memo[j+2]);
		int dontLandPlane = (j+1>=planes.length-1?0:memo[j+1]);
		memo[j] = Math.max(landPlane, dontLandPlane);
	}
	
	return memo[0];
	 
 }
 
 public int landPlanesBUDPOptimized(int[] planes) {
	
	    int planeVal =0;
	    int middleVal = 0;//+1
	    int rightVal = 0;//+2
	 
		for(int j=planes.length-1; j>=0; j--) {
			int landPlane = planes[j] + rightVal;
			int dontLandPlane = middleVal;
			planeVal = Math.max(landPlane, dontLandPlane);
			rightVal = middleVal;
			middleVal = planeVal;
		}
		
		return planeVal;
		 
	 }
	
 public int makeMinChange(int[] coins, int amount) {
	 int result =0;
	 int memo[] = new int[amount+1];
	 Arrays.fill(memo, Integer.MAX_VALUE);
	 memo[0] = 0;
	 
	 for(int i=1; i<memo.length; i++) {
		 for(int coin: coins) {
			 if(coin <= i ) {
				 memo[i] = Math.min(memo[i], memo[i-coin]+1);
			 }
		 }
	 }
	 
	 return memo[amount];
 }

  public long dearrangementsHelper(int n) {
	  long[] memo = new long[n+1];
	  Arrays.fill(memo, -1);
	  return topDownDynamicdearrangements(n,memo);
  }
  
  public long dearrangementsHelperBottom(int n) {
	  long[] memo = new long[n+1];
	  Arrays.fill(memo, -1);
	  return bottomUpDynamicDearrangements(n,memo);
  }
  
  public long bottomUpDynamicDearrangements(int n, long[] memo) {
	  memo[1] = 0;
	  memo[2] = 1;
	  
	  for(int i=3; i<=n; i++) {
		  memo[i] = (i-1) * (memo[i-1]+memo[i-2]);
	  }
	  return memo[n];
  }
  
  public long dearrangementsHelperBottomSpace(int n) {
	  return bottomUpDynamicDearrangementsSpace(n);
  }
  
  public long bottomUpDynamicDearrangementsSpace(int n) {
	  long leftTemp = 0;
	  long middleTemp = 1;
	  long res = 0;
	  
	  for(int i=3; i<=n; i++) {
		  
		  res = (i-1) * (middleTemp+leftTemp);
		  leftTemp = middleTemp;
		  middleTemp = res;
	  }
	  return res;
  }
	
  public long topDownDynamicdearrangements(int n, long[] memo) {
	  if(memo[n] != -1) return memo[n];
	  if(n ==1) {
		  return 0;
	  }else
	  if(n==2) {
		  return 1;
	  }else {
		  long result =  (n-1)*(topDownDynamicdearrangements(n-1, memo) + topDownDynamicdearrangements(n-2, memo));
		  memo[n] = result;
		  return result; 
	  }
  }
	
  public int maxProfitManyTransactions(int[] nums) {
	  int total =0;
	  for(int i=1; i<nums.length; i++) {
		  if(nums[i] > nums[i-1]) {
			  total += nums[i] - nums[i-1];
		  }
	  }
	  return total;
  }	
		
		
   public int maxProfitOneTrasaction(int[] nums) {
	   int min = nums[0];
	   int profitFromMin = 0;
	   for(int i=1; i<nums.length; i++) {
		   if(nums[i] < min) {
			   min = nums[i];
		   }else {
			   int tempProfit = nums[i] - min;
			   if(tempProfit > profitFromMin) {
				   profitFromMin = tempProfit;
			   }
		   }
	   }
	   
	   return profitFromMin;
	   
   }
		
		
	public int findMissingNumber(int[] nums) {
		int maxNo = Arrays.stream(nums).max().getAsInt();
		int a=nums[0];
		
		for(int i=1; i<nums.length; i++ ) {
			a ^= nums[i];
		}
		
		for(int i=1; i<=maxNo; i++) {
			a ^= i;
		}
		
		return a;
	}
	
	
	
	
	static int firstFit(Integer weight[], int n, int c) 
	{ 
		Arrays.sort(weight, Collections.reverseOrder()); 
		
	    // Initialize result (Count of bins) 
	    int res = 0; 
	  
	    // Create an array to store remaining space in bins 
	    // there can be at most n bins 
	    int []bin_rem = new int[n]; 
	  
	    // Place items one by one 
	    for (int i = 0; i < n; i++)  
	    { 
	        // Find the first bin that can accommodate 
	        // weight[i] 
	        int j; 
	        for (j = 0; j < res; j++)  
	        { 
	            if (bin_rem[j] >= weight[i]) 
	            { 
	                bin_rem[j] = bin_rem[j] - weight[i]; 
	                break; 
	            } 
	        } 
	  
	        // If no bin could accommodate weight[i] 
	        if (j == res) 
	        { 
	            bin_rem[res] = c - weight[i]; 
	            res++; 
	        } 
	    } 
	    return res; 
	} 
  

	public int RodCutting(int[] lengths, int[] values, int rodLength, int numOfLengths) {
		int dp[][] = new int[lengths.length+1][rodLength+1];
		
		for(int i=1; i<=numOfLengths; i++) {
			for(int j=1; j<=rodLength; j++) {
				int dontChoose = dp[i-1][j];
				int choose = 0;
			//System.out.println(i);
				if(lengths[i] <= j) {
					//dp[i]  lets you choose this element multiple times
					choose = values[i] + dp[i][j-lengths[i]];
				}
				dp[i][j] = Math.max(choose, dontChoose);
			}
		}
		showResult(numOfLengths, rodLength, lengths, dp);
		return dp[numOfLengths][rodLength];
	}

	
	public int CoinChange(int money, int[] coins) {
		int[][] dpTable = new int[coins.length+1][money+1];
		
		for(int i=0; i<=money; i++) {
			dpTable[0][i] = 0;
		}
		
		for(int i=0; i<=coins.length; i++) {
			dpTable[i][0] = 1;
		}
		
		for(int i=1; i<=coins.length; i++) {
			for(int j=1; j<=money; j++) {
				if(coins[i-1] <= j) {
					dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j - coins[i-1]];
				}else {
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
		
		return dpTable[coins.length][money];
	}
	
	
	public int Knapsnack(int numOfItems, int capacity, int[] weights, int[] values) {
		   int knap[][] = new int[numOfItems+1][capacity+1];
		   
		   for(int i=1; i<=numOfItems; i++) {
			   for(int w=1; w<=capacity; w++) {
				   int  notSelectItem = knap[i-1][w];
				   int selectItem = 0;
				   if(weights[i]<=w) {
					   selectItem = values[i] +  knap[i-1][w-i];
				   }
				   
				   knap[i][w] = Math.max(notSelectItem, selectItem);
			   }
		   }
		   showResult(numOfItems, capacity, weights, knap);
		   return knap[numOfItems][capacity];
	}
	
	public void showResult(int numOfItems, int capacity,int[] weights,int knap[][]) {
		for(int n=numOfItems, w=capacity; n>0; n--) {
			if(knap[n][w] !=0 && knap[n][w] != knap[n-1][w]) {
				System.out.println("We take item #"+ n);
				System.out.println(weights[n]);
				w = w-weights[n];
			}
		}
	}
	
	public int memoFib(int n) {
		Map<Integer, Integer> memoTable = new HashMap<Integer, Integer>();
		memoTable.put(0,0);
		memoTable.put(1,1);
		return memoFibDP(n, memoTable);
	}
	
   public int memoFibDP(int n, Map<Integer, Integer> memoTable) {
		if(memoTable.containsKey(n)) {
			return memoTable.get(n);
		}
		memoTable.put(n-1, memoFibDP(n-1, memoTable));
		memoTable.put(n-2, memoFibDP(n-2, memoTable));
		
		int calcNumber = memoTable.get(n-1) + memoTable.get(n-2);
		memoTable.put(n, calcNumber);
		return calcNumber;
	}
	
	
	 public int naiveFib(int n) {
		 if(n ==0 || n==1) {
			 return n;
		 }
		 return naiveFib(n-1) + naiveFib(n-2);
	 }
	
	//Given an array, write a function to output the ranking of each value in the array. 
	//Equal values should have the same ranking. 
	//For example: input of [25, 7, 54, 90, 7] should result in [2, 1, 3, 4, 1]
	
	public int[] rankItems(int[] nums) {
		int[] sortedArr = nums.clone(); 
		Arrays.sort(sortedArr);
		Map<Integer, Integer> map = new HashMap<>();
		int count = 1;
		for(int i=0; i<sortedArr.length; i++) {
			if(!map.containsKey(sortedArr[i])) {
				map.put(sortedArr[i], count);
				count++;
			}
		}
		
		for(int i=0; i<nums.length;i++) {
			nums[i] = map.get(nums[i]);
		}
		
		return nums;
		
	}
	
	public double percentageOfStrings(String[] s1, String[] s2) {
		Set<String> set = new HashSet<>();
		for(String s: s1) {
			set.add(s);
		}
		
	    double count=0.0;
		for(String s: s2) {
			if(set.contains(s)) {
				count++;
			}
		}
		
		System.out.println(count);
		System.out.println(s2.length);
		System.out.println(count/s2.length);
		
		
		return count == 0?0.0:count/s2.length*100;
	}
	
	public void integerReversion(int n) {
		int solution = 0;
		
		while(n>0) {
			int rem = n%10;
			n = n/10;
			solution = solution * 10 + rem;
		}
		System.out.println(solution);
	}
	
	public void convertNum(String text) {
		
		
		for(int i=0; i<text.length(); i++) {
			
			System.out.println(Character.getNumericValue(text.charAt(i)));
		}
	
		
	}
	
   public void convertText(String text) {
		
	   int[] arr = new int[text.length()];
		
		for(int i=0; i<text.length(); i++) {
			arr[text.charAt(i)-'a']++; 
		}
	
		System.out.println(Arrays.toString(arr));
		
	}
   
   public int countNumberOfNumbers(int num) {
	   String numStr = Integer.toString(num);
	   int[] count = new int[10]; 
	   for(int i=0; i<numStr.length(); i++) {
		   count[numStr.charAt(i)-'0']++;
	   }
	   
	   StringBuilder sb = new StringBuilder();
	   for(int i=count.length-1; i>=0; i-- ) {
		   int countVar = count[i];
		   while(countVar>0) {
			   sb.append(i);
			   countVar--;
		   }
	   }
	   
	   return Integer.parseInt(sb.toString());
   }
	
	public void reverseArray(int[] arr, int k) {
		int[] temp = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			temp[(i+k)%arr.length] = arr[i]; 
		}
		
		System.out.println(Arrays.toString(temp));
	}
	
	public void reverseArraySorting(int[] arr, int k) {
		if(arr.length == 0) return;
		if(k<0)return;
		k = k%arr.length;
		
		reverse(arr, 0, arr.length-1);
		reverse(arr,0,k-1);
		reverse(arr,k,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void reverse(int[] arr, int left, int right) {
		while(left<right) {
			int temp = arr[left];
			arr[left]=arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
	public boolean pathExists(int[][] maze, int goalX, int goalY) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		visited[0][0]=true;
		if(solveMaze(maze,0,0,goalX,goalY, visited)) {
			showResultsMaze(visited);
			return true;
		}else {
			System.out.println("No solution found");
		}
		return false;
		
	}
	
	private boolean solveMaze(int[][] maze, int x, int y , int goalX, int goalY, boolean[][] visited) {
		if(x == goalX && y==goalY)return true;
		
		int[][] dirs = {
				{0,1},
				{1,0},
				{-1,0},
				{0,-1}
		};
		
		for(int[] dir: dirs) {
			int newX = x+dir[0];
			int newY = y+dir[1];
			if(isValidMove(maze,newX,newY,visited)) {
				visited[newX][newY] = true;
				if(solveMaze(maze, newX, newY, goalX, goalY, visited)) {
					return true;
				}
				visited[newX][newY] = false;
			}
		}
		
		return false;
		
	}

	private boolean isValidMove(int[][] maze, int x, int y, boolean[][] visited) {
		if(x<0 || x>= maze.length)return false;
		if(y<0 || y>=maze[0].length)return false;
		if(maze[x][y] == 0)return false;
		if(visited[x][y] == true)return false;
		return true;
	}

	private void showResultsMaze(boolean[][] maze) {
		for(int i=0;i<maze.length; i++) {
			for(int j=0; j<maze[0].length; j++) {
				if(maze[i][j] == true) {
					System.out.print(" S ");
				}else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
	
	public int searchRotatedArray(int[] nums, int find) {
		int rotIndex = findRotationIndex(nums);
		if(nums[rotIndex] == find) return rotIndex;
		if(nums[rotIndex]<find) return searchRotatedArrayHelper(nums, rotIndex+1, nums.length-1, find);
		if(nums[rotIndex]>=find) return searchRotatedArrayHelper(nums, 0, rotIndex-1, find);
	    return -1;
	}
	
	public int searchRotatedArrayHelper(int[] nums, int left, int right, int find) {
		
		if(left>=right)return -1;
		 
		int mid = left+(right-left)/2;
		
		if(nums[mid] == find) {
			return mid;
		}
		
		if(find <nums[mid]) {
			return searchRotatedArrayHelper(nums, left, mid-1, find);
		}else {
			return searchRotatedArrayHelper(nums, mid+1, right, find);
		}
		
		
	}
	
	private int findRotationIndex(int[] nums) {
		int left=0;
		int right=nums.length;
		int mid = left + (right-left)/2;
		
		if(nums[mid-1] > nums[mid] && nums[mid+1]>nums[mid]) {
			return mid;
		}
		
		int tempLeft = mid;
		int tempRight = mid;
		while(tempLeft >=0 && tempRight < nums.length) {
			if(nums[tempLeft-1] > nums[tempLeft] && nums[tempLeft+1]>nums[tempLeft]) {
				return tempLeft;
			}
			
			if(nums[tempRight-1] > nums[tempRight] && nums[tempRight+1]>nums[tempRight]) {
				return tempRight;
			}
			
			tempLeft--;
			tempRight++;
		}
		
		return -1;
	}
	
	
	public void sortStringsAnagram(List<String> stringsList) {
		
		List<StringCustomSort> ar = new ArrayList<StringCustomSort>(); 
        for(String s: stringsList) {
        	ar.add(new StringCustomSort(s));
        }
		
		Collections.sort(ar);
		
		for (int i=0; i<ar.size(); i++) 
            System.out.println(ar.get(i).text + " " +ar.get(i).textVal); 
  
	}
	
	public int magicIndex(int[] magicArr, int left, int right) {
		if(left>right)return -1;
		
		int midIndex = left + (right-left)/2;
		
		if(midIndex == magicArr[midIndex]) return midIndex;
			
		
		if(midIndex > magicArr[midIndex]) {
			return magicIndex(magicArr, midIndex+1, right);
		}else {
			return magicIndex(magicArr, left, midIndex-1);
		}
	}
	
	public void pathSum1D(int[] path) {
		System.out.println(pathSum1DHelper(path, 0));
	}
	
	private int pathSum1DHelper(int[] path, int index) {
		if(index>=path.length) return 0;
		
		int sum=0;
		
		
		int[] dirs = {2,3}; 
		
		for(int dir: dirs) {
			int tempSum = pathSum1DHelper(path, index+dir);
			sum = Math.max(sum, tempSum);
		}
		
		return sum+path[index];
	}
	
	
	
	public void NQueens(int[][] matrix) {
		if(path(matrix,0)) {
			printQueens(matrix);
		}else {
			System.out.println("A board does not exist");
		}
	}
	
	public boolean path(int[][] matrix,int col) {
		
		if(col==matrix.length)return true;
		
		int rowLen = matrix.length;
		
		
		for(int row=0; row<rowLen; row++) {
			if(isValidPlacement(matrix,row,col)) {
				matrix[row][col] = 1;
				if(path(matrix,col+1)) {
					return true;
				}
				matrix[row][col] = 0;
			}
		}
		return false;
	}
	
	private boolean isValidPlacement(int[][] matrix, int row, int col) {
		//check horizontal
		  for(int i=0; i<col;i++) {
			  if(matrix[row][i] ==1)
				  return false;
		  }
		  
		  //check left diagonal
		  for(int i=row, j=col; i>=0 && j>=0; i--,j--) {
			  if(matrix[i][j] ==1)
				  return false;
		  }
		  
		  for(int i=row, j=col; i<matrix.length && j>=0; i++,j--) {
			  if(matrix[i][j] ==1)
				  return false;
		  }
		  
		  return true;
		  
	}
	
	private void printQueens(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(matrix[i][j] ==1) {
					System.out.print(" * ");
				}else{
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

	public String reverseString(String text) {
		if(text.isEmpty() || text.equals(""))return null;
		StringBuilder reverseString = new StringBuilder(text.length());
		for(int i=text.length()-1; i>=0; i--) {
			reverseString.append(text.charAt(i));
		}
		
	  /*	int l=0;
		int r=text.length()-1;
		while(l<r) {
			char temp = reverseString.charAt(l);
			reverseString.setCharAt(l, reverseString.charAt(r));
			reverseString.setCharAt(r, temp);
			l++;
			r--;
		}
		*/
		
		return reverseString.toString();
	}
	
	public String longestRepeatedSubstring(String text) {
		
		List<String> suffixes = getSuffixes(text.toLowerCase());
		
		Collections.sort(suffixes);
		
		String longestSubstring = "";
		
		for(int i=0; i<suffixes.size()-1; i++) {
			String temp = longestCommonPrefix(suffixes.get(i), suffixes.get(i+1));
			if(temp.length() >longestSubstring.length()) {
				longestSubstring = temp;
			}
		}
		
		return longestSubstring;
	}
	
	public String longestCommonPrefix(String text1, String text2) {
		int lenOfSmallest = Math.min(text1.length(), text2.length());
		
		for(int i=0; i<lenOfSmallest; i++) {
			if(text1.charAt(i) != text2.charAt(i)) {
				return text1.substring(0,i);
			}
		}
		return text1.substring(0,lenOfSmallest);
	}
	
	
	public List<String> getSuffixes(String text){
		List<String> suffixes = new ArrayList<>();
		for(int i=0; i<text.length(); i++) {
			suffixes.add(text.substring(i,text.length()));
		}
		return suffixes;
	}
	
	public List<String> getPrefixes(String text){
		List<String> prefixes = new ArrayList<>();
		for(int i=1; i<=text.length(); i++) {
			prefixes.add(text.substring(0,i));
		}
		return prefixes;
	}
	
	public Map<Character, Integer> compBadMatchTable(String pattern){
		Map<Character, Integer> badMatch = new HashMap<>();
		 for(int i=0; i<pattern.length(); i++) {
			 int val = Math.max(1, pattern.length()-i-1);
			 badMatch.put(pattern.charAt(i),val);
		 }
		 return badMatch;
	}
	
	public int BoyerMoore(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		Map<Character, Integer> badMatch =  compBadMatchTable(pattern);
		
		int skips=0;
		for(int i=0; i<=textLength-patternLength; i+=skips) {
			skips=0;
			for(int j=pattern.length()-1; j>=0; j--) {
				if(text.charAt(i+j) != pattern.charAt(j)) {
					if(badMatch.containsKey(text.charAt(i+j))) {
						skips = badMatch.get(text.charAt(i+j));
						break;
					}else {
						skips=patternLength;
						break;
					}
				}
			}
			
			if(skips == 0) return i;
		}
		return textLength;
	}
	
	public int bruteForceStringMatch(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		
		
		for(int i=0; i<=textLength-patternLength; i++) {
			int counter=0;
			for(int j=0; j<patternLength; j++) {
				if(text.charAt(i+j) == pattern.charAt(j)) {
					counter++;
				}
				else {
					break;
				}
			}
			if(counter == patternLength) {
				return i;
			}
		}
		return textLength;
	}
	
	public void countingSort(int[] nums, int min, int max) {
		int[] countArr = new int[max-min+1];
		
		for(int i=0; i<nums.length; i++) {
			countArr[nums[i]-min]++;
		}
		
		System.out.println(Arrays.toString(countArr));
		
		//O(k)
		int z=0;
		for(int i=min; i<=max; i++) {
			while(countArr[i-min] >0) {
				nums[z] = i;
				z++;
				countArr[i-min]--;
			}
		}
		
		System.out.println(Arrays.toString(nums));
		
	}
	
	public void mergeSortHelper(int[] nums) {
		mergeSort(nums, new int[nums.length], 0, nums.length-1);
	}
	
	public void mergeSort(int[] nums, int tempArr[], int low, int high ) {
		if(low>=high)return;
		
		int mid = low + (high-low)/2;
		
		mergeSort(nums, tempArr,low, mid);
		mergeSort(nums, tempArr, mid+1,high);
		merge(nums, tempArr, low, mid, high);
		
		System.out.println(Arrays.toString(nums));
	}
	
	public void merge(int[] nums, int tempArr[], int low, int mid, int high) {
		for(int i=low; i<=high; i++) {
			tempArr[i] = nums[i];
		}
		
		int i=low;
		int j = mid+1;
		int k=low;
		
		while(i<=mid && j<=high) {
			if(tempArr[i] <= tempArr[j]) {
				nums[k] = tempArr[i];
				i++;
			}
			else {
				nums[k] = tempArr[j];
				j++;
			}
			k++;
		}
		
		while(i <=mid) {
			nums[k]=tempArr[i];
			i++;
			k++;	
		}
		
		while(j <=high) {
			nums[k]=tempArr[j];
			j++;
			k++;
		}
	}
	
	
	public void quickSort(int[] arr, int low, int high) {
		
		 if(arr.length == 0) return;
		 if(low>=high)return;
		 int partition = partitonIndex(arr, low, high);
		 
		 quickSort(arr,low,partition-1);
		 quickSort(arr,partition+1,high);
		 System.out.println(Arrays.toString(arr));
	}
	
	public int partitonIndex(int[] arr, int low, int high) {
		int mid = low + (high-low)/2;
		swap(arr,mid,high);
		
		int swapIndex = low;
		for(int i=low; i<high; i++) {
			if(arr[i] <= arr[high] ) {
				swap(arr,swapIndex,i);
				swapIndex++;
			}
		}
		
		swap(arr,swapIndex,high);
		return swapIndex;
	}
	
	
	public void sortRedWhiteBlue(int[] arr) {
	
		int blueIndex=arr.length-1;

		int endIndex = sortEndOfArr(arr, 0, blueIndex,2);
		sortEndOfArr(arr, 0, endIndex,1);
		
		 System.out.println(Arrays.toString(arr));
	}
	
	public int sortEndOfArr(int[] arr, int beginIndex, int endIndex, int sortVal) {
		
		for(int i=0; i<endIndex; i++) {
			 if(i>=endIndex) {
				 break;
			  }
					
			if(arr[i] == sortVal) {
			   swap(arr,i,endIndex);
			   endIndex--;
			}
			else
			if(arr[i] == 0) {
			swap(arr,i,beginIndex);
			   beginIndex++;
			}    
		}
		
		return endIndex;
	}
	
	public int findKthLargestItem(int[] arr, int beginIndex, int lastIndex, int k) {
		int partitionIndex = partition(arr, beginIndex, lastIndex);
		
		int k_index=arr.length-k;
		if(k_index > partitionIndex) {
			findKthLargestItem(arr, partitionIndex+1, lastIndex, k);
		}
		else
		if(k_index < partitionIndex) {
			findKthLargestItem(arr, beginIndex, partitionIndex-1, k);
		}
		
		return arr[k_index];
	}
	
	public int partition(int[] arr, int beginIndex, int lastIndex) {
		
		int pivot = beginIndex+(lastIndex-beginIndex)/2;
		swap(arr,pivot,lastIndex);
		int swapIndex=beginIndex;
		
		for(int i=beginIndex; i<lastIndex; i++) {
			if(arr[i] < arr[lastIndex]) {
			    swap(arr,swapIndex,i);
				swapIndex++;
			}
		}
		
		swap(arr, swapIndex, lastIndex);
		return swapIndex;
	}
	
	public void swap(int[] arr,int index1, int index2) {
		int temp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = temp;
	}
	
	public void solveHanoi(int n, char rodFrom, char middleRod, char rodTo) {
		 if(n==1) {
			 System.out.println("BASE-Move disk 1 from "+rodFrom+" to "+rodTo);
			 return;
		 }
		 
		 solveHanoi(n-1,rodFrom,rodTo,middleRod);
		 System.out.println("Move disk "+n+" from "+rodFrom+" to "+rodTo);
		 solveHanoi(n-1,middleRod,rodFrom,rodTo);
		 
		 
	}
	
     public int sumIterative(int n) {
    	 int result = 0;
    	 for(int i=1; i<=n; i++) {
    		 result+=i;
    	 }
    	 
    	 return result;
     }
     
     public int sumRecursive(int n) {

    	 if(n==1)return 1;
    	 
    	 return n + sumRecursive(n-1);
     }
     
     public void headbuildLayer(int height) {
    	 if(height == 0) return;
    	 
    	 headbuildLayer(height-1);
    	 System.out.println(height);
     }
     
     public void tailbuildLayer(int height) {
    	 if(height == 0) return;
   
    	 System.out.println(height);
    	 tailbuildLayer(height-1);
     }
     
     public int factorial(int accumulator, int n) {
    	 //4! = 4*3*2*1
    	 if(n == 1)return accumulator;
    	 
    	 
    	 return n*factorial(accumulator*n,n-1);
     }
     
     public int calculateFactorial(int n) {
    	 return factorial(1,n);
     }
     
     public int gcdIterative(int num1, int num2) {
    	 while(num2 != 0) {
    		 int temp = num2;
    		 num2 = num1 % num2;
    		 num1 = temp;
    	 }
    	 
    	 return num1;
     }
     
     public int gcdRecursive(int num1, int num2) {
    	 if(num2 == 0 ) return num1;
    	 
    	 return gcdRecursive(num2, num1%num2);
     }
     
     private int[] array;
     
     public Algorithm(int[] array) {
    	 this.array = array;
     }
     
     public int linearSearch(int item) {
    	 for(int i=0; i<array.length; i++) {
    		 return i;
    	 }
    	 return -1;
     }
     
     public int binarySearch(int item) {
    	return binarySearch(0,array.length-1, item);
     }
     
     private int binarySearch(int startIndex, int endIndex, int item) {
    	 if(endIndex <startIndex) {
    		 
    	 }
    	 
    	 int middleIndex = startIndex + (endIndex-startIndex)/2;
    	 
    	 if(item == array[middleIndex]) {
    		 return middleIndex;
    	 }else if(item <array[middleIndex]) {
    		 return binarySearch(startIndex, middleIndex-1, item);
    	 }else {
    		 return binarySearch(middleIndex+1, endIndex, item);
    	 }
     }
}



import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class twoSum{
	public static void main(String arg[]) throws java.io.IOException{
		int keyInValue;
		int[] nums = new int[10];
		int[] results = new int[2];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inputs (10):");
		for(int i=0; i < 10; i++){
			try{
			nums[i] = scanner.nextInt();
			System.out.println(nums[i]);
			} catch (java.util.InputMismatchException e){
				scanner.next();
				break;
			}
			/*
			while(true){
				if((keyInValue = System.in.read()) == '\n'){
					// End of the input
					i = 10;
					break;
				}else if(keyInValue != ' '){
					nums[i] = (int)keyInValue;
					System.out.println(keyInValue);
					//System.out.println((char)keyInValue);
					break;
				}

			}
			 */
		}
		
		results = twoSum(nums, 8);
		//results = new int[] {1,2};
		System.out.println("("+ results[0] + ","+ results[1]+")");
		System.out.println("End");
	}
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println("length: " + nums.length);
		for(int i=0; i < nums.length; i++){
			int complement = target - nums[i];
			System.out.println("num: " + nums[i]);
			System.out.println("complement: " + complement);
			if(map.containsKey(complement)){
				return new int[] {map.get(complement), i};
				//return new int[] {i, map.get(complement)};
			}	
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String f = "../datafile";
		File file = new File(f);
		Scanner input = new Scanner(file);
		int numOfItems = -1;
		int i = 0;
		DataItem[] list = null;
		while (input.hasNextLine()) {
			if(numOfItems == -1) {
				numOfItems = Integer.parseInt(input.nextLine());
				list = new DataItem[numOfItems];
			} else {
				list[i] = new DataItem(input.nextLine(),Integer.parseInt(input.nextLine()),Integer.parseInt(input.nextLine()));
				i++;
			}
		}

		printPalindromes(list);

		System.out.println("the max subarray sum of random_int is " + subArrayMaxSum(list));
		System.out.println();
		
		System.out.println("sorting the array by it's score...");
		sortByScores(list);

		System.out.println("printing the data after sorting....");
		for(DataItem d : list) {
			System.out.println("name: " + d.name +" \trandom_int: "+ d.random_int + "\tscore: "+d.score);
		}
		
		System.out.println();
		
		System.out.println("reversing the list");
		reverseList(list);
		System.out.println("printing the data after reversing....");
		
		for(DataItem d : list) {
			System.out.println("name: " + d.name +" \trandom_int: "+ d.random_int + "\tscore: "+d.score);
		}
		

	}
	static void sortByScores(DataItem[] list) {
		Arrays.sort(list, new Com());
	}
	
	static void reverseList(DataItem[] list) {
		
		for(int i = 0, j = list.length-1; i < j; i++,j--) {
			DataItem temp = list[i];
			list[i] = list[j];
			list[j] = temp;
 		}
	}

	static void printPalindromes(DataItem[] list) {
		System.out.println("printing palindromes.....");
		for(DataItem d : list) {
			int i = 0,j = d.name.length()-1;
			while(i < j) {
				if(d.name.charAt(i) != d.name.charAt(j)) {
					break;
				}
				i++;
				j--;
			}
			if(i >= j) {
				System.out.println(d.name);
			}
		}
		System.out.println("printing palindromes is done");
		System.out.println();
	}

	// returns maximum subarray sum in O(n) time
	static int subArrayMaxSum(DataItem[] list) {
		System.out.println("calculating the maximum subarray sum of random_int......");
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < list.length; i++) {
			sum += list[i].random_int;
			if(max < sum) max = sum;
			if(sum < 0) sum = 0;
		}
		return max;
	}

	static class Com implements Comparator<DataItem> {
		public int compare(DataItem a, DataItem b) {
			return a.score-b.score;
		}
	}

}

import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		
		int [] array = {1, 2, 6, 9, 10, 100, 525, 735};
		int low = 0; 
		int high = array.length-1;
		int midpoint = (low + high)/2;
		int searchFor; 
		int num; 
		int foundAt =-1; 

		System.out.println("Enter the number you want to find in");
		Scanner input = new Scanner (System.in);
		searchFor = input.nextInt(); 
		
		while (foundAt == -1 && low<=high) {
			midpoint = (low + high)/2;
			num = array [midpoint];
			if (num < searchFor) {
				low = midpoint;
			}
			else if (num > searchFor) {
				high = midpoint;
			}
			else if (num == searchFor) {
				foundAt = midpoint;
			}
		}
		
		if (foundAt >= 0) {
			System.out.println("Number found at: "+foundAt);
		} else {
			System.out.println("Number not found");
		}
		
	}
	

}

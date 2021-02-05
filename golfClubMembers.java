import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class golfClubMembers {

	public static void main(String[] args) {
		ArrayList <String> members = new ArrayList <String>(); 
		
		try {
		      File myObj = new File("/Users/huongnguyenthimai/Desktop/school stuff/IBy12/src/golfMembers.txt"); //locate file 
		      Scanner myReader = new Scanner(myObj); //read file
		      while (myReader.hasNextLine()) { //read line to line
		        String data = myReader.nextLine();
		        members.add(data); //add the information of each member into the array 
		        System.out.println(data);		        
		      } 
		      myReader.close();
		    } catch (FileNotFoundException e) { //try catch error if there's no file
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		String [] names = new String [members.size()]; //arrays created for each type of information needed
		String [] ages = new String [members.size()];
		String [] passwords = new String [members.size()];
		
		
		for (int i=0;i<members.size();i++) {
			String person = members.get(i); //get each string of student
			int firstComma = person.indexOf(",", person.indexOf(",") + 1); //get the comma between name & junior/adult
			int secondComma = person.indexOf(",", firstComma + 1); //get the comma between junior/adult & password 
			//(second part of index of is where the algorithm start searching)

			
			String name = person.substring(0,firstComma-1);
			names[i] = name; //get substring of name, junior/adult and password to store
			String age = person.substring(firstComma+1,secondComma-1); 
			ages[i] = age; 
			String password = person.substring(secondComma+1,person.length());
			passwords[i] = password; 
		}
		
		for (int i=0;i<members.size();i++) {
			String password = passwords[i];
			String person = names[i];
			int length = password.length(); //get the length of the password
			boolean upperCase = Character.isUpperCase(password.charAt(0)); //check if the first letter is uppercase
			boolean isNumber = Character.isDigit(password.charAt(length-1)); //check if the last character is number of letter, if not then it's symbol
			boolean isLetter = Character.isLetter(password.charAt(length-1));
			
			while (length<8 || !upperCase || isNumber || isLetter ) { //if it's too short, first letter is uppercase and last char is anything else then re-enter
				System.out.println(person); //call name to re-enter
				System.out.println("Please re-enter the password"); 
				Scanner input = new Scanner (System.in);
				password = input.nextLine(); 
				length = password.length();
				upperCase = Character.isUpperCase(password.charAt(0)); //update variables for error checking
				isNumber = Character.isDigit(password.charAt(length-1));
				isLetter = Character.isLetter(password.charAt(length-1));
			}
			
			passwords[i] = password;  //update password
		}
		
		int adults = 0;
		int juniors = 0;
		
		for (int i=0;i<members.size();i++) {
			String age = ages[i];
			if (age.charAt(0) == 'A') { //check if junior or adult to add to int for total 
				adults++;
			} 
			else if (age.charAt(0) == 'J') {
				juniors ++;
			}
		}
		
		//printing out names, total adult/junior/member
		System.out.println("Members: ");
		for (int i=0;i<members.size();i++) {
			System.out.println(names[i]);
		}
		System.out.println("There are "+adults+" adults");
		System.out.println("There are "+juniors+" juniors");
		int total = juniors + adults; 
		System.out.println("There's a total of "+total+" members");
		
		
		try {
			   File file = new File("/Users/huongnguyenthimai/Desktop/school stuff/IBy12/src/membersRecap.txt");
			   file.createNewFile(); //create new file in the same folder 
			} catch(Exception e) {
			   e.printStackTrace(); //catch error
			}
		
		try {
		      FileWriter myWriter = new FileWriter("/Users/huongnguyenthimai/Desktop/school stuff/IBy12/src/golfMemberUpdate.txt");
		      for (int i=0;i<members.size();i++) {
		    	  myWriter.write(names[i]+"\n"); //write in the data from the code into file
		      }
		      myWriter.write("There are "+adults+" adults"+"\n");
		      myWriter.write("There are "+juniors+" juniors"+"\n");
		      myWriter.write("There's a total of "+total+" members");
		      myWriter.close(); //close writer 
		      System.out.println("Successfully wrote to the file."); //check if the process is finished 
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace(); //error check
		    }
	}

}

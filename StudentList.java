//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
public static void main(String[] args) {
        if(args==null || args.length!=1){
            System.err.println(Constants.UNVALID);
            return;
        }
        String readLine = fileReader(Constants.STUDENTLIST);
//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");		
			try {
			String students[] = readLine.split(Constants.STUDENTLIST);			
			    for(String student : students) { 
                    System.out.println(student);
                }
			}catch (Exception e){
            } 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			String students[] = readLine.split(Constants.STUDENTLIST);	
			Random random = new Random();
				int randomInt = random.nextInt(students.length);
					System.out.println(students[randomInt].trim());
			}catch (Exception e){
            }
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
        {
			System.out.println("Loading data ...");			
			try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					                        new FileWriter(Constants.STUDENTLIST, true));
			String substring = args[0].substring(1);
	        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE);
	        String formated= dateFormat.format(new Date());
			    bufferedWriter.write(", " + substring + "\nList last updated on " + formated);
			bufferedWriter.close();
			}catch (Exception e){
            }							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
                String students[] = readLine.split(Constants.STUDENTLIST);	

			String substring = args[0].substring(1);
			for(int idx = 0; idx<students.length; idx++) {
				if(students[idx].equals(substring)) {
					System.out.println("We found it!");
				}
			}
			}catch (Exception e){
            } 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
                String students[] = readLine.split(Constants.STUDENTLIST);
			    System.out.println(students.length +" word(s) found .");
			}catch (Exception e){
            } 
			System.out.println("Data Loaded.");				
		}
	}
    public static String fileReader(String fileName){
        try{
        BufferedReader bufferedReader = new BufferedReader(
                                        new InputStreamReader(
                                        new FileInputStream(fileName)));
            return bufferedReader.readLine();
        }
        catch(Exception e){
            return null;
        }
    }
}
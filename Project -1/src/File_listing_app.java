import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Scanner;

public class File_listing_app {
	public static void expand(String directory_to_serach,PrintStream writer) {
		File directory =new File(directory_to_serach);
		File files[]=directory.listFiles();
		for(int a=0;a<files.length;a++) {
			if(files[a].isFile()) {
				writer.println("Name :"+files[a].getName()+"-------------------------- Location:"+files[a].getAbsolutePath());
			}
			if(files[a].isDirectory()) {
				writer.println("Name :"+files[a].getName()+"-------------------------- Location:"+files[a].getAbsolutePath());
				expand(files[a].getName(),writer);
			}
		}	 
	}
	
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in); 
		System.out.println("Enter the Location of the file :");
		String location=scan.nextLine();
		File file=new File(location);
		String directory_to_serach="";
		String csv_file="";

		try { 
			FileReader in = new FileReader(file);
			int current_char ;
				  while((current_char =  in.read())!=10) {
					   char ch = (char)current_char;
					   directory_to_serach = directory_to_serach + ch; 
				  }
				  File dir =new File(directory_to_serach);
				  while((current_char =  in.read())!=-1) {
					   char ch = (char)current_char;
					   csv_file = csv_file + ch;   
				  }
				  
				  System.out.println("csv file :"+csv_file);
				  System.out.println("directory file :"+directory_to_serach);
				  File out =new File(csv_file);
				  PrintStream writer =new PrintStream(out);
				  expand(directory_to_serach.substring(0, directory_to_serach.length()-1),writer);
				  
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

}

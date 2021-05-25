import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;



public class Huffman {
	private static String text;
	private static String caractere;
	private static int freq;
	
	

	public Huffman() {
		
		super();
	}

	public static String FileReader(String file) {
		
		try {
			  
			File fis = new File(file);     //opens a connection to an actual file
			Scanner myReader = new Scanner(fis);
			System.out.println("file content: ");  
			  
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				
				text += data;	
			}
			myReader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		return text;
	}
	
	public static int count_char(String file) {
		int nbr_char = 0;
		try {  
			 FileReader fil = new FileReader(file);
		     BufferedReader buffer = new BufferedReader(fil);
		     String line = buffer.readLine();
		     nbr_char = Integer.parseInt(line);
		     System.out.println(nbr_char);	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return nbr_char;	
	}
	public static void get_content(String file) {
		
		ArrayList<Pair> array_line = new ArrayList<Pair>();
		try {
			final String SEPARATEUR = " ";
			FileReader fil = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fil);
			
			String line = buffer.readLine();
			StringBuffer sb = new StringBuffer();
			
			
			while((line = buffer.readLine()) != null){
				// ajoute la ligne au buffer
				Pair pair = new Pair(caractere, freq);
				String content[] = line.split(SEPARATEUR);
				caractere = content[0];
				freq = Integer.parseInt(content[1]);
				pair.caractere = caractere;
				pair.freq = freq;
				array_line.add(pair);
				
				
			}
			//System.out.println(array_line);
			System.out.println(array_line);
		    fil.close();    
			 
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*public int get_frequency(String file, int symbol) {
		try {  
			 FileReader fil = new FileReader(file);
		     BufferedReader buffer = new BufferedReader(fil);
		     String line = buffer.readLine();
		     for 
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return symbol;
		
	}*/
	
	

}




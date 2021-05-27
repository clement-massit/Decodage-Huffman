import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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



public class HuffmanFile {
	private static String text;
	private static String caractere;
	private static int freq;
	
	

	public HuffmanFile() {
	
	}

	public static String FileReader(String file) {
		
		try {
			  
			File fis = new File(file);    
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
		     buffer.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		return nbr_char;	
	}
	
	/*
	 * get the content from a txt file
	 */
	public static ArrayList get_content(String file) {
		
		ArrayList<Node> array_line = new ArrayList<Node>();
		try {
			final String SEPARATEUR = " ";
			FileReader fil = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fil);
			
			String line = buffer.readLine();
			StringBuffer sb = new StringBuffer();
			
			
			while((line = buffer.readLine()) != null){
				// ajoute la ligne au buffer
				Node node = new Node(caractere, freq);
				String content[] = line.split(SEPARATEUR);
				caractere = content[0];
				freq = Integer.parseInt(content[1]);
				node.setCharacter(caractere);
				node.setFreq(freq);
				array_line.add(node);
			}
			
			
			//System.out.println(array_line);
		    fil.close();    
			 
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return array_line;
	}
	
	/*
	 * get the content of a bin file
	 */
	public static String get_bin_content(String f) {
        FileInputStream fis = null;
        String bin = "";
        try {
            fis = new FileInputStream(f);
            int i = 0;
            while ((i = fis.read()) != -1) {
            	bin += Integer.toBinaryString(i);
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
		return bin;
    }
	
	/**
	* renvoie la valeur d un string contenant une suite de 0 et de 1 en entier
	* @param  converti String a convertir
	* @return renvoie la representation du string en entier
	*/
	        
    public static int StringToInt(String Converti){
    	int convertiseur=0;
    	for(int i=0;i<Converti.length();i++){
    		if(Converti.charAt(i)=='0'){
    			convertiseur=convertiseur*2;
    		} 
    		else{
    			convertiseur=convertiseur*2+1;
    		}
    	}return convertiseur;
    }
    
    
    /**
    * renvoie la valeur d un string contenant une suite de 0 et de 1 en entier
    * @param  bit Bit a convertir
    * @return renvoie la representation du l en entier en string
    */

    public static String BitToString(int bit){
    	if(bit==0){
    		return "0";
    	} 
    	else {
    		return "1";
    	}
    }
	
	

}




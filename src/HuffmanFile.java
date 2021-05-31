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
	private File file;
	private static String text;
	private static String caractere;
	private static int freq;
	
	

	public HuffmanFile(File file) {
		this.file = file;
	}

	public List<String> FileReader() throws FileNotFoundException {		
		String result = "";
		ArrayList<String> list_alphabet = new ArrayList<String>();
		    
		Scanner myReader = new Scanner(this.file);
	 
		while (myReader.hasNextLine()) {
			result = myReader.nextLine();	
			list_alphabet.add(result);
		}
		
		myReader.close();
		list_alphabet.remove(0);
		
		
		return list_alphabet;
	}
	
	public List<Node> transform_to_list_node(List<String> list_alphabet){
		List<Node> list_nodes = new ArrayList<Node>();
		String SEPARATEUR = " ";
		for (String car : list_alphabet) {
			Node node = new Node(caractere, freq);
			String content[] = car.split(SEPARATEUR);
			caractere = content[0];
			freq = Integer.parseInt(content[1]);
			node.setCharacter(caractere);
			node.setFreq(freq);
			list_nodes.add(node);			
		}
		return list_nodes;
		
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
	
	
	
	
	public char[] getBinaryChain(){
        try {
            String result = "";
            Scanner myReader = new Scanner(this.file);
            while(myReader.hasNextLine()) {
                result += myReader.nextLine();
            }
            myReader.close();
            return result.toCharArray();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	 
	/*
	 * get the content of a bin file
	 */
	public char[] get_bin_content() {
        FileInputStream fis = null;
        String bin = "";
        try {
            fis = new FileInputStream(this.file);
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
		return bin.toCharArray();
    }
		        

	
	

}




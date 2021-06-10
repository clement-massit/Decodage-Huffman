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
	/*
	 * This class allows the opening of files and getting their content
	 */
	private File file;
	private static String text;
	private static String caractere;
	private static int freq;
	
	

	public HuffmanFile(File file) {
		this.file = file;
	}

	public List<String> Freq_File_Reader() throws FileNotFoundException {	
		/*
		 * this function is used in order to read a file composed of alphabet and freqences 
		 * that the text compressed uses.
		 * 
		 * It returns a list of String like '[a 2, e 5, t 3,...]'
		 */
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
		/*
		 * this is function transforms a list of String into a list of Nodes object.
		 * It appears like the list of String : '[a 2, e 5, t 3,...]', but each values is a Nodes object.
		 * 
		 * @param list_alphabet : a list of String
		 * 
		 * set the freq & character of each node by each elements in the list
		 */
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
		return list_nodes; // the return is composed of a nodes list 
		
	}
		
	public char[] getBinaryChain(){
		/*
		 * this function gets the content of a file and especially txt files.
		 * 
		 */
        try {
            String result = "";
            Scanner myReader = new Scanner(this.file);
            while(myReader.hasNextLine()) {
                result += myReader.nextLine();
            }
            myReader.close();
            // the return is a char[] composed of 0 and 1
            return result.toCharArray(); 
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	 
	public char[] get_bin_content() {
		/*
		 * this function gets the content of a BIN file.
		 * needs to be improved
		 */
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




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanDecompress {	
	private static int i = 0;
	/*
	 * this class will decompress the binary code 'chain_bin' to a String travelling the 
	 * tree created in HuffmanTree.
	 */

	public HuffmanDecompress() {	
	}
		
	public static String decompress(char[] chain_bin, HuffmanTree tree) {
		/*
		 * @param chain_bin is the binary code found when a file is opened, like '011001010000111';
		 * tree is the tree created in HuffmanTree in order to be traveled to find the corresponding message
		 */
		
		String result = "";
		
		for(char binary: chain_bin) {	
			
			Node current = tree.getCurrent();

			if (current.is_leaf()) {
				result += current.getCharacter();
				tree.setCurrent(tree.getRoot());
			}
			
			if (binary == "0".charAt(0)){
				tree.setCurrent(tree.getCurrent().getLeft());
			} else {
				tree.setCurrent(tree.getCurrent().getRight());	
			}			
		}
		
		if (tree.getCurrent().is_leaf()) {
			result += tree.getCurrent().getCharacter();
			tree.setCurrent(tree.getRoot());
		}
		System.out.println(result);
		return result;

	}
	
	public static void write_text_decompressed(String text_decompressed) {
		/*
		 * @param String text_decompress is a string, it will be written 
		 * in a txt file named : text_decompressed
		 */
		try {
			i++;
			File file = new File("test/Results/" + "text_decompressed_" + String.valueOf(i) + ".txt");
			System.out.println(file.getName());
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter buffer_writer = new BufferedWriter(fw);
			buffer_writer.write(text_decompressed);
			buffer_writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}

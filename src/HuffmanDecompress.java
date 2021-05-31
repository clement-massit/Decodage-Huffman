import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanDecompress {	

	public HuffmanDecompress() {	
	}
		
	public static String decompress(char[] chain_bin, HuffmanTree arbre) {
		
		
		System.out.println(chain_bin);
		String result = "";
		
		for(char binary: chain_bin) {	
			
			Node current = arbre.getCurrent();

			if (current.is_leaf()) {
				result += current.getCharacter();
				arbre.setCurrent(arbre.getRoot());
			}
			
			if (binary == "0".charAt(0)){
				arbre.setCurrent(arbre.getCurrent().getLeft());
			} else {
				arbre.setCurrent(arbre.getCurrent().getRight());	
			}			
		}
		
		if (arbre.getCurrent().is_leaf()) {
			result += arbre.getCurrent().getCharacter();
			arbre.setCurrent(arbre.getRoot());
		}
		return result;

	}
	
	public static void write_text_decompressed(String text_decompressed) {
		try {
			File file = new File("text_decompressed.txt");
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

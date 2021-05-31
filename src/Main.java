import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) throws IOException {
		

		HuffmanTree arbre = new HuffmanTree();

		File file = new File("test/exemple_freq.txt");
		HuffmanFile freq_file = new HuffmanFile(file);

		arbre.create_tree(freq_file.transform_to_list_node(freq_file.FileReader()));
		

		File file_to_decompress = new File("test/exemple_comp.txt");
		HuffmanFile file_decompress = new HuffmanFile(file_to_decompress);
		
		String text_decompressed = HuffmanDecompress.decompress(file_decompress.getBinaryChain(), arbre);
		HuffmanDecompress.write_text_decompressed(text_decompressed);
		
	}

}

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		String path_txt = "C:\\Users\\cleme\\eclipse-workspace\\Decodage-Huffman\\test\\exemple_freq.txt";
		String path_bin = "C:\\Users\\cleme\\eclipse-workspace\\Decodage-Huffman\\test\\exemple_comp.bin";
		System.out.println(HuffmanFile.get_content(path_txt));
		System.out.println(HuffmanFile.get_bin_content(path_bin));
		
		String chaine = HuffmanFile.get_bin_content(path_bin);
		System.out.println(chaine.length());
		for (int c = 0; c < chaine.length(); c++) {
			System.out.println(chaine.charAt(c));
		}
		/*HuffmanTree arbre = new HuffmanTree();
		System.out.println(arbre.create_tree());*/
	}
	
}

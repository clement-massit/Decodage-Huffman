import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
	private static final int ALPHABET_SIZE = 256;
	
	
	
	
	private static Map<Character, String> buildLookupTable(final Node root){
		final Map<Character, String> lookupTable = new HashMap<>();
		buildLookupTableImpl(root, "", lookupTable);
		return null;
	}
	
	private static void buildLookupTableImpl(final Node node, final String s, final Map<Character, String> lookupTable) {
		
		if (!node.is_leaf()) {
			buildLookupTableImpl(node.getLeft(), s + "0", lookupTable);
			buildLookupTableImpl(node.getRight(), s + "1", lookupTable);
		} else {
			lookupTable.put(node.getCharacter(), s);
		}
	}
	
	private static Node buidlHuffmanTree(int[] freq) {
		final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		
		for (char i = 0; i < ALPHABET_SIZE; i++) {
			if (freq[i] > 0) {
				priorityQueue.add(new Node(i, freq[i], null, null));
			}
		}
		
		if (priorityQueue.size() == 1) {
			priorityQueue.add(new Node('\0',1, null, null));
		}
		
		while(priorityQueue.size() > 1) {
			final Node left = priorityQueue.poll();
			final Node right = priorityQueue.poll();
			final Node parent = new Node('\0', left.getFreq() + right.getFreq(), left, right);
			
			priorityQueue.add(parent);
		}
		return priorityQueue.poll();
	}
	
	public String decompress( ) {
		
		
		return null;
		
	}
	
	
	
	
	
	
	
}

import java.util.ArrayList;

public class Node implements Comparable<Node>{
	private int value;
	private String character;
    private int freq;
    private final Node left;
    private final Node right;
    private ArrayList<Node> liste_node = new ArrayList<Node>();
    
    
    public Node(String character, int freq) {
    	this.freq = freq;
    	this.character = character;
    	left = null;
    	right = null;
    }


	public Node(Node right, Node left) {
		this.right = right;
		this.left = left;
	}
	
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}


	boolean is_leaf() {
		return this.left == null && this.right == null;
	}

	
	@Override
	public String toString() {
		return character + " " + freq;
	}


	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

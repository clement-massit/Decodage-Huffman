import java.util.ArrayList;

public class Node implements Comparable<Node>{
	private String value;
	private String character;
    private Integer freq;
    private Node left;
    private Node right;
    
    
    public Node(String character, Integer freq) {
    	this.freq = freq;
    	this.character = character;
    	left = null;
    	right = null;
    }


	public Node(Node left, Node right) {
		this.right = right;
		this.left = left;
		this.freq = left.freq + right.freq;
	}
	
	public Node(Node left, Node right, Integer freq) {
    	this.freq = freq;
    	this.right = right;
		this.left = left;
    }
	
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String string) {
		this.value = string;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public Integer getFreq() {
		return freq;
	}
	public void setFreq(Integer freq) {
		this.freq = freq;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}


	boolean is_leaf() {
		return (this.left == null && this.right == null);
	}

	
	@Override
	public String toString() {
		return character + " " + freq;
	}


	@Override
	public int compareTo(Node o) {
		return this.getFreq().compareTo(o.getFreq());
	}
	
}

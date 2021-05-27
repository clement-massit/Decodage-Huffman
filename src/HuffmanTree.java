
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class HuffmanTree {
	private char valeur;                   
    private Node filsGauche, filsDroit;       
    private int hauteur;                 
    private int nbfeuille;  
    
    public HuffmanTree() {
    	filsGauche = filsDroit = null;
    	this.hauteur = 0;
    	this.nbfeuille = 0;
    }
    
    public HuffmanTree(char valeur) {
        this.valeur = valeur;        
        filsGauche = filsDroit = null;    
        this.hauteur=0;             
        this.nbfeuille=1;            
    }
    
    public Node create_tree() {
    	String path = "C:\\Users\\cleme\\eclipse-workspace\\Decodage-Huffman\\test\\exemple_freq.txt";
		ArrayList liste_pair = HuffmanFile.get_content(path);
		ArrayList<Node> liste_node = new ArrayList<Node>();
		
		for (Object tupple : liste_pair) {
			liste_node.add((Node) tupple);
		}

		while (liste_node.size() > 1) {
			Node n1 = liste_node.get(0);
			Node n2 = liste_node.get(1);
			
			liste_node.remove(n1);
			liste_node.remove(n2);
			
			
			Node parent = new Node("parent", n1.getFreq() + n2.getFreq());
			liste_node.add(parent);
			
			
			this.add_node_value(liste_node.get(0));
			System.out.println(liste_node);
			
		}
		return liste_node.get(0);
		
		
    }
    
    public void add_node_value(Node node) {
		Node left_child = node.getLeft();
		Node right_child = node.getRight();
		if (left_child != null) {
			left_child.setValue(1);
			this.add_node_value(left_child);
		}else if (right_child != null) {
			right_child.setValue(0);
			this.add_node_value(right_child);
		}
		
	}
	
	
	
	

}


import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HuffmanTree {
	private char valeur;
	private Node root, current;

	public HuffmanTree() {
	}

	public HuffmanTree(char valeur) {
		this.valeur = valeur;
	}

	public Node getRoot() {
		return root;
	}

	public Node getCurrent() {
		return current;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void setCurrent(Node current) {
		this.current = current;
	}

	public void create_tree(List<Node> list_nodes) {
		System.out.println(list_nodes);
		while (list_nodes.size() > 1) {
			Collections.sort(list_nodes);
			list_nodes.add(new Node(list_nodes.remove(0), list_nodes.remove(0)));
			
			System.out.println(list_nodes);
		}
		this.current = list_nodes.get(0);
		this.root = list_nodes.get(0);

	}

}

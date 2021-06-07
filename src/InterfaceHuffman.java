import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;




public class InterfaceHuffman {

	private JFrame frame;
	private final JMenuBar menuBar = new JMenuBar();
	private final JButton btnOpenFile = new JButton("Ouvrir");
	private final JFileChooser fc = new JFileChooser("C:\\Users\\cleme\\git\\Decodage-Huffman\\test");
	private final JLabel selected_file = new JLabel();
	private final JLabel Label_files_content = new JLabel();
	private final JLabel text_decompressed = new JLabel();
	private final JButton btnNewButton = new JButton("Fermer");
	private final JLabel lblNewLabel = new JLabel("Veuillez s\u00E9lectionner d'abord le fichier compress\u00E9 puis le fichier fr\u00E9quences");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceHuffman window = new InterfaceHuffman();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceHuffman() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(51, 153, 204));
		frame.setBackground(new Color(102, 102, 153));
		frame.setBounds(100, 100, 615, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar.setForeground(new Color(51, 153, 204));
		frame.setJMenuBar(menuBar);
		selected_file.setForeground(Color.WHITE);
		
		selected_file.setFont(new Font("Verdana Pro", Font.PLAIN, 16));
		selected_file.setBackground(Color.WHITE);
		selected_file.setBounds(35, 42, 545, 80);
		selected_file.setVisible(false);
		
		btnOpenFile.setFont(new Font("Verdana Pro", Font.PLAIN, 10));
		Label_files_content.setForeground(Color.WHITE);
	
		Label_files_content.setHorizontalAlignment(SwingConstants.CENTER);
		Label_files_content.setBackground(new Color(102, 102, 153));
		Label_files_content.setBounds(0, 145, 591, 52);
		Label_files_content.setFont(new Font("Verdana Pro", Font.PLAIN, 16));
		text_decompressed.setForeground(Color.WHITE);
		
		
		text_decompressed.setBackground(new Color(102, 102, 153));
		text_decompressed.setFont(new Font("Verdana Pro", Font.PLAIN, 16));
		text_decompressed.setHorizontalAlignment(SwingConstants.CENTER);
		text_decompressed.setBounds(0, 207, 591, 45);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(selected_file);
		frame.getContentPane().add(selected_file);
		frame.getContentPane().add(text_decompressed);
		frame.getContentPane().add(Label_files_content);
		frame.getContentPane().add(btnNewButton);

		menuBar.add(btnOpenFile);
		
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int retVal = fc.showOpenDialog(frame);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    File selectedfile = fc.getSelectedFile();
                    selected_file.setText(selectedfile.getName() + " successfully opened");
                    selected_file.setVisible(true);
                    try {
                    	JFileChooser freq_choose = new JFileChooser("C:\\Users\\cleme\\git\\Decodage-Huffman\\test");
                    	int Val = freq_choose.showOpenDialog(frame);
                    	if (Val == JFileChooser.APPROVE_OPTION) {
                    		File freq_file_choose = freq_choose.getSelectedFile();
                    		
                    		//tree creation 
                    		HuffmanTree arbre = new HuffmanTree();
                    		HuffmanFile freq_file = new HuffmanFile(freq_file_choose);
                    		arbre.create_tree(freq_file.transform_to_list_node(freq_file.Freq_File_Reader()));
                    		
                    		HuffmanFile file_decompress = new HuffmanFile(selectedfile);
    						Label_files_content.setText(String.valueOf(file_decompress.getBinaryChain()) + " is the compressed text for :");
    						
    						text_decompressed.setText(HuffmanDecompress.decompress(file_decompress.getBinaryChain(), arbre));
    						System.out.println();
    						HuffmanDecompress.write_text_decompressed(text_decompressed.getText());
                    	}	
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
                }
			}
		});
		btnNewButton.setFont(new Font("Verdana Pro", Font.PLAIN, 10));
		btnNewButton.setBounds(489, 330, 100, 21);
		lblNewLabel.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 611, 45);
		
		frame.getContentPane().add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
}

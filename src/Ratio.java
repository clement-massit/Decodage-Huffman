import java.io.File;

public class Ratio {
	private static File compressed_file = new File("test/exemple_comp.txt");
	private static File decompressed_file = new File("test/Results/text_decompressed.txt");
	
	public Ratio() {
	}

	public File getCompressed_file() {
		return compressed_file;
	}

	public File getDecompressed_file() {
		return decompressed_file;
	}
	
	public static float compress_ratio(File compressed_file, File decompressed_file) {
		long compress_lenght = compressed_file.length();
		long decompress_lenght = decompressed_file.length(); 
		float result = (float) decompress_lenght / compress_lenght;
		
		return 1 - result;
	}
	public static void main(String args[]) {
		System.out.println(decompressed_file.length());
		
		System.out.println(compress_ratio(compressed_file, decompressed_file));
	}
	

}

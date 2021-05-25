
public class Pair{
	public String caractere;
	public Integer freq;
	
	public Pair(String caractere, Integer freq) {
		this.caractere = caractere;
		this.freq = freq;
	}

	public String getCaractere() {
		return caractere;
	}

	public Integer getFreq() {
		return freq;
	}
	
	public String toString() { return "(" + getCaractere() + "," + getFreq() + ")"; }

	

}

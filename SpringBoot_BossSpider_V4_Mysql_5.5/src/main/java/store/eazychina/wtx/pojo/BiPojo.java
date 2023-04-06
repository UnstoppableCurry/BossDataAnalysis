package store.eazychina.wtx.pojo;

public class BiPojo {

	private int id;
	private String word;
	private int	freq;
	private int day_seq;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getDay_seq() {
		return day_seq;
	}
	public void setDay_seq(int day_seq) {
		this.day_seq = day_seq;
	}
	@Override
	public String toString() {
		return "DiPojo [id=" + id + ", word=" + word + ", freq=" + freq
				+ ", day_seq=" + day_seq + "]";
	}
	public BiPojo(int id, String word, int freq, int day_seq) {
		super();
		this.id = id;
		this.word = word;
		this.freq = freq;
		this.day_seq = day_seq;
	}
	public BiPojo() {
		super();
	}
	
}

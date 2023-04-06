package store.eazychina.wtx.pojo;

public class BossBiPojoFromAddr {
	private int id;
	private String addr;
	private int minred;
	private int avgred;
	private int maxred;
	public BossBiPojoFromAddr(int id, String addr, int minred, int avgred,
			int maxred) {
		super();
		this.id = id;
		this.addr = addr;
		this.minred = minred;
		this.avgred = avgred;
		this.maxred = maxred;
	}
	public BossBiPojoFromAddr() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getMinred() {
		return minred;
	}
	public void setMinred(int minred) {
		this.minred = minred;
	}
	public int getAvgred() {
		return avgred;
	}
	public void setAvgred(int avgred) {
		this.avgred = avgred;
	}
	public int getMaxred() {
		return maxred;
	}
	public void setMaxred(int maxred) {
		this.maxred = maxred;
	}
	@Override
	public String toString() {
		return "BossBiPojoFromAddr [id=" + id + ", addr=" + addr + ", minred="
				+ minred + ", avgred=" + avgred + ", maxred=" + maxred + "]";
	}
	
}

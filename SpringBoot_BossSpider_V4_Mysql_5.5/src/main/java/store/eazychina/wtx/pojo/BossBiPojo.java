package store.eazychina.wtx.pojo;

public class BossBiPojo {
private int id;
private int rank;
private String jobName;
			    
private String jobTageItem;
public String getJobTageItem() {
	return jobTageItem;
}
public void setJobTageItem(String jobTageItem) {
	this.jobTageItem = jobTageItem;
}
private int minred;
private int avgred;
private int maxred;
private String addr;
@Override
public String toString() {
	return "BossBiPojo [id=" + id + ", rank=" + rank + ", jobName=" + jobName
			+ ", jobTageItem=" + jobTageItem + ", minred=" + minred + ", avgred="
			+ avgred + ", maxred=" + maxred + ", addr=" + addr + "]";
}
public BossBiPojo(int id, int rank, String jobName, String jobTageItem,
		int minred, int avgred, int maxred, String addr) {
	super();
	this.id = id;
	this.rank = rank;
	this.jobName = jobName;
	this.jobTageItem = jobTageItem;
	this.minred = minred;
	this.avgred = avgred;
	this.maxred = maxred;
	this.addr = addr;
}
public BossBiPojo() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRank() {
	return rank;
}
public void setRank(int rank) {
	this.rank = rank;
}
public String getJobName() {
	return jobName;
}
public void setJobName(String jobName) {
	this.jobName = jobName;
}
public String getjobTageItem() {
	return jobTageItem;
}
public void setjobTageItem(String jobTageItem) {
	this.jobTageItem = jobTageItem;
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
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}

}

package store.eazychina.wtx.pojo;

public class bossPojo {
	private int id;
	//公司名称
	private String companyName;
	//hr信息
	private String hrMessage;
	//学历要求
	private String vline;
	//最低薪酬
	private int minRed;
	//最高薪酬
	private int maxRed;
	//招聘地点/工作地点
	private String jobAreaWrapper;
	//招聘岗位名称
	private String jobName;
	//岗位要求
	private String jobTagItem;
	
	//实习薪酬,备用
	private String otherRed;

	public bossPojo(int id, String companyName, String hrMessage, String vline,
			int minRed, int maxRed, String jobAreaWrapper, String jobName,
			String jobTagItem, String otherRed) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.hrMessage = hrMessage;
		this.vline = vline;
		this.minRed = minRed;
		this.maxRed = maxRed;
		this.jobAreaWrapper = jobAreaWrapper;
		this.jobName = jobName;
		this.jobTagItem = jobTagItem;
		this.otherRed = otherRed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public bossPojo(String companyName, String hrMessage, String vline,
			int minRed, int maxRed, String jobAreaWrapper, String jobName,
			String jobTagItem, String otherRed) {
		super();
		this.companyName = companyName;
		this.hrMessage = hrMessage;
		this.vline = vline;
		this.minRed = minRed;
		this.maxRed = maxRed;
		this.jobAreaWrapper = jobAreaWrapper;
		this.jobName = jobName;
		this.jobTagItem = jobTagItem;
		this.otherRed = otherRed;
	}
	public String getOtherRed() {
		return otherRed;
	}
	public void setOtherRed(String otherRed) {
		this.otherRed = otherRed;
	}
	public bossPojo(String companyName, String hrMessage, String vline,
			int minRed, int maxRed, String jobAreaWrapper, String jobName,
			String jobTagItem) {
		super();
		this.companyName = companyName;
		this.hrMessage = hrMessage;
		this.vline = vline;
		this.minRed = minRed;
		this.maxRed = maxRed;
		this.jobAreaWrapper = jobAreaWrapper;
		this.jobName = jobName;
		this.jobTagItem = jobTagItem;
	}
	public bossPojo() {
		super();
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getHrMessage() {
		return hrMessage;
	}
	public void setHrMessage(String hrMessage) {
		this.hrMessage = hrMessage;
	}
	public String getVline() {
		return vline;
	}
	public void setVline(String vline) {
		this.vline = vline;
	}
	public int getMinRed() {
		return minRed;
	}
	public void setMinRed(int minRed) {
		this.minRed = minRed;
	}
	public int getMaxRed() {
		return maxRed;
	}
	public void setMaxRed(int maxRed) {
		this.maxRed = maxRed;
	}
	public String getJobAreaWrapper() {
		return jobAreaWrapper;
	}
	public void setJobAreaWrapper(String jobAreaWrapper) {
		this.jobAreaWrapper = jobAreaWrapper;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobTagItem() {
		return jobTagItem;
	}
	public void setJobTagItem(String jobTagItem) {
		this.jobTagItem = jobTagItem;
	}
	@Override
	public String toString() {
		return "bossPojo [id=" + id + ", companyName=" + companyName
				+ ", hrMessage=" + hrMessage + ", vline=" + vline + ", minRed="
				+ minRed + ", maxRed=" + maxRed + ", jobAreaWrapper="
				+ jobAreaWrapper + ", jobName=" + jobName + ", jobTagItem="
				+ jobTagItem + ", otherRed=" + otherRed + "]";
	}
	
}

/**
 * 学生信息
 */
package bean;

public class Student {
	private String no;
	private String name;
	private String sex;
	private String birth;
	private String from;
	private String majorno;
	private String collegeno;
	private String isjob;
	private String jobno;//工作编号
	private String jobtype;//工作名称
	private String jobfrom;//公司
	
	/*@Override
	public String toString() {
		return "Student [id=" + id + ", no=" + no + ", name=" + name + ", sex=" + sex + ", number=" + number
				+ ", classroom=" + classroom + ", score=" + score + ", school=" + school + "]";
	}*/

	public String getNo() {
		return no;
	}
	public void setNo(String string) {
		this.no = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMajorno() {
		return majorno;
	}
	public void setMajorno(String majorno) {
		this.majorno = majorno;
	}
	public String getCollegeno() {
		return collegeno;
	}
	public void setCollegeno(String collegeno) {
		this.collegeno = collegeno;
	}
	public String getIsjob() {
		return isjob;
	}
	public void setIsjob(String isjob) {
		this.isjob = isjob;
	}
	
	public void setJobno(String jobno) {
		this.jobno = jobno;
	}
	public String getJobno() {
		return jobno;
	}
	
	public void setJobname(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getJobname() {
		return jobtype;
	}
	
	public void setJobfrom(String jobfrom) {
		this.jobfrom = jobfrom;
	}
	public String getJobfrom() {
		return jobfrom;
	}
}

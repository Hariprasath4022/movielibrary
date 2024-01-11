package dto;

public class Admin 
{
	private int adminid;
	private String adminname;
	private Long admincontact;
	private String adminemail;
	private String adminpassword;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public Long getAdmincontact() {
		return admincontact;
	}
	public void setAdmincontact(Long admincontact) {
		this.admincontact = admincontact;
	}
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", admincontact=" + admincontact
				+ ", adminemail=" + adminemail + ", adminpassword=" + adminpassword + "]";
	}
	
	
}

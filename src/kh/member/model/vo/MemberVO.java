package kh.member.model.vo;

public class MemberVO {
//	이름       널?       유형           
//			-------- -------- ------------ 
//			ID       NOT NULL VARCHAR2(20) 
//			NICKNAME          VARCHAR2(20) 
//			EMAIL    NOT NULL VARCHAR2(40) 
//			PASSWORD NOT NULL VARCHAR2(20) 
//			MRG      NOT NULL VARCHAR2(1)  
	
	private String id;
	private String nickname;
	private String email;
	private String password;
	private String mgr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", nickname=" + nickname + ", email=" + email + ", password=" + password + ", mgr="
				+ mgr + "]";
	}
	
}

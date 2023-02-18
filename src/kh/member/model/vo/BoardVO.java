package kh.member.model.vo; 

import java.sql.Date;

public class BoardVO {
//	이름       널?       유형             
//			-------- -------- -------------- 
//			POSTID   NOT NULL VARCHAR2(10)   
//			POSTNAME NOT NULL VARCHAR2(30)   
//			ID       NOT NULL VARCHAR2(20)   
//			GAMENAME NOT NULL VARCHAR2(20)   
//			NOWDATE  NOT NULL TIMESTAMP(6)   
//			CONTENTS NOT NULL VARCHAR2(1000)   
	private int postId;
	private String postName;
	private String id;
	private String nickname;
	private String gameName;
	private Date nowDate;
	private String contents;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "BoardVO [postId=" + postId + ", postName=" + postName + ", id=" + id + ", nickname=" + nickname
				+ ", gameName=" + gameName + ", nowDate=" + nowDate + ", contents=" + contents + "]";
	}
	
	
	
}

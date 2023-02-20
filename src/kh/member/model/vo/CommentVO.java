package kh.member.model.vo;

import java.sql.Date;

public class CommentVO {
//	이름       널?       유형                 
//			-------- -------- ------------------ 
//			CMTID   NOT NULL VARCHAR2(10 CHAR)  
//			CMT      NOT NULL VARCHAR2(500 CHAR) 
//			POSTID   NOT NULL NUMBER             
//			NICKNAME NOT NULL VARCHAR2(20 CHAR)  
//			NOWDATE  NOT NULL TIMESTAMP(6)       
	private String cmtId;
	private String cmt;
	private int postId;
	private String nickname;
	private Date nowdate;
	public String getCmtId() {
		return cmtId;
	}
	public void setCmtId(String cmtId) {
		this.cmtId = cmtId;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
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
	public Date getNowdate() {
		return nowdate;
	}
	public void setNowdate(Date nowdate) {
		this.nowdate = nowdate;
	}
	@Override
	public String toString() {
		return "CommentVO [cmtId=" + cmtId + ", cmt=" + cmt + ", postId=" + postId + ", nickname=" + nickname
				+ ", nowdate=" + nowdate + "]";
	}
	
	
	
}

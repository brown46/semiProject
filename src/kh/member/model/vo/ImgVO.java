package kh.member.model.vo;

public class ImgVO {
	private String imgName;
	private int postId;

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Override
	public String toString() {
		return "ImgVO [imgName=" + imgName + ", postId=" + postId + "]";
	}


	
}

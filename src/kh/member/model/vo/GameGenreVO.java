package kh.member.model.vo;

public class GameGenreVO {
//	이름        널?       유형           
//			--------- -------- ------------ 
//			GAMENAME  NOT NULL VARCHAR2(20) 
//			GENRENAME NOT NULL VARCHAR2(20) 
	private String gameName;
	private String genreName;
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		return "GameGenreVO [gameName=" + gameName + ", genreName=" + genreName + "]";
	}
	
}

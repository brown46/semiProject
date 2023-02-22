package kh.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import connect.OracleConnection;
import kh.member.model.vo.BoardVO;
import kh.member.model.vo.CommentVO;
import kh.member.model.vo.GameGenreVO;
import kh.member.model.vo.ImgVO;
import kh.member.model.vo.SearchDTO;

public class BoardDAO {
	private SqlSession session = OracleConnection.getSqlSession();

	public void commit() {
		session.commit();
	}

	public void rollback() {
		session.rollback();
	}

	public void close() {
		session.close();
	}

	public List<BoardVO> selectPage(Map<String, Integer> page) {
		List<BoardVO> dataList =session.selectList("boardMapper.selectPage", page);
		return dataList;
	}

	public int getRowCount() {
		int rowCount= session.selectOne("boardMapper.getRowCount");
		return rowCount;
	}

	public int getGenreRowCount(String genre) {
		int rowCount= session.selectOne("boardMapper.getGenreRowCount",genre);
		return rowCount;
	}

	public int getNameRowCount(String name) {
		int rowCount= session.selectOne("boardMapper.getNameRowCount",name);
		return rowCount;
	}

	public List<BoardVO> searchName(SearchDTO dto) {
		List<BoardVO> dataList = session.selectList("boardMapper.searchName",dto);
		return dataList;
	}

	public List<String> searchGenre(SearchDTO dto) {
		List<String> gameList= session.selectList("boardMapper.searchGenre",dto);
//		System.out.println(gameList);
		return gameList;
	}

	public List<String> getGenre() {
		List<String> genreList = session.selectList("boardMapper.getGenre");
		return genreList;
	}
	public List<String> getGrGa(String gamename) {
		List<String> genreList = session.selectList("boardMapper.getGrGa",gamename);
		return genreList;
	}
	

	public int posting(BoardVO bvo) {
		int result = session.insert("boardMapper.posting", bvo);
		return result;
	}

	public int addGame(String gameTitle) {
		int result = session.insert("boardMapper.addGame",gameTitle);
		return result;
	}

	public int getGGcount(GameGenreVO gg) {
		int result = session.selectOne("boardMapper.getGGcount",gg);
		return result;
	}

	public int addGameGenre(GameGenreVO gg) {
		int result = session.insert("boardMapper.addGameGenre",gg);
		return result;
	}

	public List<BoardVO> getMyPage(SearchDTO dto) {
		List<BoardVO> dataList = session.selectList("boardMapper.getMyPage",dto);
		return dataList;
	}

	public int getGameNameCount(String gameTitle) {
		int rowCount= session.selectOne("boardMapper.getGameNameCount",gameTitle);
		return rowCount;
	}

	public BoardVO getDetail(int postId) {
		BoardVO post = session.selectOne("boardMapper.getDetail",postId);
		return post;
	}

	public List<String> getGenre(String gameName) {
		List<String> genreList = session.selectList("boardMapper.findGenre",gameName);
		return genreList;
	}

	public int comment(CommentVO vo) {
		int result = session.insert("boardMapper.comment",vo);
		return result;
	}

	public List<CommentVO> getComment(int postId) {
		List<CommentVO> cList= session.selectList("boardMapper.getComment",postId);
		return cList;
	}

	public List<String> getAllGames() {
		List<String> games =session.selectList("boardMapper.getAllGames");
		return games;
	}

	public List<String> genreSearch(String keyword) {
		List<String> games =session.selectList("boardMapper.recommendGame",keyword);
		return games;
	}

	public int getImgCount(ImgVO img) {
		int count = session.selectOne("boardMapper.getImgCount",img);
		return count;
	}

	public int uploadImg(ImgVO img) {
		int result = session.insert("boardMapper.uploadImg",img);
		return result;
	}

	public int getLastPID() {
		int pid = session.selectOne("boardMapper.getLastPID");
		return pid;
	}

	public String getImgName(int postId) {
		String imgName = session.selectOne("boardMapper.getImgName",postId);
		return imgName;
	}
}

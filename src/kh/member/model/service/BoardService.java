package kh.member.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.member.model.dao.BoardDAO;
import kh.member.model.vo.BoardVO;
import kh.member.model.vo.CommentVO;
import kh.member.model.vo.GameGenreVO;
import kh.member.model.vo.ImgVO;
import kh.member.model.vo.SearchDTO;

public class BoardService {

	public List<BoardVO> getPage(int pNum, int cnt) {
		Map<String, Integer> page =new HashMap<String, Integer>();
		page.put("start", (pNum-1)*cnt+1);
		page.put("end", pNum*cnt);
		BoardDAO dao = new BoardDAO();
		List<BoardVO> dataList =dao.selectPage(page);
		dao.close();
		return dataList;
	}

	public int getRowCount() {
		BoardDAO dao = new BoardDAO();
		int rowCount=dao.getRowCount();
		dao.close();
		return rowCount;
	}

	public int getNameRowCount(String keyword) {
		BoardDAO dao = new BoardDAO();
		int NameRowCount=dao.getNameRowCount(keyword);
		dao.close();
		return NameRowCount;
	}
	public int getGenreRowCount(String keyword) {
		BoardDAO dao = new BoardDAO();
		int genreRowCount=dao.getGenreRowCount(keyword);
		dao.close();
		return genreRowCount;
	}

	public List<BoardVO> nameSearch(String keyword,int pNum, int cnt) {
		BoardDAO dao = new BoardDAO();
		SearchDTO dto = new SearchDTO();
		dto.setStart((pNum-1)*cnt+1);
		dto.setEnd( pNum*cnt);
		dto.setKeyword(keyword);
		List<BoardVO> boardList = dao.searchName(dto);
		dao.close();
		return boardList;
	}

	public List<String> genreSearch(String keyword,int pNum, int cnt ) {
		BoardDAO dao = new BoardDAO();
		SearchDTO dto = new SearchDTO();
		dto.setStart((pNum-1)*cnt+1);
		dto.setEnd( pNum*cnt);
		dto.setKeyword(keyword);
		List<String> gameList= dao.searchGenre(dto);
		dao.close();
		return gameList;
	}

	public List<String> getGrGa(String gamename) {
		BoardDAO dao = new BoardDAO();
		List<String> genreList= dao.getGrGa(gamename);
		dao.close();
		return genreList;
	}
	public List<String> getGenre() {
		BoardDAO dao = new BoardDAO();
		List<String> genreList= dao.getGenre();
		dao.close();
		return genreList;
	}
	public int posting(BoardVO bvo) {
		BoardDAO dao = new BoardDAO();
		int result =dao.posting(bvo);
		dao.commit();
		dao.close();
		return result;
	}

	public int addGame(String gameTitle) {
		BoardDAO dao = new BoardDAO();
		int result= dao.addGame(gameTitle);
		dao.commit();
		dao.close();
		return result;
	}

	public int addGameGenre(GameGenreVO gg) {
		BoardDAO dao = new BoardDAO();
		int count = dao.addGameGenre(gg);
		dao.commit();
		dao.close();
		return count;
	}

	public boolean getGGcount(GameGenreVO gg) {
		BoardDAO dao = new BoardDAO();
		int count =dao.getGGcount(gg);
		dao.close();
		if(count==0) {
			return false;
		}
		return true;
	}

	public List<BoardVO> getMyPage(String id,int pNum, int cnt) {
		BoardDAO dao = new BoardDAO();
		SearchDTO dto = new SearchDTO();
		dto.setStart((pNum-1)*cnt+1);
		dto.setEnd( pNum*cnt);
		dto.setKeyword(id);
		List<BoardVO> dataList= dao.getMyPage(dto);
		dao.close();
		return dataList;
	}

	public int getGameNameCount(String gameTitle) {
		BoardDAO dao = new BoardDAO();
		int gameNameCount=dao.getGameNameCount(gameTitle);
		dao.close();
		return gameNameCount;
	}

	public BoardVO getDetail(int postId) {
		BoardDAO dao = new BoardDAO();
		BoardVO post =dao.getDetail(postId);
		return post;
	}



	public List<String> getGenre(String gameName) {
		BoardDAO dao = new BoardDAO();
		List<String> list= dao.getGenre(gameName);
		dao.close();
		return list;
	}

	public int comment(CommentVO vo) {
		BoardDAO dao = new BoardDAO();
		int result =dao.comment(vo);
		dao.commit();
		dao.close();
		return result;
	}

	public List<CommentVO> getComment(int postId) {
		BoardDAO dao = new BoardDAO();
		List<CommentVO> cList= dao.getComment(postId);
		dao.close();
		return cList;
	}

	public List<String> getAllGames() {
		BoardDAO dao = new BoardDAO();
		List<String> games=dao.getAllGames();
		dao.close();
		return games;
	}

	public List<String> genreSearch(String keyword) {
		BoardDAO dao = new BoardDAO();
		List<String> games=dao.genreSearch(keyword);
		dao.close();
		return games;
	}

	public int getImgCount(ImgVO img) {
		BoardDAO dao = new BoardDAO();
		int count =dao.getImgCount(img);
		dao.close();
		return count;
	}

	public int uploadImg(ImgVO img) {
		BoardDAO dao = new BoardDAO();
		int result =dao.uploadImg(img);
		dao.commit();
		dao.close();
		return result;
	}

	public int getLastPID() {
		BoardDAO dao = new BoardDAO();
		int pid = dao.getLastPID();
		dao.close();
		return pid;
	}

	public String getImgName(int postId) {
		BoardDAO dao = new BoardDAO();
		String imgName = dao.getImgName(postId);
		dao.close();
		return imgName;
	}




}

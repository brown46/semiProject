package kh.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.member.model.dao.BoardDAO;
import kh.member.model.vo.BoardVO;
import kh.member.model.vo.GameGenreVO;
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




}

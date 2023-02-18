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
		return gameList;
	}



}

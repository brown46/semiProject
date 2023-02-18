package kh.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import connect.OracleConnection;
import kh.member.model.vo.BoardVO;
import kh.member.model.vo.GameGenreVO;
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
		System.out.println(gameList);
		return gameList;
	}
}

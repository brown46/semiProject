package kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import connect.OracleConnection;
import kh.member.model.vo.MemberVO;

public class MemberDAO {
	private SqlSession session= OracleConnection.getSqlSession();
	
	public void commit() {
		session.commit();
	}
	public void rollback() {
		session.rollback();
	}
	public void close() {	
		session.close();
	}
	public int enroll(MemberVO vo) {
		int count= session.insert("memberMapper.enroll",vo);
		return count;
	}
	public int idDupChk(MemberVO idVo) {
		int count= session.selectOne("memberMapper.idDupChk",idVo);
		return count;
	}
	public int nickDupChk(MemberVO nickVo) {
		int count= session.selectOne("memberMapper.nickDupChk",nickVo);
		return count;
	}
	public MemberVO login(MemberVO vo) {
		vo = session.selectOne("memberMapper.login", vo);
		return vo;
	}
	public int updateNick(MemberVO vo) {
		int result =session.update("memberMapper.updateNick", vo);
		return result;
	}
	public int updateEmail(MemberVO vo) {
		int result =session.update("memberMapper.updateEmail", vo);
		return result;
	}
	public int updatePassword(MemberVO vo) {
		int result =session.update("memberMapper.updatePassword", vo);
		return result;
	}
	
	public int deleteAllPost(MemberVO vo) {
		int result =session.delete("memberMapper.deleteAllPost",vo);
		return result;
	}
	
	public int withdrawal(MemberVO vo) {
		int result =session.delete("memberMapper.withdrawal",vo);
		return result;
	}
	
}

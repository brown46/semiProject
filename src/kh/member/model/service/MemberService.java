package kh.member.model.service;

import kh.member.model.dao.MemberDAO;
import kh.member.model.vo.MemberVO;

public class MemberService {

	public int enroll(MemberVO vo) {
		MemberDAO dao = new MemberDAO();
		
		int result =-1;
		result= dao.enroll(vo);
		if (result == 1) {
			dao.commit();
			dao.close();
		}else {
			dao.rollback();
			dao.close();
		}
		
		return result;
	}

	public int idDupChk(MemberVO idVo) {
		MemberDAO dao = new MemberDAO();
		int result = dao.idDupChk(idVo);
		
		dao.close();
		return result;
	}

	public int nickDupChk(MemberVO nickVo) {
		MemberDAO dao = new MemberDAO();
		int result = dao.nickDupChk(nickVo);
		
		dao.close();
		return result;
	}

	public MemberVO login(MemberVO vo) {
		MemberDAO dao = new MemberDAO();
		vo= dao.login(vo);
		dao.close();
		return vo;
	}

	public int updateNick(MemberVO vo) {
		MemberDAO dao = new MemberDAO();
		int result = dao.updateNick(vo);
		if(result ==1) {
			dao.commit();
			System.out.println("dao: 닉네임 변경 완료");
		}else {
			System.out.println("dao: 문제 발생");
			dao.rollback();
		}
		dao.close();
		return result;
	}

	public int updateEmail(MemberVO vo) {
		MemberDAO dao = new MemberDAO();
		int result = dao.updateEmail(vo);
		if(result ==1) {
			dao.commit();
			System.out.println("dao: 이메일 변경 완료");
		}else {
			System.out.println("dao: 문제 발생");
			dao.rollback();
		}
		dao.close();
		return result;
	}

	public int updatePassword(MemberVO vo) {
		MemberDAO dao = new MemberDAO();
		int result = dao.updatePassword(vo);
		if(result ==1) {
			dao.commit();
			System.out.println("dao: 비밀번호 변경 완료");
		}else {
			System.out.println("dao: 문제 발생");
			dao.rollback();
		}
		dao.close();
		return result;
	}
	
	public int deleteAllPost(MemberVO vo) {
		MemberDAO dao = new MemberDAO();
		int result =dao.deleteAllPost(vo);
		dao.commit();
		dao.close();
		return result;
	}
	
	public int withdrawal(MemberVO vo) {
		MemberDAO dao = new MemberDAO();
		int result =dao.withdrawal(vo);
		if(result ==1) {
			dao.commit();
			System.out.println("dao: 계정 삭제 완료");
		}else {
			System.out.println("dao: 문제 발생");
			dao.rollback();
		}
		dao.close();
		return result;
	}
	
	

	
}

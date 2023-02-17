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

	
}

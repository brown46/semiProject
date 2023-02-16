package kh.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVO;

/**
 * Servlet implementation class EnrollController
 */
@WebServlet("/enroll")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String nickname= request.getParameter("id");
		String password= request.getParameter("password");	
		String email = request.getParameter("email");
	
		MemberService ms = new MemberService();
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setNickname(nickname);
		vo.setPassword(password);
		vo.setEmail(email);
		vo.setMgr("F");
		
		ms.enroll(vo);
		
	}

}

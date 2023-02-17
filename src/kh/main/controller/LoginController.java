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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id  =request.getParameter("id");
		String password = request.getParameter("password");
		MemberService ms = new MemberService();
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		MemberVO result = ms.login(vo);
		System.out.println(result);
		if(result!=null) {
			request.getSession().setAttribute("lgnss", result);
			response.sendRedirect(request.getContextPath()+"/");
		}else {
			request.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
		
		
	}

}

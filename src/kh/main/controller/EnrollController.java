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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/view/enroll.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= (String) request.getSession().getAttribute("id");
		String nickname=  (String) request.getSession().getAttribute("nickname");
		String password= request.getParameter("password");	
		String email = request.getParameter("email");
		System.out.println(id);
		System.out.println(nickname);
		MemberService ms = new MemberService();
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setNickname(nickname);
		vo.setPassword(password);
		vo.setEmail(email);
		vo.setMgr("F");
		
		int result= ms.enroll(vo);
		if(result==1) {
			response.sendRedirect(request.getContextPath()+"/");
		}else {
			request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
		}
		
	}

}

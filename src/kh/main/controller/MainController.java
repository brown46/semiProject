package kh.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.vo.MemberVO;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getSession().getAttribute("lgnss")==null) {
			request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);			
		}else if(((MemberVO)request.getSession().getAttribute("lgnss")).getMgr().equals("F")){
			System.out.println(((MemberVO)request.getSession().getAttribute("lgnss")).getMgr()+1);
			request.getRequestDispatcher("WEB-INF/view/membermain.jsp").forward(request, response);			
		}else {
			request.getRequestDispatcher("WEB-INF/view/managermain.jsp").forward(request, response);			
			System.out.println(((MemberVO)request.getSession().getAttribute("lgnss")).getMgr()+2);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

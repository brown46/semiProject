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
 * Servlet implementation class DupChkController
 */
@WebServlet("/dupChk")
public class DupChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DupChkController() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		MemberVO idVo = new MemberVO();
		MemberVO nickVo = new MemberVO();
		
		if (id != null && nickname != null) {
			idVo.setId(id);
			nickVo.setNickname(nickname);

			MemberService ms = new MemberService();
			int idCount = ms.idDupChk(idVo);
			int nickCount = ms.nickDupChk(nickVo);
			request.setAttribute("idCount",idCount );
			request.setAttribute("nickCount", nickCount);
			if(idCount == 0 && nickCount == 0) {				
				request.getSession().setAttribute("id", id);
				request.getSession().setAttribute("nickname", nickname);

			}
			System.out.println(idCount);
			System.out.println(nickCount);
			System.out.println((String) request.getSession().getAttribute("id"));
			System.out.println((String) request.getSession().getAttribute("nickname"));
		}
		request.getRequestDispatcher("/WEB-INF/view/dupChk.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		MemberVO idVo = new MemberVO();
		MemberVO nickVo = new MemberVO();
		if (id != null && nickname != null) {
			idVo.setId(id);
			nickVo.setNickname(nickname);

			MemberService ms = new MemberService();
			int idCount = ms.idDupChk(idVo);
			int nickCount = ms.nickDupChk(nickVo);
			request.setAttribute("idCount",idCount );
			request.setAttribute("nickCount", nickCount);
			if(idCount == 0 && nickCount == 0) {				
				request.setAttribute("id",id );
				request.setAttribute("nickname", nickname);
			}
			System.out.println(idCount);
			System.out.println(nickCount);
			System.out.println(request.getAttribute("id"));
			System.out.println(request.getAttribute("nickname"));
		}
//		request.getRequestDispatcher("/WEB-INF/view/enroll.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/enroll");
	}

}

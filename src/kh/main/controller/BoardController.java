package kh.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.BoardService;
import kh.member.model.vo.BoardVO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNumber = request.getParameter("p");
		
		int pNum;
		if (pageNumber == null || pageNumber.isEmpty()) {
			pNum = 1;
		} else {
			pNum = Integer.valueOf(pageNumber);
		}
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("cnt")) {
				cookie = c;
			}
		} // 이미 저장된 쿠키가 있으면 사용
		
		String cnt = request.getParameter("cnt");
		if (cnt != null) { // cnt-parameter값- 자체가 없는 경우
			if (cnt.isEmpty()) {// cnt가 빈 문자열 일 경우. cnt =
				if (cookie != null) {
					cnt = cookie.getValue();
				} else {
					cnt = "10"; // 초기값
				}
			}
		} else {
			if(cookie !=null) {
				cnt = cookie.getValue();
			}else {				
				cnt = "10";
			}
		}
		
		cookie = new Cookie("cnt", cnt);
		cookie.setMaxAge(60 * 60 * 24 * 5);
		response.addCookie(cookie);
		
		BoardService service = new BoardService();
		List<BoardVO> boardList = service.getPage(pNum, Integer.parseInt(cnt));
		
		int rowCount = service.getRowCount();
		int pageCount =0;
		if (rowCount % Integer.parseInt(cnt) == 0) {
			pageCount = rowCount / Integer.parseInt(cnt);
		} else {
			pageCount = rowCount / Integer.parseInt(cnt) + 1;
		}
		//pageCount를 잘라서 전달
				int start =1;
				int end =5;
				if(pNum >5/2+1) {
					start =pNum-2;
					end =pNum+2;
				}
				
				if(end>=pageCount) {
					end=pageCount;
				}
				
				
				request.setAttribute("pageStart", start);
				request.setAttribute("pageEnd", end);
				request.setAttribute("cnt", cnt);
				request.setAttribute("dataList", boardList);
				request.getRequestDispatcher("/WEB-INF/view/board.jsp").forward(request,response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

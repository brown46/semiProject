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
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = request.getParameter("kinds");
		String keyword= request.getParameter("keyword");
		
	
		
		String pageNumber = request.getParameter("p");	
		int pNum;
		if (pageNumber == null || pageNumber.isEmpty()) {
			pNum = 1;
		} else {
			pNum = Integer.valueOf(pageNumber);
		}
		Cookie cookie = null;
		Cookie kindscookie = null;
		Cookie keycookie = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("cnt")) {
				cookie = c;
			}
		} // 이미 저장된 쿠키가 있으면 사용
		for (Cookie c : cookies) {
			if (c.getName().equals("kinds")) {
				kindscookie = c;
			}
		}
		for (Cookie c : cookies) {
			if (c.getName().equals("keyword")) {
				keycookie = c;
			}
		}
		if ( value== null) {
			value = kindscookie.getValue();
		}
		if ( keyword== null) { 
			keyword = keycookie.getValue();
		}
		System.out.println("===========1");
		System.out.println(cookie);
		System.out.println(kindscookie);
		System.out.println(keycookie);
		
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
		request.setAttribute("kinds", value);
		request.setAttribute("keyword", keyword);
		System.out.println("===========2");
		System.out.println(cnt);
		System.out.println(value);
		System.out.println(keyword);
		
		cookie = new Cookie("cnt", cnt);
		kindscookie = new Cookie("kinds", value);
		keycookie = new Cookie("keyword", keyword);
		cookie.setMaxAge(60 * 60 * 24 * 5);
		
		System.out.println("===========3");
		System.out.println(cookie);
		System.out.println(kindscookie);
		System.out.println(keycookie);
		
		response.addCookie(cookie);
		response.addCookie(kindscookie);
		response.addCookie(keycookie);
		int rowCount =0;
		BoardService service = new BoardService();
		List<BoardVO> dataList =null;
		List<String> gameList =null;
		if(value.equals("name")) {
			rowCount = service.getNameRowCount(keyword);
			dataList = service.nameSearch(keyword, pNum,Integer.parseInt(cnt));
		}else {
			rowCount= service.getGenreRowCount(keyword);
			gameList = service.genreSearch(keyword,pNum,Integer.parseInt(cnt));	
			
		}
		
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
				request.setAttribute("dataList", dataList);

				System.out.println(cnt);
				System.out.println(value);
				System.out.println(keyword);
				
				if(value.equals("name")) {
					request.setAttribute("dataList", dataList);
					request.getRequestDispatcher("/WEB-INF/view/nameSearch.jsp").forward(request,response);				
				}else {
					request.setAttribute("dataList", gameList); 
					System.out.println(gameList);
					request.getRequestDispatcher("/WEB-INF/view/genreSearch.jsp").forward(request,response);
				}
	}	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }


}

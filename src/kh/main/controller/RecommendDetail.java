package kh.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.BoardService;
import kh.member.model.vo.SearchDTO;

/**
 * Servlet implementation class RecommendDetail
 */
@WebServlet("/recommendDetail")
public class RecommendDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("map");
//		request.getSession().removeAttribute("map");
		request.setAttribute("map",map);
		
		
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		entryList.sort(Map.Entry.comparingByValue());
		List<String> top3 = new ArrayList<>();
		for (int i = entryList.size() - 1; i >=  entryList.size()-3 ; i--) {
//	          System.out.println("key : " + entryList.get(i).getKey() + ", value : " + entryList.get(i).getValue());
	          top3.add(entryList.get(i).getKey());
	        }//상위 3개 장르. 중복이 3개 이상이 아니라면 오류난다.
		System.out.println(top3);
		request.setAttribute("top3", top3);
		List<String> list0 = service.genreSearch(top3.get(0));
		List<String> list1 = service.genreSearch(top3.get(1));
		List<String> list2 = service.genreSearch(top3.get(2));
		request.setAttribute("list0", list0);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		
		request.getRequestDispatcher("/WEB-INF/view/recommendDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

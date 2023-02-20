package kh.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.BoardService;

/**
 * Servlet implementation class Recommend
 */
@WebServlet("/recommend")
public class Recommend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Recommend() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardService service = new BoardService();

		List<String> games = service.getAllGames();
		request.setAttribute("games", games);
		request.getRequestDispatcher("/WEB-INF/view/recommend.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = new BoardService();
		String gameList = request.getParameter("input");
		List<String> list = new ArrayList<>();
		if (gameList != null) {
			for (String s : gameList.trim().split(" ")) {
				list.add(s);
				System.out.println(s);
			}
		}

		// 장르를 map에 넣고 같은 장르 이름이 나올 때마다 value를 +1
		Map<String, Integer> map = new HashMap<>();
		for (String s : list) {
			List<String> genreList = service.getGenre();
			for (String st : genreList) {
				if (map.get(st) == null) {
					map.put(st, 1);
				} else {
					map.put(st, map.get(st) + 1);
				}
			}
		}
		System.out.println(map);
		
	}

}

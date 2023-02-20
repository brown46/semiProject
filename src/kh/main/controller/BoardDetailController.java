package kh.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.BoardService;
import kh.member.model.vo.BoardVO;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시글 id를 받고 db를 거쳐 jsp로 이동
		int postId = 0;
		try {			
			postId= Integer.parseInt(request.getParameter("postId")); 
		} catch (Exception e) {
		}
		BoardService bs = new BoardService();
		BoardVO post= bs.getDetail(postId);
		request.setAttribute("post", post);

		//게임 이름 별로 장르 받아오기
		//
		ArrayList<String> genreList= new ArrayList<String>(bs.getGenre(post.getGameName()));
		request.setAttribute("genreList", genreList);

		
		request.getRequestDispatcher("/WEB-INF/view/boardDetail.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

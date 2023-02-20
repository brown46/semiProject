package kh.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;

import kh.member.model.service.BoardService;
import kh.member.model.vo.BoardVO;
import kh.member.model.vo.CommentVO;
import kh.member.model.vo.MemberVO;

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
		BoardService service = new BoardService();
		BoardVO post= service.getDetail(postId);
		request.setAttribute("post", post);

		//게임 이름 별로 장르 받아오기
		//
		ArrayList<String> genreList= new ArrayList<String>(service.getGenre(post.getGameName()));
		request.setAttribute("genreList", genreList);

		//댓글 받아오기
		List<CommentVO> cList= service.getComment(postId);
		request.setAttribute("cList", cList);
		
		
		request.getRequestDispatcher("/WEB-INF/view/boardDetail.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardService service = new BoardService(); 
		//댓글 달기
		CommentVO vo = new CommentVO();
		String comment= request.getParameter("comment");
		int postId = 0;
		try {			
			postId= Integer.parseInt(request.getParameter("postid")); 
		} catch (Exception e) {
			System.out.println("에러남??");
		}
		vo.setCmt(comment);
		vo.setPostId(postId);
		System.out.println(postId);
		
		//댓글쓴 사람의 닉네임 가져오기
		MemberVO mvo = (MemberVO) request.getSession().getAttribute("lgnss");	
		String nickname= mvo.getNickname();
		vo.setNickname(nickname);
		
		int result = service.comment(vo);
		
		response.sendRedirect(request.getContextPath()+"/detail?postId="+postId);
	}

}

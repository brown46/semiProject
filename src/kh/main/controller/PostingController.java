package kh.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kh.member.model.service.BoardService;
import kh.member.model.vo.BoardVO;
import kh.member.model.vo.GameGenreVO;
import kh.member.model.vo.MemberVO;

/**
 * Servlet implementation class PostingController
 */
@WebServlet("/posting")
public class PostingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String input =request.getParameter("input");

		if(input!=null) {
			List<String> list = new ArrayList<>();
			System.out.println("input:"+input.trim() );
			System.out.println("--------------------------");
			for(String s :input.trim().split(" ")  ) {
				list.add(s);
				System.out.println(s);
			}
		request.getSession().setAttribute("list", list);
		}
		BoardService service = new BoardService();
		List<String> genreList= service.getGenre();
		
		request.setAttribute("genreList",genreList);
		request.getRequestDispatcher("WEB-INF/view/posting.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postTitle= request.getParameter("postTitle");
		String gameTitle= request.getParameter("gameTitle");
		String contents = request.getParameter("contents");

		//게시글 처리
		MemberVO mvo =  (MemberVO) request.getSession().getAttribute("lgnss");
		
		
	
		
		System.out.println(postTitle);
		System.out.println(gameTitle);
		System.out.println(contents);
		
		BoardService service = new  BoardService();
		BoardVO bvo = new BoardVO();
		
		int count= service.getGameNameCount(gameTitle); // 수정해야됨 game_t에서 검색으로 
		System.out.println(count);
		
//		private int postId;
//		private String postName;
//		private String id;
//		private String nickname;
//		private String gameName;
//		private Date nowDate;
//		private String contents;
		bvo.setPostName(postTitle);
		bvo.setId(mvo.getId());
		bvo.setNickname(mvo.getNickname());
		bvo.setGameName(gameTitle);
		bvo.setContents(contents);
		
		if(count==0) {
			service.addGame(gameTitle);
		}
		int result= service.posting(bvo);
		if(result==1) {
			System.out.println("작성 성공");
		}else{
			System.out.println("작성 실패");
		}
		
		//장르 처리
		ArrayList<String> genres= (ArrayList<String>) request.getSession().getAttribute("list");
		request.getSession().removeAttribute("list");
//		System.out.println(genres); 
		
		for(int i=0; i<genres.size();i++) {
			System.out.println(genres.get(i));
			GameGenreVO gg= new GameGenreVO();
			gg.setGenreName(genres.get(i).trim());	
			gg.setGameName(gameTitle);
			boolean isDup =service.getGGcount(gg);
			System.out.println(isDup);
			System.out.println(gg);
			if(!isDup) {
				service.addGameGenre(gg);				
			}
			
		}
		
		
//		//파일 업로드
//		 String fileWriter = request.getParameter("fileWriter");
//		// 파일 설명
//		 String fileDescription = request.getParameter("fileDescription");
//		// 파일 이름
//		 Part part = request.getPart("fileName");
//	        String fileName = getFilename(part);
//	        if (!fileName.isEmpty()) {
//	            part.write("C:\\uploadTest\\"+fileName);
//	        }
//		
//	        // 응답 작성
//	        PrintWriter out = response.getWriter();
//	        out.print("작성자: " + fileWriter + "<br>");
//	        out.print("파일명:<a href='FileDownloadTest?fileName=" + fileName + "'> " + fileName + "</a href><br>"); 
//	        out.print("파일설명: "+ fileDescription + "<br>"); // 다운로드 추가
//	        out.print("파일크기: " + part.getSize() + " bytes" + "<br>");
		
		response.sendRedirect(request.getContextPath()+"/board");
	}


}

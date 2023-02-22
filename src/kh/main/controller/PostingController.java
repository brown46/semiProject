package kh.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.member.model.service.BoardService;
import kh.member.model.vo.BoardVO;
import kh.member.model.vo.GameGenreVO;
import kh.member.model.vo.ImgVO;
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

		//이미지 이름
		String rawname ="";
		String[] splitname=null;
		String img ="";
		if(request.getParameter("img").length()!=0) {
			rawname = request.getParameter("img");
			splitname= rawname.split("\\\\") ;
			img = splitname[2]; 
		}
//		C:\fakepath\화면 캡처 2023-02-16 112851.png
		
		System.out.println("이미지 이름: "+img);
		
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
		
		
		
		//이미지 처리
//		PrintWriter out = response.getWriter();
//		String savePath = "upload";//다운로드 경로
//		int uploadFileSizeLimit = 5 * 1024 * 1024;
//		String encType = "UTF-8";
//		ServletContext context = getServletContext();
//		String uploadFilePath = context.getRealPath(savePath);
//		System.out.println("서버상의 실제 디렉토리 :"+uploadFilePath);
//		
//		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,new DefaultFileRenamePolicy());
//		String imgName = multi.getFilesystemName("uploadFile");
//		request.getSession().setAttribute("imgName",  multi.getParameter("imgName"));
		
		//img길이가 0이 아닐 때 조건 추가
		if(img.length()!=0) {
			ImgVO imgvo = new ImgVO();			
			int pid= service.getLastPID();
//			imgvo.setImgName("임시이름");
			imgvo.setImgName(img);
			imgvo.setPostId(pid);//postid를 받아와야됨
			System.out.println("확인");
			System.out.println(imgvo);		
			int imgResult=0;
			int imgCount=1;
			//이미지 업로드는 하나만
			imgCount = service.getImgCount(imgvo);
			System.out.println(imgCount);
			//이미 있다면 업데이트. 나중에 추가 
			
			if(imgCount==0) {
				imgResult= service.uploadImg(imgvo);
			}
		
		}
		
		response.sendRedirect(request.getContextPath()+"/board");
	}


}

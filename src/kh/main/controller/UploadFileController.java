package kh.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.member.model.service.BoardService;
import kh.member.model.vo.ImgVO;



/**
 * Servlet implementation class FileUploadController
 */
@WebServlet("/uploadfile")
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/uploadFile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		int postId=0;
//		System.out.println(request.getSession().getAttribute("postId"));
//		postId=Integer.parseInt((String)request.getSession().getAttribute("postId"));
//		
//		System.out.println(postId);
		
		
		PrintWriter out = response.getWriter();
		String savePath = "upload";//다운로드 경로
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리 :"+uploadFilePath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,new DefaultFileRenamePolicy());
		String imgName = multi.getFilesystemName("uploadFile");
		
		if(imgName==null) {
			System.out.print("파일 업로드 되지 않았음");
		}else { // 파일이 업로드 되었을때ㅋ
			request.getSession().setAttribute("imgName",  multi.getParameter("imgName"));
			out.println("<br> 파일명 : " + imgName);
			imgName="임의변환";
			//posting에서 get방식으로 postid를 보내고 이곳에서 postid와 filename을 테이블에 저장 
//			BoardService bs = new BoardService();
			
			
		response.sendRedirect(request.getContextPath()+"/posting");
		
		}
		
		
	}

}

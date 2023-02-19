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
 * Servlet implementation class UpdatePostController
 */
@WebServlet("/updateinfo")
public class UpdateInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo =  (MemberVO) request.getSession().getAttribute("lgnss");
		request.setAttribute("info", vo);
		
		request.getRequestDispatcher("/WEB-INF/view/updateInfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname= (String) request.getParameter("nickname");
		String email= (String) request.getParameter("email");
		String newPwd= (String) request.getParameter("newPwd");
		String chkNewPwd= (String) request.getParameter("chkNewPwd");
		System.out.println(nickname );
		System.out.println(email );
		System.out.println(newPwd );
		System.out.println(chkNewPwd );
		MemberVO vo =  (MemberVO) request.getSession().getAttribute("lgnss");
		MemberService service = new MemberService();
		request.setAttribute("info", vo);
		
		String msg= "";
		boolean error =false;
		//닉네임 변경이 없을 경우
		//닉네임 변경이 있을 경우 - null, 중복 체크 후 업데이트
		if((vo.getNickname()!=nickname) && (nickname!=null)) {
			MemberVO dupNick = new MemberVO();
			dupNick.setNickname(nickname);
			int result= service.nickDupChk(dupNick);
			if(result==0) {
				dupNick.setId(vo.getId());
				dupNick.setNickname(nickname);
			   service.updateNick(dupNick);
			   msg+="닉네임이 변경 완료되었습니다.\n";
				//닉네임 변경 완료 
			}else {
				msg+="중복된 닉네임이 존재합니다\n";
				error=true;
				//닉네임 중복
			}
			
		}
		
		//이메일 변경이 없을 경우
		//변경이 있을 경우 - null 체크 
		if(!(vo.getEmail().equals(email)) && (email!=null)) {
			MemberVO evo = new MemberVO();
			evo.setEmail(email);
			evo.setId(vo.getId());
			service.updateEmail(evo);
			
			//이메일 변경 완료
			msg+="이메일이 변경 완료되었습니다.\n";
		}
		
		//비밀번호 둘다 null 일 경우
		//비밀번호 확인과 다를 경우
		if(!newPwd.equals(chkNewPwd)) {
			msg+="비밀번호가 일치하지 않습니다.\n";
			error=true;
			//비밀번호가 일치하지 않습니다.
		}
		
		
		//현재 비밀번호과 같을 경우
		//새 비밀번호 확인 후 같을 경우 업데이트 
		if(newPwd.equals(chkNewPwd)) {
			
			if(newPwd.equals(vo.getPassword()) ) {
				msg+="이전과 같은 비밀번호는 사용할 수 없습니다.\n";
				error=true;
			}else if((newPwd!=null&&!newPwd.isEmpty())&&(chkNewPwd!=null&&!chkNewPwd.isEmpty())) {
				MemberVO pvo = new MemberVO();
				pvo.setPassword(newPwd);
				pvo.setId(vo.getId());
				service.updatePassword(pvo);
				msg+="비밀번호 변경이 완료되었습니다.";
				System.out.println("비밀번호 변경");
				System.out.println(request.getContextPath()+"/logout");
//				response.sendRedirect(request.getContextPath()+"/logout");
				//업데이트 완료
			}
		} 
		response.getWriter().print(msg);
		request.getSession().setAttribute("updateError", error);
		request.getSession().setAttribute("updateMsg", msg);


		
	}

}

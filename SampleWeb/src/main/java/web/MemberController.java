package web;

import java.io.IOException;

import dao.MemberDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * "/member"にアクセスされた場合の処理
     * "/jsp/newmember-mailaddress-view.jsp"に遷移する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/newmember-mailaddress-view.jsp");
        dispatcher.forward(request, response);
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getParameter("path");
		
		switch (path) {
			
		//mailaddress-view.jspからの遷移
			case "mailaddress-view":
				
				String email = request.getParameter("mailaddress");
				
				if( email.trim().length() == 0 ){
					request.setAttribute("message", "メールアドレスは必須入力項目です。");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/newmember-mailaddress-view.jsp");
					dispatcher.forward(request, response);
					
				}else {
					MemberDAO mDao= new MemberDAO();
					boolean kekka = mDao.mailCheck(email);
					if( kekka == true ) {
						//みつかった＝既に登録されています
						request.setAttribute("message", "すでに登録されています。");
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/newmember-mailaddress-view.jsp");
						dispatcher.forward(request, response);
						
					}else {
						//みつからなかった＝登録ページへ
						request.setAttribute("email", email);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/newmember-input-view.jsp");
						dispatcher.forward(request, response);
					}
					
				}
				break;	
				
		//input-view.jspからの遷移
			case "newmember-input":
                
				// 入力パラメータを取得
				String memberId = request.getParameter("memberId");
				String memberName  = request.getParameter("memberName");
				String gender = request.getParameter("gender");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String password = request.getParameter("password");
				String passwordChk = request.getParameter("passwordChk");
				
				// 入力チェック

				MemberDAO mDao = new MemberDAO();
				//mDao.insertMember(memberId, memberName,gender,address,phone,password);
				
				break;
                
        }
		
		
	}

}

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
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/newmember-mailaddress-view.jsp");
        dispatcher.forward(request, response);
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				
			}
			
		}
	}

}

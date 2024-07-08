package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	
	// コンストラクタでDBに接続した情報を持つフィールド。
	// これはMemberDAO全体で利用するため、フィールドとして定義する
	private Connection con;

	// コンストラクタ
	public MemberDAO() {
		//DBに接続する
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/acompany";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url,user,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public boolean mailCheck( String email ) {
		
		// 本当は、"SELECT * FROM member WHERE memberId = ?;";と定義する
		String sql = "SELECT * FROM member WHERE memberId = '" + email + "';";
		
		Statement smt;
		try {
			// Statement オブジェクトを作成し、
			smt = con.createStatement();
			// SQLクエリを実行します。ResultSet オブジェクトに結果が格納され、
			ResultSet rs = smt.executeQuery(sql);
			
			// rs.next() メソッドを使用して結果セットにレコードが存在するかどうかを確認します。
			if( rs.next() ) {
				return true;
				
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}

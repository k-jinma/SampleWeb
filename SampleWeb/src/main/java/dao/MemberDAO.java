package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	
	private ConnectionManager cm;
	private Connection con;
	
	// コンストラクタ
	public MemberDAO() {
		cm = ConnectionManager.getInstance();
		con = cm.getConnection();
	}
	
	public boolean mailCheck( String email ) {
		
		// 本当は、"SELECT * FROM member WHERE memberId = ?;";と定義する
		String sql = "SELECT * FROM members WHERE member_id = '" + email + "';";
		
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

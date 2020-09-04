package basic.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnectionDB {
	
	
	public ObservableList<Student> getStList() {
		Connection conn=DBConnection.getConnection();
		ObservableList<Student> sts=FXCollections.observableArrayList();
		try {
		String sql="select * from new_st";
		PreparedStatement pstmt=conn.prepareStatement("select * from new_st");
		ResultSet rs=pstmt.executeQuery();
		int idx=0;
		while(rs.next()) {
			Student st=new Student();
			int id=rs.getInt("id");
			st.setid(id);
			String name=rs.getString("name");
			st.setName(name);
			int Korean=rs.getInt("Korean");
			st.setKorean(Korean);
			int English=rs.getInt("English");
			st.setEnglish(English);
			int Math=rs.getInt("Math");
			st.setMath(Math);
			sts[idx++]=st;
			
		}
		System.out.println("---- end of data --");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sts;
	}
}

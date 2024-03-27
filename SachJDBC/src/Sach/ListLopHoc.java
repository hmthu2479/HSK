package Sach;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListLopHoc implements Serializable{
	ArrayList<lopHoc> dslh;
	lopHoc lh;
	Connection con;
	
	public ListLopHoc() {
		dslh = new ArrayList<lopHoc>();
		lh = new lopHoc();
	}
	
	public ArrayList<lopHoc> docTuBang(){
		try {
			con = db.getInstance().getConnection();
			String sql = "Select * from lopHoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLop = rs.getString(1);
				String tenLop = rs.getString(2);
				String gvcn = rs.getString(3);
				lopHoc s = new lopHoc(maLop, tenLop, gvcn);
				dslh.add(s);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dslh;
	}
	public boolean create(lopHoc p) {
		con = db.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into lopHoc values(?, ?, ?)");
			stmt.setString(1,p.getMaLop());
			stmt.setString(2,p.getTenLop());
			stmt.setString(3,p.getGvcn());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean update(lopHoc p) {
		con = db.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("update lopHoc " + "set tenLop = ?," + "gvcn = ? " + "where maLop = ? ");
			stmt.setString(1, p.getTenLop());
			stmt.setString(2, p.getGvcn());
			stmt.setString(3, p.getMaLop());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String malop) {
		con = db.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("delete from lopHoc where maLop = ?");
			stmt.setString(1,malop);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getalltbNhanVien() {
		ArrayList<PhongBan> dspban = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhongBan";
			java.sql.Statement statement = con.createStatement();
			//thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//duyệt trên kết quả trả về
			while(rs.next()) { //di chuyển con trỏ xuống bản ghi kế tiếp
				String maPB = rs.getString("maPhong");
				String tenPB = rs.getString(2);
				PhongBan pBan = new PhongBan(maPB,tenPB);
				dspban.add(pBan);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dspban;
	}
}

package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_DAO {
	public NhanVien_DAO() {
		
	}
	public ArrayList<NhanVien> getalltbNhanVien() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien";
			java.sql.Statement statement = con.createStatement();
			//thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//duyệt trên kết quả trả về
			while(rs.next()) { //di chuyển con trỏ xuống bản ghi kế tiếp
				int maNV = rs.getInt(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				float luong = rs.getFloat(6);
				PhongBan pBan = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsnv;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoMaNV(int id) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhanVien where maNV = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			//thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//duyệt trên kết quả trả về
			while(rs.next()) { //di chuyển con trỏ xuống bản ghi kế tiếp
				int maNV = rs.getInt(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				float luong = rs.getFloat(6);
				PhongBan pBan = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return dsnv;
	}
	public ArrayList<NhanVien> getNhanVienTheoPhongBan(String idpb) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhanVien where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, idpb);
			//thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			//duyệt trên kết quả trả về
			while(rs.next()) { //di chuyển con trỏ xuống bản ghi kế tiếp
				int maNV = rs.getInt(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				float luong = rs.getFloat(6);
				PhongBan pBan = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return dsnv;
	}
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("update NhanVien set hoNV=?, tenNV=?" + "tuoiNV=?, phai=?, luong=?, phongban=?" + "where maNV=?");
			statement.setString(1, nv.getHoNV());
			statement.setString(2, nv.getTenNV());
			statement.setInt(3, nv.getTuoi());
			statement.setBoolean(4, nv.getPhai);;
			statement.setFloat(5, nv.getTienLuong());
			statement.setString(6, nv.getPhong().getMaPhongBan());
			statement.setInt(7, nv.getMaNV());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}

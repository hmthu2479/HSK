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
	//get all table NhanVien
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
			while(rs.next()) {
			    int maNV = rs.getInt(1);
			    String hoNV = rs.getString(2);
			    String tenNV = rs.getString(3);
			    int tuoi = rs.getInt(4);
			    boolean phai = rs.getBoolean(5);
			    float luong = rs.getFloat(6);
			    PhongBan pBan = new PhongBan(rs.getString("maPhong"));
			    
			    NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
			    dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsnv;
	}
	//get NhanVien by MaNV
/*	public ArrayList<NhanVien> getNhanVienTheoMaNV(int id) {
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
	//get NhanVien by PhongBan
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
	}*/
	public boolean create(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("insert into " + "NhanVien values (?,?,?,?,?,?,?)" );
			statement.setInt(1, nv.getMaNV());
			statement.setString(2, nv.getHoNV());
			statement.setString(3, nv.getTenNV());
			statement.setInt(4, nv.getTuoi());
			statement.setBoolean(5, nv.isPhai());;
			statement.setFloat(6, nv.getTienLuong());
			statement.setString(7, nv.getPhong().getMaPhongBan());
			
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
	public boolean update(NhanVien nv) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement statement = null;
	    int n = 0;
	    try {
	        statement = con.prepareStatement("update NhanVien set hoNV=?, tenNV=?, tuoiNV=?, phai=?, luong=?, phongban=? where maNV=?");
	        statement.setString(1, nv.getHoNV());
	        statement.setString(2, nv.getTenNV());
	        statement.setInt(3, nv.getTuoi());
	        statement.setBoolean(4, nv.isPhai());
	        statement.setFloat(5, nv.getTienLuong());
	        statement.setString(6, nv.getPhong().getMaPhongBan());
	        statement.setInt(7, nv.getMaNV());
	        n = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return n > 0;
	}
	
	public boolean delete(int maNV) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;

        try {
            statement = con.prepareStatement("DELETE FROM NhanVien WHERE maNV=?");
            statement.setInt(1, maNV);
            n = statement.executeUpdate();

            return n > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return false;
     }
}

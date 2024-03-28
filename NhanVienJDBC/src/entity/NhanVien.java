package entity;

import java.util.Objects;

public class NhanVien {
	private String hoNV, tenNV;
	private boolean Phai;
	private int maNV, tuoi;
	private float tienLuong;
	private PhongBan phong;
	
	
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public boolean isPhai() {
		return Phai;
	}
	public void setPhai(boolean phai) {
		Phai = phai;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public float getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(float tienLuong) {
		this.tienLuong = tienLuong;
	}
	public PhongBan getPhong() {
		return phong;
	}
	public void setPhong(PhongBan phong) {
		this.phong = phong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	
	
	public NhanVien(String hoNV, String tenNV, boolean phai, int maNV, int tuoi, float tienLuong, PhongBan phong) {
		super();
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		Phai = phai;
		this.maNV = maNV;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
		this.phong = phong;
	}
	public NhanVien(String ma) {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "NhanVien [hoNV=" + hoNV + ", tenNV=" + tenNV + ", Phai=" + Phai + ", maNV=" + maNV + ", tuoi=" + tuoi
				+ ", tienLuong=" + tienLuong + ", phong=" + phong + "]";
	}
	public static void main(String[] args) {
		
	}
	
	
}
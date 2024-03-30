package entity;

import java.util.Objects;

public class NhanVien {
	private String hoNV, tenNV;
	private boolean Phai;
	private int maNV, tuoi;
	private float tienLuong;
	private PhongBan phong;
	
	public NhanVien(int maNV, String hoNV, String tenNV, int tuoi, boolean phai, float tienLuong, PhongBan phong) {
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		Phai = phai;
		this.tienLuong = tienLuong;
		this.phong = phong;
	}

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
	

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", Phai=" + Phai + ", tuoi=" + tuoi
				+ ", tienLuong=" + tienLuong + ", phong=" + phong + "]";
	}

	public static void main(String[] args) {
		
	}
	
	
}
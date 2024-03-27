package Sach;

public class lopHoc {
	private String maLop;
	private String tenLop;
	private String gvcn;
	public lopHoc(String maLop, String tenLop, String gvcn) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.gvcn = gvcn;
	}
	public lopHoc(String maLop) {
		this(maLop,"tên lớp","gvcn");
	}
	public lopHoc() {
		this("mã lớp");
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public String getGvcn() {
		return gvcn;
	}
	public void setGvcn(String gvcn) {
		this.gvcn = gvcn;
	}

	
	@Override
	public String toString() {
		return "Lophoc [maLop=" + maLop + ", tenLop=" + tenLop + ", gvcn=" + gvcn + "]";
	}
	
	
}

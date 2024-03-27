package nhanVienFileIO;

import java.util.ArrayList;

public class NhanVien_Collection {
	private ArrayList<NhanVien> dsNV;
	public NhanVien_Collection() {
		dsNV = new ArrayList<NhanVien>();
	}
	
	public boolean themNV(NhanVien nv) {
	    if (dsNV.contains(nv)) {
	        return false;
	    } else {
	        dsNV.add(nv);
	        return true;
	    }
	}
	
	/*public boolean xoaNV(String ma) {
	    NhanVien xoaNV = null;
	    for (NhanVien nv : dsNV) {
	        if (nv.getMaNV().equals(ma)) {
	            xoaNV = nv;
	            break;
	        }
	    }
	    if (xoaNV != null) {
	        dsNV.remove(xoaNV);
	        return true;
	    } else {
	        return false;
	    }
	}*/
	public boolean xoaNV(String ma) {
	    return dsNV.removeIf(nv -> nv.getMaNV().equals(ma));
	}
	
	public NhanVien tim(String ma) {
		NhanVien nv = new NhanVien(ma);
		if(dsNV.contains(nv))
			return dsNV.get(dsNV.indexOf(nv));
		return null;
	}
	
	public ArrayList<NhanVien> getDsNV(){
		return dsNV;
	}
	
	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV=dsNV;
	}
	
	public NhanVien getElement(int index) {
		if(index<0 || index>=dsNV.size())
			return null;
		return dsNV.get(index);
	}
	
	public int getSize() {
		return dsNV.size();
	}
}

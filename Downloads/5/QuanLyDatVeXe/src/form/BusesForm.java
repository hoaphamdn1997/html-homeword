package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Location;
import model.bean.Province;
import model.bean.Trip;

public class BusesForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maChuyenXe,maXe,maChang;
	private int giaVe,thoiGianDiChuyen;
	private String diemDi,diemDen,gioXuatPhat,gioToiNoi,submit,listBusJson,
	maTinhXuatPhat,maTinhDen,maHuyenXuatPhat,maHuyenDen,listTripJson,tenTinh,
	tenHuyen,ngayXuatPhat,tenXe,bienSo,ngayKetThuc,listRepeatJson;
	private ArrayList<Trip> ListTrip;
	private ArrayList<Location> ListLocation;
	private ArrayList<Province> listProvince;
	
	
    
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getListRepeatJson() {
		return listRepeatJson;
	}
	public void setListRepeatJson(String listRepeatJson) {
		this.listRepeatJson = listRepeatJson;
	}
	public String getBienSo() {
		return bienSo;
	}
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getNgayXuatPhat() {
		return ngayXuatPhat;
	}
	public void setNgayXuatPhat(String ngayXuatPhat) {
		this.ngayXuatPhat = ngayXuatPhat;
	}
	public int getThoiGianDiChuyen() {
		return thoiGianDiChuyen;
	}
	public void setThoiGianDiChuyen(int thoiGianDiChuyen) {
		this.thoiGianDiChuyen = thoiGianDiChuyen;
	}
	public String getTenTinh() {
		return tenTinh;
	}
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	public String getTenHuyen() {
		return tenHuyen;
	}
	public void setTenHuyen(String tenHuyen) {
		this.tenHuyen = tenHuyen;
	}
	public String getListTripJson() {
		return listTripJson;
	}
	public void setListTripJson(String listTripJson) {
		this.listTripJson = listTripJson;
	}
	public int getMaChang() {
		return maChang;
	}
	public void setMaChang(int maChang) {
		this.maChang = maChang;
	}
	public String getMaTinhXuatPhat() {
		return maTinhXuatPhat;
	}
	public void setMaTinhXuatPhat(String maTinhXuatPhat) {
		this.maTinhXuatPhat = maTinhXuatPhat;
	}
	public String getMaTinhDen() {
		return maTinhDen;
	}
	public void setMaTinhDen(String maTinhDen) {
		this.maTinhDen = maTinhDen;
	}
	public String getMaHuyenXuatPhat() {
		return maHuyenXuatPhat;
	}
	public void setMaHuyenXuatPhat(String maHuyenXuatPhat) {
		this.maHuyenXuatPhat = maHuyenXuatPhat;
	}
	public String getMaHuyenDen() {
		return maHuyenDen;
	}
	public void setMaHuyenDen(String maHuyenDen) {
		this.maHuyenDen = maHuyenDen;
	}
	public ArrayList<Province> getListProvince() {
		return listProvince;
	}
	public void setListProvince(ArrayList<Province> listProvince) {
		this.listProvince = listProvince;
	}
	public String getListBusJson() {
		return listBusJson;
	}
	public void setListBusJson(String listBusJson) {
		this.listBusJson = listBusJson;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<Location> getListLocation() {
		return ListLocation;
	}
	public void setListLocation(ArrayList<Location> listLocation) {
		ListLocation = listLocation;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public ArrayList<Trip> getListTrip() {
		return ListTrip;
	}
	public void setListTrip(ArrayList<Trip> listTrip) {
		ListTrip = listTrip;
	}
	public int getMaChuyenXe() {
		return maChuyenXe;
	}
	public void setMaChuyenXe(int maChuyenXe) {
		this.maChuyenXe = maChuyenXe;
	}
	public int getMaXe() {
		return maXe;
	}
	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}
	public int getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}
	public String getDiemDi() {
		return diemDi;
	}
	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}
	public String getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}
	public String getGioXuatPhat() {
		return gioXuatPhat;
	}
	public void setGioXuatPhat(String gioXuatPhat) {
		this.gioXuatPhat = gioXuatPhat;
	}
	public String getGioToiNoi() {
		return gioToiNoi;
	}
	public void setGioToiNoi(String gioToiNoi) {
		this.gioToiNoi = gioToiNoi;
	}
	@Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        super.reset(mapping, request);
    }
	
}

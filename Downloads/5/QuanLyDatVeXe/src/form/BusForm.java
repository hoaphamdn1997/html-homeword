package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.BusType;
import model.bean.Ghe;

public class BusForm extends ActionForm {
	private int maXe,maNhaXe,maLoaiXe,soHangGhe,soCotGhe,maXeHienTai;
	private String tenNhaXe,tenLoaiXe;
	private ArrayList<BusType> listBusType;
	
	
	
	public ArrayList<BusType> getListBusType() {
		return listBusType;
	}
	public void setListBusType(ArrayList<BusType> listBusType) {
		this.listBusType = listBusType;
	}
	public String getTenNhaXe() {
		return tenNhaXe;
	}
	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}
	public String getTenLoaiXe() {
		return tenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}
	public int getMaXeHienTai() {
		return maXeHienTai;
	}
	public void setMaXeHienTai(int maXeHienTai) {
		this.maXeHienTai = maXeHienTai;
	}
	private String tenXe,bienSo,chairLayoutJson,submit;
	private ArrayList<Ghe> listGhe;
	
	
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getChairLayoutJson() {
		return chairLayoutJson;
	}
	public void setChairLayoutJson(String chairLayoutJson) {
		this.chairLayoutJson = chairLayoutJson;
	}
	
	public ArrayList<Ghe> getListGhe() {
		return listGhe;
	}
	public void setListGhe(ArrayList<Ghe> listGhe) {
		this.listGhe = listGhe;
	}
	public int getSoHangGhe() {
		return soHangGhe;
	}
	public void setSoHangGhe(int soHangGhe) {
		this.soHangGhe = soHangGhe;
	}
	public int getSoCotGhe() {
		return soCotGhe;
	}
	public void setSoCotGhe(int soCotGhe) {
		this.soCotGhe = soCotGhe;
	}
	
	public int getMaXe() {
		return maXe;
	}
	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}
	public int getMaNhaXe() {
		return maNhaXe;
	}
	public void setMaNhaXe(int maNhaXe) {
		this.maNhaXe = maNhaXe;
	}
	public int getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(int maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getBienSo() {
		return bienSo;
	}
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
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

package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.bean.Bus;
import model.bean.Chuyen;
import model.bean.DiaDiem;
import model.bean.Ghe;
import model.bean.ResultChuyenSearch;
import model.bean.TransportServiceProvider;
import model.bean.User;
import model.bean.VeXe;
import model.bo.BusBO;
import model.bo.ChairBO;
import model.bo.ChuyenBO;
import model.bo.DiaDiemBO;
import model.bo.TransportServiceProviderBO;
import model.bo.TripBO;
import model.bo.UserBO;
import model.bo.VeXeBO;

public class TicketInforAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    VeXeBO veXeBO = new VeXeBO();
	    ChuyenBO chuyenBO = new ChuyenBO();
        DiaDiemBO diaDiemBO = new DiaDiemBO();
        ChairBO chairBO = new ChairBO();
        UserBO userBO = new UserBO();
        TripBO tripBO = new TripBO();
        BusBO busBO = new BusBO();
        TransportServiceProviderBO transportServiceProviderBO = new TransportServiceProviderBO();
	    
	    ArrayList<ResultChuyenSearch> listChuyen = new ArrayList<ResultChuyenSearch>();
	    
	    HttpSession session = request.getSession();
	    if(session.getAttribute("maNguoiDung") != null) {
	        int maNguoiDung = (Integer) session.getAttribute("maNguoiDung");
	        String userName = (String) session.getAttribute("username");
	        
	        User itemUser = userBO.getOneUser(userName);
	        
	        ArrayList<VeXe> itemsVe = veXeBO.getItemsByMND(maNguoiDung);
	        for (VeXe veXe : itemsVe) {
	            Chuyen itemChuyen = chuyenBO.getItemByMCX(veXe.getMaChuyenXe());
	            TransportServiceProvider nhaXe = transportServiceProviderBO.getItemsForSearch(itemChuyen.getMaChuyenXe());
	            DiaDiem diaDiemDi = diaDiemBO.getDiemDiByMaChang(itemChuyen.getMaChang());
	            DiaDiem diaDiemDen = diaDiemBO.getDiemDenByMaChang(itemChuyen.getMaChang());
	            int soGheTrong = chairBO.getSoGheTrong(itemChuyen.getMaChuyenXe());
	            //String ngaygioxp = veXeBO.getNgayGioXP(itemChuyen.getMaChuyenXe());
	            int tgdc = tripBO.getTravelingTimeByTipId(itemChuyen.getMaChang());
	            int maXe = tripBO.getMaXeByMaChang(itemChuyen.getMaChang());
	            Bus xe = busBO.getOneBusByBusId(maXe);
	            
	            ArrayList<VeXe> listVe = veXeBO.getItemsByMCX(veXe.getMaChuyenXe());
	            for (VeXe veXe2 : listVe) {
                    Ghe itemGhe = veXeBO.getItemByMaGhe(veXe2.getMaGhe());
                    veXe2.setMaSoGhe(itemGhe.getMaSoGhe());
                }
	            
	            ResultChuyenSearch resultChuyenSearch = new ResultChuyenSearch(nhaXe.getTenNhaXe(), diaDiemDi.getTenDiaDiem(), diaDiemDen.getTenDiaDiem(), veXe.getTongTien(), itemChuyen.getGioXuatPhat(), itemChuyen.getGioToiNoi(), 0, soGheTrong, itemChuyen.getMaChuyenXe(), veXe.getSoGheDaDat(), tgdc, listVe, xe);
	            resultChuyenSearch.setNgayXuatPhat(itemChuyen.getNgayXuatPhat().toLocalDate().toString());
	            listChuyen.add(resultChuyenSearch);
            }
	        
	        request.setAttribute("userName", itemUser.getTenNguoiDung());
	        request.setAttribute("listChuyen", listChuyen);
	        return mapping.findForward("render");
	    } else {
	        request.setAttribute("err", "Bạn phải đăng nhập!");
	        return mapping.findForward("fail");
	    }
	}
	
}
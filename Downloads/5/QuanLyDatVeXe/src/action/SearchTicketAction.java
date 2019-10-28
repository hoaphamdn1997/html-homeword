package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SearchTicketForm;
import model.bean.Bus;
import model.bean.Chuyen;
import model.bean.DiaDiem;
import model.bean.ResultChuyenSearch;
import model.bean.TransportServiceProvider;
import model.bo.BusBO;
import model.bo.ChairBO;
import model.bo.ChuyenBO;
import model.bo.DiaDiemBO;
import model.bo.TransportServiceProviderBO;
import model.bo.TripBO;

public class SearchTicketAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");
        ChuyenBO chuyenBO = new ChuyenBO();
        DiaDiemBO diaDiemBO = new DiaDiemBO();
        ChairBO chairBO = new ChairBO();
        TripBO tripBO = new TripBO();
        BusBO busBO = new BusBO();
        TransportServiceProviderBO transportServiceProviderBO = new TransportServiceProviderBO();
        SearchTicketForm searchTicketForm = (SearchTicketForm) form;
        
        //searchTicketForm.setNum(3);
        // System.out.println(searchTicketForm.getNgayDi() + searchTicketForm.getNoiDi()
        // + searchTicketForm.getNoiDen());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = searchTicketForm.getNgayDi();
        Date date1 = dateFormat.parse(date);
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date2 = dateFormat.format(date1);

        // System.out.println(searchTicketForm.getNoiDi() + " " +
        // searchTicketForm.getNoiDen() + " " + date2);
        ArrayList<Chuyen> listChuyenSearch = chuyenBO.getItemsSearch(searchTicketForm.getNoiDi(),
                searchTicketForm.getNoiDen(), date2);
        
        ArrayList<ResultChuyenSearch> listRsChuyenSearch = new ArrayList<ResultChuyenSearch>();
        
        for (Chuyen chuyen : listChuyenSearch) {
            TransportServiceProvider nhaXe = transportServiceProviderBO.getItemsForSearch(chuyen.getMaChuyenXe());
            DiaDiem diaDiemDi = diaDiemBO.getDiemDiByMaChang(chuyen.getMaChang());
            DiaDiem diaDiemDen = diaDiemBO.getDiemDenByMaChang(chuyen.getMaChang());
            int soGheTrong = chairBO.getSoGheTrong(chuyen.getMaChuyenXe());
            int tgdc = tripBO.getTravelingTimeByTipId(chuyen.getMaChang());
            

            int maXe = tripBO.getMaXeByMaChang(chuyen.getMaChang());
            Bus xe = busBO.getOneBusByBusId(maXe);
            
            ResultChuyenSearch resultChuyenSearch = new ResultChuyenSearch(nhaXe.getTenNhaXe(), diaDiemDi.getTenDiaDiem(), diaDiemDen.getTenDiaDiem(), chuyen.getGiaVe(), chuyen.getGioXuatPhat(), chuyen.getGioToiNoi(), 0, soGheTrong, chuyen.getMaChuyenXe(), tgdc, xe);
            listRsChuyenSearch.add(resultChuyenSearch);
        }
        /*for (ResultChuyenSearch resultChuyenSearch : listRsChuyenSearch) {
            System.out.println(resultChuyenSearch.getTenNhaXe());
        }*/
        request.setAttribute("listRsChuyenSearch", listRsChuyenSearch);
        //System.out.println(listChuyenSearch.size());
        //for (Chuyen chuyen : listChuyenSearch) {
        //    System.out.println(chuyen.getNgayXuatPhat() + " " + searchTicketForm.getNoiDi());
        //}

        // System.out.println(date2);
        // java.util.Date startingdateparsed = dateFormat.parse(date);
        // java.sql.Date startdatingparse = new
        // java.sql.Date(startingdateparsed.getTime());
        // dateFormat.parse(temp[2])
        // dateFormat.parse(date);
        // String date = request.getParameter("departDate");
        // System.out.println(startingdateparsed + " - " + startdatingparse);
        return mapping.findForward("render");
    }

}

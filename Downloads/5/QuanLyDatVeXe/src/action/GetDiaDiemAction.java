/**
 * GetCountriesAction.java
 *
 * Version 1.0
 *
 * Date 14/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 14/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import form.DistrictForm;
import model.bean.DiaDiem;
import model.bean.District;
import model.bo.DiaDiemBO;
import model.bo.DistrictBO;

public class GetDiaDiemAction extends Action{

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        DiaDiemBO diadiemBO = new DiaDiemBO();
        ArrayList<DiaDiem> listDiaDiem = diadiemBO.getItems();
        Gson gson = new Gson();
        String json = gson.toJson(listDiaDiem);
        request.setAttribute("listDiadiem", json);
        //System.out.println(json);
        /*for (District district : listDistrict) {
            System.out.println("1" + district.getName());
        }*/
        return mapping.findForward("success");
        
    }

}

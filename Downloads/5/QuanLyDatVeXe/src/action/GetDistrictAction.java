
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import model.bean.District;
import model.bo.DistrictBO;

public class GetDistrictAction extends Action{

	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
       
        DistrictBO districtBO = new DistrictBO();
        ArrayList<District> listDistrict = districtBO.getItems();
        Gson gson = new Gson();
        String json = gson.toJson(listDistrict);
        request.setAttribute("listDistrict", json);
        //System.out.println(json);
        /*for (District district : listDistrict) {
            System.out.println("1" + district.getName());
        }*/
        return mapping.findForward("success");
        
    }


}

package action.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import model.bo.LocationBO;

public class ApiGetDistrictAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String provinceid = request.getParameter("id");
		
		Gson gson = new Gson();
        request.setAttribute("listDistrict", gson.toJson((new LocationBO()).getDistrictByProvinceId(provinceid)));
		return mapping.findForward("success");
	}


	
}


/**
 * HomePageAction.java
 *
 * Version 1.0
 *
 * Date 14/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 14/02/2019     QuanLyDatVeXe       
 */ 


package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DistrictForm;

public class HomePageAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        DistrictForm districtForm = new DistrictForm();
        //submit layout
        if(districtForm.getSubmit()!=null && districtForm.getSubmit().equals("submit"))
        {
            return null;
        } else {
            return mapping.findForward("render");
        }
    }
}
 
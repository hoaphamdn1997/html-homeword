package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Buses;

public class ListBusesForm extends ActionForm {
	ArrayList<Buses> listBuses;
	private int currentPageIndex,paginationNumber;

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public int getPaginationNumber() {
		return paginationNumber;
	}

	public void setPaginationNumber(int paginationNumber) {
		this.paginationNumber = paginationNumber;
	}

	public ArrayList<Buses> getListBuses() {
		return listBuses;
	}

	public void setListBuses(ArrayList<Buses> listBuses) {
		this.listBuses = listBuses;
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

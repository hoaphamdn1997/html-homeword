package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Bus;

public class ListBusForm extends ActionForm{
	ArrayList<Bus> listBus;
	private int currentPageIndex,paginationNumber;

	public int getPaginationNumber() {
		return paginationNumber;
	}

	public void setPaginationNumber(int paginationNumber) {
		this.paginationNumber = paginationNumber;
	}

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public ArrayList<Bus> getListBus() {
		return listBus;
	}

	public void setListBus(ArrayList<Bus> listBus) {
		this.listBus = listBus;
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

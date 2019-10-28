package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Ticket;

public class ListTicketForm extends ActionForm{
	private ArrayList<Ticket> listTicket;
	private int paginationNumber,currentPageIndex;
	private String tenXe,ngatXuatPhat,submit;
	

	

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getNgatXuatPhat() {
		return ngatXuatPhat;
	}

	public void setNgatXuatPhat(String ngatXuatPhat) {
		this.ngatXuatPhat = ngatXuatPhat;
	}

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

	public void setListTicket(ArrayList<Ticket> listTicket) {
		this.listTicket = listTicket;
	}

	public ArrayList<Ticket> getListTicket() {
		return listTicket;
	}

	
	
}

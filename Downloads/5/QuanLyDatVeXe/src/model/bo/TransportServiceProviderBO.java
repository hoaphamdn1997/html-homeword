package model.bo;

import form.TransportServiceProviderForm;
import model.bean.TransportServiceProvider;
import model.dao.TransportServiceProviderDAO;

public class TransportServiceProviderBO {

	public int createTransportServiceProvider(TransportServiceProviderForm transportProviceFrom,int maNguoiDung) {
		return (new TransportServiceProviderDAO()).createTransportServiceProvider(transportProviceFrom,maNguoiDung);
		
	}

	public int getTransportServiceProviderIdByUserId(int userId) {
		return (new TransportServiceProviderDAO()).getTransportServiceProviderIdByUserId(userId);
	}

	public TransportServiceProvider getItemsForSearch(int maChuyenXe) {
		return (new TransportServiceProviderDAO()).getItemsForSearch(maChuyenXe);
	}

}

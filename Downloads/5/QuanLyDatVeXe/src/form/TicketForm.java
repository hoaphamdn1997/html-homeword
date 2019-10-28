package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Location;
import model.bean.User;

public class TicketForm extends ActionForm{
	private String submit,chairLayoutJson,userJson,locationJson;
	private User user;
	private Location pickupLocation,dropLocation;
	private int maChuyen;
	private String an_username,an_fullname,an_phone,an_address;
	
	
	public String getAn_username() {
		return an_username;
	}

	public void setAn_username(String an_username) {
		this.an_username = an_username;
	}

	public String getAn_fullname() {
		return an_fullname;
	}

	public void setAn_fullname(String an_fullname) {
		this.an_fullname = an_fullname;
	}

	public String getAn_phone() {
		return an_phone;
	}

	public void setAn_phone(String an_phone) {
		this.an_phone = an_phone;
	}

	public String getAn_address() {
		return an_address;
	}

	public void setAn_address(String an_address) {
		this.an_address = an_address;
	}

	public int getMaChuyen() {
		return maChuyen;
	}

	public void setMaChuyen(int maChuyen) {
		this.maChuyen = maChuyen;
	}

	public String getLocationJson() {
		return locationJson;
	}

	public void setLocationJson(String locationJson) {
		this.locationJson = locationJson;
	}

	public String getUserJson() {
		return userJson;
	}

	public void setUserJson(String userJson) {
		this.userJson = userJson;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getChairLayoutJson() {
		return chairLayoutJson;
	}

	public void setChairLayoutJson(String chairLayoutJson) {
		this.chairLayoutJson = chairLayoutJson;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Location pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Location getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(Location dropLocation) {
		this.dropLocation = dropLocation;
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

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import form.UserForm;
import model.bean.District;
import model.bean.Province;

public class LocationDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public ArrayList<District> getDistrictByProvinceId(String provinceid) {
		ArrayList<District> listDistrict = new ArrayList<District>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM district where provinceid=?");
            pre.setString(1, provinceid);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	District district = new District();
            	district.setMaHuyen(rs.getString("districtid"));
            	district.setTenHuyen(rs.getString("name"));
            	listDistrict.add(district);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return listDistrict;
	}
	public ArrayList<Province> getAllProvince() {
		ArrayList<Province> listProvince = new ArrayList<Province>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM province");
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Province province = new Province();
            	province.setMaTinh(rs.getString("provinceid"));
            	province.setTenTinh(rs.getString("name"));
            	listProvince.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return listProvince;
	}
	public int addNewLocation(String maTinh,String maHuyen,String tenDiaDiem) {
		System.out.println(maTinh+","+maHuyen+","+tenDiaDiem);
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs= null;
		int locationID=0;
		
        try {
            pre = conn.prepareStatement("insert into DiaDiem(districtid,provinceid,TenDiaDiem) output inserted.MaDiaDiem values(?,?,?)");
            pre.setString(1, maHuyen);
            pre.setString(2, maTinh);
            pre.setString(3, tenDiaDiem);
            
            rs=pre.executeQuery();
            while(rs.next())
            {
            	locationID=rs.getInt("MaDiaDiem");
            }
            return locationID;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return locationID;
	}
	public String getLocationName(String maTinh,String maHuyen) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs= null;
		String locationName="";
		
        try {
            pre = conn.prepareStatement("SELECT dbo.getLocationName(?,?) AS TenDiaDiem ");
            pre.setString(1, maHuyen);
            pre.setString(2, maTinh);
            
            rs=pre.executeQuery();
            while(rs.next())
            {
            	locationName=rs.getString("TenDiaDiem");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return locationName;
	}
}

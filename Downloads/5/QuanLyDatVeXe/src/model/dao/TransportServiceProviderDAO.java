package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import form.TransportServiceProviderForm;
import model.bean.TransportServiceProvider;

public class TransportServiceProviderDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public int createTransportServiceProvider(TransportServiceProviderForm transportProviceFrom, int maNguoiDung) {
		/*SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs = null;
		int lastId=0;
		
        try {
            pre = conn.prepareStatement("INSERT INTO NhaXe(TenNhaXe,DiaChi,SoDienThoai) OUTPUT Inserted.MaNhaXe VALUES(?,?,?)");
            pre.setString(1, transportProviceFrom.getTenNhaXe());
            pre.setString(2, transportProviceFrom.getDiaChi());
            pre.setString(3, transportProviceFrom.getSoDienThoai());
           
            
            rs = pre.executeQuery();
            while(rs.next()) {
            	lastId = rs.getInt("MaNhaXe");
            }
            pre = conn.prepareStatement("UPDATE NguoiDung SET MaNhaXe =? WHERE username = ?");
            pre.setInt(1, lastId);
            pre.setString(2, username);
            return pre.executeUpdate();
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
		return 0;*/
		
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		
        try {
            pre = conn.prepareStatement("INSERT INTO NhaXe(TenNhaXe,DiaChi,SoDienThoai,MaNguoiDung) VALUES(?,?,?,?)");
            pre.setString(1, transportProviceFrom.getTenNhaXe());
            pre.setString(2, transportProviceFrom.getDiaChi());
            pre.setString(3, transportProviceFrom.getSoDienThoai());
            pre.setInt(4, maNguoiDung);
            return pre.executeUpdate();
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
		return 0;
	}
	public int getTransportServiceProviderIdByUserId(int userId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		int tspId=0;
		
        try {
            pre = conn.prepareStatement("SELECT MaNhaXe FROM NhaXe WHERE MaNguoiDung =?");
            pre.setInt(1,userId);
            
            ResultSet rs = pre.executeQuery();
            
            while(rs.next())
            {
            	tspId=rs.getInt("MaNhaXe");
            	//user.setMaNhaXe(rs.getInt("MaNhaXe"));
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
        return tspId;
	}
	public TransportServiceProvider getItemsForSearch(int maChuyenXe) {
	    TransportServiceProvider item = new TransportServiceProvider();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("Select * from NhaXe nhaXe Where nhaXe.MaNhaXe in (Select xe.MaNhaXe from Xe xe Where xe.MaXe in (Select chag.MaXe from Chang chag Where chag.MaChang in (Select chyen.MaChang from Chuyen chyen Where chyen.MaChuyenXe = ?)))");
            pre.setInt(1, maChuyenXe);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                item = new TransportServiceProvider(rs.getInt("MaNhaXe"), rs.getString("TenNhaXe"), rs.getString("SoDienThoai"), rs.getString("DiaChi"));
            }
            return item;
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
	    return item;
	}
	public ArrayList<Integer> getBusIdArrByTrId(int maNhaXe)
	{
		ArrayList<Integer> listBusId = new ArrayList<Integer>();
		SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT MaXe FROM Xe WHERE MaNhaXe=? ");
            pre.setInt(1, maNhaXe);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	listBusId.add(rs.getInt("MaXe"));
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
	    return listBusId;
	}
	public boolean removeTransporter(int maNhaXe) {
		ArrayList<Integer> l = getBusIdArrByTrId(maNhaXe);
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        boolean isSuccess=false;
        try {
        	
        	for(int i=0;i<l.size();i++)
        	{
        		System.out.println("ma Xe "+l.get(i));
        		(new BusDAO()).removeBusByBusId(l.get(i));
        	}
        	
        	
            pre = conn.prepareStatement("DELETE FROM NhaXe WHERE MaNhaXe=?");
            pre.setInt(1, maNhaXe);
            pre.executeUpdate();
            isSuccess=true;
        } catch (SQLException e) {
        	isSuccess=false;
            e.printStackTrace();
        } finally {
            try {
                pre.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	    return isSuccess;
	}
	
	public ArrayList<Integer> getTransIdArrByUserId(int maNguoiDung)
	{
		ArrayList<Integer> listBusId = new ArrayList<Integer>();
		SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT MaNhaXe FROM NhaXe WHERE MaNguoiDung=? ");
            pre.setInt(1, maNguoiDung);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	listBusId.add(rs.getInt("MaNhaXe"));
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
	    return listBusId;
	} 

}

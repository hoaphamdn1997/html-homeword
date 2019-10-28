package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Ghe;

public class ChairDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public ArrayList<Ghe> getChairByBusId(int busId) {
		ArrayList<Ghe> listChair = new ArrayList<Ghe>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM Ghe WHERE MaXe=?");
            pre.setInt(1, busId);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	listChair.add(new Ghe(rs.getInt("MaGhe"), rs.getInt("VtHang"),
            			rs.getInt("VTCot"), rs.getInt("TrangThai"), rs.getInt("Tang"),rs.getInt("MaXe")));
            }
            return listChair;
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
		return listChair;
	}
	public int deleteAllCharByBusId(int busId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("DELETE FROM Ghe WHERE MaXe=?");
            pre.setInt(1, busId);
            return  pre.executeUpdate();
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
	public ArrayList<Ghe> getChairForSellByBusId(int i) {
		ArrayList<Ghe> listChair = new ArrayList<Ghe>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("select Ghe.MaGhe,Ghe.VTHang,Ghe.VTCot,Ghe.TrangThai,Ghe.MaXe,Ghe.Tang,Chuyen.GiaVe,\r\n" + 
            		"            			case \r\n" + 
            		"            			 when Ghe.MaGhe IN (SELECT Ghe.MaGhe FROM Ghe inner join VeXe on Ghe.MaGhe = VeXe.MaGhe\r\n" + 
            		"            									inner join Chuyen on VeXe.MaChuyenXe = Chuyen.MaChuyenXe\r\n" + 
            		"            									where Chuyen.MaChuyenXe=?)\r\n" + 
            		"            								then 0\r\n" + 
            		"            				else 1 \r\n" + 
            		"            			end as TrangThaiDatGhe\r\n" + 
            		"            		 from Chuyen inner join Chang on Chuyen.MaChang = Chang.MaChang\r\n" + 
            		"								inner join Xe on Chang.MaXe = Xe.MaXe\r\n" + 
            		"            		inner join Ghe on Xe.MaXe=Ghe.MaXe \r\n" + 
            		"            		where Chuyen.MaChuyenXe=?");
            pre.setInt(1, i);
            pre.setInt(2, i);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Ghe ghe = new Ghe(rs.getInt("VtHang"), rs.getInt("VTCot"),
            			rs.getInt("TrangThai"), rs.getInt("Tang"),
            			rs.getInt("MaXe"), rs.getInt("MaGhe"), rs.getInt("TrangThaiDatGhe"));
            	ghe.setGiaGhe(rs.getInt("GiaVe"));
            	listChair.add(ghe);
            	
            }
            return listChair;
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
		return listChair;
	}
	public int getSoGheTrong(int maChuyenXe) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		int tspId=0;
		
        try {
            pre = conn.prepareStatement("select count(TrangThaiDatGhe) as availableChairs from (select Ghe.MaGhe,Ghe.VTHang,Ghe.VTCot,Ghe.TrangThai,Ghe.MaXe,Ghe.Tang,Chuyen.GiaVe, \r\n" + 
            		"            		            			case  \r\n" + 
            		"            		            			 when Ghe.MaGhe IN (SELECT Ghe.MaGhe FROM Ghe inner join VeXe on Ghe.MaGhe = VeXe.MaGhe \r\n" + 
            		"            		            									inner join Chuyen on VeXe.MaChuyenXe = Chuyen.MaChuyenXe \r\n" + 
            		"            		            									where Chuyen.MaChuyenXe=?\r\n" + 
            		"																	)\r\n" + 
            		"            		            								then 0 \r\n" + 
            		"            		            				else 1  \r\n" + 
            		"            		            			end as TrangThaiDatGhe \r\n" + 
            		"            		            		 from Chuyen inner join Chang on Chuyen.MaChang = Chang.MaChang \r\n" + 
            		"            										inner join Xe on Chang.MaXe = Xe.MaXe \r\n" + 
            		"            		            		inner join Ghe on Xe.MaXe=Ghe.MaXe  \r\n" + 
            		"            		            		where Chuyen.MaChuyenXe=? and Ghe.TrangThai=1) as getAvailableChairs where TrangThaiDatGhe=1\r\n" + 
            		"										");
            pre.setInt(1,maChuyenXe);
            pre.setInt(2,maChuyenXe);
            
            ResultSet rs = pre.executeQuery();
            
            while(rs.next())
            {
            	tspId=rs.getInt("availableChairs");
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

}

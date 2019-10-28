package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Trip;

public class TripDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public ArrayList<Trip> getAllTripByUserId(int userId) {
		ArrayList<Trip> listTrip = new ArrayList<Trip>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("select cg.MaChang,cg.MaDiaDiemDi,cg.MaDiaDiemDen,x.MaXe,x.TenXe,x.BienSo,d.TenDiaDiem as TenDiemDi,d1.TenDiaDiem as TenDiemDen from Chang cg inner join Xe x on cg.MaXe=x.MaXe \r\n" + 
            		"inner join NhaXe nx on nx.MaNhaXe = x.MaNhaXe \r\n" + 
            		"inner join DiaDiem d on d.MaDiaDiem = cg.MaDiaDiemDi\r\n" + 
            		"inner join DiaDiem d1 on d1.MaDiaDiem = cg.MaDiaDiemDen \r\n" + 
            		"where nx.MaNguoiDung=?");
            pre.setInt(1, userId);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Trip trip = new Trip();
            	trip.setMaChang(rs.getInt("MaChang"));
            	trip.setMaDiaDiemDi(rs.getInt("MaDiaDiemDi"));
            	trip.setMaDiaDiemDen(rs.getInt("MaDiaDiemDen"));
            	trip.setTenDiaDiemDi(rs.getString("TenDiemDi"));
            	trip.setTenDiaDiemDen(rs.getString("TenDiemDen"));
            	trip.setMaXe(rs.getInt("MaXe"));
            	trip.setTenXe(rs.getString("TenXe"));
            	trip.setBienSo(rs.getString("BienSo"));
            	
            	listTrip.add(trip);
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
		return listTrip;
	}
	public int addNewTrip(int maXe, int thoiGianDiChuyen, int maDDXP, int maDDDen) {
		SQLConnection db = new SQLConnection();
		int maChang=0;
		conn = db.getConnect();
        try {
        	
        	ResultSet rs= null;
            pre = conn.prepareStatement("INSERT INTO Chang(MaXe,ThoiGianDiChuyen,MaDiaDiemDi,MaDiaDiemDen) output inserted.MaChang"
            		+ " VALUES(?,?,?,?)");
            pre.setInt(1, maXe);
            pre.setInt(2, thoiGianDiChuyen);
            pre.setInt(3, maDDXP);
            pre.setInt(4, maDDDen);
            rs = pre.executeQuery();
            while(rs.next()) {
            	maChang = rs.getInt("MaChang");
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
		return maChang;
	}
	public int getTravelingTimeByTipId(int maChang) {
		SQLConnection db = new SQLConnection();
		int tgdc=0;
		conn = db.getConnect();
        try {
        	
        	ResultSet rs= null;
            pre = conn.prepareStatement("SELECT * FROM Chang WHERE MaChang=?");
            pre.setInt(1, maChang);
            rs = pre.executeQuery();
            while(rs.next()) {
            	tgdc = rs.getInt("ThoiGianDiChuyen");
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
		return tgdc;
	}
	public ArrayList<Integer> getTripByBusId(int busId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ArrayList<Integer> tspId=new ArrayList<Integer>();

		try {
			pre = conn.prepareStatement("SELECT MaChang FROM Chang WHERE MaXe =?");
			pre.setInt(1,busId);

			ResultSet rs = pre.executeQuery();

			while(rs.next())
			{
				tspId.add(rs.getInt("MaChang"));
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
	public int getMaXeByMaChang(int maChang) {
        SQLConnection db = new SQLConnection();
        int mX=0;
        conn = db.getConnect();
        try {
            
            ResultSet rs= null;
            pre = conn.prepareStatement("SELECT * FROM Chang WHERE MaChang=?");
            pre.setInt(1, maChang);
            rs = pre.executeQuery();
            while(rs.next()) {
                mX = rs.getInt("MaXe");
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
        return mX;
    }
	public int updateTravelingTimeByTripId(int maChang,int time) {
		SQLConnection db = new SQLConnection();
		int tgdc=0;
		conn = db.getConnect();
		int s=0;
        try {
        	
        	ResultSet rs= null;
            pre = conn.prepareStatement("Update Chang SET ThoiGianDiChuyen=? WHERE MaChang=?");
            pre.setInt(1, time);
            pre.setInt(2, maChang);
           s= pre.executeUpdate();
           
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
		return s;
	}

}

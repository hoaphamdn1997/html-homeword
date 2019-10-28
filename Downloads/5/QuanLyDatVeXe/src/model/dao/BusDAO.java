package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import form.BusForm;
import model.bean.Bus;
import model.bean.Ghe;
import model.bo.BusesBO;
import model.bo.TripBO;

public class BusDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public int addNewLayOutChair(Bus bus,int maXe) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
        	String sql = "INSERT INTO Ghe(MaXe,VTHang,VTCot,TrangThai,Tang,MaSoGhe) VALUES";
        	ArrayList<Ghe> listGhe = bus.getListGhe();
        	
        	for(int i=0;i<listGhe.size();i++)
        	{
        		Ghe ghe = listGhe.get(i);
        		sql+="("+maXe+","+ghe.getVtHang()+","+ghe.getVtCot()+","+ghe.getTrangThai()+","+ghe.getTang()+",'"+ghe.getDay()+"'),";
        	}
        	sql=sql.substring(0, sql.length()-1);
        	System.out.println(sql);
            pre = conn.prepareStatement(sql);
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            	if(pre!=null)
                pre.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return -1;
	}
	public ArrayList<Bus> getAllBusByUserId(int userId) {
		ArrayList<Bus> listBus = new ArrayList<Bus>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM Xe x inner join NhaXe n on x.MaNhaXe = n.MaNhaXe WHERE n.MaNguoiDung =?");
            pre.setInt(1, userId);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Bus bus = new Bus();
            	bus.setMaXe(rs.getInt("MaXe"));
            	bus.setTenXe(rs.getString("TenXe"));
            	bus.setMaNhaXe(rs.getInt("MaNhaXe"));
            	bus.setBienSo(rs.getString("BienSo"));
            	bus.setMaLoaiXe(rs.getInt("MaLoaiXe"));
            	listBus.add(bus);
            }
            return listBus;
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
		return listBus;
	}
	public int getRowCountBusByUserId(int attribute) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        ResultSet rs=null;
        try {
            pre = conn.prepareStatement("SELECT COUNT(*) as rowNum FROM Xe x inner join NhaXe n on x.MaNhaXe = n.MaNhaXe WHERE n.MaNguoiDung=?");
            pre.setInt(1, attribute);
            rs= pre.executeQuery();
            rs.next();
            return rs.getInt("rowNum");
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
	public ArrayList<Bus> getPaginationBus(int i,int userId) {
		ArrayList<Bus> listBus = new ArrayList<Bus>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM Xe x inner join NhaXe n on x.MaNhaXe = n.MaNhaXe "
            		+ "inner join LoaiXe l on x.MaLoaiXe = l.MaLoaiXe "
            		+ "WHERE n.MaNguoiDung=? ORDER BY x.MaXe OFFSET "+i+" ROWS FETCH NEXT 5 ROWS ONLY;");
            pre.setInt(1, userId);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Bus bus = new Bus();
            	bus.setMaXe(rs.getInt("MaXe"));
            	bus.setBienSo(rs.getString("BienSo"));
            	bus.setMaNhaXe(rs.getInt("MaNhaXe"));
            	bus.setTenXe(rs.getString("TenXe"));
            	bus.setMaLoaiXe(rs.getInt("MaLoaiXe"));
            	bus.setTenNhaXe(rs.getString("TenNhaXe"));
            	bus.setTenLoaiXe(rs.getString("TenLoaiXe"));
            	listBus.add(bus);
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
		return listBus;
	}
	public int AddNewBus(BusForm busForm, int tspId) {
		SQLConnection db = new SQLConnection();
		int maXe =0;
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("INSERT INTO Xe(TenXe,BienSo,MaNhaXe,MaLoaiXe) output inserted.MaXe"
            		+ " VALUES(?,?,?,?)");
            pre.setString(1, busForm.getTenXe());
            pre.setString(2, busForm.getBienSo());
            pre.setInt(3, tspId);
            pre.setInt(4, busForm.getMaLoaiXe());
            ResultSet rs= pre.executeQuery();
            while(rs.next())
            {
            	maXe = rs.getInt("MaXe");
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
		return maXe;
	}
	public Bus getOneBusByBusId(int parameter) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		Bus bus = new Bus();
        try {
            pre = conn.prepareStatement("SELECT * FROM Xe WHERE MaXe =?");
            pre.setInt(1, parameter);
            
            ResultSet rs = pre.executeQuery();
            
            while(rs.next())
            {
            	bus.setMaXe(rs.getInt("MaXe"));
            	bus.setTenXe(rs.getString("TenXe"));
            	bus.setBienSo(rs.getString("BienSo"));
            	bus.setMaLoaiXe(rs.getInt("MaLoaiXe"));
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
        return bus;
	}
	public boolean EditBus(BusForm busForm) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("UPDATE Xe SET TenXe=?,BienSo=?,MaLoaiXe=? WHERE MaXe = ?");
            pre.setString(1, busForm.getTenXe());
            pre.setString(2, busForm.getBienSo());
            pre.setInt(3, busForm.getMaLoaiXe());
            pre.setInt(4, busForm.getMaXe());
            System.out.println(busForm.getMaXe());
            pre.executeUpdate();
            isSuccess=true;
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
		return isSuccess;
	}
	public boolean removeBusByBusId(int busId) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
        try {
        	 ArrayList<Integer> busesId = (new BusesBO()).getOneBusesByBusId(busId);
        	 
        	 for(int i=0;i<busesId.size();i++)
        	 {
        		 pre = conn.prepareStatement("DELETE VeXe WHERE MaChuyenXe = ?");
                 pre.setInt(1, busesId.get(i));
                 pre.executeUpdate();
                 
                 pre = conn.prepareStatement("DELETE Chuyen WHERE MaChuyenXe = ?");
                 pre.setInt(1, busesId.get(i));
                 pre.executeUpdate();
        	 }
        	
        	 pre = conn.prepareStatement("DELETE Chang WHERE MaXe = ?");
             pre.setInt(1, busId);
             pre.executeUpdate();
        	 
             
        	pre = conn.prepareStatement("DELETE Ghe WHERE MaXe = ?");
            pre.setInt(1, busId);
            pre.executeUpdate();
            
            pre = conn.prepareStatement("DELETE Xe WHERE MaXe = ?");
            pre.setInt(1, busId);
            pre.executeUpdate();
            isSuccess=true;
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
		return isSuccess;
	}
	public int getBusIdByBusesId(int busId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		int busid = 0;
        try {
            pre = conn.prepareStatement("SELECT Xe.MaXe FROM Xe inner join Chang on Xe.MaXe = Chang.MaXe \r\n" + 
            		"inner join Chuyen on Chang.MaChang = Chuyen.MaChang \r\n" + 
            		"WHERE Chuyen.MaChuyenXe=?");
            pre.setInt(1, busId);
            
            ResultSet rs = pre.executeQuery();
            
            while(rs.next())
            {
            	busid = rs.getInt("MaXe");
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
        return busid;
	}
	public ArrayList<Bus> getAllBusByBusTypeId(int bustypeId) {
		ArrayList<Bus> listBus = new ArrayList<Bus>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM Xe x inner join LoaiXe n on x.MaLoaiXe = n.MaLoaiXe WHERE n.MaLoaiXe =?");
            pre.setInt(1, bustypeId);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Bus bus = new Bus();
            	bus.setMaXe(rs.getInt("MaXe"));
            	bus.setTenXe(rs.getString("TenXe"));
            	bus.setMaNhaXe(rs.getInt("MaNhaXe"));
            	bus.setBienSo(rs.getString("BienSo"));
            	bus.setMaLoaiXe(rs.getInt("MaLoaiXe"));
            	listBus.add(bus);
            }
            return listBus;
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
		return listBus;
	}


}

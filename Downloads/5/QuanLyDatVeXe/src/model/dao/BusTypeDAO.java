package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Bus;
import model.bean.BusType;
import model.bean.User;
import model.bo.BusBO;
import model.bo.BusesBO;

public class BusTypeDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public int getFloorNumber(int maXe) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		int floor=0;
        try {
            pre = conn.prepareStatement("select SoTang from LoaiXe inner join Xe on LoaiXe.MaLoaiXe = Xe.MaLoaiXe where Xe.MaXe=?");
            pre.setInt(1, maXe);
            ResultSet rs=  pre.executeQuery();
            while(rs.next()) floor = rs.getInt("SoTang");
            return floor;
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
		return floor;
	}
	public BusType getBusTypeByBusId(int busId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		BusType busType=null;
        try {
            pre = conn.prepareStatement("select * from LoaiXe inner join Xe on LoaiXe.MaLoaiXe = Xe.MaLoaiXe where Xe.MaXe=?");
            pre.setInt(1, busId);
            ResultSet rs=  pre.executeQuery();
            while(rs.next())
            {
            	busType = new BusType();
            	busType.setMaLoaiXe(busId);
            	busType.setSoGhe(rs.getInt("SoGhe"));
            	busType.setMaLoaiXe(rs.getInt("MaLoaiXe"));
            	busType.setSoTang(rs.getInt("SoTang"));
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
        return busType;
	}
	public ArrayList<BusType> getAllBusType() {
		ArrayList<BusType> listBusType = new ArrayList<BusType>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM LoaiXe");
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	BusType busType = new BusType();
            	busType.setMaLoaiXe(rs.getInt("MaLoaiXe"));
            	busType.setTenLoaiXe(rs.getString("TenLoaiXe"));
            	busType.setSoGhe(rs.getInt("SoGhe"));
            	busType.setSoTang(rs.getInt("SoTang"));
            	busType.setMoTa(rs.getString("MoTa"));
            	listBusType.add(busType);
            }
            return listBusType;
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
		return listBusType;
	}
	/**
	 * Thuan
	 * @param id: MaLoaiXe
	 * @return
	 */
	public BusType getBusTypeById(int id) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		BusType busType = null;
		
		String sql = "SELECT * FROM LoaiXe WHERE MaLoaiXe=?";
		try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	busType = new BusType();
            	busType.setMaLoaiXe(rs.getInt("MaLoaiXe"));
            	busType.setTenLoaiXe(rs.getString("TenLoaiXe"));
            	busType.setSoGhe(rs.getInt("SoGhe"));
            	busType.setSoTang(rs.getInt("SoTang"));
            	busType.setMoTa(rs.getString("MoTa"));
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
		return busType;
	}
	
	/**
	 * Thuan
	 * @param id
	 * @param tenLX
	 * @param soGhe
	 * @param soTang
	 * @param moTa
	 * @return
	 */
	public BusType updateBusType(int id, String tenLX, int soGhe,
			int soTang, String moTa) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		BusType busType = null;
		
		String sql = "UPDATE LoaiXe SET TenLoaiXe=?, SoGhe=?, MoTa=?, SoTang=?"
				+ " WHERE MaLoaiXe=?";
		try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, tenLX);
            pre.setInt(2, soGhe);
            pre.setString(3, moTa);
            pre.setInt(4, soTang);
            pre.setInt(5, id);
            pre.executeUpdate();
            System.out.println( pre.executeUpdate());
           
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
		return busType;
	}
	public ArrayList<BusType> getPaginationBusType(int i) {
		ArrayList<BusType> listBusType = new ArrayList<BusType>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			pre = conn.prepareStatement(
					"SELECT * FROM LoaiXe ORDER BY MaLoaiXe OFFSET " + i + " ROWS FETCH NEXT 5 ROWS ONLY;");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				listBusType.add(new BusType(rs.getInt("MaLoaiXe"), rs.getInt("SoGhe"), rs.getInt("SoTang"),
						rs.getString("TenLoaiXe"), rs.getString("MoTa")));
			}
			return listBusType;
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
		return listBusType;
	}

	public int getRowCountBusType() {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement("SELECT COUNT(*) as rowNum FROM LoaiXe ");
			rs = pre.executeQuery();
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
	public void AddBusType(String tenLoaiXe, int soGhe, int soTang, String moTa) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		
		
        try {
            pre = conn.prepareStatement("insert into LoaiXe(TenLoaiXe,SoGhe,SoTang,MoTa) VALUES(?,?,?,?)");
            pre.setString(1, tenLoaiXe);
            pre.setInt(2, soGhe);
            pre.setInt(3, soTang);
            pre.setString(4,  moTa);
            
            pre.executeUpdate();
          
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
	
		
	
	
		
	}
	public boolean removeBusByBusType(int busType) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess = false;
		conn = db.getConnect();
		try {
			ArrayList<Bus> listbus = (new BusBO()).getAllBusByBusTypeId(busType);

			for (Bus bus : listbus) {
				int busId = bus.getMaXe();
				ArrayList<Integer> busesId = (new BusesBO()).getOneBusesByBusId(busId);

				for (int i = 0; i < busesId.size(); i++) {
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
			}
			
			pre = conn.prepareStatement("DELETE LoaiXe WHERE MaLoaiXe = ?");
			pre.setInt(1, busType);
			pre.executeUpdate();
			isSuccess = true;
			
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

}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import form.BusesForm;
import model.bean.Buses;
import model.bo.BusesBO;

public class BusesDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public ArrayList<Integer> getOneBusesByBusId(int busId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ArrayList<Integer> tspId=new ArrayList<Integer>();

		try {
			pre = conn.prepareStatement("SELECT MaChuyenXe FROM Chuyen inner join Chang on Chuyen.MaChang = Chang.MaChang WHERE MaXe =?");
			pre.setInt(1,busId);

			ResultSet rs = pre.executeQuery();

			while(rs.next())
			{
				tspId.add(rs.getInt("MaChuyenXe"));
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
	public int getRowCountBusesByUserId(int userId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs=null;
		try {
			pre = conn.prepareStatement("SELECT COUNT(*)as rowNum from (\r\n" + 
					"SELECT MIN(c.MaChuyenXe) as MaChuyenXe,c.MaChang,c.GioXuatPhat,c.GioToiNoi,MIN(c.NgayXuatPhat) as NgayXuatPhat,d.TenDiaDiem as[DiaDiemDi],d1.TenDiaDiem as[DiaDiemDen],c.GiaVe,x.MaXe \r\n" + 
					"            		 FROM Chuyen c inner join Chang cg on c.MaChang = cg.MaChang  \r\n" + 
					"            							inner join DiaDiem d on cg.MaDiaDiemDi = d.MaDiaDiem \r\n" + 
					"            							inner join DiaDiem d1 on cg.MaDiaDiemDen = d1.MaDiaDiem \r\n" + 
					"            							inner join Xe x on x.MaXe = cg.MaXe \r\n" + 
					"            							inner join NhaXe nx on x.MaNhaXe = nx.MaNhaXe \r\n" + 
					"            		            		WHERE nx.MaNguoiDung=? group by c.MaChang,c.GioXuatPhat,c.GioToiNoi,d.TenDiaDiem ,d1.TenDiaDiem ,c.GiaVe,x.MaXe \r\n" + 
					"								)AS subquery;");
			pre.setInt(1, userId);
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
	public ArrayList<Buses> getPaginationBuses(int i, int userId) {
		ArrayList<Buses> listBuses = new ArrayList<Buses>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			pre = conn.prepareStatement("SELECT MIN(c.MaChuyenXe) as MaChuyenXe,c.MaChang,c.GioXuatPhat,c.GioToiNoi,MIN(c.NgayXuatPhat) as NgayXuatPhat,d.TenDiaDiem as[DiaDiemDi],d1.TenDiaDiem as[DiaDiemDen],c.GiaVe,x.MaXe \r\n" + 
					"            		 FROM Chuyen c inner join Chang cg on c.MaChang = cg.MaChang  \r\n" + 
					"            							inner join DiaDiem d on cg.MaDiaDiemDi = d.MaDiaDiem \r\n" + 
					"            							inner join DiaDiem d1 on cg.MaDiaDiemDen = d1.MaDiaDiem \r\n" + 
					"            							inner join Xe x on x.MaXe = cg.MaXe \r\n" + 
					"            							inner join NhaXe nx on x.MaNhaXe = nx.MaNhaXe \r\n" + 
					"            		            		WHERE nx.MaNguoiDung=? group by c.MaChang,c.GioXuatPhat,c.GioToiNoi,d.TenDiaDiem ,d1.TenDiaDiem ,c.GiaVe,x.MaXe \r\n" + 
					"										ORDER BY MaChuyenXe OFFSET "+i+" ROWS FETCH NEXT 5 ROWS ONLY;");
			pre.setInt(1, userId);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				Buses buses = new Buses();
				buses.setMaChuyenXe(rs.getInt("MaChuyenXe"));
				buses.setMaXe(rs.getInt("MaXe"));
				buses.setDiemDi(rs.getString("DiaDiemDi"));
				buses.setDiemDen(rs.getString("DiaDiemDen"));
				buses.setGioXuatPhat(rs.getString("GioXuatPhat"));
				buses.setGioToiNoi(rs.getString("GioToiNoi"));
				buses.setGiaVe(rs.getInt("GiaVe"));
				buses.setNgayXuatPhat(rs.getString("NgayXuatPhat"));
				buses.setMaChang(rs.getInt("MaChang"));
				listBuses.add(buses);
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
		return listBuses;
	}
	public boolean AddNewBuses(BusesForm busesForm, boolean[] repeatArr) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			try {
				startDate = formatter.parse(busesForm.getNgayXuatPhat());
				Date endDate = formatter.parse(busesForm.getNgayKetThuc());
				LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1))
				{
					Date fullDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
					for(int i=0;i<repeatArr.length;i++)
					{
						if(repeatArr[i]==true&&i==fullDate.getDay())
						{
							pre = conn.prepareStatement("INSERT INTO Chuyen(MaChang,GioXuatPhat,GioToiNoi,NgayXuatPhat,GiaVe)"
									+ " VALUES(?,?,?,?,?)");
							SimpleDateFormat df = new SimpleDateFormat("HH:mm");
							String gioToiNoi="";
							Date d;
							try {
								d = df.parse(busesForm.getGioXuatPhat());
								Calendar cal = Calendar.getInstance();
								cal.setTime(d);
								cal.add(Calendar.HOUR, busesForm.getThoiGianDiChuyen());
								gioToiNoi= df.format(cal.getTime());
								System.out.println("new time"+gioToiNoi);
							} catch (ParseException e) {
								e.printStackTrace();
							} 

							pre.setInt(1, busesForm.getMaChang());
							pre.setString(2, busesForm.getGioXuatPhat());
							pre.setString(3, gioToiNoi);
							pre.setString(4, date.toString());
							pre.setInt(5, busesForm.getGiaVe());
							pre.executeUpdate();
						}
					}
					//System.out.println(fullDate.getDay());
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
	public boolean AddNewBusesAndTrip(BusesForm busesForm,int maChang, boolean[] repeatArr) {

		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			try {
				startDate = formatter.parse(busesForm.getNgayXuatPhat());
				Date endDate = formatter.parse(busesForm.getNgayKetThuc());
				LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1))
				{
					Date fullDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
					for(int i=0;i<repeatArr.length;i++)
					{
						if(repeatArr[i]==true&&i==fullDate.getDay())
						{
							pre = conn.prepareStatement("INSERT INTO Chuyen(MaChang,GioXuatPhat,GioToiNoi,NgayXuatPhat,GiaVe)"
									+ " VALUES(?,?,?,?,?)");
							SimpleDateFormat df = new SimpleDateFormat("HH:mm");
							String gioToiNoi="";
							Date d;
							try {
								d = df.parse(busesForm.getGioXuatPhat());
								Calendar cal = Calendar.getInstance();
								cal.setTime(d);
								cal.add(Calendar.HOUR, busesForm.getThoiGianDiChuyen());
								gioToiNoi= df.format(cal.getTime());
								System.out.println("new time"+gioToiNoi);
							} catch (ParseException e) {
								e.printStackTrace();
							} 


							pre.setInt(1, maChang);
							pre.setString(2, busesForm.getGioXuatPhat());
							pre.setString(3, gioToiNoi);
							pre.setString(4, date.toString());
							pre.setInt(5, busesForm.getGiaVe());
							pre.executeUpdate();
						}
					}
					//System.out.println(fullDate.getDay());
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			isSuccess=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pre != null) {
					pre.close();
				} 
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
	}
	public Buses getOneBusesByBusesId(int busesid) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		Buses buses = new Buses();

		try {
			pre = conn.prepareStatement("SELECT * FROM Chuyen WHERE MaChuyenXe=?");
			pre.setInt(1,busesid);

			ResultSet rs = pre.executeQuery();

			while(rs.next())
			{
				buses.setMaChuyenXe(rs.getInt("MaChuyenXe"));
				buses.setMaChang(rs.getInt("MaChang"));
				buses.setGioXuatPhat(rs.getString("GioXuatPhat"));
				buses.setGioToiNoi(rs.getString("GioToiNoi"));
				buses.setNgayXuatPhat(rs.getString("NgayXuatPhat"));
				buses.setGiaVe(rs.getInt("GiaVe"));
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
		return buses;
	}
	public boolean EditBusesAll(BusesForm busesForm) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
		try {

			pre = conn.prepareStatement("UPDATE Chuyen SET GioXuatPhat=?,"
					+ "GioToiNoi=?,NgayXuatPhat=?,GiaVe=?  WHERE MaChang=?");
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			String gioToiNoi="";
			Date d;
			try {
				d = df.parse(busesForm.getGioXuatPhat());
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				cal.add(Calendar.HOUR, busesForm.getThoiGianDiChuyen());
				gioToiNoi= df.format(cal.getTime());
				System.out.println("new time"+gioToiNoi);
			} catch (ParseException e) {
				e.printStackTrace();
			} 


			//pre.setInt(1, busesForm.getMaChang());
			pre.setString(1, busesForm.getGioXuatPhat());
			pre.setString(2, gioToiNoi);
			pre.setString(3, busesForm.getNgayXuatPhat());
			pre.setInt(4, busesForm.getGiaVe());
			//pre.setInt(5, busesForm.getThoiGianDiChuyen());
			pre.setInt(5, busesForm.getMaChang());
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
	public boolean EditBuses(BusesForm busesForm) {
		System.out.println("run here");
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
		try {

			pre = conn.prepareStatement("UPDATE Chuyen SET MaChang=?,GioXuatPhat=?,"
					+ "GioToiNoi=?,NgayXuatPhat=?,GiaVe=? WHERE MaChuyenXe=?");
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			String gioToiNoi="";
			Date d;
			try {
				d = df.parse(busesForm.getGioXuatPhat());
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				cal.add(Calendar.HOUR, busesForm.getThoiGianDiChuyen());
				gioToiNoi= df.format(cal.getTime());
				System.out.println("new time"+gioToiNoi);
			} catch (ParseException e) {
				e.printStackTrace();
			} 


			pre.setInt(1, busesForm.getMaChang());
			pre.setString(2, busesForm.getGioXuatPhat());
			pre.setString(3, gioToiNoi);
			pre.setString(4, busesForm.getNgayXuatPhat());
			pre.setInt(5, busesForm.getGiaVe());
			//pre.setInt(6, busesForm.getThoiGianDiChuyen());
			pre.setInt(6, busesForm.getMaChuyenXe());
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
	public boolean removeBusesByBusesId(int busesId) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
		try {
			pre = conn.prepareStatement("DELETE FROM VeXe WHERE MaChuyenXe = ?");
			pre.setInt(1, busesId);
			pre.executeUpdate();
			
			pre = conn.prepareStatement("DELETE FROM Chuyen WHERE MaChuyenXe = ?");
			pre.setInt(1, busesId);
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
	public int getRowCountDetailBusesByUserId(int userId,int maXe, int maChang) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs=null;
		try {
			pre = conn.prepareStatement("SELECT COUNT(*) as rowNum FROM Chuyen c inner join Chang cg on c.MaChang=cg.MaChang inner join Xe x on x.MaXe = cg.MaXe inner join NhaXe n on x.MaNhaXe=n.MaNhaXe WHERE n.MaNguoiDung=? and x.MaXe=? and cg.MaChang=?");
			pre.setInt(1, userId);
			pre.setInt(2, maXe);
			pre.setInt(3, maChang);
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
	public ArrayList<Buses> getPaginationBusesDetail(int i, int userId,int maXe,int maChang) {
		ArrayList<Buses> listBuses = new ArrayList<Buses>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			pre = conn.prepareStatement("SELECT c.MaChuyenXe,c.MaChang,c.GioXuatPhat,c.GioToiNoi,c.NgayXuatPhat,d.TenDiaDiem as[DiaDiemDi],d1.TenDiaDiem as[DiaDiemDen],c.GiaVe,x.MaXe\r\n" + 
					" FROM Chuyen c inner join Chang cg on c.MaChang = cg.MaChang \r\n" + 
					"					inner join DiaDiem d on cg.MaDiaDiemDi = d.MaDiaDiem\r\n" + 
					"					inner join DiaDiem d1 on cg.MaDiaDiemDen = d1.MaDiaDiem\r\n" + 
					"					inner join Xe x on x.MaXe = cg.MaXe\r\n" + 
					"					inner join NhaXe nx on x.MaNhaXe = nx.MaNhaXe\r\n" + 
					"            		WHERE nx.MaNguoiDung=? and x.MaXe=? and c.MaChang = ? ORDER BY c.MaChuyenXe OFFSET "+i+" ROWS FETCH NEXT 10 ROWS ONLY;");
			pre.setInt(1, userId);
			pre.setInt(2, maXe);
			pre.setInt(3, maChang);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				Buses buses = new Buses();
				buses.setMaChuyenXe(rs.getInt("MaChuyenXe"));
				buses.setMaXe(rs.getInt("MaXe"));
				buses.setDiemDi(rs.getString("DiaDiemDi"));
				buses.setDiemDen(rs.getString("DiaDiemDen"));
				buses.setGioXuatPhat(rs.getString("GioXuatPhat"));
				buses.setGioToiNoi(rs.getString("GioToiNoi"));
				buses.setGiaVe(rs.getInt("GiaVe"));
				buses.setNgayXuatPhat(rs.getString("NgayXuatPhat"));
				listBuses.add(buses);
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
		return listBuses;
	}
	public Buses getOneBuses(int busesId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		Buses buses = new Buses();
		
		try {
			pre = conn.prepareStatement("SELECT MIN(c.MaChuyenXe) as MaChuyenXe,c.MaChang,c.GioXuatPhat,c.GioToiNoi,MIN(c.NgayXuatPhat) as NgayXuatPhat,d.TenDiaDiem as[DiaDiemDi],d1.TenDiaDiem as[DiaDiemDen],c.GiaVe,x.MaXe \r\n" + 
					"            		 FROM Chuyen c inner join Chang cg on c.MaChang = cg.MaChang  \r\n" + 
					"            							inner join DiaDiem d on cg.MaDiaDiemDi = d.MaDiaDiem \r\n" + 
					"            							inner join DiaDiem d1 on cg.MaDiaDiemDen = d1.MaDiaDiem \r\n" + 
					"            							inner join Xe x on x.MaXe = cg.MaXe \r\n" + 
					"            							inner join NhaXe nx on x.MaNhaXe = nx.MaNhaXe \r\n" + 
					"            		            		WHERE c.MaChuyenXe=? group by c.MaChang,c.GioXuatPhat,c.GioToiNoi,d.TenDiaDiem ,d1.TenDiaDiem ,c.GiaVe,x.MaXe \r\n" + 
					"										");
			pre.setInt(1, busesId);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				
				buses.setMaChuyenXe(rs.getInt("MaChuyenXe"));
				buses.setMaXe(rs.getInt("MaXe"));
				buses.setDiemDi(rs.getString("DiaDiemDi"));
				buses.setDiemDen(rs.getString("DiaDiemDen"));
				buses.setGioXuatPhat(rs.getString("GioXuatPhat"));
				buses.setGioToiNoi(rs.getString("GioToiNoi"));
				buses.setGiaVe(rs.getInt("GiaVe"));
				buses.setNgayXuatPhat(rs.getString("NgayXuatPhat"));
				buses.setMaChang(rs.getInt("MaChang"));
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
		return buses;
	}
	public boolean removeBusesByTripId(int tripId) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		
		try {
			ArrayList<Integer> busesIdArr = getBusesIdByTripId(tripId);
			conn = db.getConnect();
			for(int i=0;i<busesIdArr.size();i++)
			{
				pre = conn.prepareStatement("DELETE FROM VeXe WHERE MaChuyenXe = ?");
				pre.setInt(1, busesIdArr.get(i));
				pre.executeUpdate();
			}
			pre = conn.prepareStatement("DELETE FROM Chuyen WHERE MaChang = ?");
			pre.setInt(1, tripId);
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
	public ArrayList<Integer> getBusesIdByTripId(int tripid)
	{
		SQLConnection db = new SQLConnection();
		ArrayList<Integer>BusesId = new ArrayList<Integer>();
		conn = db.getConnect();
		try {
			
			pre = conn.prepareStatement("Select MaChuyenXe From Chuyen WHERE MaChang = ?");
			pre.setInt(1, tripid);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				BusesId.add(rs.getInt("MaChuyenXe"));
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
		return BusesId;
	}
	public ArrayList<Buses> getBuseseByBusId(int busid)
	{
		ArrayList<Buses> buses = new ArrayList<Buses>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			
			pre = conn.prepareStatement("  select \r\n" + 
					"	c.MaChang,\r\n" + 
					"	c.MaChuyenXe,\r\n" + 
					"	c.NgayXuatPhat,\r\n" + 
					"	c.GioXuatPhat \r\n" + 
					"  from Chuyen c \r\n" + 
					"	inner join Chang ch on c.MaChang = ch.MaChang\r\n" + 
					"  where ch.MaXe = ?");
			pre.setInt(1, busid);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				Buses b = new Buses();
				b.setMaChang(rs.getInt("MaChang"));
				b.setMaChuyenXe(rs.getInt("MaChuyenXe"));
				b.setNgayXuatPhat(rs.getString("NgayXuatPhat"));
				b.setGioXuatPhat(rs.getString("GioXuatPhat"));
				buses.add(b);
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
		return buses;
	}
}

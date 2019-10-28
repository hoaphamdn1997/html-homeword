package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Bus;
import model.bean.Buses;
import model.bean.Ghe;
import model.bean.Ticket;
import model.bean.User;

public class TicketDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public int buyTicKet(Ticket ticket) {
		/*SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
        	String sql = "INSERT INTO Ghe(MaXe,VTHang,VTCot,TrangThai,Tang) VALUES";
        	ArrayList<Ghe> listGhe = jsonBus.getListGhe();
        	
        	for(int i=0;i<listGhe.size();i++)
        	{
        		Ghe ghe = listGhe.get(i);
        		sql+="("+maXe+","+ghe.getVtHang()+","+ghe.getVtCot()+","+ghe.getTrangThai()+","+ghe.getTang()+"),";
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
		return -1;*/
		return 0;
	}
	public int buyTicKet(int maChuyenXe,int maKhachHang,ArrayList<Ghe> listGhe) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
        	String sql = "INSERT INTO VeXe(MaChuyenXe, MaNguoiDung,MaGhe,Giave) values";
        	
        	for(int i=0;i<listGhe.size();i++)
        	{
        		sql+="("+maChuyenXe+","+maKhachHang+","+listGhe.get(i).getMaGhe()+","+listGhe.get(i).getGiaGhe()+"),";
        	}
        	sql=sql.substring(0, sql.length()-1);
        	System.out.println(sql);
            pre = conn.prepareStatement(sql);
            System.out.println(sql);
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
	public boolean removeTicketByBusesId(int busesid)
	{
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("DELETE FROM VeXe WHERE MaChuyenXe = ?");
            pre.setInt(1, busesid);
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
	public int getRowCountTicketByUserId(int userId) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        ResultSet rs=null;
        try {
            pre = conn.prepareStatement("select count(*) as rowNum from VeXe inner join Chuyen on VeXe.MaChuyenXe = Chuyen.MaChuyenXe\r\n" + 
            		"inner join Chang on Chuyen.MaChang = Chang.MaChang\r\n" + 
            		"inner join Xe on Xe.MaXe = Chang.MaXe\r\n" + 
            		"inner join NhaXe on Xe.MaNhaXe = NhaXe.MaNhaXe\r\n" + 
            		"inner join NguoiDung on NguoiDung.MaNguoiDung = NhaXe.MaNguoiDung\r\n" + 
            		"where NguoiDung.MaNguoiDung = ?");
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
	public ArrayList<Ticket> getPaginationTicket(int i, int userId) {
		ArrayList<Ticket> listTicket = new ArrayList<Ticket>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("select VeXe.MaVe, nd.TenNguoiDung,nd.SoDienThoai,nd.Email,Xe.TenXe,VeXe.GiaVe,Chuyen.NgayXuatPhat,Chuyen.GioXuatPhat, \r\n" + 
            		"            		diemdi.TenDiaDiem as DiaDiemDi,diemden.TenDiaDiem as DiaDiemDen \r\n" + 
            		"            		 from VeXe inner join Chuyen on VeXe.MaChuyenXe = Chuyen.MaChuyenXe \r\n" + 
            		"            		inner join Chang on Chuyen.MaChang = Chang.MaChang \r\n" + 
            		"            		inner join Xe on Xe.MaXe = Chang.MaXe \r\n" + 
            		"            		inner join NhaXe on Xe.MaNhaXe = NhaXe.MaNhaXe \r\n" + 
            		"            		inner join NguoiDung on NguoiDung.MaNguoiDung = NhaXe.MaNguoiDung \r\n" + 
            		"            		inner join DiaDiem diemdi on Chang.MaDiaDiemDi = diemdi.MaDiaDiem \r\n" + 
            		"            		inner join DiaDiem diemden on Chang.MaDiaDiemDen = diemden.MaDiaDiem \r\n" + 
            		"					inner join NguoiDung nd on VeXe.MaNguoiDung=nd.MaNguoiDung\r\n" + 
            		"            		where NguoiDung.MaNguoiDung = ? ORDER BY Chuyen.NgayXuatPhat OFFSET " +i+ " ROWS FETCH NEXT 5 ROWS ONLY;");
            pre.setInt(1, userId);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Ticket t = new Ticket();
            	t.setMaVe(rs.getInt("MaVe"));
            	
            	User user = new User();
            	user.setTenNguoiDung(rs.getString("tenNguoiDung"));
            	user.setSoDienThoai(rs.getString("soDienThoai"));
            	user.setEmail(rs.getString("Email"));
            	t.setUser(user);
            	
            	Buses buses = new Buses();
            	buses.setDiemDen(rs.getString("DiaDiemDen"));
            	buses.setDiemDi(rs.getString("DiaDiemDi"));
            	buses.setGiaVe(rs.getInt("GiaVe"));
            	buses.setNgayXuatPhat(rs.getString("NgayXuatPhat"));
            	buses.setGioXuatPhat(rs.getString("GioXuatPhat"));
            	
            	t.setBuses(buses);
            	
            	Bus bus = new Bus();
            	bus.setTenXe(rs.getString("TenXe"));
            	t.setBus(bus);
            	
            	listTicket.add(t);
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
		return listTicket;
	}
	public boolean removeTicketByTicket(int t) {
		SQLConnection db = new SQLConnection();
		boolean isSuccess=false;
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("DELETE FROM VeXe WHERE MaVe = ?");
            pre.setInt(1, t);
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
	public ArrayList<Ticket> getPaginationFilterTicket(int i, int userId, String tenXe, String ngayXuatPhat) {
		ArrayList<Ticket> listTicket = new ArrayList<Ticket>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        try {
            pre = conn.prepareStatement("select VeXe.MaVe, nd.TenNguoiDung,nd.SoDienThoai,nd.Email,Xe.TenXe,VeXe.GiaVe,Chuyen.NgayXuatPhat,Chuyen.GioXuatPhat, \r\n" + 
            		"            		diemdi.TenDiaDiem as DiaDiemDi,diemden.TenDiaDiem as DiaDiemDen \r\n" + 
            		"            		 from VeXe inner join Chuyen on VeXe.MaChuyenXe = Chuyen.MaChuyenXe \r\n" + 
            		"            		inner join Chang on Chuyen.MaChang = Chang.MaChang \r\n" + 
            		"            		inner join Xe on Xe.MaXe = Chang.MaXe \r\n" + 
            		"            		inner join NhaXe on Xe.MaNhaXe = NhaXe.MaNhaXe \r\n" + 
            		"            		inner join NguoiDung on NguoiDung.MaNguoiDung = NhaXe.MaNguoiDung \r\n" + 
            		"            		inner join DiaDiem diemdi on Chang.MaDiaDiemDi = diemdi.MaDiaDiem \r\n" + 
            		"            		inner join DiaDiem diemden on Chang.MaDiaDiemDen = diemden.MaDiaDiem \r\n" + 
            		"					inner join NguoiDung nd on VeXe.MaNguoiDung=nd.MaNguoiDung\r\n" + 
            		"            		where NguoiDung.MaNguoiDung = ? "
            		+ "						and Chuyen.NgayXuatPhat = ? \r\n" + 
            		"						and Xe.TenXe = ? "
            		+ "					ORDER BY Chuyen.NgayXuatPhat OFFSET " +i+ " ROWS FETCH NEXT 5 ROWS ONLY;");
            pre.setInt(1, userId);
            pre.setString(2, ngayXuatPhat);
            pre.setString(3, tenXe);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
            	Ticket t = new Ticket();
            	t.setMaVe(rs.getInt("MaVe"));
            	
            	User user = new User();
            	user.setTenNguoiDung(rs.getString("tenNguoiDung"));
            	user.setSoDienThoai(rs.getString("soDienThoai"));
            	user.setEmail(rs.getString("Email"));
            	t.setUser(user);
            	
            	Buses buses = new Buses();
            	buses.setDiemDen(rs.getString("DiaDiemDen"));
            	buses.setDiemDi(rs.getString("DiaDiemDi"));
            	buses.setGiaVe(rs.getInt("GiaVe"));
            	buses.setNgayXuatPhat(rs.getString("NgayXuatPhat"));
            	buses.setGioXuatPhat(rs.getString("GioXuatPhat"));
            	
            	t.setBuses(buses);
            	
            	Bus bus = new Bus();
            	bus.setTenXe(rs.getString("TenXe"));
            	t.setBus(bus);
            	
            	listTicket.add(t);
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
		return listTicket;
	}
	public int getRowCountTicketByUserId(int userId, String tenXe, String ngatXuatPhat) {
		System.out.println(userId+" "+ tenXe+" "+ ngatXuatPhat);
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
        ResultSet rs=null;
        try {
            pre = conn.prepareStatement("select count(*) as rowNum from VeXe inner join Chuyen on VeXe.MaChuyenXe = Chuyen.MaChuyenXe\r\n" + 
            		"inner join Chang on Chuyen.MaChang = Chang.MaChang\r\n" + 
            		"inner join Xe on Xe.MaXe = Chang.MaXe\r\n" + 
            		"inner join NhaXe on Xe.MaNhaXe = NhaXe.MaNhaXe\r\n" + 
            		"inner join NguoiDung on NguoiDung.MaNguoiDung = NhaXe.MaNguoiDung\r\n" + 
            		"where NguoiDung.MaNguoiDung = ? and Xe.tenXe =? and Chuyen.ngayXuatPhat = ?");
            pre.setInt(1, userId);
            pre.setString(2, tenXe);
            pre.setString(3, ngatXuatPhat);
    
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
	
	

}

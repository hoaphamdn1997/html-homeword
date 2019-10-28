package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.PasswordEncrypt;
import form.UserForm;
import model.bean.User;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pre = null;
	public User checkLogin(String username, String password) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = null;
		try {
			pre = conn.prepareStatement("SELECT * FROM NguoiDung Where username=? and password=?");
			pre.setString(1, username);
			pre.setString(2, password);

			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				user = new User(rs.getInt("MaNguoiDung"),
						rs.getString("username"), rs.getString("password"), 
						rs.getString("TenNguoiDung"),rs.getString("SoDienThoai"),
						rs.getString("DiaChi"), rs.getString("Email")
						, rs.getBoolean("TrangThai"), rs.getInt("PhanQuyen"));
			}
			return user;
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
		return user;
	}

	public int getRowCountUser() {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs=null;
		try {
			pre = conn.prepareStatement("SELECT COUNT(*) as rowNum FROM NguoiDung ");
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
	public ArrayList<User> getPaginationUsers(int i) {
		ArrayList<User> listUser = new ArrayList<User>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			String sql="SELECT * FROM NguoiDung WHERE TrangThai=1 ORDER BY MaNguoiDung OFFSET "+i+" ROWS FETCH NEXT 5 ROWS ONLY;";
			System.out.println(sql);
			pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				listUser.add(new User(rs.getInt("MaNguoiDung"), rs.getString("username"), 
						rs.getString("password"), rs.getString("TenNguoiDung"), 
						rs.getString("SoDienThoai"), rs.getString("DiaChi"), 
						rs.getString("Email"), 
						rs.getBoolean("TrangThai"), rs.getInt("phanQuyen")));
			}
			return listUser;
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
		return listUser;
	}

	public boolean checktontai(int id) { // sau doi ten lai nge
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs=null;
		 // false la chua trung id
		try {
			pre = conn.prepareStatement("select NguoiDung.MaNguoiDung from NguoiDung where NguoiDung.MaNguoiDung="+id);
			rs= pre.executeQuery();
			while(rs.next()) {
				return true;
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
		return false;
	}

	public ArrayList<User> getPeddingPaginationUsers(int i) {
		ArrayList<User> listUser = new ArrayList<User>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			pre = conn.prepareStatement("SELECT * FROM NguoiDung"

            		+ " WHERE TrangThai=0 ORDER BY MaNguoiDung OFFSET "+i+" ROWS FETCH NEXT 5 ROWS ONLY;");
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				User user = new User(rs.getInt("MaNguoiDung"), rs.getString("username"), 
						rs.getString("password"), rs.getString("TenNguoiDung"), 
						rs.getString("SoDienThoai"), rs.getString("DiaChi"), 
						rs.getString("Email"), 
						rs.getBoolean("TrangThai"), rs.getInt("phanQuyen"));
				//user.setTenNhaXe(rs.getString("TenNhaXe"));
				listUser.add(user);
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
		return listUser;
	}

	public boolean register(UserForm userForm) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			pre = conn.prepareStatement("INSERT INTO NguoiDung(username,password,TenNguoiDung,SoDienThoai,"
					+ "DiaChi,Email,PhanQuyen,TrangThai) VALUES(?,?,?,?,?,?,?,?)");
			pre.setString(1, userForm.getUsername());
			pre.setString(2, userForm.getPassword());
			pre.setString(3, userForm.getTenNguoiDung());
			pre.setString(4, userForm.getSoDienThoai());
			pre.setString(5, userForm.getDiaChi());
			pre.setString(6, userForm.getEmail());
			pre.setInt(7, 2);
			pre.setBoolean(8, true);

			pre.executeUpdate();
			return true;
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
		return false;
	}
	public User getOneUser(String username) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = new User();
		try {
			pre = conn.prepareStatement("SELECT * FROM NguoiDung WHERE username =?");
			pre.setString(1, username);

			ResultSet rs = pre.executeQuery();

			while(rs.next())
			{
				user.setMaNguoiDung(rs.getInt("MaNguoiDung"));
				user.setDiaChi(rs.getString("DiaChi"));
				user.setEmail(rs.getString("Email"));
				user.setPhanQuyen(rs.getInt("PhanQuyen"));
				user.setSoDienThoai(rs.getString("SoDienThoai"));
				user.setTenNguoiDung(rs.getString("TenNguoiDung"));
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
		return user;
	}

	public User checkIfTransporterExist(String username) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = new User();
		try {
			pre = conn.prepareStatement("SELECT * FROM NguoiDung inner join NhaXe on NguoiDung.MaNguoiDung = NhaXe.MaNguoiDung WHERE username =?");
			pre.setString(1, username);

			ResultSet rs = pre.executeQuery();

			while(rs.next())
			{

				user.setUsername(rs.getString("username"));
				user.setPhanQuyen(rs.getInt("PhanQuyen"));
			}
			return user;
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
		return user;
	}

	public User changePassword(int uID, String newPassword) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = new User();
		try {
			String query = "UPDATE NguoiDung SET password='"+newPassword+"'"
					+ "WHERE MaNguoiDung='"+uID+"'";
			pre = conn.prepareStatement(query);
			//pre.setString(2, newPassword);
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
		return user;
	}
	public User getPassword(int uid) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = null;
		try {
			String query = "SELECT * FROM NguoiDung WHERE MaNguoiDung='"+uid+"'";
			pre = conn.prepareStatement(query);
			ResultSet rs =  pre.executeQuery();
			while(rs.next())
			{
				user = new User(rs.getInt("MaNguoiDung"),
						rs.getString("username"), rs.getString("password"), 
						rs.getString("TenNguoiDung"),rs.getString("SoDienThoai"),
						rs.getString("DiaChi"), rs.getString("Email")
						, rs.getBoolean("TrangThai"), rs.getInt("PhanQuyen"));
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
		return user;
	}

	public boolean removeUser(int id) {
		ArrayList<Integer> l = (new TransportServiceProviderDAO()).getTransIdArrByUserId(id);
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		boolean isSuccess = false;
		try {
			String query2 = "DELETE FROM VeXe WHERE MaNguoiDung = ?";
			pre = conn.prepareStatement(query2);
			pre.setInt(1, id);
			pre.executeUpdate();

			for(int i=0;i<l.size();i++)
			{
				System.out.println("nha xe " +l.get(i) );
				(new TransportServiceProviderDAO()).removeTransporter(l.get(i));
			}

			String query = "DELETE FROM NguoiDung WHERE MaNguoiDung = ?";
			pre = conn.prepareStatement(query);
			pre.setInt(1, id);
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
	/**
	 * Enter Ma Nguoi Dung to get information of a user
	 * @param id: 
	 * @return
	 */
	public User getUserById(int id) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = null;
		try {
			pre = conn.prepareStatement("SELECT * FROM NguoiDung WHERE MaNguoiDung =?");
			pre.setInt(1, id);

			ResultSet rs = pre.executeQuery();

			while(rs.next())
			{
				user = new User(rs.getInt("MaNguoiDung"),
						rs.getString("username"), rs.getString("password"), 
						rs.getString("TenNguoiDung"),rs.getString("SoDienThoai"),
						rs.getString("DiaChi"), rs.getString("Email")
						, rs.getBoolean("TrangThai"), rs.getInt("PhanQuyen"));

			}
			return user;
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
		return user;
	}

	public User updateUserInformation(int maNguoiDung, String userName, String password, int phanQuyen,
			String tenNguoiDung, String phone, String diaChi, String email, boolean trangThai) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = null;

		String sql = "UPDATE NguoiDung SET username=?, password=?, PhanQuyen=?,"
				+ " TenNguoiDung=?, SoDienThoai=?, DiaChi=?, Email=?"
				+ " WHERE MaNguoiDung=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, password);
			pre.setInt(3, phanQuyen);
			pre.setString(4, tenNguoiDung);
			pre.setString(5, phone);
			pre.setString(6, diaChi);
			pre.setString(7, email);
			//pre.setBoolean(8, trangThai);
			pre.setInt(8, maNguoiDung);
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
		return user;
	}
	public void ChangeInfo(int userId,String username, String tenNguoiDung, String soDienThoai, String diaChi, String email) {

		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		//User user = new User();

		String sql=	String.format("UPDATE NguoiDung "+
				" SET username = N'%s', TenNguoiDung = N'%s', SoDienThoai = '%s',DiaChi =N'%s' ,Email =N'%s' " +
				" WHERE MaNguoiDung = '%s'", username, tenNguoiDung, soDienThoai, diaChi,email,userId);
		System.out.println(sql);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public ArrayList<User> getConfirmUser() {

		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs=null;
		try {
			pre = conn.prepareStatement("select * from NguoiDung where PhanQuyen = ? And ChePheDuyet =?");
			pre.setInt(1, 2);
			pre.setInt(2, 0);
			rs= pre.executeQuery();
			// System.out.println(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		ArrayList<User> listUser = new ArrayList<User>();
		User user;
		try {
			while(rs.next()){
				user = new User();
				user.setMaNguoiDung(rs.getInt("maNguoiDung"));
				user.setUsername(rs.getString("username"));
				user.setTenNguoiDung(rs.getString("TenNguoiDung"));
				user.setSoDienThoai(rs.getString("SoDienThoai"));
				user.setDiaChi(rs.getString("DiaChi"));
				user.setEmail(rs.getString("Email"));
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pre.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listUser;

	}
	public void confirm(int maNguoiDung) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		//User user = new User();

		String sql=	"UPDATE NguoiDung "+
				" SET PhanQuyen =1 ,choPheDuyet=0"+
				" WHERE MaNguoiDung = ?";
		System.out.println(sql);
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, maNguoiDung);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}	
	public User getInforUser(int id) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		User user = new User();
		try {
            pre = conn.prepareStatement("SELECT * FROM NguoiDung WHERE MaNguoiDung =?");
            pre.setInt(1, id);
            
            ResultSet rs = pre.executeQuery();
            
            while(rs.next())
            {
            	
            	user.setUsername(rs.getString("username"));
            	user.setTenNguoiDung(rs.getString("TenNguoiDung"));
            	user.setSoDienThoai(rs.getString("SoDienThoai"));
            	user.setDiaChi(rs.getString("DiaChi"));
            	user.setEmail(rs.getString("Email"));
            }
            return user;
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
        return user;
	}

	public ArrayList<User> getPeddingPaginationConfirmUsers(int i) {
		ArrayList<User> listUser = new ArrayList<User>();
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		try {
			pre = conn.prepareStatement("SELECT * FROM NguoiDung WHERE TrangThai=1 And choPheDuyet=1 ORDER BY MaNguoiDung OFFSET "+i+" ROWS FETCH NEXT 5 ROWS ONLY;");
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				listUser.add(new User(rs.getInt("MaNguoiDung"), rs.getString("username"), 
						rs.getString("password"), rs.getString("TenNguoiDung"), 
						rs.getString("SoDienThoai"), rs.getString("DiaChi"), 
						rs.getString("Email"), 
						rs.getBoolean("TrangThai"), rs.getInt("phanQuyen")));
			}
			return listUser;
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
		return listUser;
	}

	public int getRowCountPenddingUser() {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs=null;
		try {
			pre = conn.prepareStatement("SELECT COUNT(*) as rowNum FROM NguoiDung WHERE TrangThai=1 And choPheDuyet=1");
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
	public void RegisterTransport(int userId, String noiDungPheDuyet) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		//User user = new User();

		String sql=	String.format("UPDATE NguoiDung "+
				" SET NoiDungPheDuyet = N'%s',choPheDuyet=1 " +
				" WHERE MaNguoiDung = '%s'",noiDungPheDuyet ,userId);
		System.out.println(sql);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public int an_register(String username, String fullname, String phone, String address) {
		SQLConnection db = new SQLConnection();
		PasswordEncrypt pEncrypt = new PasswordEncrypt();
		conn = db.getConnect();
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement("INSERT INTO NguoiDung(username,password,TenNguoiDung,SoDienThoai,"
					+ "DiaChi,Email,PhanQuyen,TrangThai) output inserted.MaNguoiDung VALUES(?,?,?,?,?,?,?,?)");
			pre.setString(1, username);
			pre.setString(2, pEncrypt.md5("123456"));
			pre.setString(3, fullname);
			pre.setString(4, phone);
			pre.setString(5, address);
			pre.setString(6, "");
			pre.setInt(7, 2);
			pre.setBoolean(8, true);

			rs = pre.executeQuery();
			rs.next();
			return rs.getInt("MaNguoiDung");
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

	public boolean checkExisted(String username) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement("SELECT MaNguoiDung FROM NguoiDung WHERE username = ?");
			pre.setString(1, username);

			rs = pre.executeQuery();
			boolean isEx = rs.next();
			System.out.println("-------------------------------");
			System.out.println(isEx);
			return isEx;
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
		return true;
	}
	public User getSendEmailPasswordUser(String username,String Email) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		String sql=	String.format("select MaNguoiDung,username,password,TenNguoiDung from NguoiDung\r\n" + 
				"where NguoiDung.username='%s' and NguoiDung.Email='%s'",username,Email);
				ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		User user = new User();
		try {
			while(rs.next()){
				user.setMaNguoiDung(rs.getInt("MaNguoiDung"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setTenNguoiDung(rs.getString("TenNguoiDung"));
	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public String getSendEmailPasswordUser1(String username,String Email) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		String sql=String.format("select MaNguoiDung,username,password,TenNguoiDung from NguoiDung\r\n" + 
				"				where NguoiDung.username='%s' and NguoiDung.Email='%s'",username, Email);
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String kq =" " ;
		try {
			while(rs.next()){
			 kq=rs.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}
	public String getSendEmailPasswordUser2(String username,String Email) {
		SQLConnection db = new SQLConnection();
		conn = db.getConnect();
		String sql=String.format("select MaNguoiDung,username,password,TenNguoiDung from NguoiDung\r\n" + 
				"				where NguoiDung.username='%s' and NguoiDung.Email='%s'",username, Email);
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String kq =" " ;
		try {
			while(rs.next()){
			 kq=rs.getString("TenNguoiDung");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}
	
	public static void main(String[] args) {
		UserDAO run=new UserDAO();

		
		
	}

}

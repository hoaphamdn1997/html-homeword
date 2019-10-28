/**
 * ChuyenDAO.java
 *
 * Version 1.0
 *
 * Date 19/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 19/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Chuyen;

public class ChuyenDAO {
    Connection conn = null;
    PreparedStatement pre = null;
    public ArrayList<Chuyen> getItemsSearch(String diaDiemDi, String diaDiemDen, String ngayXuatPhat) {
        ArrayList<Chuyen> listChuyen = new ArrayList<Chuyen>();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("Select * from Chuyen As chyen Where chyen.MaChang in (Select chag.MaChang from Chang As chag Where chag.MaDiaDiemDi in (Select dia.MaDiaDiem from DiaDiem AS dia WHere dia.districtid = (Select dis.districtid from district As dis Where dis.name like N'%"+diaDiemDi+"%') OR dia.provinceid = (Select pro.provinceid from province as pro where pro.name like N'%"+diaDiemDi+"%') OR dia.TenDiaDiem like N'%"+diaDiemDi+"%')\r\n" + 
                    "    And chag.MaDiaDiemDen in (Select dia.MaDiaDiem from DiaDiem AS dia WHere dia.districtid = (Select dis.districtid from district As dis Where dis.name like N'%"+diaDiemDen+"%') OR dia.provinceid = (Select pro.provinceid from province as pro where pro.name like N'%"+diaDiemDen+"%') OR dia.TenDiaDiem like N'%"+diaDiemDen+"%'))\r\n" + 
                    "    And chyen.NgayXuatPhat = '"+ngayXuatPhat+"'");
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                listChuyen.add(new Chuyen(rs.getInt("MaChuyenXe"), rs.getInt("MaChang"),
                        rs.getTime("GioXuatPhat"), rs.getTime("GioToiNoi"), rs.getDate("NgayXuatPhat"), rs.getFloat("GiaVe")));
            }
            return listChuyen;
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
        return listChuyen;
    }
    
    public Chuyen getItemByMCX(int maChuyen) {
        Chuyen item = new Chuyen();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("Select * from Chuyen Where MaChuyenXe = ?");
            pre.setInt(1, maChuyen);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                item = new Chuyen(rs.getInt("MaChuyenXe"), rs.getInt("MaChang"),
                        rs.getTime("GioXuatPhat"), rs.getTime("GioToiNoi"), rs.getDate("NgayXuatPhat"), rs.getFloat("GiaVe"));
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
}
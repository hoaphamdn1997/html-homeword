/**
 * VeXeDAO.java
 *
 * Version 1.0
 *
 * Date 25/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 25/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DiaDiem;
import model.bean.Ghe;
import model.bean.VeXe;

public class VeXeDAO {
    Connection conn = null;
    PreparedStatement pre = null;
    public ArrayList<VeXe> getItemsByMND(int maNguoiDung) {
        ArrayList<VeXe> item = new ArrayList<VeXe>();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("select MaNguoiDung, MaChuyenXe, count(MaChuyenXe) as SoGheDaDat, sum(GiaVe) as TongTien from VeXe Where MaNguoiDung =?\r\n" + 
                    "group by MaNguoiDung, MaChuyenXe");
            pre.setInt(1, maNguoiDung);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                VeXe object = new VeXe(0, rs.getInt("MaChuyenXe"), 0, rs.getInt("MaNguoiDung"), rs.getInt("SoGheDaDat"), 0, rs.getFloat("TongTien"));
                item.add(object);
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

    public ArrayList<VeXe> getItemsByMCX(int maChuyenXe) {
        ArrayList<VeXe> item = new ArrayList<VeXe>();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("select MaVe, MaGhe from VeXe Where MaChuyenXe =?");
            pre.setInt(1, maChuyenXe);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                VeXe object = new VeXe(rs.getInt("MaVe"), 0, rs.getInt("MaGhe"), 0, 0, 0, 0);
                item.add(object);
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
    
    public Ghe getItemByMaGhe(int maGhe) {
        Ghe item = new Ghe();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT MaSoGhe from Ghe Where MaGhe = ?");
            pre.setInt(1, maGhe);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                item = new Ghe(rs.getString("MaSoGhe"));
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
 
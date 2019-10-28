/**
 * DiaDiemDAO.java
 *
 * Version 1.0
 *
 * Date 15/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 15/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DiaDiem;
import model.bean.District;
import model.bean.TransportServiceProvider;

public class DiaDiemDAO {
    Connection conn = null;
    PreparedStatement pre = null;
    public ArrayList<DiaDiem> getItems() {
        ArrayList<DiaDiem> listDiaDiem = new ArrayList<DiaDiem>();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM DiaDiem");
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                listDiaDiem.add(new DiaDiem(rs.getInt("MaDiaDiem"), rs.getString("districtid"), rs.getString("provinceid"),
                        rs.getString("TenDiaDiem")));
            }
            return listDiaDiem;
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
        return listDiaDiem;
    }
    
    public DiaDiem getDiemDiByMaChang(int maChang) {
        DiaDiem item = new DiaDiem();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("Select * from DiaDiem diaDiem Where diaDiem.MaDiaDiem in (Select chag.MaDiaDiemDi from Chang chag Where chag.MaChang = ?)");
            pre.setInt(1, maChang);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                item = new DiaDiem(rs.getInt("MaDiaDiem"), rs.getString("districtid"), rs.getString("provinceid"), rs.getString("TenDiaDiem"));
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
    
    public DiaDiem getDiemDenByMaChang(int maChang) {
        DiaDiem item = new DiaDiem();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("Select * from DiaDiem diaDiem Where diaDiem.MaDiaDiem in (Select chag.MaDiaDiemDen from Chang chag Where chag.MaChang = ?)");
            pre.setInt(1, maChang);
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                item = new DiaDiem(rs.getInt("MaDiaDiem"), rs.getString("districtid"), rs.getString("provinceid"), rs.getString("TenDiaDiem"));
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
 
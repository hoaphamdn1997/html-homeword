/**
 * DistrictDAO.java
 *
 * Version 1.0
 *
 * Date 14/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 14/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.District;
import model.bean.Ghe;
import model.bean.Province;

public class ProvinceDAO {
    Connection conn = null;
    PreparedStatement pre = null;
    public ArrayList<Province> getItems() {
        ArrayList<Province> listPro = new ArrayList<Province>();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM province");
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                listPro.add(new Province(rs.getString("provinceid"), rs.getString("name")));
            }
            return listPro;
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
        return listPro;
    }
}
 
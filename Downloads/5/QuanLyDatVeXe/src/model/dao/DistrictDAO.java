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

public class DistrictDAO {
    Connection conn = null;
    PreparedStatement pre = null;
    public ArrayList<District> getItems() {
        ArrayList<District> listDis = new ArrayList<District>();
        SQLConnection db = new SQLConnection();
        conn = db.getConnect();
        try {
            pre = conn.prepareStatement("SELECT * FROM district");
            ResultSet rs = pre.executeQuery();
            while(rs.next())
            {
                listDis.add(new District(rs.getString("districtid"), rs.getString("name"),
                        rs.getString("provinceid")));
            }
            return listDis;
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
        return listDis;
    }
}
 
/**
 * DiaDiemBO.java
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


package model.bo;

import java.util.ArrayList;

import model.bean.Chuyen;
import model.dao.ChuyenDAO;

public class ChuyenBO {
    public ArrayList<Chuyen> getItemsSearch(String diaDiemDi, String diaDiemDen, String ngayXuatPhat) {
        return (new ChuyenDAO().getItemsSearch(diaDiemDi, diaDiemDen, ngayXuatPhat));
    }
    public Chuyen getItemByMCX(int maChuyen) {
        return (new ChuyenDAO().getItemByMCX(maChuyen));
    }
}
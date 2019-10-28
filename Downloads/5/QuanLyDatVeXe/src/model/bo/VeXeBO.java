/**
 * VeXeBO.java
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


package model.bo;

import java.util.ArrayList;

import model.bean.Ghe;
import model.bean.VeXe;
import model.dao.VeXeDAO;

public class VeXeBO {
    public ArrayList<VeXe> getItemsByMND(int maNguoiDung) {
        return (new VeXeDAO()).getItemsByMND(maNguoiDung);
    }
    public ArrayList<VeXe> getItemsByMCX(int maChuyenXe) {
        return (new VeXeDAO()).getItemsByMCX(maChuyenXe);
    }
    public Ghe getItemByMaGhe(int maGhe) {
        return (new VeXeDAO()).getItemByMaGhe(maGhe);
    }
}
 
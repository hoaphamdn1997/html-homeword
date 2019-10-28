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

import model.bean.DiaDiem;
import model.dao.DiaDiemDAO;

public class DiaDiemBO {
    public ArrayList<DiaDiem> getItems() {
        return (new DiaDiemDAO().getItems());
    }
    public DiaDiem getDiemDiByMaChang(int maChang) {
        return (new DiaDiemDAO().getDiemDiByMaChang(maChang));
    }
    public DiaDiem getDiemDenByMaChang(int maChang) {
        return (new DiaDiemDAO().getDiemDenByMaChang(maChang));
    }
}
 
/**
 * DistrictBO.java
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


package model.bo;

import java.util.ArrayList;

import model.bean.Province;
import model.dao.ProvinceDAO;

public class ProvinceBO {
    public ArrayList<Province> getItems() {
        return (new ProvinceDAO().getItems());
    }
}
 
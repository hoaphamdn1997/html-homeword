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

import model.bean.District;
import model.dao.DistrictDAO;

public class DistrictBO {
    public ArrayList<District> getItems() {
        return (new DistrictDAO().getItems());
    }
}
 
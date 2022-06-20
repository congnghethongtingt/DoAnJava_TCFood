/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.SERVICE;

import com.doanjava.DAO.ThucDonDAO;
import com.doanjava.DTO.ThucDon;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ThucDonSERVICE {
    
    private ThucDonDAO thucDonDAO;
    
    public ThucDonSERVICE() {
        thucDonDAO = new ThucDonDAO();
    }
    
    public List<ThucDon> getAllThucDon(){
            return thucDonDAO.getAllThucDon();
    }
    
    public void themThucDon(ThucDon thucDon) {
        thucDonDAO.themThucDon(thucDon);
    }
    
    public void suaThucDon(ThucDon thucDon) {
        thucDonDAO.suaThucDon(thucDon);
    }
    
    public void xoaThucDon(String maMonAn) {
        thucDonDAO.xoaThucDon(maMonAn);
    }
}

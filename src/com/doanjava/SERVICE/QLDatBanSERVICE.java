/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.SERVICE;

import com.doanjava.DAO.QLDatBanDAO;
import com.doanjava.DTO.DatBan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class QLDatBanSERVICE {
    
    private QLDatBanDAO datBanDAO;
    
    public QLDatBanSERVICE() {
        datBanDAO = new QLDatBanDAO();
    }
    
    public void themDatBan(DatBan datBan) {
        datBanDAO.themDatBan(datBan);
    }
    
    public void suaDatBan(DatBan datBan) {
        datBanDAO.suaDatBan(datBan);
    }
    
    public void xoaDatBan(String maKH) {
        datBanDAO.xoaDatBan(maKH);
    }
    
    public List<DatBan> getAllDatBan(){
            return datBanDAO.getAllDatBan();
    }
    
    public void capNhatTTBan(DatBan datBan){
        datBanDAO.capNhatTTBan(datBan);
    }
    
    public void TTBanTrong(DatBan datBan){
        datBanDAO.TTBanTrong(datBan);
    }
}

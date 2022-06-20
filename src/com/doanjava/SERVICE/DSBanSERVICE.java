/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.SERVICE;

import com.doanjava.DAO.DSBanDAO;
import com.doanjava.DTO.DSBan;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class DSBanSERVICE {
    
    private DSBanDAO dsBanDAO;
    
    public List<DSBan> getAllDSBan(){
            return dsBanDAO.getAllDSBan();
    }
    
    public DSBanSERVICE() {
        dsBanDAO = new DSBanDAO();
    }
    
    public void themDSBan(DSBan dsBan) {
        dsBanDAO.themDSBan(dsBan);
    }
    
    public void xoaDSBan(String maBan) {
        dsBanDAO.xoaDSBan(maBan);
    }
    
    public void suaDSBan(DSBan dsBan) {
        dsBanDAO.suaDSBan(dsBan);
    }
}

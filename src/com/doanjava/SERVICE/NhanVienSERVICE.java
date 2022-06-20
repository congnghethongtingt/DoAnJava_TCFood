/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.SERVICE;

import com.doanjava.DAO.NhanVienDAO;
import com.doanjava.DTO.NhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienSERVICE {
    
    private NhanVienDAO nhanVienDAO;
    
    public NhanVienSERVICE() {
        nhanVienDAO = new NhanVienDAO();
    }
    
    public List<NhanVien> getAllNhanVien(){
            return nhanVienDAO.getAllNhanVien();
    }
    
    public List<NhanVien> getNhanVienbyMaNV(){
            return nhanVienDAO.getNhanVienbyMaNV();
    }
    
    public void themNhanVien(NhanVien nhanVien) {
        nhanVienDAO.themNhanVien(nhanVien);
    }
    
    public void suaNhanVien(NhanVien nhanVien) {
        nhanVienDAO.suaNhanVien(nhanVien);
    }
    
    public void xoaNhanVien(String maNV) {
        nhanVienDAO.xoaNhanVien(maNV);
    }
}

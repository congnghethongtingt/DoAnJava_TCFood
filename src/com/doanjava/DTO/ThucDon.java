/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.DTO;

/**
 *
 * @author ADMIN
 */
public class ThucDon {

    public ThucDon() {
        
    }

    public String getMaMonAn() {
        return maMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public String getMaLoaiMon() {
        return maLoaiMon;
    }

    public String getDonVi() {
        return donVi;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getImageMonAn() {
        return imageMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public void setMaLoaiMon(String maLoaiMon) {
        this.maLoaiMon = maLoaiMon;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setImageMonAn(String imageMonAn) {
        this.imageMonAn = imageMonAn;
    }
    
    private String maMonAn;
    private String tenMonAn;
    private String maLoaiMon;
    private String donVi;
    private float giaTien;
    private int soLuong;
    private String imageMonAn;

    
    public ThucDon(String maMonAn, String tenMonAn, String maLoaiMon, String donVi, float giaTien, int soLuong,  String imageMonAn) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.maLoaiMon = maLoaiMon;
        this.donVi = donVi;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.imageMonAn = imageMonAn;
    }
    
}

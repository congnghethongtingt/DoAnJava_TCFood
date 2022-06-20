/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.DTO;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class DatBan {

    public String getMaKH() {
        return maKH;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getMaSoBan() {
        return maSoBan;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public String getTrangThaiDat() {
        return trangThaiDat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setMaSoBan(String maSoBan) {
        this.maSoBan = maSoBan;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setTrangThaiDat(String trangThaiDat) {
        this.trangThaiDat = trangThaiDat;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public String maKH;
    public String tenKhachHang;
    public String soDT;
    public String maSoBan;
    public String ngayDat;
    public String trangThaiDat;
    public String ghiChu;

    public String tenBan;
       
    
    public void DatBan(String maKH, String tenKhachHang, String soDT, String maSoBan, String tenBan, String ngayDat, String trangThaiDat, String ghiChu){
        this.maKH =maKH;
        this.tenKhachHang =tenKhachHang;
        this.soDT = soDT;
        this.maSoBan = maSoBan;
        this.ngayDat = ngayDat;
        this.trangThaiDat = trangThaiDat;
        this.ghiChu = ghiChu;
        
        this.tenBan = tenBan;
    }
}

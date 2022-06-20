/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.DTO;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    
    public NhanVien(){
        
    }

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getImageNV() {
        return imageNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setImageNV(String imageNV) {
        this.imageNV = imageNV;
    }

    
    private String maNV;
    private String tenNV;
    private String ngaySinh;
    private String gioiTinh;
    private String soDT;
    private String diaChi;
    private String chucVu;
    private String taiKhoan;
    private String matKhau;
    private String imageNV;

    
    public NhanVien(String maNV, String tenNV, String ngaySinh, String gioiTinh, String soDT, String diaChi,  String chucVu, String taiKhoan, String matKhau, String imageNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.imageNV = imageNV;
    }
}

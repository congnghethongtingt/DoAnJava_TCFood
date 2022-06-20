/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.DAO;

import com.doanjava.DTO.DatBan;
import com.doanjava.DTO.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {
    
    public List<NhanVien> getAllNhanVien(){
        List<NhanVien> nhanViens = new ArrayList<NhanVien>();
        
        Connection connection = ConnectSQL.getConnection();
        
        String sql = "SELECT maNV, tenNV,ngaySinh,gioiTinh,diaChi,soDT,chucVu,taiKhoan,matKhau,imageNV FROM NhanVien";
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                
                //bien tu csdl
                nhanVien.setMaNV(rs.getString("maNV"));
                nhanVien.setTenNV(rs.getString("tenNV"));
                nhanVien.setNgaySinh(rs.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setSoDT(rs.getString("soDT"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setChucVu(rs.getString("chucVu"));
                nhanVien.setTaiKhoan(rs.getString("taiKhoan"));
                nhanVien.setMatKhau(rs.getString("matKhau"));
                nhanVien.setImageNV(rs.getString("imageNV"));
                
                nhanViens.add(nhanVien);
                System.out.println(rs);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return nhanViens;
    }
    public List<NhanVien> getNhanVienbyMaNV(){
        List<NhanVien> nhanViens = new ArrayList<NhanVien>();
        
        Connection connection = ConnectSQL.getConnection();
        
        String sql = "SELECT tenNV,ngaySinh,gioiTinh,diaChi,soDT,chucVu,taiKhoan,matKhau,imageNV FROM NhanVien WHERE maNV =?";
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                
                //bien tu csdl
                nhanVien.setTenNV(rs.getString("tenNV"));
                nhanVien.setNgaySinh(rs.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setSoDT(rs.getString("soDT"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setChucVu(rs.getString("chucVu"));
                nhanVien.setTaiKhoan(rs.getString("taiKhoan"));
                nhanVien.setMatKhau(rs.getString("matKhau"));
                nhanVien.setImageNV(rs.getString("imageNV"));
                nhanVien.setMaNV(rs.getString("maNV"));
                
                nhanViens.add(nhanVien);
                System.out.println(rs);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return nhanViens;
    }
    
    public void themNhanVien(NhanVien nv) 
    {
        Connection connection = ConnectSQL.getConnection();
        String sql = "Insert into NhanVien(maNV,tenNV,ngaySinh,gioiTinh,soDT,diaChi,chucVu,taiKhoan,matKhau,imageNV)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nv.getMaNV());
            preparedStatement.setString(2, nv.getTenNV());
            preparedStatement.setString(3, nv.getNgaySinh());
            preparedStatement.setString(4, nv.getGioiTinh());
            preparedStatement.setString(5, nv.getSoDT());
            preparedStatement.setString(6, nv.getDiaChi());
            preparedStatement.setString(7, nv.getChucVu());
            preparedStatement.setString(8, nv.getTaiKhoan());
            preparedStatement.setString(9, nv.getMatKhau());
            preparedStatement.setString(10, nv.getImageNV());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void suaNhanVien(NhanVien nv) 
    {
        Connection connection = ConnectSQL.getConnection();
        String sql = "UPDATE NhanVien SET tenNV = ?, ngaySinh = ?, gioiTinh = ?, soDT = ?,"
                + " diaChi = ?, chucVu = ?, taiKhoan = ?, matKhau = ?, imageNV = ? WHERE maNV = ?";
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nv.getTenNV());
            preparedStatement.setString(2, nv.getNgaySinh());
            preparedStatement.setString(3, nv.getGioiTinh());
            preparedStatement.setString(4, nv.getSoDT());
            preparedStatement.setString(5, nv.getDiaChi());
            preparedStatement.setString(6, nv.getChucVu());
            preparedStatement.setString(7, nv.getTaiKhoan());
            preparedStatement.setString(8, nv.getMatKhau());
            preparedStatement.setString(9, nv.getImageNV());
            preparedStatement.setString(10, nv.getMaNV());
            
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    public void xoaNhanVien(String maNV) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "DELETE FROM NhanVien WHERE maNV = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, maNV);
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
}

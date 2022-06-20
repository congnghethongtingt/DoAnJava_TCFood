/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.DAO;

import com.doanjava.DTO.DatBan;
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
public class QLDatBanDAO {
    
    
    public List<DatBan> getAllDatBan(){
        List<DatBan> datBans = new ArrayList<DatBan>();
        
        Connection connection = ConnectSQL.getConnection();
        
        String sql = "  SELECT maKH, tenKhachHang, soDT, maSoBan, ngayDat, trangThaiDat, ghiChu FROM DatBan";
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                DatBan datBan = new DatBan();
                
                //bien tu csdl
                datBan.setMaKH(rs.getString("maKH"));
                datBan.setTenKhachHang(rs.getString("tenKhachHang"));
                datBan.setSoDT(rs.getString("soDT"));
                datBan.setMaSoBan(rs.getString("maSoBan"));
                datBan.setNgayDat(rs.getString("ngayDat"));
                datBan.setTrangThaiDat(rs.getString("trangThaiDat"));
                datBan.setGhiChu(rs.getString("ghiChu"));
                
                datBans.add(datBan);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return datBans;
    }
    
    public void themDatBan(DatBan datBan) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "INSERT INTO DatBan VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
                preparedStatement.setString(1, datBan.getMaKH());
                preparedStatement.setString(2, datBan.getTenKhachHang());
                preparedStatement.setString(3, datBan.getSoDT());
                preparedStatement.setString(4, datBan.getMaSoBan());
                preparedStatement.setString(5, datBan.getNgayDat());
                preparedStatement.setString(6, datBan.getTrangThaiDat());
                preparedStatement.setString(7, datBan.getGhiChu());
                
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    
    public void capNhatTTBan(DatBan datBan) { //Cập nhật Trạng thái bàn = Khách đặt theo Mã Bàn được chọn
        Connection connection = ConnectSQL.getConnection();
            String sql = "UPDATE BanAn SET trangThaiDat =N'Khách đặt' WHERE maBan = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, datBan.getMaSoBan());
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void TTBanTrong(DatBan datBan) { //Cập nhật Trạng thái bàn = Khách đặt theo Mã Bàn được chọn
        Connection connection = ConnectSQL.getConnection();
            String sql = "UPDATE BanAn SET trangThaiDat =N'Trống' WHERE maBan = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, datBan.getMaSoBan());
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void suaDatBan(DatBan datBan) {
        Connection connection = ConnectSQL.getConnection();
        String sql = "UPDATE DatBan SET tenKhachHang = ?, soDT = ?, maSoBan = ?, ngayDat = ?, trangThaiDat = ?,  ghiChu = ? WHERE maKH = ?";
        try {           
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, datBan.getTenKhachHang());
            preparedStatement.setString(2, datBan.getSoDT());
            preparedStatement.setString(3, datBan.getMaSoBan());
            preparedStatement.setString(4, datBan.getNgayDat());
            preparedStatement.setString(5, datBan.getTrangThaiDat());
            preparedStatement.setString(6, datBan.getGhiChu());
            preparedStatement.setString(7, datBan.getMaKH());
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public void xoaDatBan(String maKH) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "DELETE FROM DatBan WHERE maKH = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, maKH);
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

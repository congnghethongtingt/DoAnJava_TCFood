/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.DAO;

import com.doanjava.DTO.DSBan;
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
public class DSBanDAO {
    
    public List<DSBan> getAllDSBan(){
        List<DSBan> dsBans = new ArrayList<DSBan>();
        
        Connection connection = ConnectSQL.getConnection();
        
        String sql = "  SELECT maBan, tenBan, trangThai FROM BanAn";
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                DSBan dsBan = new DSBan();
                
                //bien tu csdl
                dsBan.setMaBan(rs.getString("maBan"));
                dsBan.setTenBan(rs.getString("tenBan"));
                dsBan.setTrangThai(rs.getString("trangThai"));
                
                dsBans.add(dsBan);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dsBans;
    }
    
    public void themDSBan(DSBan dsBan) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "INSERT INTO BanAn VALUES (?, ?, ?)";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, dsBan.getMaBan());
                preparedStatement.setString(2, dsBan.getTenBan());
                preparedStatement.setString(3, dsBan.getTrangThai());
                
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void suaDSBan(DSBan dsBan) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "UPDATE BanAn SET tenBan = ?, trangThai = ? WHERE  maBan = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, dsBan.getTenBan());
                preparedStatement.setString(2, dsBan.getTrangThai());
                preparedStatement.setString(3, dsBan.getMaBan());
                
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void xoaDSBan(String maBan) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "DELETE FROM BanAn WHERE maBan = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, maBan);
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void capNhatTTBan(String maBan) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "UPDATE BanAn SET trangThai=N'Khách đặt' WHERE maBan = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, maBan);
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doanjava.DAO;

import com.doanjava.DTO.DSBan;
import com.doanjava.DTO.ThucDon;
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
public class ThucDonDAO {
    
    public List<ThucDon> getAllThucDon(){
        List<ThucDon> thucDons = new ArrayList<ThucDon>();
        
        Connection connection = ConnectSQL.getConnection();
        
        String sql = "  SELECT maMonAn, tenMonAn, maLoaiMon, donVi,  giaTien, soLuong,  imageMonAn FROM MonAn";
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                ThucDon thucDon = new ThucDon();
                
                //bien tu csdl
                thucDon.setMaMonAn(rs.getString("maMonAn"));
                thucDon.setTenMonAn(rs.getString("tenMonAn"));
                thucDon.setMaLoaiMon(rs.getString("maLoaiMon"));
                thucDon.setDonVi(rs.getString("donVi"));
                thucDon.setGiaTien(rs.getFloat("giaTien"));
                thucDon.setSoLuong(rs.getInt("soLuong"));
                thucDon.setImageMonAn(rs.getString("imageMonAn"));
                
                thucDons.add(thucDon);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return thucDons;
    }
    
    public void themThucDon(ThucDon thucDon) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "INSERT INTO MonAn VALUES (?, ?, ?, ?, ?, ?,?)";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, thucDon.getMaMonAn());
                preparedStatement.setString(2, thucDon.getTenMonAn());
                preparedStatement.setString(3, thucDon.getMaLoaiMon());
                preparedStatement.setString(4, thucDon.getDonVi());
                preparedStatement.setFloat(5, thucDon.getGiaTien());
                preparedStatement.setInt(6, thucDon.getSoLuong());
                preparedStatement.setString(7, thucDon.getImageMonAn());
                
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
     
    public void suaThucDon(ThucDon thucDon) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "UPDATE MonAn SET tenMonAn = ?, maLoaiMon = ? , donVi = ? , giaTien = ? , soLuong = ?, imageMonAn = ?  WHERE  maMonAn = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, thucDon.getTenMonAn());
                preparedStatement.setString(2, thucDon.getMaLoaiMon());
                preparedStatement.setString(3, thucDon.getDonVi());
                preparedStatement.setFloat(4, thucDon.getGiaTien());
                preparedStatement.setInt(5, thucDon.getSoLuong());
                preparedStatement.setString(6, thucDon.getImageMonAn());
                preparedStatement.setString(7, thucDon.getMaMonAn());
                
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    public void xoaThucDon(String maMonAn) {
        Connection connection = ConnectSQL.getConnection();
            String sql = "DELETE FROM MonAn WHERE maMonAn = ?";
            try {           
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, maMonAn);
                preparedStatement.executeUpdate();
                System.out.println(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

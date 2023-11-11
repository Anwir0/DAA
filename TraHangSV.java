/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cxt;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author DELL
 */
public class TraHangSV {
    Connection conn = jdbc.getConnection();
    private ArrayList<TraHang> listTH;
    
    public TraHangSV(){
        this.listTH = new ArrayList<>();
    }
    
    public ArrayList<TraHang> getAll(String name){
        this.listTH = new ArrayList<>();
        try {
            String sql = "select * from return_bill";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TraHang th;
                String tongCP = rs.getString(1);
                String maHD = rs.getString(2);
                String ngayTao = rs.getString(3);
                String ID = rs.getString(4);
                String ngayCN = rs.getString(5);
                String lyDo = rs.getString(6);
                th = new TraHang(tongCP, maHD, ngayTao, ID, ngayCN, lyDo);
                this.listTH.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTH;
    }
    
    public void setListTH(){
        this.listTH = listTH;
    }
    
    public Integer insert(TraHang th){
        try {
            String sql = "insert into return_bill (created_at, updated_at, total_cost, bill_id, reason_description)"
                                                            + "values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getNgayTao());
            ps.setString(2, th.getNgayCN());
            ps.setString(3, th.getTongCP());
            ps.setString(4, th.getMaHD());
            ps.setString(5, th.getLyDo());
            int row = ps.executeUpdate();
            if(row > 0){
                return row;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer delete(String ma){
        try {
            String sql = "delete from return_bill where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,ma);
            int row = ps.executeUpdate();
            if(row > 0){
                return row;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer update(String id, TraHang th){
        this.listTH = new ArrayList<>();
        try {
            String sql = "update NHANVIEN set created_at = ?, updated_at = ?, total_cost = ? bill_id=? reason_description=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getNgayTao());
            ps.setString(2, th.getNgayCN());
            ps.setString(3, th.getTongCP());
            ps.setString(4, th.getMaHD());
            ps.setString(5, th.getLyDo());
            ps.setString(6, id);           
            int row = ps.executeUpdate();
            if(row > 0){
                return row;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public ArrayList<TraHang> getAllth(){
//        String sql = "select * from return_bill_detail";
//        try {           
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            ArrayList<TraHang> list = new ArrayList<>();
//            while (rs.next()) {
//                TraHang tr = new TraHang();
//                tr.setNgayTao(rs.getString(3));
//                tr.setNgayCN(rs.getString(7));
//                tr.setGiaMua(rs.getString(1));
//                tr.setSoLuong(rs.getString(2));
//                tr.setIdTraHang(rs.getString(6));
//                tr.setIdHoaDon(rs.getString(4));
//                tr.setTrangThai(rs.getBoolean(8));   
//                list.add(tr);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    
//    public Boolean delete(String price_at_the_time_of_purchase) {
//        String sql = "delete from return_bill_detail where price_at_the_time_of_purchase=?";
//        int check = 0;
//        try (Connection cn = jdbc.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
//            ps.setObject(1, price_at_the_time_of_purchase);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Boolean add(TraHang th) {
//        String sql = "insert into return_bill_detail (created_at, updated_at, price_at_the_time_of_purchase, quantity_of_products_returned, product_detail_id, return_bill_id, status)"
//                + "values(?,?,?,?,?,?,?)";
//        
//        try  {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setObject(1, th.getGiaMua());
//            ps.setObject(2, th.getSoLuong());
//            ps.setObject(3, th.getNgayTao());
//            ps.setObject(4, th.getIdHoaDon());
//            ps.setObject(5, th.getIdTraHang());
//            ps.setObject(6, th.getNgayCN());
//            ps.setObject(7, th.isTrangThai());
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Boolean update(TraHang th, String price_at_the_time_of_purchase) {
//        String sql = "update return_bill_detail set price_at_the_time_of_purchase=?,quantity_of_products_returned=?,created_at=?,id=?,return_bill_id=?,updated_at=?,status=? where price_at_the_time_of_purchase=?";
//        int check = 0;
//        try (Connection cn = jdbc.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
//            ps.setObject(1, th.getGiaMua());
//            ps.setObject(2, th.getSoLuong());
//            ps.setObject(3, th.getNgayTao());
//            ps.setObject(4, th.getIdHoaDon());
//            ps.setObject(5, th.getIdTraHang());
//            ps.setObject(7, th.getNgayCN());
//            ps.setObject(8, th.isTrangThai());
//
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return check > 0;
//    }
    
    
//}
    
    

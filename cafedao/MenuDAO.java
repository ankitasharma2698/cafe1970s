/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafedao;

import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author pmhrn
 */
public class MenuDAO extends BaseDAO{
    public static LinkedList<String> getMenuItem (){
        LinkedList<String> res = new LinkedList<String>();
        Connection con = null;
        try {
            con = getCon();
            String sql = "select food_name from menu ";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
               res.add(rs.getString("food_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    public static Double getItemPrice (String Food_item){
        Double res = new Double(0);
        Connection con = null;
        try {
            con = getCon();
            String sql = "select price from menu where food_name like ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, Food_item);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
               res = Double.valueOf(rs.getString("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    public static Double calculateAmount (String Food_item,Integer qnty){
        Double res = new Double(0);
        Connection con = null;
        try {
            con = getCon();
            String sql = "select price from menu where food_name like ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, Food_item);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
               res = Double.valueOf(rs.getString("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    
    
}

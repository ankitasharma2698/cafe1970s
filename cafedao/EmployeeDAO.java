package cafedao;

import ECUtils.BaseDAO;
import cafebean.Employee;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;



/**
 *
 * @author compaq
 */
public class EmployeeDAO extends BaseDAO {
    public static void insert(Employee e1){
        Connection con=null;
        try{
            con =getCon();
		String sql = "insert into employee " +
				" (ename,edesg,ejoin,esal) " +
				" values (?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
                st.setString(i++, e1.getEname());
		st.setString(i++, e1.getEdesg());
                st.setDate(i++, e1.getEjoin());
                st.setString(i++, e1.getEsal());
		st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}

        public static void update(Employee e1,Employee old){
	Connection con=null;
	try {
		con =getCon();
		String sql = "update employee " +
		" set ename = ?, edesg =?,ejoin=?,esal=?" +
		" where eid = ?  ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, e1.getEname());
		st.setString(i++, e1.getEdesg());
		st.setDate(i++, e1.getEjoin());
                st.setString(i++, e1.getEsal());
		st.setString(i++, old.getEid());
                st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}
public static void delete(String id){
	Connection con=null;
	try {
		con =getCon();
		String sql = "delete from employee " +
		" where id =? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, id);
		st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}
public static Employee findById(String id){
        Employee res = null;
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from employee where id = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			Employee e1 = new Employee();
			e1.setEname(rs.getString("ename"));
			e1.setEdesg(rs.getString("edesg"));
			e1.setEid(rs.getString("eid"));
                        e1.setEjoin(rs.getDate("ejoin"));
                        e1.setEsal(rs.getString("esal"));
			res=e1;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
	return res;
}
 public static LocalDate getDate( String Edesg, String Esal){
            LocalDate res = null;
            Connection con = null;
            try {
            con = getCon();
            // edesig , ejoin , esal
            String sql = " select ejoin from employee ";
             sql = sql + " where edesg like ? and esal like ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, Edesg);
            st.setString(i++, Esal);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                res = rs.getDate("ejoin").toLocalDate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
            return res;
        }   
}

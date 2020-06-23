package cafedao;
import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import cafebean.Orders;
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
public class OrderDAO extends BaseDAO {
    public static void insert(Orders odr){
        Connection con=null;
        try{
            con =getCon();
		String sql = "insert into orders " +
				" (fname,price,quantity,totalAmount) " +
				" values (?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
                st.setString(i++, odr.getF_name());
		st.setDouble(i++, odr.getPrice());
                st.setDouble(i++, odr.getQuantity());
                st.setDouble(i++, odr.getAmount());
                
                
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
		String sql = "delete from orders " +
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
    @SuppressWarnings("CallToPrintStackTrace")
     public static void update(Orders o1, Orders d){
        Connection con=null;
        try{
            con =getCon();
	String sql = " update orders set quantity = ? ";
             sql = sql + " where fname like ? and price = ? and quantity like ? ";	
            PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
                st.setString(i++, o1.getF_name());
		st.setDouble(i++, o1.getPrice());
                st.setInt(i++, d.getQuantity());
                st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}
public static Orders findById(String id){
        Orders res = null;
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from order where id = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			Orders o1 = new Orders(rs.getString("id"),rs.getString("f_name"),rs.getDouble("price"),rs.getInt("quantity"),rs.getDouble("totalAmount"));                       
			res=o1;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
	return res;
}
    
}



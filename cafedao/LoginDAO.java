package cafedao;
import ECUtils.BaseDAO;
import static ECUtils.BaseDAO.closeCon;
import static ECUtils.BaseDAO.getCon;
import cafebean.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class LoginDAO extends BaseDAO{
       @SuppressWarnings("CallToPrintStackTrace")
        public static Login validate(String uname, String passwd) {
        Login res = new Login();
        res.setUid("0");
        res.setUname("NOTFOUND");
        res.setPass("NOTFOUND");
        Connection con = null;
        try {
            con = getCon();
            String sql = " select * from login where uname = ? and pass = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            int i = 1;
            st.setString(i++, uname);
            st.setString(i++, passwd);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                res.setUid(rs.getString("uid"));
                res.setUname(rs.getString("uname"));
                res.setPass(rs.getString("pass"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
    public static void registerUser(String uname,String passwd){
        Connection con=null;
        try{
            con =getCon();
		String sql = "insert into login " +
				" (uname,pass) " +
				" values (?,?)";
                PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
                st.setString(i++, uname);
		st.setString(i++, passwd);
                st.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
}
    public static Login findById(String id){
        Login res = null;
	Connection con=null;
	try {
		con =getCon();
		String sql = "select * from login where id = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		int i = 1;
		st.setString(i++, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			Login l1 = new Login();
			l1.setUname(rs.getString("uname"));
			l1.setPass(rs.getString("pass"));
			l1.setUid(rs.getString("uid"));
                        res=l1;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		closeCon(con);
	}
	return res;
}
    public static Login getUserDetails( int id){
            Login res = new Login();
            Connection con = null;
        try {
            con = getCon();
            String sql = " select * from login ";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
               res.setUid(rs.getString("uid"));
               res.setUname(rs.getString("uname"));
               res.setPass(rs.getString("pass"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
            return res; 
        }

    @SuppressWarnings("CallToPrintStackTrace")
        public static LinkedList<String> getUnames() {
        LinkedList<String> res = new LinkedList();
        res.addFirst("New/Existing User");
        Connection con = null;
        try {
            con = getCon();
            String sql = " select uname from login ";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
               res.add(rs.getString("uname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    } 
    
}


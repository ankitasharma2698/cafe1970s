
package cafebean;
import java.sql.Date;

/**
 *
 * @author compaq
 */
public class Employee {

    public static void update(Employee e1, Employee updt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String eid;
    private String ename;
    private String edesg;
    private Date ejoin;
    private String esal;
    
    public String getEid(){
        return eid;
    }
    public void setEid(String eid){
        this.eid=eid;
    }
    public String getEname(){
        return ename;
    }
    public void setEname(String Ename){
        this.ename=ename;
    }
    public String getEdesg(){
        return edesg;
    }
    public void setEdesg(String edesg){
        this.edesg=edesg;
    }
    public Date getEjoin(){
        return ejoin;
    }
    public void setEjoin(Date ejoin){
        this.ejoin=ejoin;
    }
    public String getEsal(){
        return esal;
    }
    public void setEsal(String esal){
        this.esal=esal;
    }
}

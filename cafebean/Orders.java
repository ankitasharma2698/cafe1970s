
package cafebean;

/**
 *
 * @author compaq
 */
public class Orders {
    private String id;
    private String f_name;
    private Double price;
    private Integer quantity;
    private Double amount;

    public Orders(String id, String f_name, Double price, Integer quantity, Double amount) {
        this.id = id;
        this.f_name = f_name;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
    }
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getF_name(){
        return f_name;
    }
    public void setF_name(String f_name){
        this.f_name=f_name;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price=Double.valueOf(price);
    }
    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(String quantity){
        this.quantity=Integer.valueOf(quantity);
    }
    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amt){
        this.amount=amt;
    }
}

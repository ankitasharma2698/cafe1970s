package ECUtils;
public class ECConst {
	public static String DB_NAME ="fx_cafecollege";
	public static String DB_HOST="localhost";
	public static String DB_USER="root";
	public static String DB_PASS ="";
	public static String SQLS[] = 
	{
		"create table employee ( eid INT NOT NULL AUTO_INCREMENT, ename varchar(100),edesg varchar(100),ejoin date,esal double, PRIMARY KEY (eid))",	
		"create table login ( uid INT NOT NULL AUTO_INCREMENT, uname varchar(40), pass varchar(50), PRIMARY KEY (uid))",
                "create table menu ( mid INT NOT NULL AUTO_INCREMENT, food_name varchar(40), price DOUBLE  , PRIMARY KEY (mid))",
                //"create table orders ( id INT NOT NULL AUTO_INCREMENT, f_name varchar(100), price DOUBLE  , quantity DOUBLE  , PRIMARY KEY (id))",
                "CREATE TABLE orders ( oid INT NOT NULL AUTO_INCREMENT , fname VARCHAR(100) NOT NULL , quantity INT NOT NULL , price DOUBLE NOT NULL , totalAmount DOUBLE NOT NULL , PRIMARY KEY (oid))",
                // MENU ITEM INSERTION
                "insert into menu ( food_name , price )"
                +          "values ( 'Cappucino' , 150 )",
                "insert into menu ( food_name , price )"
                +          "values ( 'Kulhad Tea' , 40 )",
                "insert into menu ( food_name , price )"
                +          "values ( 'SandWich' , 70 )",
                "insert into menu ( food_name , price )"
                +          "values ( 'Pizza' , 150 )",
                "insert into menu ( food_name , price )"
                +          "values ( 'Burgers' , 100 )",
                "insert into menu ( food_name , price )"
                +          "values ( 'French Fries' , 70 )",
                
                "insert into login ( uid , uname, pass ) "
                +          "values ( 1 , 'admin' , 'admin')",
                "insert into employee ( eid, ename, edesg, ejoin, esal )"
                +           "values ( 1 , 'ankita','employee','2019-10-30',20000)",
                "insert into orders ( fname, price, quantity , totalAmount)"
                +           "values ( 'xyz',150.00,7, 3000.0)"
                
                
	};
}

package util;
import java.sql.*;
import java.util.*;
public class DBUtil{
    private String driver, url, username, password;
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public DBUtil(){
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/sims?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        username = "root";
        password = "123456";
    }
    public void setDriver(String d){ 
    	driver = d; 
    	}
    public void setUrl(String u){ 
    	url = u; 
    	}
    public void setUsername(String un) { 
    	username = un; 
    	}
    public void setPassword(String pw) { 
    	password = pw; 
    	}

    private Connection getConnection(){
        try{
            Class.forName(driver);
            System.out.println("Load dirver...");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("new a Statement...");
        }catch(ClassNotFoundException e) {
            System.out.println("Driver is no find...");
            e.printStackTrace();
        }catch(SQLException e) { 
        	e.printStackTrace(); 
        	}
        catch(Exception e){ 
        	e.printStackTrace(); 
        	}
        return con;
    }
    private PreparedStatement getPrepareStatement(String sql){
        try{
            pstmt = getConnection().prepareStatement(sql);
            System.out.println("Success to get PreparedStatement!");
        }catch(SQLException e) { 
        	e.printStackTrace(); 
        	}
        return pstmt;
    }
    private void setParams(String sql, String[] params){
        pstmt = this.getPrepareStatement(sql);
        //System.out.println("Success to return PreparedStatement!");
        if(params == null) return;
        for(int i = 0; i < params.length; ++i)
            try{
                pstmt.setString(i+1, params[i]);
            }catch(SQLException e) { e.printStackTrace(); }
        //System.out.println("Success to fill pstmt!");
    }
    public List getList(String sql, String[] params){
        List list = new ArrayList();
        try{
            this.setParams(sql, params);
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                Map m = new HashMap();
                for(int i = 1; i <= rsmd.getColumnCount(); ++i){
                    String colName = rsmd.getColumnName(i);
                    m.put(colName, rs.getString(colName));
                }
                list.add(m);
            }
        }catch(SQLException e) { e.printStackTrace(); }
        finally { close(); }
        //System.out.println("Success to getList!");
        if(list.isEmpty()) return null;
        return list;
    }
    public Map getMap(String sql, String[] params){
        List list = getList(sql, params);
        //System.out.println("Success to getMap!");
        if(list == null) return null;
        return (Map)list.get(0);
    }
    public int update(String sql, String[] params){
        int recNo = 0;
        try{
            setParams(sql, params);
            recNo = pstmt.executeUpdate();
        }catch(Exception e) { e.printStackTrace(); }
        finally { close(); }
        //System.out.println("Success to update!");
        return recNo;
    }
    private void close(){
        try{
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();
        }catch(SQLException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        DBUtil db = new DBUtil();
        String sql = "select * from nl";
        List l = db.getList(sql, null);
        if(l != null) System.out.println("successful");
    }
}

package util;
import java.util.*;
import util.DBUtil;
public class UL{
    private String id, nickname, username, password, adminAty;
    private int userNum;
    private DBUtil db;
    private void setUserNum(){
        String sql = "select * from nl where name = \"un\"";
        HashMap m = (HashMap)db.getMap(sql,null);
        if(m != null) userNum = Integer.parseInt((String)m.get("num"));
        //System.out.println("Success to setUserNUm!");
        //System.out.println("UserNum: " + userNum);
    }
    private void updateUserNum(){
        String sql = "update nl set num = ? where name = \"un\"";
        String[] params = {userNum+""};
        db.update(sql,params);
        System.out.println("Success to updateUserNum!");
    }
    private void getUserByDatabase(){
        ArrayList a = (ArrayList)getUserByUsername();
        HashMap m = (HashMap)a.get(0);
        setId((String)m.get("id"));
        setNickname((String)m.get("nn"));
        setAdminAty((String)m.get("aa"));
        //System.out.println("Success to getUserByDB!");
    }
    private List getUser(String s){
        String[] params = new String[1];
        if(s.equals("id")) params[0] = id;
        else if(s.equals("nickname")) { params[0] = nickname; s = "nn"; }
        else if(s.equals("username")) { params[0] = username; s = "un"; }
        else if(s.equals("password")) { params[0] = password; s = "pw"; }
        else if(s.equals("adminAty")) { params[0] = adminAty; s = "aa"; }
        String sql = "select * from ul where " + s + " = ? order by aa";
        return db.getList(sql,params);
    }
    public UL(){ db = new DBUtil(); setUserNum(); }
    public void setId(String id){this.id = id; }
    public void setNickname(String nn){ nickname = nn; }
    public void setUsername(String un){ username = un; }
    public void setPassword(String pw){ password = pw; }
    public void setAdminAty(String aa){ adminAty = aa; }
    public void setUserInfo(String un, String pw){
        setUsername(un); setPassword(pw);
    }
    public void setUserInfo(String id, String nn, String un, String pw, String aa){
        setId(id); setNickname(nn); setUserInfo(un,pw); setAdminAty(aa);
    }
    public String getId(){ return id; }
    public String getNickname(){ return nickname; }
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }
    public String getAdminAty(){ return adminAty; }
    public int getUserNum(){ return userNum; }

    public boolean checkName(){
        String sql = "select * from ul where un = ?";
        String[] params = {username};
        if(db.getMap(sql,params) != null)
            return true;
        return false;
    }
    public boolean checkUsername(String oldUn, String newUn){
        if(oldUn.equals("null")) { setUsername(newUn); return checkName();}
        String sql = "select * from ul where un = ? and un != ?";
        String[] params = {newUn, oldUn};
        if(db.getList(sql,params) != null) return true;
        return false;
    }
    public boolean checkPassword(){
        if(!checkName()) return false;
        System.out.println("Success to checkName!");
        ArrayList a = (ArrayList)getUserByUsername();
        HashMap m = (HashMap)a.get(0);
        String pw = (String)m.get("pw");
        if(!pw.equals(password)) return false;
        getUserByDatabase(); return true;
    }
    public boolean addUser(){
        String sql = "insert into ul values(null,?,?,?,?)";
        String[] params = {nickname, username, password,adminAty};
        if(db.update(sql,params) != 1) return false;
        ++userNum; updateUserNum(); return true;
    }
    public boolean delUser(){
        String sql = "delete from ul where id = ?";
        String[] params = {id};
        if(db.update(sql,params) != 1) return false;
        --userNum; updateUserNum(); return true;
    }
    public List getUsers(){
        String sql = "select * from ul order by aa";
        return db.getList(sql,null);
    }
    public List getUserById(){ return getUser("id"); }
    public List getUserByUsername(){ return getUser("username"); }
    public List getUserByNickname(){ return getUser("nickname"); }
    public List getUserByAdminAty(){ return getUser("adminAty"); }
    public boolean update(){
        String sql = "update ul set nn = ?,un = ?,pw = ?,aa = ? where id = ?";
        String[] params = {nickname,username,password,adminAty,id};
        if(db.update(sql,params) == 1) return true;
        return false;
    }
    public boolean updatePW(String pw){
        getUserByDatabase();
        setPassword(pw);
        return update();
    }
    /*public static void main(String[] args){
        UL ul = new UL();
        String o = "sa", n = "ad";
        boolean flag = ul.checkUsername(o,n);
        if(flag)
            System.out.println("Success");
        else
            System.out.println("Error");

    }*/
}

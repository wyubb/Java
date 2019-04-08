package util;
import java.util.*;
import util.DBUtil;
public class SL{
    private String id, num, name, sex, birth, tel, score, order = "asc", orderBy = "num";
    private int stuNum, lineNum = 10, maxPage;
    private DBUtil db;
    private void setStuNum(){
        String sql = "select * from nl where name = \"sn\"";
        HashMap m = (HashMap)db.getMap(sql,null);
        if(m != null) stuNum = Integer.parseInt((String)m.get("num"));
    }
    private void updateStuNum(){
        String sql = "update nl set num = ? where name = \"sn\"";
        String[] params = {stuNum+""};
        db.update(sql,params);
    }
    private List getStu(String s){
        System.out.println("Enter getStu");
        String[] params = new String[1];
        if(s.equals("id")) params[0] = id;
        else if(s.equals("num")) params[0] = num;
        else if(s.equals("name")) params[0] = name;
        else if(s.equals("sex")) params[0] = sex;
        else if(s.equals("birth")) params[0] = birth;
        else if(s.equals("tel")) params[0] = tel;
        else if(s.equals("sc")) params[0] = score;
        System.out.println("Score: " + score);
        String sql = "select * from sl where " + s + " = ? order by " + orderBy + " " + order;
        return db.getList(sql,params);
    }
    private void setMaxPage(){ maxPage = stuNum/lineNum + (stuNum%lineNum == 0?0:1); }
    public SL(){ db = new DBUtil(); setStuNum(); setMaxPage(); }
    public void setId(String id) {this.id = id; }
    public void setNum(String nu) { num = nu; }
    public void setName(String na) { name = na; }
    public void setSex(String se) { sex = se; }
    public void setBirth(String bi) { birth = bi; }
    public void setTel(String te) { tel = te; }
    public void setScore(String sc) { score = sc; }
    public void setOrderBy(String or) { orderBy = or; }
    public void setOrder(String or) { order = or; }
    public void setLineNum(int li) { lineNum = li; }

    public String getId() { return id; }
    public String getNum() { return num; }
    public String getName(){ return name; }
    public String getSex() { return sex; }
    public String getBirth() { return birth; }
    public String getTel() { return tel; }
    public String getScore() { return score; }
    public String getOrderBy() { return orderBy; }
    public String getOrder() { return order; }
    public int getLineNum() { return lineNum; }
    public int getStuNum() { return stuNum; }
    public int getMaxPage() { return maxPage; }

    public void setStuInfo(String id, String nu, String na, String se, String bi, String te, String sc){
        setId(id); setNum(nu); setName(na); setSex(se); setBirth(bi); setTel(te); setScore(sc);
    }
    public boolean addStu(){
        String sql = "insert into sl values(null,?,?,?,?,?,?)";
        String[] params = {num,name,sex,birth,tel,score};
        if(db.update(sql,params) != 1) return false;
        ++stuNum; setMaxPage(); updateStuNum(); return true;
    }
    public boolean delStu(){
        String sql = "delete from sl where id = ?";
        String[] params = {id};
        if(db.update(sql,params) != 1) return false;
        --stuNum; setMaxPage(); updateStuNum(); return true;
    }
    public List getStus(){
        String sql = "select * from sl order by " + orderBy + " " + order;
        return db.getList(sql,null);
    }
    public List getStus(int page){
        if(page == maxPage) return null;
        String sql = "select * from sl order by " + orderBy + " " + order + " limit " + page*lineNum + "," + lineNum;
        return db.getList(sql,null);
    }
    public List getStuById(){ return getStu("id"); }
    public List getStuByNum(){ return getStu("num"); }
    public List getStuByName(){ return getStu("name"); }
    public List getStuBySex(){ return getStu("sex"); }
    public List getStuByBirth(){ return getStu("birth"); }
    public List getStuByTel(){ return getStu("tel"); }
    public List getStuByScore(){ return getStu("sc"); }
    public boolean update(){
        String sql = "update sl set num = ?,name = ?,sex = ?,birth = ?,tel = ?,sc = ? where id = ?";
        String[] params = {num,name,sex,birth,tel,score,id};
        if(db.update(sql,params) == 1) return true;
        return false;
    }
    /*public static void main(String[] args){
        SL sl = new SL(); sl.setNum("000");
        ArrayList a = (ArrayList)sl.getStu("id");
        if(a == null) System.out.println("NULL");
        else{
            for(Object o:a){
                Map m = (HashMap)o;
                System.out.println(m.get("num"));
                System.out.println(m.get("name"));
            }
        }
    }
*/
}

package servlets;
import util.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("*.sims")
public class Controller extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public Controller(){ super(); }
    private boolean isSuperAdmin(Map m){
        String aa = (String)m.get("aa");
        if(aa.equals("0")) return true;
        return false;
    }
    private String veryAdminAty(String aa){
        if(aa.equals("Super Admin")) return "0";
        if(aa.equals("Admin")) return "1";
        if(aa.equals("Teacher")) return "2";
        if(aa.equals("Student")) return "3";
        return "";
    }
    private Map getEmptyMap(String US){
        Map m = new HashMap();
        if(US.equals("user")){
            m.put("nn",""); m.put("un","");
            m.put("pw",""); m.put("aa","3");
        }
        else{
            m.put("num",""); m.put("name",""); m.put("sex","");
            m.put("birth",""); m.put("tel",""); m.put("sc","");
        }
        return m;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ doPost(request,response); }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String url = request.getServletPath();
        System.out.println("URL: " + url);
        HttpSession session = request.getSession();
        //request.getRequestDispatcher("test.jsp").forward(request, response);way of goto.
        session.setAttribute("userQueryBy","nickname");
        session.setAttribute("studentQueryBy","num");
        if(url.equals("/login.sims")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("Remember: "+request.getParameter("remember"));
            if(request.getParameter("remember") != null)
                session.setAttribute("username", username);
            else
                session.removeAttribute("username");
            UL ul = new UL(); SL sl = new SL();
            ul.setUserInfo(username,password);
            if(ul.checkPassword()){
                session.setAttribute("userInfo",(Map)ul.getUserByUsername().get(0));
                session.setAttribute("display","all");
                session.setAttribute("orderBy","num");
                session.setAttribute("order","asc");
                session.setAttribute("page",-1);
                session.setAttribute("maxPage",1);
                //System.out.println("Password right!");
                String adminAty = ul.getAdminAty();
                if(adminAty.equals("0"))
                    response.sendRedirect("pages/refreshUser.sims");
                else
                    response.sendRedirect("pages/refreshStu.sims");
            }
            else{
                //System.out.println("Password Error!");
                request.setAttribute("error","true");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else if(url.equals("/pages/gotoAddUser.sims")){
            session.setAttribute("attr","add");
            session.setAttribute("user",getEmptyMap("user"));
            response.sendRedirect("user.jsp");
        }
        else if(url.equals("/pages/addUser.sims")){
            String nickname = request.getParameter("nickname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String adminAty = request.getParameter("adminAty");
            UL ul = new UL();
            ul.setUserInfo("",nickname,username,password,adminAty);
            ul.addUser();
            response.sendRedirect("refreshUser.sims");
        }
        else if(url.equals("/pages/deleteUser.sims")){
            Map m = (HashMap)session.getAttribute("userInfo");
            if(m == null) response.sendRedirect("../index.jsp");
            if(!isSuperAdmin(m)) response.sendRedirect("pages/sl.jsp");
            String id = request.getParameter("id");
            UL ul = new UL(); ul.setId(id); ul.delUser();
            session.setAttribute("delete","true");
            response.sendRedirect("refreshUser.sims");
        }
        else if(url.equals("/pages/queryUser.sims")){
            String queryBy = request.getParameter("queryBy");
            String query = request.getParameter("query");
            session.setAttribute("userQueryBy",queryBy);
            UL ul = new UL();
            if(queryBy.equals("nickname")){
                ul.setNickname(query);
                session.setAttribute("ul",ul.getUserByNickname());
            }
            else if(queryBy.equals("username")){
                ul.setUsername(query);
                session.setAttribute("ul",ul.getUserByUsername());
            }
            else{
                ul.setAdminAty(veryAdminAty(query));
                session.setAttribute("ul",ul.getUserByAdminAty());
            }
            response.sendRedirect("ul.jsp");
        }
        else if(url.equals("/pages/gotoUpdateUser.sims")){
            //System.out.println("Enter modify");
            String id = request.getParameter("id");
            //System.out.println("ID: " + id);
            UL ul = new UL(); ul.setId(id);
            session.setAttribute("user",ul.getUserById().get(0));
            session.setAttribute("attr","update");
            response.sendRedirect("user.jsp");
        }
        else if(url.equals("/pages/updateUser.sims")){
            //System.out.println("updateUser");
            Map m = (HashMap)session.getAttribute("user");
            String id = (String)m.get("id");
            String nickname = request.getParameter("nickname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String adminAty = request.getParameter("adminAty");
            //System.out.println(nickname + " " + username + " " + password + " " + adminAty);
            UL ul = new UL();
            ul.setUserInfo(id,nickname,username,password,adminAty);
            ul.update();
            response.sendRedirect("refreshUser.sims");
        }
        else if(url.equals("/pages/checkUsername.sims")){
            System.out.println("Enter");
            String oldUn = request.getParameter("oldUn");
            String newUn = request.getParameter("newUn");
            boolean flag;
            UL ul = new UL();
            if(ul.checkUsername(oldUn,newUn)) flag = true;
            else flag = false;
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            if(flag){
                out.print("true");
            }else{
                out.print("false");
            }
            out.flush();
            out.close();
        }
        else if(url.equals("/pages/refreshUser.sims")){
            Map m = (HashMap)session.getAttribute("userInfo");
            if(m == null) response.sendRedirect("../index.jsp");
            if(!isSuperAdmin(m)) response.sendRedirect("pages/sl.jsp");
            UL ul = new UL();
            session.setAttribute("userQueryBy","nickname");
            session.setAttribute("userNum",ul.getUserNum());
            session.setAttribute("ul",ul.getUsers());
            response.sendRedirect("ul.jsp");
        }
        else if(url.equals("/pages/gotoAddStu.sims")){
            session.setAttribute("attr","add");
            session.setAttribute("student",getEmptyMap("student"));
            response.sendRedirect("student.jsp");
        }
        else if(url.equals("/pages/addStu.sims")){
            String num = request.getParameter("num");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String birth = request.getParameter("birth");
            String tel = request.getParameter("tel");
            String score = request.getParameter("score");
            SL sl = new SL();
            sl.setStuInfo("",num,name,sex,birth,tel,score);
            sl.addStu();
            response.sendRedirect("refreshStu.sims");
        }
        else if(url.equals("/pages/deleteStu.sims")){
            Map m = (HashMap)session.getAttribute("userInfo");
            if(m == null) response.sendRedirect("../index.jsp");
            String id = request.getParameter("id");
            SL sl = new SL(); sl.setId(id); sl.delStu();
            session.setAttribute("delete","true");
            response.sendRedirect("refreshStu.sims");
        }
        else if(url.equals("/pages/queryStu.sims")){
            String queryBy = request.getParameter("queryBy");
            String query = request.getParameter("query");
            session.setAttribute("studentQueryBy",queryBy);
            session.setAttribute("query","true");
            session.setAttribute("display","all");
            session.setAttribute("page",-1);
            String orderBy = (String)session.getAttribute("orderBy");
            String order = (String)session.getAttribute("order");
            SL sl = new SL();
            sl.setOrderBy(orderBy); sl.setOrder(order);
            if(queryBy.equals("num")){
                sl.setNum(query);
                session.setAttribute("sl",sl.getStuByNum());
            }
            else if(queryBy.equals("name")){
                sl.setName(query);
                session.setAttribute("sl",sl.getStuByName());
            }
            else if(queryBy.equals("sex")){
                sl.setSex(query);
                session.setAttribute("sl",sl.getStuBySex());
            }
            else if(queryBy.equals("birth")){
                sl.setBirth(query);
                session.setAttribute("sl",sl.getStuByBirth());
            }
            else if(queryBy.equals("tel")){
                sl.setTel(query);
                session.setAttribute("sl",sl.getStuByTel());
            }
            else if(queryBy.equals("score")){
                sl.setScore(query);
                session.setAttribute("sl",sl.getStuByScore());
            }
            response.sendRedirect("sl.jsp");
        }
        else if(url.equals("/pages/gotoUpdateStu.sims")){
            String id = request.getParameter("id");
            SL sl = new SL(); sl.setId(id);
            session.setAttribute("student",sl.getStuById().get(0));
            session.setAttribute("attr","update");
            response.sendRedirect("student.jsp");
        }
        else if(url.equals("/pages/updateStu.sims")){
            Map m = (HashMap)session.getAttribute("student");
            String id = (String)m.get("id");
            String num = request.getParameter("num");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String birth = request.getParameter("birth");
            String tel = request.getParameter("tel");
            String score = request.getParameter("score");
            SL sl = new SL();
            sl.setStuInfo(id,num,name,sex,birth,tel,score);
            sl.update();
            response.sendRedirect("refreshStu.sims");
        }
        else if(url.equals("/pages/display.sims")){
            String display = request.getParameter("display");
            if(display.equals("all")){
                session.setAttribute("display","all");
                session.setAttribute("page",-1);
                session.setAttribute("maxPage",1);
                response.sendRedirect("refreshStu.sims");
            }
            else{
                SL sl = new SL();
                session.setAttribute("maxPage",sl.getMaxPage());
                session.setAttribute("page",0);
                session.setAttribute("display","page");
                response.sendRedirect("updatePage.sims?page=0");
            }
        }
        else if(url.equals("/pages/updatePage.sims")){
            SL sl = new SL();
            int page = Integer.parseInt(request.getParameter("page"));
            session.setAttribute("page",page);
            response.sendRedirect("refreshStu.sims");
        }
        else if(url.equals("/pages/orderBy.sims")){
            String orderBy = request.getParameter("orderBy");
            session.setAttribute("orderBy",orderBy);
            SL sl = new SL(); sl.setOrderBy(orderBy);
            response.sendRedirect("refreshStu.sims");
        }
        else if(url.equals("/pages/order.sims")){
            String order = request.getParameter("order");
            session.setAttribute("order",order);
            SL sl =  new SL(); sl.setOrder(order);
            response.sendRedirect("refreshStu.sims");
        }
        else if(url.equals("/pages/refreshStu.sims")){
            Map m = (HashMap)session.getAttribute("userInfo");
            if(m == null) response.sendRedirect("../index.jsp");
            SL sl = new SL();
            String adminAty = (String)m.get("aa");
            String username = (String)m.get("un");
            if(adminAty.equals("3")){
                sl.setNum(username);
                session.setAttribute("sl",sl.getStuByNum());
            }
            else{
                int page = (int)session.getAttribute("page");
                String orderBy = (String)session.getAttribute("orderBy");
                String order = (String)session.getAttribute("order");
                sl.setOrderBy(orderBy); sl.setOrder(order);
                session.setAttribute("stuNum",sl.getStuNum());
                if(page == -1)
                    session.setAttribute("sl",sl.getStus());
                else
                    session.setAttribute("sl",sl.getStus(page));
            }
            response.sendRedirect("sl.jsp");
        }
        else if(url.equals("/pages/updatePassword.sims")){
            String password = request.getParameter("npw");
            Map m = (HashMap)session.getAttribute("userInfo");
            String username = (String)m.get("un");
            UL ul = new UL();
            ul.setUsername(username); ul.updatePW(password);
            session.setAttribute("update","true");
            response.sendRedirect("../index.jsp");
        }
        else if(url.equals("/pages/exit.sims")){
            String username = (String)session.getAttribute("username");
            session.invalidate();
            HttpSession newSession = request.getSession();
            if(username != null)newSession.setAttribute("username",username);
            response.sendRedirect("../index.jsp");
        }
        else if(url.equals("/test.sims")){
            String account = request.getParameter("account");
            boolean flag;
            if(account.equals("admin")) flag = true;
            else flag = false;
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            if(flag){
                out.print("true");
            }else{
                out.print("false");
            }
            out.flush();
            out.close();
        }
    }
}

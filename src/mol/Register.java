package mol;

import dao.User;
import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {

    public Register() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");//指定返回格式
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String result = "3";

        UserDao dao = new UserDaoImpl();
        boolean flag = dao.isExist(username);
        if (flag){
            result = "4";
        }else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            boolean flag1 = dao.addUser(user);
            if (flag1){
                System.out.println("添加用户成功");
                result = "4";
            }else {
                result = "3";
            }
            PrintWriter out = resp.getWriter();
            out.write(result);
            out.close();
        }
    }
}

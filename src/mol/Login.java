package mol;

import dao.User;
import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login")
public class Login extends HttpServlet {

    public Login() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //System.out.println(username+","+password);

        UserDao dao = new UserDaoImpl();
        User u = dao.login(username, password);
        String result = "0";
        if (u!=null) {
            result = "1";
            System.out.println("用户："+u.getUsername()+"已上线");
        }else {
            result = "0";
        }
        PrintWriter out = resp.getWriter();
        out.write(result);
        out.close();
    }
//        if (u!=null){
//            System.out.println(u.getUsername());
//        }else {
//            System.out.println("登陆失败");
//        }

}

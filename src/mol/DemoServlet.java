package mol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet")
public class DemoServlet extends HttpServlet {

    public DemoServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理Post。。。");
        //PrintWriter out = response.getWriter();
        //out.print("hello servlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // System.out.println("处理get请求（）。。。");
       // PrintWriter out = response.getWriter();
        //out.print("hello servlet");
        doPost(request,response);
    }
}

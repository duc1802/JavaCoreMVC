package com.example.webapplication;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    //Khởi tạo Servlet
    //Tạo ra 1 cặp đối tượng duy nhất là: Request và Response. Các Request sau đó tới Servlet
    //Không cần phải tạo lại cặp Requets và Response này nữa vì chúng chỉ cần tạo 1 lần đầu tiên
    //duy nhất, điều này do Servlet Container quản lý dòng đời của Servlet.
    //Vai trò của Servlet Container
    /*
    *1. LifeCycle Managerment: Quản lý vòng đời của servlet, khởi tạo load class, call method... giải pháp
    *2. JSP Support: Quản lý JSP
    *3. Communication support: Quản lý giao tiếp giữa Servlet và webServer
    * */

    //Chỉ được gọi một lần trước khi Servlet xử lý cac request (trước khi là service() đươc gọi)
    //Method này có thể Override được sử dụng để khơi tạo các resource
    public void init() {
        message = "Hello World!";
    }

    //Service(): được gọi bởi các Container khi các client make request, có thể được gọi nhiều lần để xử lý các request
    //Service(): dựa vào HTTP request để gọi các doXXX() tương ứng. Method này được xử lý trong từng luồng (thread) riêng biệt
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    //doPost() được gọi bởi Service() nếu method() tùy thuộc vào HTTP request(method = POST)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    //doGet() được gọi bởi Service() nếu method() tùy thuộc vào HTTP request(method = GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    //getAllProduct() được gọi bởi Service()
    public void getAllProduct(){

    }

    //chỉ được gọi chính xác 1 lần bởi container
    public void destroy() {
    }
}
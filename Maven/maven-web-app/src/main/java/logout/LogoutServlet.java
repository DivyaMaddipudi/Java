package logout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.maven.todo.TodoService;




@WebServlet(urlPatterns = "/logout.do")
public class LogoutServlet extends HttpServlet{
	  
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  
		  //request.setAttribute("name", request.getParameter("name"));
		  //request.setAttribute("password", request.getParameter("password"));
		  request.getSession().invalidate();
		  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	  }
	  
}

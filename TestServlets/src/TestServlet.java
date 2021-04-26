import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      String title = "PhraseOMatic has generated the folowing phrase";

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<html><head><title>");
      out.println("PhraseOMatic");
      out.println("</title></head><body>");
      out.println("H1" + title + "</H1>");
      out.println("<p>" + PhraseOMatic.makePhrase());
      out.println("<p><a href=\"TestServlet\"> Создать другую фразу</a></p>");
      out.println("</body></html>");
    }
}

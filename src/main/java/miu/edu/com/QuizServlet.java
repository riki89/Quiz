package miu.edu.com;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class QuizServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException{
        PrintWriter out = rep.getWriter();
        HttpSession s = req.getSession();
        Quiz quiz= (Quiz)s.getAttribute("quizz");
        int index = (int)s.getAttribute("index");
        if (quiz.equals(null)){
            quiz = new Quiz();
            s.setAttribute("quizz", quiz);
            s.setAttribute("index", 0);
        }

        out.println("<html><body>");
        out.println("<h1>The Number Quiz</h1>");
        out.println("<label>Your current score is </label>"+quiz.getScore());
        out.println("<h1>Guess the next number in the sequence<h1>");
        out.println("<p>"+quiz.questionToString(index)+"<p>");
        out.println("<p>Your answer</p>");
        out.println("<submit>");

        out.println("</body></html>");
        s.setAttribute("index", ++index);
        quiz.score +=1 ;
        s.setAttribute("quiz", quiz);
        RequestDispatcher rd = req.getRequestDispatcher("/");
        rd.forward(req, rep);

    }
}

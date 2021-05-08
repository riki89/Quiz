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
        Quiz quiz= (Quiz)s.getAttribute("quiz");
        int index = s.getAttribute("index") == null?0:(int)s.getAttribute("index");
        if (quiz==null){
            quiz = new Quiz();
            s.setAttribute("quiz", quiz);
            s.setAttribute("index", 0);
        }
        out.println("<html><body>");
        out.println("begin=> index: "+index);
        String answer = req.getParameter("answer");
        if (answer == null)
        {
            answer = String.valueOf(-100);
        }
        String correctAnswer = String.valueOf((Integer) s.getAttribute("correctAnswer"));
        if (correctAnswer == null){
            correctAnswer = String.valueOf(-1);
        }
        out.println("answer: "+correctAnswer+ " given A: "+answer);
        if (index < quiz.sizeQuiz){
            s.setAttribute("correctAnswer", quiz.getAnswer(index));
            out.println("<form action=''>");
            out.println("<h1>The Number Quiz</h1>");
            out.println("<label>Your current score is </label>"+quiz.getScore());
            out.println("<h1>Guess the next number in the sequence<h1>");
            out.println("<p>"+quiz.questionToString(index)+"<p>");
            out.println("<div>Your answer <input type='text' name = 'answer'></div>");
            out.println("<input type='submit'>");
            out.println("</form>");
            index++;
            s.setAttribute("index", index);
        } else {
            out.println("<h1>The Number Quiz</h1>");
            out.println("<label>Your current score is </label>"+quiz.getScore());
        }
        if (Integer.parseInt(correctAnswer) == Integer.parseInt(answer)){
            quiz.setScore(quiz.getScore()+1);
        }
//        out.println("score: "+quiz.getScore());
//
//        out.println("after => index: "+index);

        out.println("</body></html>");


    }
}

package miu.edu.com;

public class Quiz {
    private int score = 0;
    private String question;
    private int answer;

    private static String[] questions = {
            "3, 1, 4, 1, 5", //pi
            "1, 1, 2, 3, 5", //fibonacci
            "1, 4, 9, 16, 25", //squares
            "2, 3, 5, 7, 11", //primes
            "1, 2, 4, 8, 16" //power of 2
    };
    public int sizeQuiz = questions.length;
    private static int[] answers = {9, 8, 36, 13, 32};

    public String questionToString(int index){
        return questions[index].toString();
    }

    public int computeScore(String question, String answer){
        switch (question){
            case "pi": if (Integer.parseInt(answer) == answers[0]) score++;
                break;
            case "fibonacci": if (Integer.parseInt(answer) == answers[1]) score++;
                break;
            case "squares": if (Integer.parseInt(answer) == answers[2]) score++;
                break;
            case "primes": if (Integer.parseInt(answer) == answers[3]) score++;
                break;
            case "power2": if (Integer.parseInt(answer) == answers[4]) score++;
                break;
        }
        return score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static String[] getQuestions() {
        return questions;
    }

    public static void setQuestions(String[] questions) {
        Quiz.questions = questions;
    }

    public static int[] getAnswers() {
        return answers;
    }

    public static void setAnswers(int[] answers) {
        Quiz.answers = answers;
    }

    public String getQuestion(int index) {
        return questions[index];
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer(int index) {
        return answers[index];
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}

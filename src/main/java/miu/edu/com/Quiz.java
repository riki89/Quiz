package miu.edu.com;

public class Quiz {
    public static int score = 0;
    private static String[] questions = {
            "3, 1, 4, 1, 5", //pi
            "1, 1, 2, 3, 5", //fibonacci
            "1, 4, 9, 16, 25", //squares
            "2, 3, 5, 7, 11", //primes
            "1, 2, 4, 8, 16" //power of 2
    };
    private static int[] answers = {9, 8, 36, 13, 32};

    public String questionToString(int index){
        return questions[index].toString();
    }

    public static int computeScore(String question, String answer){
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

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Quiz.score = score;
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
}

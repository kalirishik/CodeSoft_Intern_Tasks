import java.util.*;
class QuizQuestion {
    String question;
    List<String> options;
    int correctOptionIndex;
    private int userSelectedOption;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }
    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
    public int getUserSelectedOption() {
        return userSelectedOption;
    }

    public void setUserSelectedOption(int userSelectedOption) {
        this.userSelectedOption = userSelectedOption;
    }
}
class QuizApp {
    private List<QuizQuestion> questions;
    private int score;
    private int currentQuestionIndex;
    int q=1;
    Scanner scanner;
    private final int QUESTION_TIMEOUT_SECONDS = 5;
    public QuizApp() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;
        scanner=new Scanner(System.in);
    }
    public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }
    public void startQuiz() {
        for (QuizQuestion curr : questions) {
            displayQuestion(curr);
            submitAnswer(curr);
            System.out.println("------------------------------------------------------------------------");
        }
        showResult();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                 Thanks For Using  Quiz Application                    |");
        System.out.println("------------------------------------------------------------------------");
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("Question "+(q++)+" of 5 : " + question.getQuestion());
        for (int i = 0; i < question.getOptions().size(); i++) {
            System.out.println((i + 1) + ". " + question.getOptions().get(i));
        }
    }

    private void submitAnswer(QuizQuestion question) {
        int selectedOption;
        do {
            System.out.print("Enter your answer (1-" + question.getOptions().size() + "): ");
            selectedOption = scanner.nextInt();
            if (selectedOption > question.getOptions().size()) {
                System.out.println("Invalid option. Please enter a number between 1 and " + question.getOptions().size() + ".");
            }
        } while (selectedOption > question.getOptions().size());
        question.setUserSelectedOption(selectedOption);
        if (selectedOption == question.getCorrectOptionIndex()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }

    }
    private void showResult() {
        int qe=1;
        System.out.println("Quiz ended!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                       Result Screen                                  |");
         for(QuizQuestion question : questions) {
             System.out.println("------------------------------------------------------------------------");
            System.out.println("Question "+(qe++)+" : " + question.getQuestion());
            System.out.println("Correct Answer: " + (question.getCorrectOptionIndex() - 1)+")"+question.getOptions().get(question.getCorrectOptionIndex() - 1));
            if (question.getUserSelectedOption() != -1) {
                System.out.println("Your Answer: " + (question.getUserSelectedOption() - 1)+")"+question.getOptions().get(question.getUserSelectedOption() - 1));
            } else {
                System.out.println("Your Answer: Not attempted");
            }
        }
    }
}
public class Task4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        QuizApp quizApp =new QuizApp();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                     Quiz Application With Timer                      |");
        System.out.println("------------------------------------------------------------------------");
        quizApp.addQuestion(new QuizQuestion("What are Technologies is used for CodeSoft Company?",
                Arrays.asList("Java", "ReactJs", "Flutter", "All the above"), 4));
        quizApp.addQuestion(new QuizQuestion("Who invented Java Programming?",
                Arrays.asList("Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"), 2));
        quizApp.addQuestion(new QuizQuestion("Which component is used to compile, debug and execute the java programs?",
                Arrays.asList("JRE", "JIT", "JDK", "JVM"), 3));
        quizApp.addQuestion(new QuizQuestion("What is the extension of java code files?",
                Arrays.asList(".js", ".txt", ".class", ".java"), 4));
        quizApp.addQuestion(new QuizQuestion("Which of the following is not an OOPS concept in Java?",
                Arrays.asList("Polymorphism", "Inheritance", "Compilation", "Encapsulation"), 3));
        quizApp.startQuiz();
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

class Timer extends Thread {
    final public int DURATION;
    Date startTime, nowTime;
    long timediff;
    public boolean isTimeOver = false;
    public boolean isOver = false;
    Timer(){
        this(1 * 20 * 1000);
    }
    Timer(int time){
        DURATION = time;
        startTime = new Date();
        nowTime = new Date();
        timediff = nowTime.getTime() - startTime.getTime();
    }
    public void run(){
        while(timediff < DURATION && !isOver){
            nowTime = new Date();
            timediff = nowTime.getTime() - startTime.getTime();
        }
        if(timediff >= DURATION){
            isTimeOver = true;
        }
    }
}
class Ques{
    int num1, num2;
    char operator;
    int answer;
    Ques(int num1, int num2, char operator){
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        answer = getAnswer();
    }
    public int getAnswer(){
        return switch(operator){
            case '+'->  num1+num2;
            case '-'->  num1-num2;
            case '%'->  num1%num2;
            case '*'->  num1*num2;
            case '/'->  num1/num2;
            default ->  -1;
        };
    }
    public void display(){
        System.out.printf("What is %d %c %d equals?\n",num1,operator, num2);
    }
}
class QuesHandeler{
    ArrayList<Ques> questions;
    int length;
    QuesHandeler(int num){
        this(num, 1, 100);
    }
    QuesHandeler(int num, int min, int max){        
        length = num;
        questions =  new ArrayList<>();
        for(int i = 0; i < num; i++){
            int num1 = random(min, max);
            int num2 = random(min, max);
            char operator = randamo();
            questions.add(new Ques(num1, num2, operator));
        }
    }
    private int getAnswer(int index){
        return questions.get(index).getAnswer();
    }
    public boolean isCorrect(int answer, int index){
        return answer == getAnswer(index);
    }
    public void display(int index){
        Ques ques = questions.get(index);
        ques.display();
    }
    int random(int start, int end){
        double temp = Math.random()*1000;
        int rand = (int)(start + temp%(end - start));
        return rand;
    }
    char randamo(){
        char[] operators = {'+', '-', '*', '/', '%'};

        return operators[random(0,5)];
    }
}
class Player extends QuesHandeler{
    String name;
    short age;
    int ques_attempt;
    int ques_correct;
    int score;
    int question_no = 0;
    Player(String name, int age){
        this(name, age, 100);
    }
    Player(String name, int age, int num){
        super(num);
        this.name = name;
        this.age = (short)age;
    }
    public void askQuestion(){
        Scanner scan = new Scanner(System.in);
        display(question_no);
        int ans = scan.nextInt();
        if(isCorrect(ans, question_no)){
            score+=2;
            ques_correct++;
        }
        else{
            score--;
        }
        question_no++;
    }
    public boolean start() {
        if(length > question_no){
            askQuestion();
            return true;
        }
        else{
            System.out.println("The Questions are Over");
            return false;
        }
    }
    public void display(){
        System.out.printf("""
Name    =>  %s
Age     =>  %d
Attempt =>  %d
Correct =>  %d
Score   =>  %d
                """,name, age, question_no, ques_correct, score);
    }
}
class Quiz{
    Timer timer_thread;
    Player player;
    Quiz(){
        this(1000, 2 * 60 * 1000);
    }
    Quiz(int num,int time){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = scan.nextLine();
        System.out.print("Enter your Age : ");
        int age = scan.nextInt();
        timer_thread = new Timer(time);
        player = new Player(name, age, num);

    }
    Quiz(String name, int age, int time){
        this(name, age, 100, time);
    }
    Quiz(String name, int age, int num, int time ){
        timer_thread = new Timer(time);
        player = new Player(name, age, num);
    }
    public void start(){
        timer_thread.start();
        while(!timer_thread.isTimeOver && player.start());
        player.display();
    }
}
class JavaProgramToImplementMultiThreading{
    public static void main(String[] args) {
        Quiz obj = new Quiz();
        obj.start();
    }
}
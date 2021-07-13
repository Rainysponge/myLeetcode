package LC;

import java.util.Scanner;

public class PTA_JIA_1036 {
    class Student{
        public void setName(String name) {
            this.name = name;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public void setScore(int score) {
            this.score = score;
        }

        String name;
        String sex;
        String ID;
        int score;
        public Student(String name, String sex, String ID, int score){
            this.name = name;
            this.sex = sex;
            this.ID = ID;
            this.score = score;

        }

    }

    public void solution(){
        int N = 0;
        N = new Scanner(System.in).nextInt();
        Student[] student = new Student[N];
        int i=0;
        while(i<N){

            String info = new Scanner(System.in).nextLine();
            String[] infoList = info.split(" ");
            student[i] = new Student(infoList[0], infoList[1], infoList[2], Integer.parseInt(infoList[3]));
            i++;
        }

        for(i=0; i<N; i++){
            System.out.println(student[i].name+" "+student[i].sex+" "+student[i].ID+" "+student[i].score);
        }
    }
}

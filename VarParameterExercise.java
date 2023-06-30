public class VarParameterExercise {
    public static void main(String[] args) {
        JsxMethod myMethod = new JsxMethod();
        System.out.println(myMethod.showScore("JiangShangXiao", 99,99));
    }
}

class JsxMethod {
    public String showScore(String name,double... scores) {
        double totalScore = 0;
        for (int i = 0;i < scores.length;i++) {
            totalScore += scores[i];
        }
        return name + "有" + scores.length + "门的成绩为" + totalScore;
    }
}
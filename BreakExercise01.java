import java.util.Scanner;
public class BreakExercise01 {
    //编写一个main方法
    public static void main(String[] args) {
        //实现登录验证，有3次机会，如果用户名为"丁真",密码”666“提示登陆成功
        //否则提示还有几次机会，请使用for+break完成
        String name = "";
        String passwd = "";
        int chance = 3; // 登陆一次，就减少一次机会
        Scanner myScanner = new Scanner(System.in);
        for (int i = 1; i <= 3;i++) { // 3次登陆机会
            System.out.println("请输入名字：");
            name = myScanner.next();
            System.out.println("请输入密码：");
            passwd = myScanner.next();
            if ("丁真".equals(name) && "666".equals(passwd)) {
                System.out.println("恭喜你，登陆成功");
                break;
            }
            chance--;
            System.out.println("你还有" + chance + "次登录机会");
        }
    }
}

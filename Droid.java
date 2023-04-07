public class Droid {
    String name;
    int batteryLevel;

    public Droid(String droidName) {
        name = droidName;
        batteryLevel = 100;
    }

    public String toString() {
        return "你好我是机器人" + name;
    }

    public void performTask(String task) {
        System.out.println(name + "正在执行" + task + "任务！");
        batteryLevel -= 10;
    }

    public void energyReport() {
        System.out.println("现在电量为" + batteryLevel + "%");
    }

    public void energyTransfer() {
        batteryLevel = 100;
        System.out.println("充电完毕！");
    }

    public static void main(String[] args) {
        Droid myDroid = new Droid("9527");
        System.out.println(myDroid);
        myDroid.performTask("扫地");
        myDroid.energyReport();
        myDroid.energyTransfer();
        myDroid.energyReport();
    }
}

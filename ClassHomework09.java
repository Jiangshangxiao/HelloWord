public class ClassHomework09 {
    public static void main(String[] args) {
        //定义一个Music类,里面有音乐名name、音乐市场time属性,
        //并有播放play功能和返回本身属性信息的功能方法getInfo
        Music myMusic = new Music("笑傲江湖", 300);
        myMusic.play();
        System.out.println(myMusic.getInfo());
    }
}

class Music {
    String name;
    int times;
    public Music(String name, int times) {
        this.name = name;
        this.times = times;
    }

    public void play() {
        System.out.println("音乐" + name + "正在播放中.....时长为" + times + "秒");
    }
    public String getInfo() {
        return "音乐" + name + "播放时间为" + times;
    }
}

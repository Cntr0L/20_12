
import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {

    public static AudioClip troll;
    public static void main(String[] args) throws AWTException, IOException {
        Robot botbot = new Robot();
        start();

        while(true){
            int a = (int)(Math.random()*1921);
            int b = (int)(Math.random()*900);
            botbot.mouseMove(a,b);
            botbot.delay(200);
            botbot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            botbot.delay(4);
            botbot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        //Runtime rt = Runtime.getRuntime();
        //rt.exec("cmd.exe /c start", null, new File("C:\\Users\\jvila"));


    }

    public static void spawn1(int x, int y){
        String path = chosePath();
        GUI temp = new GUI("TROLL",300,300,x, y, path);
        JButton click_to_close = temp.addButton("CLICK TO CLOSE",0,220,150,50);
        temp.setButtonGenMore(click_to_close);
        JButton random = temp.addButton("CANCLE",150,220,150,50);
        temp.setButtonGenRandom(random);
        JButton cmd = temp.addButton("CMD", 110, 15, 80,40);
        temp.setButtonGenHAX(cmd);
    }
    public static void start(){
        troll  = Applet.newAudioClip(Launcher.class.getResource("TrollSong.wav"));
        troll.loop();
        scrollLR();
        scrollRL();
        genRandom();
    }
    public static void scrollLR(){
        for(int i = 0; i < 1080; i+= 100){
            for(int j = 0; j < 1920; j+=150){
                String path = chosePath();
                GUI temp = new GUI("TROLL",300,300,j, i, path);
                JButton click_to_close = temp.addButton("CLICK TO CLOSE",0,220,150,50);
                temp.setButtonGenMore(click_to_close);
                JButton random = temp.addButton("CANCLE",150,220,150,50);
                temp.setButtonGenRandom(random);
                JButton cmd = temp.addButton("CMD", 110, 15, 80,40);
                temp.setButtonGenHAX(cmd);
            }
        }
    }

    public static void scrollRL(){
        for(int i = 1080; i > 0;i-= 100){
            for(int j = 1980; j > 0; j-=150){
                String path = chosePath();
                GUI temp = new GUI("TROLL",300,300,j, i, path);
                JButton click_to_close = temp.addButton("CLICK TO CLOSE",0,220,150,50);
                temp.setButtonGenMore(click_to_close);
                JButton random = temp.addButton("CANCLE",150,220,150,50);
                temp.setButtonGenRandom(random);
                JButton cmd = temp.addButton("CMD", 110, 15, 80,40);
                temp.setButtonGenHAX(cmd);
            }
        }
    }

    public static String chosePath(){
        String path = null;
        int rand = (int)(Math.random()*5);
        if(rand == 0){
            path = "/faceLeft.png";
        }
        else if(rand == 1){
            path = "/faceRight.png";
        }
        else if(rand == 2){
            path = "/kingTroll.png";
        }
        else{
            path = "/problem.png";
        }
        return path;
    }

    public static void genRandom(){
        int temp = (int)(Math.random()*150 + 30);
        for(int i = 0; i < temp; i++){
            int a = (int)(Math.random()*1921);
            int b = (int)(Math.random()*1081);
            spawn1(a,b);
        }
    }

    public static void haxCMD(){
        try{
            Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"cd C:\\Users\\jvila && color a && tree");

        }
        catch (Exception e){
            System.out.println("wrong");
            e.printStackTrace();
        }
    }
}

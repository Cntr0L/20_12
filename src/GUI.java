import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI extends Frame{

    private JFrame frame;
    private JPanel panel;

    private final int width,height;
    private int x,y;

    private JLabel background;
    private ImageIcon startScreenBg;
    public GUI(String t,int w, int h, int x, int y,String path) {
        frame = new JFrame();
        panel = new JPanel();

        width = w;
        height = h;

        URL url = getClass().getResource(path);
        if (url == null){
            throw new RuntimeException("cannot find file:  " + path);
        }

        try{
            URL resource = frame.getClass().getResource("/kingTroll.png");
            BufferedImage image = ImageIO.read(resource);
            frame.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        startScreenBg = new ImageIcon(url);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle(t);
        frame.setPreferredSize(new Dimension(w,h));
        frame.setResizable(false);

        background = new JLabel(startScreenBg);


        this.setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        frame.setLocation(x,y);
        frame.add(panel);
        frame.add(background);
        panel.setLayout(null);
        frame.pack();



        frame.setVisible(true);
    }

    public JButton addButton(String name, int x, int y, int w, int h){
        JButton button = new JButton(name);
        button.setBounds(x,y,w,h);

        background.add(button);

        return button;
    }

    public void setButtonGenMore(JButton b){
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                selectionButtonPressed();
            }

            private void selectionButtonPressed() {
                Launcher launcher = new Launcher();
                Launcher.start();
            }
        });
    }
    public void setButtonGenRandom(JButton b){
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                selectionButtonPressed();
            }

            private void selectionButtonPressed() {
                Launcher l = new Launcher();

                int temp = (int)(Math.random()*200 + 30);

                for(int i =0; i < temp; i++){
                    int a = (int)(Math.random()*1921);
                    int b = (int)(Math.random()*900);
                    l.spawn1(a,b);
                }

                int rand = (int)(Math.random()*99);
                if(rand <= 30){
                    l.haxCMD();
                }
            }
        });
    }

    public void setButtonGenHAX(JButton b){
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                selectionButtonPressed();
            }

            private void selectionButtonPressed() {
                Launcher l = new Launcher();
                l.haxCMD();
            }
        });
    }

}


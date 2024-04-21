import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ThreadBoard extends JPanel implements Runnable
{
    private final int BWIDTH=1500;
    private final int BHEIGHT=700;
    private final int INITIAL_X=750;
    private final int INITIAL_Y=0;
    private final int DELAY=25;

    private Image egg;
    private Thread animator;
    private int x,y;
    
    public ThreadBoard()
    {
        initThreadBoard();
    }

    private void initThreadBoard()
    {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(BWIDTH,BHEIGHT));

        loadImage();

        x=INITIAL_X;
        y=INITIAL_Y;
    }

    private void loadImage()
    {
        ImageIcon ii=new ImageIcon("E:\\CODES\\Java-Game\\src\\Assets\\egg.jpg");
        egg=ii.getImage();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawEgg(g);
    }

    private void drawEgg(Graphics g)
    {
        g.drawImage(egg,x,y,this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle()
    {
        //x+=1;
        y+=1;
        if(y>BHEIGHT)
        {
            x=INITIAL_X;
            y=INITIAL_Y;
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        animator=new Thread(this);
        animator.start();
    }

    public void run()
    {
        long beforeTime, timeDiff, sleep;

        beforeTime=System.currentTimeMillis();

        while(true)
        {
            cycle();
            repaint();

            timeDiff=System.currentTimeMillis()-beforeTime;
            sleep=DELAY-timeDiff;

            if(sleep<0)
            sleep=2;

            try
            {
                Thread.sleep(sleep);   
            }catch(InterruptedException e){
                String msg=String.format("Thread interrupted: %s",e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",JOptionPane.ERROR_MESSAGE);
            }
            beforeTime=System.currentTimeMillis();
        }
    }
}

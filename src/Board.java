import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;

public class Board extends JPanel implements ActionListener{
    
    private final int BWIDTH=350;
    private final int BHEIGHT=350;
    private final int INITIAL_X=-40;
    private final int INITIAL_Y=-40;
    private final int DELAY=25;

    private Image star;
    private Timer timer;
    private int x,y;

    public Board()
    {
        initBoard();
    }

    private void loadImage()
    {
        ImageIcon ii=new ImageIcon("E:\\CODES\\Java-Game\\src\\Assets\\star.png");
        star=ii.getImage();
    }

    private void initBoard()
    {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(BWIDTH,BHEIGHT));

        loadImage();

        x=INITIAL_X;
        y=INITIAL_Y;

        timer=new Timer(DELAY, this);
        timer.start();
    }

    @Override

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawStar(g);
    }

    private void drawStar(Graphics g)
    {
        g.drawImage(star,x,y,this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x+=1;
        y+=1;

        if(y>BHEIGHT)
        {
            y=INITIAL_Y;
            x=INITIAL_X;
        }
        revalidate();
        repaint();
    }

}
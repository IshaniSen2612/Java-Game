import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardSpace extends JPanel implements ActionListener{

    private Timer timer;
    private Spaceship ship;
    private final int DELAY=10;

    public BoardSpace()
    {
        initBoard();
    }

    private void initBoard()
    {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        ship=new Spaceship();

        timer=new Timer(DELAY,this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw(Graphics g)
    {
        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(ship.getImage(),ship.getX(),ship.getY(),this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        step();
    }

    private void step()
    {
        ship.move();
        repaint(ship.getX()-1,ship.getY()-1,ship.getWidth()+2,ship.getHeight()+2);
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) 
        {
            ship.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            ship.keyPressed(e);
        }
    }
}


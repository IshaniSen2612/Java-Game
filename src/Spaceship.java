import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Spaceship 
{
    private int x=40;
    private int y=60;
    private int dx;
    private int dy;
    private int w;
    private int h;
    private Image image;
    
    public Spaceship()
    {
        loadImage();
    }

    /**
     * loadImage() loads the image to be used as sprite
     */
    private void loadImage()
    {
        ImageIcon ii=new ImageIcon("E:\\CODES\\Java-Game\\src\\Assets\\24752-5-spaceship.png");
        
        image=ii.getImage().getScaledInstance(120, 50, Image.SCALE_DEFAULT);
       
        w=image.getWidth(null);
        h=image.getHeight(null);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return w;
    }

    public int getHeight()
    {
        return h;
    }

    public Image getImage()
    {
        return image;
    }

    public void move()
    {
        x+=dx;
        y+=dy;
    }

    public void keyPressed(KeyEvent e)
    {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_LEFT)
            dx=-2;

        if(key==KeyEvent.VK_RIGHT)
            dx=2;
        
        if(key==KeyEvent.VK_UP)
            dy=-2;

        if(key==KeyEvent.VK_DOWN)
            dy=2;
    }

    public void keyReleased(KeyEvent e)
    {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_LEFT)
            dx=0;
        
        if(key==KeyEvent.VK_RIGHT)
            dx=0;
        
        if(key==KeyEvent.VK_UP)
            dy=0;

        if(key==KeyEvent.VK_DOWN)
            dy=0;   
    }
}

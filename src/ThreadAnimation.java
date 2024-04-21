import java.awt.EventQueue;

import javax.swing.JFrame;

public class ThreadAnimation extends JFrame {
    public ThreadAnimation()
    {
        initUI();
    }

    private void initUI()
    {
        add(new ThreadBoard()); //creates instance of Board class 

        setResizable(false);
        pack();
        setTitle("Egg Animation using thread");
        setLocationRelativeTo(null);
        setExtendedState(getExtendedState()|MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(()->
        {
            JFrame ex=new ThreadAnimation();

            ex.setVisible(true);
        });
    }
}

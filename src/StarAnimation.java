import java.awt.EventQueue;

import javax.swing.JFrame;

public class StarAnimation extends JFrame{
    StarAnimation()
    {
        initUI();
    }
    private void initUI()
    {
        add(new Board());
        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(getExtendedState()|MAXIMIZED_BOTH);
    }
    public static void main(String args[])
    {
        EventQueue.invokeLater(()->
        {
            StarAnimation s=new StarAnimation();
            s.setVisible(true);
        });
    }
}

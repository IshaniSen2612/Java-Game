import javax.swing.JFrame;

public class AppWindow extends JFrame
{
    AppWindow()
    {
        initUI();
    }

    private void initUI()
    {
        setTitle("Game");
        setSize(200,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() |MAXIMIZED_BOTH);
    }
    public static void main(String[] args) 
    {
        AppWindow win=new AppWindow();
        win.setVisible(true);
        
    }
}
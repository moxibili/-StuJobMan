package window;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Mainjm {
    JFrame jFrame = new JFrame("高校就业信息管理系统主界面");
    Container contentPane;
    JTabbedPane jTabbedPane;
    int jPanelLabNum = 6;

    JPanel[] jPanels = new JPanel[5];

    public void go(){
        contentPane = jFrame.getContentPane();
        jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(jTabbedPane);

        designPanel();

        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        jFrame.setBounds(500, 50, 700, 550);
    }

    protected void designPanel(){
        //创建面板
        jPanels[0] = new JPanel();
        jPanels[1] = new JPanel();
        jPanels[2] = new JPanel();
        jPanels[3] = new JPanel();
        jPanels[4] = new JPanel();

        //设置面板的背景色
       /* jPanels[0].setBackground(Color.RED);
        jPanels[1].setBackground(Color.BLUE);
        jPanels[2].setBackground(Color.GREEN);
        jPanels[3].setBackground(Color.YELLOW);*/

        //将面板加入jTabbedPanel中
        XIugai xiugai = new XIugai();
        Chaxun chaxun = new Chaxun();
        Dengji dengji = new Dengji();
        Dengji1 dengji1 = new Dengji1();
        Chaxun1 chaxun1 = new Chaxun1();
        jTabbedPane.add("管理学生信息",xiugai);
        jTabbedPane.add("企业需求登记",  dengji1 );
        jTabbedPane.add("就业信息登记", dengji);
        jTabbedPane.add("查询就业信息",  chaxun);  
        jTabbedPane.add("查询学生信息", chaxun1);
        Font font = new Font("华文彩云", Font.BOLD, 15);

        //设置标签页名字的字体
      jTabbedPane.setFont(font);

 /*       //设置标签页的背景色
        jTabbedPane.setBackground(Color.yellow);
        
        //设置标签页的前景色
        jTabbedPane.setForegroundAt(0, Color.RED);
        jTabbedPane.setForegroundAt(1, Color.BLUE);
        jTabbedPane.setForegroundAt(2, Color.GREEN);
        jTabbedPane.setForegroundAt(3, Color.YELLOW);*/

        
        //设置标签面板的changeListener,注册事件
     /*   jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("这是第：" + (jTabbedPane.getSelectedIndex() + 1) + "  个标签页: " );
            }
        });*/
    
    }
}

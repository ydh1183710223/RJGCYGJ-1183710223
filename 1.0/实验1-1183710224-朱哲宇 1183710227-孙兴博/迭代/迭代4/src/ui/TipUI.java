package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 错误信息弹窗
 * @author sunxingbo
 *
 */
public class TipUI {
	public TipUI(String text)
	{
		JFrame Tip=new JFrame("错误!");
		Tip.setSize(300, 200);
		Tip.setLayout(null);
		Tip.setLocationRelativeTo(null);
		
		
		JLabel  content=new JLabel(text);
		Font JT=new Font("宋体",Font.BOLD,20);
  		content.setFont(JT);
  		content.setHorizontalAlignment(JTextField.CENTER);
  		content.setBounds(10, 0, 250, 100);
  		Tip.add(content);
  		
  		
		JButton ok=new JButton("确定");
		ok.setFont(JT);
		ok.setBounds(90, 90, 80, 30);
		ok.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Tip.setVisible(false);
					}
				});
		Tip.add(ok);
		
		Background bgd1;
		bgd1 = new Background((new ImageIcon("src//bak2.png")).getImage());
		bgd1.setBounds(0, 0, 280, 150);
		Tip.add(bgd1);
		
		
		Tip.setVisible(true);
	}
}

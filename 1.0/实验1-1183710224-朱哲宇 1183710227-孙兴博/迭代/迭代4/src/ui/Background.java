package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * ±≥æ∞Õº∆¨…Ë÷√¿‡
 * @author sunxingbo
 *
 */
public class Background extends JPanel{
 
		Image im;
		public Background(Image im)
		{
			this.im=im;
			this.setOpaque(true);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(im, 0, 0, this.getWidth(),this.getHeight(),this);
			
		}
}
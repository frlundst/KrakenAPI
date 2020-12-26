package kraken;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.*;
import java.awt.Color;
import java.io.*;
import javax.swing.*;

public class Interface {

	public static void main(String[] args) {
		
		String xbtvalue = "";
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(750,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(panel);
		panel.setLayout(null);
		
		panel.setBackground(Color.LIGHT_GRAY);
		
		
		while(true) {
			xbtvalue = Kraken.krakenConnect();
			JLabel label = new JLabel(xbtvalue);
			label.setBounds(10,20,120,25);
			panel.add(label);
			
			label.revalidate();
			frame.repaint();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.remove(label);
			
		}
		
		//JLabel label = new JLabel(xbtvalue);
		//label.setBounds(10,20,120,25);
		//panel.add(label);
		/*frame.repaint();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panel.remove(label);
		
		label = new JLabel("TEST");
		label.setBounds(10,20,120,25);
		panel.add(label);
		
		label.revalidate();
		frame.repaint();*/

	}

}

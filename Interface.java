package KrakenAPI;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.*;
import java.awt.Color;
import java.io.*;
import javax.swing.*;

public class Interface {

	public static void main(String[] args) {
		
		String xbtvalue = "";
		JFrame frame = CreateFrame(); //Skapa frame
		
		JPanel panel = new JPanel();
		
		frame.add(panel);
		panel.setLayout(null);
		
		panel.setBackground(Color.LIGHT_GRAY);
		
		boolean pointbool = false;
		JLabel label = new JLabel(xbtvalue);
		label.setBounds(10,20,120,25);
		panel.add(label);

		
		while(true) {
			
			xbtvalue = Kraken.krakenConnect();
			
			if(Double.parseDouble(xbtvalue) > 38500 && pointbool == false) {
		        JOptionPane.showMessageDialog(null, "XBT value greater than: " + 38500, "Alert", JOptionPane.INFORMATION_MESSAGE);
		        pointbool = true;
			} else if (Double.parseDouble(xbtvalue) < 38500){
				pointbool = false;
			}
			
			label.setText(xbtvalue);
			label.revalidate();
			frame.repaint();
			
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

	}
	
	public static JFrame CreateFrame() {
		JFrame frame = new JFrame();
		frame.setSize(750,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		return frame;
	}

}

package JFrame.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")


public class demo extends JFrame {
	//public static final int GRID = 3;
	JPanel pn;
	int alternate = 0;//if this number is a even, then put a X. If it's odd, then put an O
	private JButton bt[][] = new JButton[3][3];

	public demo(String tt){
		super(tt);
		Screen();
	}

	public void Screen() {
		Container conn = getContentPane();

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new FlowLayout());
		conn.add(pnMain,BorderLayout.CENTER);
		pn = new JPanel();
		pn.setLayout(new GridLayout(3, 3));
		for (int i = 0; i <= 2 ; i++ ) {
			for ( int j = 0 ; j <= 2 ; j++) {
				bt[i][j] = new JButton("");
				pn.add(bt[i][j]);
				bt[i][j].setActionCommand(String.valueOf(i));
				bt[i][j].setBackground(Color.CYAN);
				bt[i][j].addActionListener(new buttonListener());
				bt[i][j].setFont(new Font("Antique", 1, 120));
			}
		}
		conn.add(pn);
	}
	public void ShowWindow(){
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void reset()
	{
		alternate = 0;
		for ( int i = 0 ; i <= 2 ; i++) {
			for ( int j = 0 ; j <= 2 ; j++) {
				bt[i][j].setText("");
			}
		}
	}

	private class buttonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{

			JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
			if(buttonClicked.getText().equals("")) {
				if(alternate%2 == 0)
				{
					buttonClicked.setText("X");
					if(check("X")==true) {
						JOptionPane.showMessageDialog(null,"X win","notice",JOptionPane.YES_OPTION);
						reset();
					}
				}
				else {
					buttonClicked.setText("O");
					if(check("O")==true) {
						JOptionPane.showMessageDialog(null,"O win","notice",JOptionPane.YES_OPTION);
						reset();
					}
				}
				if(alternate==9) {
					JOptionPane.showMessageDialog(null,"Deo than lol nao thang","notice",JOptionPane.YES_OPTION);
					reset();
				}
				alternate++;

			}		
		}
		public boolean check(String v) {
			//check row
			for( int  i = 0 ; i <= 2 ; i ++ ) {
				int check1 = 0;
				for ( int j = 0 ; j <= 2 ; j++) {
					if(bt[i][j].getText().equals(v)) check1++;
				}
				if(check1==3) return true;
			}
			//check col
			for( int  i = 0 ; i <= 2 ; i ++ ) {
				int check1 = 0;
				for ( int j = 0 ; j <= 2 ; j++) {
					if(bt[j][i].getText().equals(v)) check1++;
				}
				if(check1==3) return true;
			}
			// check duong cheo
			int dem = 0;
			for ( int i = 0 ; i <= 2 ; i++) {
				if(bt[i][i].getText().equals(v)) dem++;
				if(dem==3) return true;
			}
			//check duong cheo
			int dem1 = 0;
			for ( int i = 0 ; i <= 2 ; i++) {
				int j = 2 - i;
				if(bt[i][j].getText().equals(v)) dem1++;
				if(dem1==3) return true;
			}
			return false;
		}
	}
}
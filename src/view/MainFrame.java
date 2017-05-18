package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private SSHPanel sshPanel;
	
	public MainFrame() {
		super("Zustandsliste der Standorte"); //set Window name
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		LoginPanel loginPanel = new LoginPanel();
		sshPanel = new SSHPanel(loginPanel);
		
		setLayout(new BorderLayout());
		getContentPane().add(loginPanel, BorderLayout.CENTER);
		getContentPane().add(sshPanel, BorderLayout.NORTH);
		
		setSize(new Dimension(500,850));
		setLocation(dim.width/2-400, 50);
		setVisible(true);
	}

	public SSHPanel getSshPanel() {
		return sshPanel;
	}

}

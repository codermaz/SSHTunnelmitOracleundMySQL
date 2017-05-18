package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.LoginPanel;

public class MySQLKonfiguration implements ActionListener{
	private LoginPanel panel;
	
	public MySQLKonfiguration(JPanel panel) {
		this.panel=(LoginPanel) panel;
		configStrings();
	}

	private void configStrings() {
		// SSH loging username 	//String strSshUser = "ssh_user_name";
		String strSshUser = "Ay-171259";
		
		// SSH login password // String strSshPassword = "abcd1234";
		String strSshPassword = "...";
		
		// hostname or ip or SSH server // String strSshHost = "your.ssh.hostname.com";
		String strSshHost = "ssh.hs-weingarten.de";
		
		// remote SSH host port number 	// int nSshPort = 22;
		int nSshPort = 22;
		
		// hostname or ip of your database server // String strRemoteHost = "your.database.hostname.com";
		String strRemoteHost = "fbe-neptun.hs-weingarten.de";
		
		// remote port number of your database 	
		int nRemotePortMySQL = 3306; 
		
		panel.setJdbcPrefix("jdbc:mysql://");
		panel.setServer("localhost:");

		// local port number use to bind SSH tunnel // int nLocalPort = 3366;
		int nLocalPortMySQL = 3306;
		
		panel.setLocalPort(Integer.toString(nLocalPortMySQL));
		panel.setDb("/hb_student_tracker");

		// database loging username  // String strDbUser = "db_user_name";
		String strDbUserMySQL = "hbstudent";
		panel.setUser(strDbUserMySQL);
		
		// database login password 	// String strDbPassword = "4321dcba";
		String strDbPasswordMySQL = "...";
		panel.setPw(strDbPasswordMySQL);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		configStrings();
		
	}
	
	
}

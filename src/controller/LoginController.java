package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import model.NotenModel;
import model.StudentModel;
import view.LoginPanel;
import view.MainFrame;
import view.SSHPanel;
import view.TableView;

public class LoginController implements ActionListener {
	private String forNameKlasse = "";
	private Boolean SshOK;
	private String connString;

	private static void doSshTunnel(String strSshUser, String strSshPassword, String strSshHost, int nSshPort,
			String strRemoteHost, int nLocalPort, int nRemotePort) throws JSchException {
		final JSch jsch = new JSch();
		Session session = jsch.getSession(strSshUser, strSshHost, 22);
		session.setPassword(strSshPassword);

		final Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);

		session.connect();
		session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LoginPanel loginPanel = (LoginPanel) ((Component) e.getSource()).getParent();
		MainFrame mainFrame = (MainFrame) loginPanel.getParent().getParent().getParent().getParent();
		SSHPanel sshPanel = mainFrame.getSshPanel();
		Connection connection = null;

		String strSshServer = sshPanel.getSshServer().getText();
		String nSshPort = sshPanel.getSshPort().getText();
		String strRemoteHost = sshPanel.getSshRemoteHost().getText();
		String nRemotePort = sshPanel.getSshRemotePort().getText();
		String nLocalPort = sshPanel.getSshLocalPort().getText();
		String strSshUser = sshPanel.getSshUser().getText();
		String strSshPassword = String.valueOf(sshPanel.getSshPw().getPassword());

		String prefix = loginPanel.getJdbcPrefix();
		String server = loginPanel.getServer();
		String lokalPort = loginPanel.getLocalPort();
		String dbname = loginPanel.getDb();
		String user = loginPanel.getUser();
		String pw = String.valueOf(loginPanel.getPw().getPassword());

		if (loginPanel.getSSHButton().isSelected()) {
			try {
				SshOK=false;
				System.out.println(strSshServer+" : "+nSshPort+" : "+strRemoteHost+" : "+nRemotePort+" : "+nLocalPort);
				doSshTunnel(strSshUser, strSshPassword, strSshServer, Integer.parseInt(nSshPort),
						strRemoteHost, Integer.parseInt(nLocalPort), Integer.parseInt(nRemotePort));
				System.out.println("SSH Server Tunnel: Succesful");
				SshOK=true;
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			} catch (JSchException e2) {
				e2.printStackTrace();
			}
		} else if (loginPanel.getOhneSSHButton().isSelected()) {
			System.out.println(" No SSH selected @LoginControl ");
			SshOK=false;
		}

		if (loginPanel.getOracleButton().isSelected()) {
			forNameKlasse = "oracle.jdbc.OracleDriver";
			// jdbc:oracle:thin:@SERVER:1033:namib  << mit SSH
			// jdbc:oracle:thin:@SERVER:1521:namib  << ohne SSH
			connString = prefix + server + lokalPort + dbname;
			System.out.println(" Connection String (Oracle) = " + connString);
		} else {
			forNameKlasse = "com.mysql.jdbc.Driver";
			// jdbc:mysql://SERVER:3366/hb_student_tracker << mit SSH
			// jdbc:mysql://SERVER:3306/hb_student_tracker << ohne SSH
			connString = prefix + server + lokalPort + dbname;
			System.out.println(" Connection String (MySQL)= " + connString);
		}

		try {
			Class.forName(forNameKlasse).newInstance();
		} catch (ClassNotFoundException ex) {
			System.out.println("Fehler: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.print(" Driver Manager Connection ......: ");
			connection = DriverManager.getConnection(connString, user, pw);
			System.out.println("OK");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}

		mainFrame.getContentPane().remove(loginPanel);
		mainFrame.getContentPane().removeAll();

		StudentModel studModel = new StudentModel(connection);
		NotenModel notenModel = new NotenModel(connection, null);

		TableView tv = new TableView(studModel, notenModel);
		mainFrame.getContentPane().add(tv);
		mainFrame.setSize(800, 300);
	}

}

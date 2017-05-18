package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.LoginPanel;
import view.SSHPanel;

public class MitSSHKonfiguration implements ActionListener{
	private SSHPanel sshPanel;
	private LoginPanel loginPanel;
	
	public MitSSHKonfiguration(SSHPanel sshPanel, LoginPanel loginPanel) {
		this.sshPanel=sshPanel;
		this.loginPanel=loginPanel;
		configStrings();
	}

	private void configStrings() {
		sshPanel.setSshServer("ssh.hs-weingarten.de");
		sshPanel.setSshPort("22");
		sshPanel.setSshRemoteHost("fbe-neptun.hs-weingarten.de");
		// remote port number of your database
		int remotePort;
		int localPort;
		if (loginPanel.getOracleButton().isSelected()) {
			remotePort = 1521;
			localPort=1033;
		}
		else {
			remotePort = 3306;
			localPort = 3366;
		}
		sshPanel.setSshRemotePort(Integer.toString(remotePort));
		sshPanel.setSshLocalPort(Integer.toString(localPort));
		sshPanel.setSshUser("Ay-171259");
		sshPanel.setSshPw("...");
		
		loginPanel.setLocalPort(Integer.toString(localPort));
		loginPanel.setServer("localhost:");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LoginPanel loginPanel = (LoginPanel)((Component)e.getSource()).getParent();
		if (loginPanel.getSSHButton().isSelected()) {
			sshPanel.setVisible(true);
			configStrings();
			
		}
	}

}

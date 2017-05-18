package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginPanel;
import view.SSHPanel;

public class OhneSSHKonfiguration implements ActionListener{
	private SSHPanel sshPanel;
	private LoginPanel loginPanel;
	
	public OhneSSHKonfiguration(SSHPanel sshPanel, LoginPanel loginPanel) {
		this.sshPanel=sshPanel;
		this.loginPanel=loginPanel;
		configStrings();
	}

	private void configStrings() {

			if (loginPanel.getOracleButton().isSelected()) {
				loginPanel.setServer("fbe-neptun.hs-weingarten.de");
				loginPanel.setLocalPort("1521");		
			}
			else if (loginPanel.getMySQLButton().isSelected()) {
				loginPanel.setServer("localhost:");
				loginPanel.setLocalPort("3306");				
			}
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		sshPanel.setVisible(false);
		configStrings();
	}

}

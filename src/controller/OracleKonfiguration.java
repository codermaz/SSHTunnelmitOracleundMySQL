package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.LoginPanel;
import view.SSHPanel;

public class OracleKonfiguration implements ActionListener {
	private LoginPanel loginPanel;
	private SSHPanel sshPanel;

	public OracleKonfiguration(JPanel loginPanel) {
		this.loginPanel = (LoginPanel) loginPanel;
		//this.sshPanel = loginPanel.getParent().getSshPane
		configStrings();
	}

	private void configStrings() {

		loginPanel.setJdbcPrefix("jdbc:oracle:thin:@");
		int nLocalPortOracle;
		if (loginPanel.getOhneSSHButton().isSelected()) {
			loginPanel.setServer("fbe-neptun.hs-weingarten.de");
			nLocalPortOracle = 1521;
		} else {
			loginPanel.setServer("localhost:");
			nLocalPortOracle = 1033;
			
		}

		loginPanel.setLocalPort(Integer.toString(nLocalPortOracle));
		loginPanel.setDb(":namib");

		// database loging username // String strDbUser = "db_user_name";
		String strDbUserOracle = "DABS_42";
		loginPanel.setUser(strDbUserOracle);

		// database login password // String strDbPassword = "4321dcba";
		String strDbPasswordOracle = "...";
		loginPanel.setPw(strDbPasswordOracle);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		configStrings();

	}

}

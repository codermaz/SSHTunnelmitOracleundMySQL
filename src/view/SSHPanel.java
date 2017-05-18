package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MitSSHKonfiguration;
import controller.OhneSSHKonfiguration;

public class SSHPanel extends JPanel {
	private LoginPanel loginPanel;
	private JTextField sshServer;
	private JTextField sshPort;
	private JTextField sshRemoteHost;
	private JTextField sshRemotePort;
	private JTextField sshLocalPort;
	private JTextField sshUser;
	private JPasswordField sshPw;
	private Dimension dimLinks = new Dimension(100, 40);
	private Dimension dimRechts = new Dimension(250, 40);


	public SSHPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel; 
		sshServer = new JTextField();
		sshServer.setPreferredSize(dimRechts);

		sshPort = new JTextField();
		sshPort.setPreferredSize(dimRechts);

		sshRemoteHost = new JTextField();
		sshRemoteHost.setPreferredSize(dimRechts);

		sshRemotePort = new JTextField();
		sshRemotePort.setPreferredSize(dimRechts);

		sshLocalPort = new JTextField();
		sshLocalPort.setPreferredSize(dimRechts);

		sshUser = new JTextField();
		sshUser.setPreferredSize(dimRechts);

		sshPw = new JPasswordField();
		sshPw.setPreferredSize(dimRechts);


		GridLayout layout = new GridLayout(8, 2);
		setLayout(layout);

		JLabel lblSServer = new JLabel("  SSH server  ");
		lblSServer.setPreferredSize(dimLinks);
		lblSServer.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSServer);
		add(sshServer);

		JLabel lblSPort = new JLabel("  SSH port number  ");
		lblSPort.setPreferredSize(dimLinks);
		lblSPort.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSPort);
		add(sshPort);

		JLabel lblRemoteHost = new JLabel("  Hostname of your database server  ");
		lblRemoteHost.setPreferredSize(dimLinks);
		lblRemoteHost.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblRemoteHost);
		add(sshRemoteHost);

		JLabel lblRemotePort = new JLabel("  Remote port number  ");
		lblRemotePort.setPreferredSize(dimLinks);
		lblRemotePort.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblRemotePort);
		add(sshRemotePort);
 
		JLabel lblLocalPort = new JLabel("  Local port number  ");
		lblLocalPort.setPreferredSize(dimLinks);
		lblLocalPort.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblLocalPort);
		add(sshLocalPort);

		JLabel lblUser = new JLabel("  SSH login username  ");
		lblUser.setPreferredSize(dimLinks);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblUser);
		add(sshUser);

		JLabel lblPw = new JLabel("  SSH login pass  ");
		lblPw.setPreferredSize(dimLinks);
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPw);
		add(sshPw);

		add(new JLabel());
		add(new JLabel());
		
		loginPanel.getOhneSSHButton().addActionListener(new OhneSSHKonfiguration(this, loginPanel));
		loginPanel.getSSHButton().addActionListener(new MitSSHKonfiguration(this, loginPanel));
	}


	public JTextField getSshServer() {
		return sshServer;
	}


	public void setSshServer(String sshServer) {
		this.sshServer.setText(sshServer);
	}


	public JTextField getSshPort() {
		return sshPort;
	}


	public void setSshPort(String sshPort) {
		this.sshPort.setText(sshPort);
	}


	public JTextField getSshRemoteHost() {
		return sshRemoteHost;
	}


	public void setSshRemoteHost(String sshRemoteHost) {
		this.sshRemoteHost.setText(sshRemoteHost);
	}


	public JTextField getSshRemotePort() {
		return sshRemotePort;
	}


	public void setSshRemotePort(String sshRemotePort) {
		this.sshRemotePort.setText(sshRemotePort);
	}


	public JTextField getSshLocalPort() {
		return sshLocalPort;
	}


	public void setSshLocalPort(String sshLocalPort) {
		this.sshLocalPort.setText(sshLocalPort);
	}


	public JTextField getSshUser() {
		return sshUser;
	}


	public void setSshUser(String sshUser) {
		this.sshUser.setText(sshUser);
	}


	public JPasswordField getSshPw() {
		return sshPw;
	}


	public void setSshPw(String sshPw) {
		this.sshPw.setText(sshPw);
	}
}

package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;
import controller.MySQLKonfiguration;
import controller.OracleKonfiguration;
import controller.MitSSHKonfiguration;
import controller.OhneSSHKonfiguration;

public class LoginPanel extends JPanel {

	private JRadioButton oracleButton;
	private JRadioButton mySQLButton;
	private JRadioButton SSHButton;
	private JRadioButton ohneSSHButton;
	private JTextField jdbcPrefix;
	private JTextField server;
	private JTextField localPort;
	private JTextField db;
	private JTextField user;
	private JPasswordField pw;
	private Dimension dimLinks=new Dimension(100,40);
	private Dimension dimRechts=new Dimension(250,40);
	
	private JButton connectButton;
	
	
	public LoginPanel() {
		
	    //Create the radio buttons for Oracle or MySQL
	    oracleButton = new JRadioButton("OracleSQL");
	    oracleButton.setMnemonic(KeyEvent.VK_O);
	    oracleButton.setActionCommand("OracleSQL");
	    oracleButton.setSelected(true);
	    oracleButton.setPreferredSize(dimRechts);
	    mySQLButton = new JRadioButton("mySQL");
	    mySQLButton.setMnemonic(KeyEvent.VK_M);
	    mySQLButton.setActionCommand("mySQL");
	    mySQLButton.setPreferredSize(dimRechts);
	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(oracleButton);
	    group.add(mySQLButton);

	    //Create the radio buttons for mit SSH or ohne SSH
	    SSHButton = new JRadioButton("baue SSH-Tunnel");
	    SSHButton.setMnemonic(KeyEvent.VK_S);
	    SSHButton.setActionCommand("SSHTunnel");
	    SSHButton.setSelected(true);
	    SSHButton.setPreferredSize(dimLinks);
	    ohneSSHButton = new JRadioButton("ohne SSH");
	    ohneSSHButton.setMnemonic(KeyEvent.VK_L);
	    ohneSSHButton.setActionCommand("ohneSSH");
	    ohneSSHButton.setPreferredSize(dimLinks);
	    //Group the radio buttons.
	    ButtonGroup group2 = new ButtonGroup();
	    group2.add(SSHButton);
	    group2.add(ohneSSHButton);
	    
	    jdbcPrefix = new JTextField();
	    jdbcPrefix.setPreferredSize(dimRechts);
	    
		server = new JTextField();
		server.setPreferredSize(dimRechts);

		localPort = new JTextField();
		localPort.setPreferredSize(dimRechts);
		
		db = new JTextField();
		db.setPreferredSize(dimRechts);
		
		user = new JTextField();
		user.setPreferredSize(dimRechts);
		
		pw = new JPasswordField();
		pw.setPreferredSize(dimRechts);
		
		connectButton = new JButton("Connect");
		connectButton.setPreferredSize(dimLinks);

		GridLayout layout = new GridLayout(14,2);
		setLayout(layout);
		add(oracleButton);
		add(SSHButton);
		add(mySQLButton);
		add(ohneSSHButton);
		add(new JLabel());
		add(new JLabel());
		
		JLabel lblJdbc=new JLabel("  JDBC-Prefix  ");
		lblJdbc.setPreferredSize(dimLinks);
		lblJdbc.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblJdbc);
		add(jdbcPrefix);
		
		JLabel lblServer=new JLabel("  Server  ");
		lblServer.setPreferredSize(dimLinks);
		lblServer.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblServer);
		add(server);
		
		JLabel lblLocalPort=new JLabel("  Lokal port number  ");
		lblLocalPort.setPreferredSize(dimLinks);
		lblLocalPort.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblLocalPort);
		add(localPort);
		
		JLabel lblDb=new JLabel("  DB / SID  ");
		lblDb.setPreferredSize(dimLinks);
		lblDb.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDb);
		add(db);
		
		JLabel lblUser=new JLabel("  Username  ");
		lblUser.setPreferredSize(dimLinks);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblUser);
		add(user);
		
		JLabel lblPw=new JLabel("  Pass  ");
		lblPw.setPreferredSize(dimLinks);
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPw);
		add(pw);
		
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(connectButton);
		
	    //Register a listener for the radio buttons.
		mySQLButton.addActionListener(new MySQLKonfiguration(this));
		oracleButton.addActionListener(new OracleKonfiguration(this));
	
		connectButton.addActionListener(new LoginController());
	}
	
	
	
	public String getServer(){
		return server.getText();
	}

	public String getDb(){
		return db.getText();
	}
	
	public String getUser(){
		return user.getText();
	}
	
	public JPasswordField getPw(){
		return pw;
	}

	public void setServer(String server) {
		this.server.setText(server);
	}

	public void setDb(String db) {
		this.db.setText(db);
	}

	public void setUser(String user) {
		this.user.setText(user);
	}

	public void setPw(String pw) {
		this.pw.setText(pw);
	}

	public String getJdbcPrefix() {
		return jdbcPrefix.getText();
	}

	public void setJdbcPrefix(String jdbcPrefix) {
		this.jdbcPrefix.setText(jdbcPrefix); 
	}

	public String getLocalPort() {
		return localPort.getText();
	}

	public void setLocalPort(String localPort) {
		this.localPort.setText(localPort);
	}

	public JRadioButton getSSHButton() {
		return SSHButton;
	}

	public void setSSHButton(JRadioButton sSHButton) {
		SSHButton = sSHButton;
	}

	public JRadioButton getOhneSSHButton() {
		return ohneSSHButton;
	}

	public void setLocalhostButton(JRadioButton localhostButton) {
		this.ohneSSHButton = localhostButton;
	}

	public JRadioButton getOracleButton() {
		return oracleButton;
	}

	public void setOracleButton(JRadioButton oracleButton) {
		this.oracleButton = oracleButton;
	}

	public JRadioButton getMySQLButton() {
		return mySQLButton;
	}

	public void setMySQLButton(JRadioButton mySQLButton) {
		this.mySQLButton = mySQLButton;
	}
}

package main.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import main.controller.Controller;
import main.miftari.prodotti.Prodotto;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.Color;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JTextField;

public class SupermercatoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	private ViewObserver observer; // observer della view
	private JPanel contentPane;
	private JLabel lblDataInfo;
	private JLabel lblBilancioInfo;
	private JTextArea lblInventarioInfo;
	private JLabel lblLavoratoriInfo;
	private JLabel lblClientiInfo;
	private JLabel lblCarrelliLiberiInfo;
	private JLabel lblCarrelliOccupatiInfo;
	private JTextField txtDurata;
	private JLabel lblRisultato;
	private JButton confermaButton;

	public SupermercatoFrame(Controller controller, ViewObserver observer) {
		this.controller = controller;
		this.observer = observer;
		setTitle("Simulazione Supermercato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Calibri", Font.BOLD, 15));
		lblData.setBounds(38, 31, 137, 20);
		contentPane.add(lblData);
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setFont(new Font("Calibri", Font.BOLD, 15));
		lblInventario.setBounds(38, 97, 109, 20);
		contentPane.add(lblInventario);
	
		JLabel lblClienti = new JLabel("Numero totale clienti");
		lblClienti.setFont(new Font("Calibri", Font.BOLD, 15));
		lblClienti.setBounds(38, 177, 137, 13);
		contentPane.add(lblClienti);
		
		JLabel lblBilancio = new JLabel("Bilancio");
		lblBilancio.setFont(new Font("Calibri", Font.BOLD, 15));
		lblBilancio.setBounds(38, 61, 137, 19);
		contentPane.add(lblBilancio);
		
		JLabel lblLavoratori = new JLabel("Numero lavoratori");
		lblLavoratori.setFont(new Font("Calibri", Font.BOLD, 15));
		lblLavoratori.setBounds(38, 141, 137, 13);
		contentPane.add(lblLavoratori);
		
		JLabel lblCLiberi = new JLabel("Carrelli liberi");
		lblCLiberi.setFont(new Font("Calibri", Font.BOLD, 15));
		lblCLiberi.setBounds(38, 216, 137, 13);
		contentPane.add(lblCLiberi);
		
		JLabel lblCOccupati = new JLabel("Carrelli occupati");
		lblCOccupati.setFont(new Font("Calibri", Font.BOLD, 15));
		lblCOccupati.setBounds(38, 249, 137, 20);
		contentPane.add(lblCOccupati);
		
		lblDataInfo = new JLabel("");
		lblDataInfo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDataInfo.setBackground(new Color(255, 255, 255));
		lblDataInfo.setBounds(185, 26, 104, 20);
		contentPane.add(lblDataInfo);
	
		lblBilancioInfo = new JLabel("");
		lblBilancioInfo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblBilancioInfo.setBackground(new Color(255, 255, 255));
		lblBilancioInfo.setBounds(185, 55, 104, 20);
		contentPane.add(lblBilancioInfo);
		
		lblLavoratoriInfo = new JLabel("");
		lblLavoratoriInfo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblLavoratoriInfo.setBackground(new Color(255, 255, 255));
		lblLavoratoriInfo.setBounds(185, 132, 104, 20);
		contentPane.add(lblLavoratoriInfo);
		
		lblClientiInfo = new JLabel("");
		lblClientiInfo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblClientiInfo.setBackground(new Color(255, 255, 255));
		lblClientiInfo.setBounds(185, 168, 104, 20);
		contentPane.add(lblClientiInfo);
		
		lblCarrelliLiberiInfo = new JLabel("");
		lblCarrelliLiberiInfo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblCarrelliLiberiInfo.setBackground(new Color(255, 255, 255));
		lblCarrelliLiberiInfo.setBounds(185, 207, 104, 20);
		contentPane.add(lblCarrelliLiberiInfo);
		
		lblCarrelliOccupatiInfo = new JLabel("");
		lblCarrelliOccupatiInfo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblCarrelliOccupatiInfo.setBackground(new Color(255, 255, 255));
		lblCarrelliOccupatiInfo.setBounds(185, 247, 104, 20);
		contentPane.add(lblCarrelliOccupatiInfo);
			
		lblInventarioInfo = new JTextArea("");
		lblInventarioInfo.setEnabled(false);
		lblInventarioInfo.setBackground(new Color(240, 240, 240));
		lblInventarioInfo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblInventarioInfo.setForeground(new Color(255, 255, 255));
		lblInventarioInfo.setBounds(185, 85, 137, 22);
		contentPane.add(lblInventarioInfo);
				
		txtDurata = new JTextField("");
		txtDurata.setFont(new Font("Calibri", Font.BOLD, 15));
		txtDurata.setBounds(394, 136, 99, 19);
		txtDurata.setColumns(10);
		contentPane.add(txtDurata);

		
		JLabel lblDurata = new JLabel("inserisci durata:");
		lblDurata.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDurata.setBounds(394, 97, 113, 20);
		contentPane.add(lblDurata);
		
		lblRisultato = new JLabel("");
		lblRisultato.setBounds(321, 31, 253, 49);
		contentPane.add(lblRisultato);
		
		confermaButton = new JButton("Conferma");
		confermaButton.setFont(new Font("Calibri", Font.BOLD, 15));
		confermaButton.setBounds(513, 135, 100, 21);
		contentPane.add(confermaButton);
		confermaButton.addActionListener(e -> {
			try {
				this.observer.conferma(Integer.parseInt(txtDurata.getText()));
			}
			catch(NumberFormatException ex) {
				lblRisultato.setText("la durata deve essere un numero fra 0 e 50");
			}
		});
		
		
		JButton simulaButton = new JButton("Simula");
		simulaButton.setFont(new Font("Calibri", Font.BOLD, 15));
		simulaButton.setBackground(new Color(192, 192, 192));
		simulaButton.setBounds(394, 177, 85, 48);
		contentPane.add(simulaButton);
		simulaButton.addActionListener(e -> controller.simula());
	}
	
	public void aggiornaData(LocalDate data) {
    	lblDataInfo.setText("" + data);
    }
	
	public void aggiornaBilancio(double bilancio) {
		lblBilancioInfo.setText("" + bilancio);
	}
	
	public void aggiornaInventario(List<Prodotto> inventario) {
		lblInventarioInfo.setText("" + inventario.toString());
	}
	
	public void aggiornaNLavoratori(int n) {
		lblLavoratoriInfo.setText("" + n);
	}
	
	public void aggiornaNTotClienti(int n) {
		lblClientiInfo.setText("" + n);
	}
	
	public void aggiornaNCarrelliLiberi(int n) {
		lblCarrelliLiberiInfo.setText("" + n);
	}
	
	public void aggiornaNCarrelliOccupati(int n) {
		lblCarrelliOccupatiInfo.setText("" + n);
	}
	
	public int getDurataInserita() {
		try {
			return Integer.parseInt(txtDurata.getText());
		}
		catch(NumberFormatException e) {
			return -1;
		}
	}

	public Controller getController() {
		return this.controller;
	}
}

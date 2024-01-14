package main.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.controller.Controller;
import main.miftari.prodotti.Prodotto;

public class ViewImpl implements View{

	private Controller controller;
    private JFrame frame;
    private Point location0;
    private Point location1;
    private Point location2;
    private Point location3;
    private Point location4;
    private Point location5;
    private Point location6;

    public ViewImpl() {
        this.controller = null;
    }
    
    @Override
    public Controller getController() {
        return this.controller;
    }

    @Override
    public void setController(Controller controller) {
    	this.controller = controller;
    }

    public void creaEMostraGUI() {
        frame = new JFrame("Supermercato MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Aggiungi i componenti UI necessari
        // Ad esempio, puoi utilizzare i metodi forniti dal controller per ottenere dati dal model e aggiornare l'interfaccia grafica

        JLabel dataLabel = new JLabel("Data: ");
        JLabel bilancioLabel = new JLabel("Bilancio: ");
        JLabel inventarioLabel = new JLabel("Inventario: ");
        JLabel nLavoratoriLabel = new JLabel("Lavoratori: ");
        JLabel nTotClientiLabel = new JLabel("Numero totale di clienti: ");
        JLabel nCarrelliLiberiLabel = new JLabel("Numero di carrelli liberi: ");
        JLabel nCarrelliOccupatiLabel = new JLabel("Numero di carrelli occupati: ");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.add(dataLabel);
        //System.out.println(dataLabel.getLocation());
        panel.add(bilancioLabel);
        panel.add(inventarioLabel);
        panel.add(nLavoratoriLabel);
        panel.add(nTotClientiLabel);
        panel.add(nCarrelliLiberiLabel);
        panel.add(nCarrelliOccupatiLabel);
/*
        location0 = dataLabel.getLocation();
        location1 = bilancioLabel.getLocation();
        location2 = inventarioLabel.getLocation();
        location3 = nLavoratoriLabel.getLocation();
        location4 = nTotClientiLabel.getLocation();
        location5 = nCarrelliLiberiLabel.getLocation();
        location6 = nCarrelliOccupatiLabel.getLocation();
*/
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        JButton simulaButton = new JButton("Simula");
        simulaButton.addActionListener(e -> controller.getModel().simula());

        frame.getContentPane().add(BorderLayout.SOUTH, simulaButton);

        frame.setVisible(true);
    }
    
    // metodi per aggiornare la view con i nuovi dati
    @Override
    public void aggiornaData(LocalDate data) {
    	// comp è un JPanel
    	//Component comp = frame.getContentPane().getComponent(0);
    	//System.out.println(comp);
    	//JLabel label = (JLabel)comp.getComponentAt(location0); // è il label
    	//System.out.println(label);
    	//label.setText("Data: " + data.toString());
    }

	@Override
	public void aggiornaBilancio(double bilancio) {
		//Component comp = frame.getContentPane().getComponent(0);
		//JLabel label = (JLabel)comp.getComponentAt(location1);
        //label.setText("Bilancio: " + bilancio);
	}

	@Override
	public void aggiornaInventario(List<Prodotto> inventario) {
		Component comp = frame.getContentPane().getComponent(0);
		//inventarioLabel.setText("Data: " + inventario.toString());
	}

	@Override
	public void aggiornaNLavoratori(int n) {
		Component comp = frame.getContentPane().getComponent(0);
		//nLavoratoriLabel.setText("Data: " + n);
	}

	@Override
	public void aggiornaNTotClienti(int n) {
		Component comp = frame.getContentPane().getComponent(0);
		//nTotClientiLabel.setText("Data: " + n);
	}

	@Override
	public void aggiornaNCarrelliLiberi(int n) {
		Component comp = frame.getContentPane().getComponent(0);
		//nCarrelliLiberiLabel.setText("Data: " + n);
	}

	@Override
	public void aggiornaNCarrelliOccupati(int n) {
		Component comp = frame.getContentPane().getComponent(0);
		//nCarrelliOccupatiLabel.setText("Data: " + n);
	}
}

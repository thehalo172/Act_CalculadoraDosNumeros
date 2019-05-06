package visual;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class calculadoraIva extends JFrame implements ActionListener{

	private JLabel mensaje;
	private JLabel mensaje2;
	private JLabel mensaje3;
	private JButton boton;
	private JTextField caja;
	//private JTextField caja2;
	private JComboBox iva;
	public String selectIva;
	
	public calculadoraIva() {
		super();
		configurarVentana();
		crearComponentes();
	}
	private void configurarVentana(){
		this.setTitle("Calculadora de IVA");
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void crearComponentes(){
		mensaje = new JLabel();
		mensaje.setText("Cantidad");
		mensaje.setBounds(10, 0, 200, 60);
		mensaje.setForeground(Color.RED);
		this.add(mensaje);
		
		mensaje2 = new JLabel();
		mensaje2.setText("IVA%");
		mensaje2.setBounds(10, 80, 100, 30);
		mensaje2.setForeground(Color.black);
		this.add(mensaje2);
		
		boton =  new JButton();
		boton.setText("calcular");
		boton.setBounds(10,200,100,30);
		boton.setForeground(Color.RED);
		boton.addActionListener(this);
		this.add(boton);
		
		caja = new JTextField();
		caja.setBounds(10,40,100,30);
		this.add(caja);
		
		/*caja2 = new JTextField();
		caja2.setBounds(10,120,40,30);
		this.add(caja2);
		
		mensaje3 = new JLabel();
		mensaje3.setText("%");
		mensaje3.setBounds(50, 120, 100, 30);
		mensaje3.setForeground(Color.black);
		this.add(mensaje3);
		*/
		
		String[] ivaList = new String[] {"iva","16","8"};
		JComboBox<String> iva = new JComboBox<>(ivaList);
		iva.setBounds(10,120,100,30);
		iva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectIva = iva.getItemAt(iva.getSelectedIndex());
				System.out.println("El valor de iva es: " + selectIva);
			}
		
		});
		this.add(iva);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double r1=Double.parseDouble(caja.getText());
			double r2=Double.parseDouble(selectIva);
			
			double iva;
			iva = r1+((r1)*(r2/100));
			JOptionPane.showMessageDialog(this,"El iva es: " + iva);
		
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(this,"Caracteres no validos. Error: " + e1);
		}
	}

	
	
	
	public static void main(String[] args) {
		calculadoraIva ventana = new calculadoraIva();
		ventana.setVisible(true);
	}
}
	
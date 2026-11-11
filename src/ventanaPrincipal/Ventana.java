package ventanaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import horario.VentanaHorario;
import mascota.Mascota;
import mascota.VentanaMascota;
import stats.VentanaStats;

public class Ventana extends JFrame{
	public static Ventana ventana;
	public static Mascota m = new Mascota();
	private JLabel lFechaHora;
	

	private static final long serialVersionUID = -4737376985574446318L;

	public static Mascota getM() {
		return m;
	}

	public static void setM(Mascota m) {
		Ventana.m = m;
	}
	
	private String saludo() {
		int hora =Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hora >= 6 && hora < 12) {
			return "Buenos días";
		} else if (hora >= 12 && hora < 21) {
			return "Buenas tardes";
		} else {
			return "Buenas noches";
		}
	}
	
	private class Reloj extends Thread {
		public void run() {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
			while (true) {
				lFechaHora.setText(formato.format(new Date()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					this.interrupt();
				}
			}
		}
	}

	public Ventana() {
		ventana = this;
		JPanel pPrincipal = new JPanel(new GridLayout(1, 3, 20, 20));
		this.getContentPane().add(pPrincipal);

		JPanel pMascotPomod = new JPanel(new GridBagLayout());
			pMascotPomod.setOpaque(false);
			
			GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.BOTH;
				gbc.weightx = 1.0;
				gbc.insets = new Insets(10, 0, 10, 0);
			
			JPanelRound pMascot = new JPanelRound(new BorderLayout());
				pMascot.setBackground(new Color(111, 93, 79));
				
				JLabel eMascot = new JLabel("⛶", JLabel.RIGHT);
					eMascot.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 10));
					eMascot.setFont(new Font(getName(), Font.BOLD, 20));
					eMascot.setForeground(pMascot.getBackground().darker());
					eMascot.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						new VentanaMascota();
						dispose();
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						super.mouseEntered(e);
						eMascot.setForeground(Color.BLACK);;
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						super.mouseExited(e);
						eMascot.setForeground(pMascot.getBackground().darker());
					}
				});
				
					Image imagen = m.getImagen().getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
					JLabel mascota = new JLabel(new ImageIcon(imagen));
					
					JPanel pmStats = new JPanel(new GridLayout(6, 1, 5, 5));
						pmStats.setOpaque(false);
						
						JLabel pmHunger = new JLabel("Estómago");
							pmStats.add(pmHunger);
						JProgressBar pmpHunger = new JProgressBar();
							pmpHunger.setValue(m.getEstomago());
							pmStats.add(pmpHunger);

						JLabel pmHappiness = new JLabel("Felicidad");
							pmStats.add(pmHappiness);
						JProgressBar pmpHappiness = new JProgressBar();
							pmpHappiness.setValue(m.getFelicidad());
							pmStats.add(pmpHappiness);
							
						JLabel pmEnergy = new JLabel("Energía");
							pmStats.add(pmEnergy);
						JProgressBar pmpEnergy = new JProgressBar();
							pmpEnergy.setValue(m.getEnergia());
							pmStats.add(pmpEnergy);
					
					JPanel pmGeneral = new JPanel(new BorderLayout());
						pmGeneral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
						pmGeneral.setOpaque(false);
						pmGeneral.add(mascota, BorderLayout.NORTH);
						pmGeneral.add(pmStats);
					
				pMascot.add(eMascot, BorderLayout.NORTH);
				pMascot.add(pmGeneral, BorderLayout.CENTER);
				
				gbc.gridy = 0;
				gbc.weighty = 0.7;
				pMascotPomod.add(pMascot, gbc);
			
			JPanelRound pTimer = new JPanelRound();
				pTimer.setBackground(new Color(223, 147, 157));
				gbc.gridy = 1;
				gbc.weighty = 0.3;
				pMascotPomod.add(pTimer, gbc);
				
		//Para no alterar tamaños
			pMascot.setPreferredSize(new Dimension(0, 0));
			pTimer.setPreferredSize(new Dimension(0, 0));
			
		pPrincipal.add(pMascotPomod);
		
		
		JPanel pGreetings = new JPanel(new GridBagLayout());
			pGreetings.setOpaque(false);
			
			GridBagConstraints gbc1 = new GridBagConstraints();
			gbc1.fill = GridBagConstraints.BOTH;
			gbc1.weightx = 1.0;
			gbc1.insets = new Insets(10, 0, 10, 0);
			
			JPanelRound pTime = new JPanelRound(new BorderLayout());
				pTime.setBackground(new Color(152, 151, 105));
				JLabel eTime = new JLabel("⛶", JLabel.RIGHT);
				eTime.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 10));
				eTime.setFont(new Font(getName(), Font.BOLD, 20));
				eTime.setForeground(pTime.getBackground().darker())
				;
				eTime.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						Ventana.this.setVisible(false);
						new VentanaHorario();
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						super.mouseEntered(e);
						eTime.setForeground(Color.BLACK);;
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						super.mouseExited(e);
						eTime.setForeground(pTime.getBackground().darker());
					}
				});
				
				
				// Hora que va cambiando arriba
				
				pTime.add(eTime, BorderLayout.NORTH);
				
				lFechaHora = new JLabel("",JLabel.CENTER);
				lFechaHora.setFont(new Font("Bell MT", Font.BOLD, 22));
				lFechaHora.setForeground(pTime.getBackground().darker().darker());
				lFechaHora.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
				pTime.add(lFechaHora, BorderLayout.CENTER);

				Reloj reloj = new Reloj();
				reloj.start();
				
				gbc1.gridy = 0;
				gbc1.weighty = 0.2;
				pGreetings.add(pTime, gbc1);
	
				
				// saludo que va cambiando según la hora del del día
				JPanelRound pHoli = new JPanelRound(new BorderLayout());
				pHoli.setOpaque(false);
				final JLabel holi = new JLabel(saludo(), JLabel.CENTER);
				holi.setFont(new Font("Dubai Medium", Font.BOLD, 36));
				holi.setForeground(pTime.getBackground().darker().darker());
				pHoli.add(holi, BorderLayout.CENTER);

				
				Timer timerSaludo = new Timer(60000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						holi.setText(saludo());
					}
				});
				timerSaludo.start();

				gbc1.gridy = 1;
				gbc1.weighty = 0.2;
				pGreetings.add(pHoli, gbc1);

				gbc1.gridy = 1;
				gbc1.weighty = 0.2;
				pGreetings.add(pHoli, gbc1);
			
			JPanelRound pNotas = new JPanelRound(new BorderLayout());
			pNotas.setBackground(new Color(152, 151, 105));
			pNotas.add(new PanelTareas(), BorderLayout.CENTER);
			gbc1.gridy = 2;
			gbc1.weighty = 0.6;
			pGreetings.add(pNotas, gbc1);
			
			
			//Para no alterar tamaños
			pTime.setPreferredSize(new Dimension(0, 0));
			pHoli.setPreferredSize(new Dimension(0, 0));
			pNotas.setPreferredSize(new Dimension(0, 0));
			
		pPrincipal.add(pGreetings);
		
		
		JPanelRound pStats = new JPanelRound(new BorderLayout(10,30));
			pStats.setBackground(new Color(223, 147, 157));
			
			JPanel flowstat = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			flowstat.setOpaque(false);
			
			JLabel estadistica = new JLabel("Estadísticas                         ", JLabel.CENTER);
			estadistica.setForeground(Color.BLACK);
			pStats.add(estadistica, BorderLayout.NORTH);
			
			flowstat.add(estadistica);
			
			
			JPanel division = new JPanel(new GridLayout(2,1,5,5));
			division.setBackground(new Color(223,147,157));
			
			JPanel cuadraditos = new JPanel(new GridLayout(4,1,8,8));
			
			//Cambiar color para que no quede en los espacios blanco
			cuadraditos.setBackground(new Color(223,147,157));
			
			JLabel [] texto= {new JLabel("Tiempo total estudio:"),
			 new JLabel("Sesión más larga:"),
			 new JLabel("Día con más horas:"),
			 new JLabel("Promedio estudio:")
			};
			
			for (int i = 0; i < 4; i++) {
				JPanel cuadradito = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,20));
				cuadradito.setBackground(new Color(223,147,157));
				cuadradito.add(texto[i]);
				cuadraditos.add(cuadradito);
			}
			
			division.add(cuadraditos);
	
			ImageIcon icon = new ImageIcon("images/images.png");
			Image imagen1 = icon.getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH);
			JLabel labelimagen = new JLabel(new ImageIcon(imagen1));
			
			division.add(cuadraditos);
			
			division.add(labelimagen);
			
			JLabel eStats = new JLabel("⛶", JLabel.RIGHT);
			eStats.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 10));
			eStats.setFont(new Font(getName(), Font.BOLD, 20));
			eStats.setForeground(pStats.getBackground().darker())
			;
			eStats.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					new VentanaStats();
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					eStats.setForeground(Color.BLACK);;
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					super.mouseExited(e);
					eStats.setForeground(pStats.getBackground().darker());
				}
			});
			
			flowstat.add(eStats);
			pStats.add(flowstat, BorderLayout.NORTH);
			
			
			pStats.add(division, BorderLayout.CENTER);
			
		pPrincipal.add(pStats);
		
		
		
		//Default
		
		pPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setSize(960, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}		

}

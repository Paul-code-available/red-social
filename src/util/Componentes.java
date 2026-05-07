package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Componentes {
	
    public static ImageIcon cargarIcono(String ruta, int ancho, int largo) {
    	
   	 ImageIcon icon = new ImageIcon(Componentes.class.getResource(ruta));
		 
        Image img = icon.getImage();
        Image scaled = img.getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
        
        return new ImageIcon(scaled);
   }
    
    public static JButton crearBtnAccion(String nombre) {
    	
    	JButton btn = new JButton(nombre);
    	btn.setMaximumSize(new Dimension(160, 70));
		btn.setBackground(Color.decode("#F7F8FB"));
		btn.setFont(new Font("Arial", Font.PLAIN, 12));
		btn.setIconTextGap(10);
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		return btn;
    }
    
    public static JButton crearBtnIdeas(String texto) {
    	
    	JButton btn = new JButton(texto);
    	btn.setPreferredSize(new Dimension(160, 80));
		btn.setMaximumSize(new Dimension(160, 80));
		btn.setRolloverEnabled(false);
		btn.setBackground(Color.decode("#B2CEDE"));
		btn.setIconTextGap(5); 
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		return btn;
    }
    
    public static JLabel crearTitulo(String nombre) {
    	
    	JLabel lbl = new JLabel(nombre);
    	lbl.setForeground(Color.decode("#023e8a"));
		lbl.setFont(new Font("Arial", Font.BOLD, 16));
		lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		return lbl;
    	
    }
    
    public static JButton crearBtnInformacion(String nombre) {
    	
    	JButton btn = new JButton(nombre);
    	btn.setOpaque(false);
    	btn.setBackground(Color.decode("#F7F8FB"));
    	btn.setRolloverEnabled(false);
    	btn.setFont(new Font("Arial", Font.PLAIN, 12));
    	btn.setIconTextGap(10);
    	btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    	
    	return btn;
    	
    }
    
    
    
}

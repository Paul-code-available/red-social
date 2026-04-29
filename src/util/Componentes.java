package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
		
		return btn;
    }
    
    public static JButton crearBtnInformacion(String texto) {
    	
    	JButton btn = new JButton(texto);
    	btn.setPreferredSize(new Dimension(160, 80));
		btn.setMaximumSize(new Dimension(160, 80));
		btn.setBackground(Color.decode("#B2CEDE"));
		btn.setIconTextGap(5); 
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		return btn;
    }
    
    
    
}

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

 

 
public class reconcp extends Thread
{
	static File fcoor;
	static FileWriter fwcoor;
	static String coor;
	static JFileChooser filechoser; //Objeto para seleccionar el archivo
	static URL mediaURL;
	static String	surl;

public void abrir()//Metodo que permite abrir los archivos con extension MP3 y MPG
	{
		try{
			filechoser=new JFileChooser();
			mediaURL=null;
			int	resul=filechoser.showOpenDialog(null);//Variable entera que valida el archivo seleccionado
			surl=filechoser.getSelectedFile().toString();//Guarda en un String la direccion del directorio del archivo que se cargo
			mediaURL=filechoser.getSelectedFile().toURL();//Carga el archivo seleccionao
	} catch(MalformedURLException malforme){JOptionPane.showMessageDialog(null,"Error no hay url");	}
	}
	
	
public static void main (String[] args) {
	
		reconcp w= new reconcp();w.abrir(); //Construye la clase y llama el metodo abrir
		
		
		JLabel Resultado= new JLabel();
 
		JOptionPane.showMessageDialog(null,"Proyecto: Reconocimiento de Patrones \n"+
											"Lenguaje: Java \n"	);
 //Seleccionar color
		  // JColorChooser ventanaDeColores=new JColorChooser();
 //color=ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
   //panelColor.setBackground(color);
   
 //Seleccionar color		
		String PixelBuscar=JOptionPane.showInputDialog("Color en Hexadecimal del pixel a Buscar \n El Default es Negro - 0","0");
	//	String Archivo=JOptionPane.showInputDialog("Nombre de la imagen para Buscar el pixel \n Tiene que se png");
		int contador=0;
		String Cordenadas=null;
		ImageIcon Imagen = new ImageIcon(surl);
 		//PixelBuscar="0";
		Coversion C = new Coversion();
		BufferedImage Nueva = C.toBufferedImage(Imagen.getImage());
		Graphics g = Nueva.getGraphics();
 
		for(int x=0;x<=645;x++){
			for(int y=0;y<=435;y++){
				String val= Integer.toHexString(Nueva.getRGB(x,y) & 0x00ffffff ).toString();
				if(val.equals(PixelBuscar)){
				//	Cordenadas=Cordenadas + " (" + x+","+y+") ";
				int xa =x;
				int ya =435-y;
					coor= xa+";"+ya;
					System.out.println(coor);
					
					//Guardar en archivo
						try
						{
						fcoor=new File ("Coordenadas.csv");
						fwcoor=new FileWriter (fcoor,true);
						fwcoor.write(coor+"\r\n");
						fwcoor.close();
						}
						catch (Exception e){} 
						
					//Finguardar en archivo
					g.setColor(Color.red);
					g.fillOval(x-1, y-1, 2, 2);
					contador++;
				
				}
			}
		}
 
		//JOptionPane.showMessageDialog(null,"Tiene " + contador + " elementos que buscas");
	//	JOptionPane.showMessageDialog(null,"Cordenadas " + Cordenadas);
 
		if (contador != 0){
			try {
   				ImageIO.write(Nueva, "jpg", new File("Resultado.png"));
			} catch (IOException e) {
   				System.out.println("Error de escritura");
			}
			Resultado.setIcon(new ImageIcon("Resultado.png"));
			JOptionPane.showMessageDialog(null,Resultado);
		}else{
			JOptionPane.showMessageDialog(null,"No se encontro ningun patron");
		}
	}
 
 }
class Coversion {
 
    BufferedImage toBufferedImage(Image image) {
		if( image instanceof BufferedImage ) {
			return( (BufferedImage)image );
		} else {
			image = new ImageIcon(image).getImage();
			BufferedImage bufferedImage = new BufferedImage(
											image.getWidth(null),
											image.getHeight(null),
											BufferedImage.TYPE_INT_RGB );
			 Graphics g = bufferedImage.createGraphics();
			 g.drawImage(image,0,0,null);
			 g.dispose();
 
			return( bufferedImage );
			
		}
	}
}

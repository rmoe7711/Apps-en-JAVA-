/*JIC Administrador de Usuarios Consultorios Odontologia
 *Jusemago invent corporation 2011
 *inicio 17 Febrero 2011
*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
public class tablas
{
//TABLAS
JFrame ftabla;
JTabbedPane tbcont;
JPanel ptabl,podon;
JLabel lfact,ltrat,lpres,lvtr;
JTable tpres,tfact;
JScrollPane scrollPane1,scrollPane2;
static String colnamestp []= {"FECHA", "DETALLE", "ABONO", "SALDO"},colnamestf []= {"FECHA", "DIENTE", "TRATAMIENTO", "VALOR"};
static Object datatp [][]= new Object[30][4],datatf [][]= new Object[30][4];
String val;
public void igutablas()
{

ftabla= new JFrame("Tablas");

//Tablas
tpres = new JTable(datatp,colnamestp);  
tpres.setPreferredScrollableViewportSize(new Dimension(400,200));
scrollPane1 = new JScrollPane(tpres);
scrollPane1.setBounds(10,90,500,260);

tfact = new JTable(datatf,colnamestf);  
tfact.setPreferredScrollableViewportSize(new Dimension(400,190));
scrollPane2 = new JScrollPane(tfact);
scrollPane2.setBounds(10,390,500,260);

ltrat=new JLabel("TRATAMIENTO");
ltrat.setBounds(200,0,100,30);
lfact=new JLabel("FACTURACION");
lfact.setBounds(200,350,100,30);
lpres=new JLabel("Plan total presupuesto");
lpres.setBounds(0,20,300,30);
lvtr=new JLabel("Valor tratamiento");
lvtr.setBounds(0,50,300,30);


podon =new JPanel  ();	
podon.setBounds(0,0,300,300);


ptabl =new JPanel ();
ptabl.setBounds(0,0,300,300);
ptabl.add(ltrat);
ptabl.add(lpres);
ptabl.add(lvtr);
ptabl.add(scrollPane1);
ptabl.add(scrollPane2);

ptabl.add(lfact);

tbcont =new JTabbedPane ();	
tbcont.setBounds(0,0,600,720);
ptabl.setLayout(null);
podon.setLayout(null);
ftabla.setLayout(null);
//ftabla.addTab(tbtabl);
tbcont.addTab( "Odontogramas", null, podon, "Primer panel" );
tbcont.addTab( "Presupuesto", null, ptabl, "Primer panel" );

//val.getValueAt(0,0);
ftabla.add(tbcont);

ftabla.reshape(10,10,600,750);
ftabla.show();
}


public static void main (String[]args)
{
	tablas t=new tablas();
	t.igutablas();
}


}
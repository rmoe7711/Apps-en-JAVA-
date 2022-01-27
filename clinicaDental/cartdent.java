/*JIC Administrador de Usuarios Consultorios Odontologia
 *Jusemago invent corporation 2011
 
*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
public class cartdent
{
//Contadores
static String si;
static int i,j,f=0,h=0;

static JFrame fmain;
static JMenu march,medit;
static JMenuBar mbarra;
static JMenuItem miexit,mielim,minuev,miusdo,miusno,mieddp,miedec,miedpr,miinic,miedct,miedfa,mieder;

//Datos personales
static JLabel lnom,lape,lide,leda,ltel,ldir,lsex,lciu,lprof,lenc,lenr,lale,lhcl,lsag,lrea,legb,lobs;
static JTextField tfnom,tfape,tfide,tfeda,tfsex,tftel,tfdir,tfciu,tfprof,tfenc,tfenr,tfale;
static JTextArea tahcl,tasag,tarea,taegb,taobs;

//Examen Radiologico
static JLabel ldia,lobr;
static JTextArea tadia,taobr;
static JLabel la1,la2,la3,la4,la5,la6,la7,la8,la9,la10,la11,la12,la13,la14,la15,la16,la17;
static JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17;

//Label de titulos
static JLabel ltdpe,ltpre,ltfac,ltexr;
//Paneles
static JPanel pcont;
//Fondo Pantalla
static ImageIcon ifondo;
static JLabel lifon;
//Odontogramas
static JLabel lioec,lioct,liexr,liec,lict;
static ImageIcon ioec,ioct,iexr,iec,ict;
static String urlec="Content//oec.png",urlct="Content//oct.png";
//Banderas
static String banmostdp="",baninsOupd="";
//Vectores
public static String vecnom[]= new String [500],vecexr[]= new String[32];
public static int veccc[]= new int [500];
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
JTextField tfplan,tfvalt;
JPanel pfond;
public void igmain()
{
	fmain=new JFrame("JIC Administrador de Usuarios Consultorio Odontologia ");//Ventana principal
	fmain.setIconImage(Toolkit.getDefaultToolkit().getImage("content//icon.jpg")); 
	//JmenuItem
	miexit=new JMenuItem("Salir");
	miexit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){System.exit(0);}});
	miinic=new JMenuItem("Inicio");
	miinic.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){inicio();}});
	minuev=new JMenuItem("Nuevo");
	minuev.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){nuevo();}});
	miusno=new JMenuItem("Abrir x Nombre");
	miusno.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){abrirnombre();}});
	miusdo=new JMenuItem("Abrir x Documento");
	miusdo.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){abrircc();}});
	mieddp=new JMenuItem("Datos Personales");
	mieddp.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editardp();}});
	miedec=new JMenuItem("Examen Clinico");
	miedec.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editarec();}});
	miedct=new JMenuItem("Curso Tratamiento");
	miedct.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editarct();}});
	miedpr=new JMenuItem("Contabilidad");
	miedpr.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editarpre();}});
	mieder=new JMenuItem("Examen Radiologico");
	mieder.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){editarer();}});
	mielim=new JMenuItem("Eliminar");
	mielim.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){igeliminar();}});
	//JMenu
	march=new JMenu("Archivo      "); 
	march.add(miinic);
	march.add(minuev);
	march.add(miusdo);
	march.add(miusno);
	march.add(miexit);
	medit=new JMenu("Editar Usuario"); 
	medit.setEnabled(false);
	medit.add(mieddp);
	medit.add(miedec);
	medit.add(miedct);
	medit.add(mieder);
	medit.add(miedpr);

	medit.add(mielim);
	//JMenuBar
	mbarra=new JMenuBar();
	mbarra.add(march);
	mbarra.add(medit);
	
	//Label Titulos
		ltdpe = new JLabel("DATOS PERSONALES");
        ltdpe.setBounds(240, 0, 200, 30);
        ltexr = new JLabel("EXAMEN RADIOLOGICO");
        ltexr.setBounds(230, 440, 200, 30);
        lnom = new JLabel("Nombre:");
        lnom.setBounds(0, 30, 200, 30);
        lape = new JLabel("Apellido:");
        lape.setBounds(300, 30, 200, 30);
        lide = new JLabel("No.Identificacion:");
        lide.setBounds(0, 60, 200, 30);
        leda = new JLabel("Edad:");
        leda.setBounds(300, 60, 120, 30);
        lsex = new JLabel("Sexo:");
        lsex.setBounds(0, 90, 120, 30);
        ltel = new JLabel("Telefono:");
        ltel.setBounds(300, 90, 100, 30);
        ldir = new JLabel("Direccion:");
        ldir.setBounds(0, 120, 200, 30);
        lciu = new JLabel("Ciudad:");
        lciu.setBounds(300, 120, 200, 30);
        lprof = new JLabel("Profesion:");
        lprof.setBounds(0, 150, 200, 30);
        lhcl = new JLabel("Historia Clinica:");
        lhcl.setBounds(0, 180, 200, 30);
        lsag = new JLabel("Salud General:");
        lsag.setBounds(0, 240, 200, 30);
        lrea = new JLabel("Reaccion a la anestesia:");
        lrea.setBounds(300, 240, 200, 30);
        lenc = new JLabel("Enfermedades circulatorias:");
        lenc.setBounds(0, 320, 200, 30);
        lenr = new JLabel("Enfermedades respiratorias:");
        lenr.setBounds(230, 320, 200, 30);
        lale = new JLabel("Alergias:");
        lale.setBounds(460, 320, 200, 30);
        legb = new JLabel("Estado General de la boca:");
        legb.setBounds(0, 350, 200, 30);
        lobs = new JLabel("Observaciones:");
        lobs.setBounds(300, 350, 200, 30);
        tfnom = new JTextField(20);
        tfnom.setBounds(50, 35, 240, 20);
        tfape = new JTextField(20);
        tfape.setBounds(350, 35, 240, 20);
        tfide = new JTextField(20);
        tfide.setBounds(100, 65, 190, 20);
        tfeda = new JTextField(20);
        tfeda.setBounds(340, 65, 250, 20);
        tfsex = new JTextField(20);
        tfsex.setBounds(40, 95, 250, 20);
        tftel = new JTextField(20);
        tftel.setBounds(360, 95, 230, 20);
        tfdir = new JTextField(20);
        tfdir.setBounds(60, 125, 230, 20);
        tfciu = new JTextField(20);
        tfciu.setBounds(350, 125, 240, 20);
        tfprof = new JTextField(90);
        tfprof.setBounds(70, 155, 520, 20);
        tfenc = new JTextField(90);
        tfenc.setBounds(165, 327, 60, 20);
        tfenr = new JTextField(90);
        tfenr.setBounds(395, 327, 60, 20);
        tfale = new JTextField(90);
        tfale.setBounds(515, 327, 75, 20);
        tahcl = new JTextArea(1, 1);
        tahcl.setBounds(0, 210, 590, 30);
        tasag = new JTextArea(1, 1);
        tasag.setBounds(0, 270, 290, 50);
        tarea = new JTextArea(1, 1);
        tarea.setBounds(300, 270, 290, 50);
        taegb = new JTextArea(1, 1);
        taegb.setBounds(0, 380, 290, 50);
        taobs = new JTextArea(1, 1);
        taobs.setBounds(300, 380, 290, 50);
        iexr = new ImageIcon("content//examrad.png");
        liexr = new JLabel(iexr);
        liexr.setBounds(182, 470, 223, 42);
        ldia = new JLabel("Diagnostico");
        ldia.setBounds(0, 510, 223, 30);
        lobr = new JLabel("Observaciones");
        lobr.setBounds(0, 580, 223, 30);
        tadia = new JTextArea(1, 1);
        tadia.setBounds(0, 540, 590, 40);
        taobr = new JTextArea(1, 1);
        taobr.setBounds(0, 610, 590, 60);
        la1 = new JLabel();
        la1.setBounds(183, 472, 13, 15);
        la2 = new JLabel();
        la2.setBounds(197, 472, 13, 15);
        la3 = new JLabel();
        la3.setBounds(211, 472, 13, 15);
        la4 = new JLabel();
        la4.setBounds(225, 472, 13, 15);
        la5 = new JLabel();
        la5.setBounds(239, 472, 13, 15);
        la6 = new JLabel();
        la6.setBounds(253, 472, 13, 15);
        la7 = new JLabel();
        la7.setBounds(267, 472, 13, 15);
        la8 = new JLabel();
        la8.setBounds(281, 472, 13, 15);
        la9 = new JLabel();
        la9.setBounds(300, 472, 13, 15);
        la10 = new JLabel();
        la10.setBounds(314, 472, 13, 15);
        la11 = new JLabel();
        la11.setBounds(328, 472, 13, 15);
        la12 = new JLabel();
        la12.setBounds(342, 472, 13, 15);
        la13 = new JLabel();
        la13.setBounds(356, 472, 13, 15);
        la14 = new JLabel();
        la14.setBounds(370, 472, 13, 15);
        la15 = new JLabel();
        la15.setBounds(384, 472, 13, 15);
        la16 = new JLabel();
        la16.setBounds(398, 472, 13, 15);
        lb1 = new JLabel();
        lb1.setBounds(183, 497, 13, 15);
        lb2 = new JLabel();
        lb2.setBounds(197, 497, 13, 15);
        lb3 = new JLabel();
        lb3.setBounds(211, 497, 13, 15);
        lb4 = new JLabel();
        lb4.setBounds(225, 497, 13, 15);
        lb5 = new JLabel();
        lb5.setBounds(239, 497, 13, 15);
        lb6 = new JLabel();
        lb6.setBounds(253, 497, 13, 15);
        lb7 = new JLabel();
        lb7.setBounds(267, 497, 13, 15);
        lb8 = new JLabel();
        lb8.setBounds(281, 497, 13, 15);
        lb9 = new JLabel();
        lb9.setBounds(300, 497, 13, 15);
        lb10 = new JLabel();
        lb10.setBounds(314, 497, 13, 15);
        lb11 = new JLabel();
        lb11.setBounds(328, 497, 13, 15);
        lb12 = new JLabel();
        lb12.setBounds(342, 497, 13, 15);
        lb13 = new JLabel();
        lb13.setBounds(356, 497, 13, 15);
        lb14 = new JLabel();
        lb14.setBounds(370, 497, 13, 15);
        lb15 = new JLabel();
        lb15.setBounds(384, 497, 13, 15);
        lb16 = new JLabel();
        lb16.setBounds(398, 497, 13, 15);
        ioec = new ImageIcon(urlec);
        ioct = new ImageIcon(urlct);
        lioec = new JLabel();
        lioec.setIcon(ioec);
        lioec.setBounds(0, 0, 550, 350);
        lioct = new JLabel();
        lioct.setIcon(ioct);
        lioct.setBounds(0, 340, 550, 350);
        pcont = new JPanel();
        pcont.setVisible(false);
        pcont.setBounds(5, 20, 590, 720);
        pcont.setLayout(null);
        pcont.add(ltdpe);
        pcont.add(ltexr);
        pcont.add(lnom);
        pcont.add(lape);
        pcont.add(lide);
        pcont.add(leda);
        pcont.add(lsex);
        pcont.add(ltel);
        pcont.add(lciu);
        pcont.add(ldir);
        pcont.add(lprof);
        pcont.add(lhcl);
        pcont.add(lsag);
        pcont.add(lrea);
        pcont.add(lenc);
        pcont.add(lenr);
        pcont.add(lale);
        pcont.add(legb);
        pcont.add(lobs);
        pcont.add(tfnom);
        pcont.add(tfape);
        pcont.add(tfide);
        pcont.add(tfeda);
        pcont.add(tfsex);
        pcont.add(tftel);
        pcont.add(tfdir);
        pcont.add(tfciu);
        pcont.add(tfprof);
        pcont.add(tfenc);
        pcont.add(tfenr);
        pcont.add(tfale);
        pcont.add(tahcl);
        pcont.add(tasag);
        pcont.add(tarea);
        pcont.add(taegb);
        pcont.add(taobs);
        pcont.add(liexr);
        pcont.add(ldia);
        pcont.add(lobr);
        pcont.add(tadia);
        pcont.add(taobr);
        pcont.add(la1);
        pcont.add(la2);
        pcont.add(la3);
        pcont.add(la4);
        pcont.add(la5);
        pcont.add(la6);
        pcont.add(la7);
        pcont.add(la8);
        pcont.add(la9);
        pcont.add(la10);
        pcont.add(la11);
        pcont.add(la12);
        pcont.add(la13);
        pcont.add(la14);
        pcont.add(la15);
        pcont.add(la16);
        pcont.add(lb1);
        pcont.add(lb2);
        pcont.add(lb3);
        pcont.add(lb4);
        pcont.add(lb5);
        pcont.add(lb6);
        pcont.add(lb7);
        pcont.add(lb8);
        pcont.add(lb9);
        pcont.add(lb10);
        pcont.add(lb11);
        pcont.add(lb12);
        pcont.add(lb13);
        pcont.add(lb14);
        pcont.add(lb15);
        pcont.add(lb16);
        tpres = new JTable(datatp, colnamestp);
        tpres.setPreferredScrollableViewportSize(new Dimension(400, 200));
        scrollPane1 = new JScrollPane(tpres);
        scrollPane1.setBounds(30, 90, 500, 270);
        tfact = new JTable(datatf, colnamestf);
        tfact.setPreferredScrollableViewportSize(new Dimension(400, 200));
        scrollPane2 = new JScrollPane(tfact);
        scrollPane2.setBounds(30, 400, 500, 270);
        ltrat = new JLabel("TRATAMIENTO");
        ltrat.setBounds(230, 0, 100, 30);
        lfact = new JLabel("FACTURACION");
        lfact.setBounds(230, 360, 100, 30);
        lpres = new JLabel("Plan total presupuesto");
        lpres.setBounds(0, 20, 300, 30);
        lvtr = new JLabel("Valor tratamiento");
        lvtr.setBounds(0, 50, 300, 30);
        tfplan = new JTextField(400);
        tfplan.setBounds(140, 25, 380, 20);
        tfvalt = new JTextField(400);
        tfvalt.setBounds(110, 55, 100, 20);
        podon = new JPanel();
        podon.add(lioec);
        podon.add(lioct);
        podon.setBounds(0, 0, 300, 300);
        ptabl = new JPanel();
        ptabl.setBounds(0, 0, 300, 300);
        ptabl.add(ltrat);
        ptabl.add(lpres);
        ptabl.add(lvtr);
        ptabl.add(tfplan);
        ptabl.add(tfvalt);
        ptabl.add(scrollPane1);
        ptabl.add(scrollPane2);
        ptabl.add(lfact);
        tbcont = new JTabbedPane();
        tbcont.setBounds(600, 0, 550, 710);
        ptabl.setLayout(null);
        podon.setLayout(null);
        tbcont.addTab("Odontogramas", null, podon, "Odontogramas examen clinico y curso tratamiento");
        tbcont.addTab("Presupuesto Tratamiento", null, ptabl, "Tablas tratamiento y facturacion ");
       
    	pfond = new JPanel();
        pfond.setLayout(new BorderLayout());
        pfond.setBounds(0, 0,1155,720);
        pfond.setBackground(new Color(0, 30, 30));
        ifondo = new ImageIcon("content//interfaz.jpg");
   
        lifon = new JLabel(ifondo,lifon.CENTER);
        pfond.add(lifon);
        fmain.setLayout(null);
        fmain.add(pfond);
        fmain.add(pcont);
        fmain.add(tbcont);
        fmain.setJMenuBar(mbarra);
        fmain.setSize(1170,770);
        fmain.setLocationRelativeTo(null);
        fmain.show();

}

public void nuevo()
{
    baninsOupd = "nuevo";
    urlec = "Content//oec.png";
    urlct = "Content\\oct.png";
    fmain.show();
    cc = 0;
    tfnom.setText("");
    tfape.setText("");
    tfide.setText("");
    tfeda.setText("");
    tfsex.setText("");
    tftel.setText("");
    tfdir.setText("");
    tfciu.setText("");
    tfprof.setText("");
    tahcl.setText("");
    tasag.setText("");
    tarea.setText("");
    tfenc.setText("");
    tfenr.setText("");
    tfale.setText("");
    taegb.setText("");
    taobs.setText("");
    fmain.setVisible(false);
    igmain();
    pfond.setVisible(false);
    pcont.setVisible(true);
    medit.setEnabled(true);
	 for(i = 0; i <= 29; i++)
     {
        for(j = 0; j <= 3; j++)
        {
    	sabono[i][j] ="";
    	tpres.setValueAt(sabono[i][j], i, j);
    	sdafact[i][j]="";
    	tfact.setValueAt(sdafact[i][j], i, j);
  		}
  		}
  	splan="";
  	svalt="";
}

public void inicio()
{
	pfond.setVisible(true);
	pcont.setVisible(false);
	medit.setEnabled(false);
}

//ABRIR USARIOS
JFrame facc,fanom;
JLabel ltacc,ltanom;
JTextField tfacc;
Choice choanom;
JButton bacc,banom;

public void abrircc()
{
    baninsOupd = "abrircc";
    banmostdp = "abrircc";
    facc = new JFrame("Abrir Usuario x Documento");
    ltacc = new JLabel("Ingresa el No. de documento");
    tfacc = new JTextField(10);
    bacc = new JButton("Aceptar");
	bacc.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){cargardp();cargarer();cargarpre();cargarfac();}});
  	facc.add(ltacc);
    facc.add(tfacc);
    facc.add(bacc);
    facc.setLayout(new FlowLayout());
    facc.setSize(200, 120);
    facc.setLocationRelativeTo(null);
    facc.show();
    h=0;
    
}


public void abrirnombre()
{

    h=0;
    fanom = new JFrame("Abrir Usuario x Nombre");
    ltanom = new JLabel("Busca en la lista el nombre");
    choanom = new Choice();
	try{
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
	Statement st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet resultado=st.executeQuery("SELECT * FROM DATOSPERSONALES ");
	//Realiza el recorrido en la base de datos
	while(resultado.next())
	{

	//Captura el contenido de los campos de la base de datos y los muestra por pantalla
	cc=resultado.getInt("CC");
	snomb=resultado.getString("Nombre");
	sapel=resultado.getString("Apellido");
	choanom.addItem(snomb+" "+sapel);
	vecnom[f]=snomb+" "+sapel;

	veccc[f]=cc;
	f=f+1;
	}
	f=0;
	st.close();
	con.close();	
	}	catch (Exception e){	}
	banom=new JButton("Aceptar");
	banom.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){consultanombre();}});

	fanom.add(ltanom);
    fanom.add(choanom);
    fanom.add(banom);
    fanom.setLayout(new FlowLayout());
    fanom.setSize(250, 120);
    fanom.setLocationRelativeTo(null);
    fanom.show();
    
    
}

public void consultanombre()
{
	try{
	banmostdp="connombre";
	baninsOupd="connombre";
	snomb=choanom.getSelectedItem();
	for(i=0;i<vecnom.length;i++)
	{
		if(vecnom[i].equals(snomb))
		{
		cc=veccc[i];
		}


	}

		}	catch (Exception e){	}
	cargardp();	
	cargarer();
	cargarpre();
	cargarfac();

}

//EDITAR DATOS 
JFrame feddp,feder;
//Datos Personales
JTextField tfcnom,tfcape,tfcide,tfctel,tfcdir,tfcciu,tfcprof;
JTextArea tachcl,tacsag,tacrea,tacegb,tacobs;
Choice choeda;
CheckboxGroup chgsex,chgenc,chgenr,chgale;
Checkbox chmas,chfem,checs,checn,chers,chern,chals,chaln;
JButton beddp;

//Examen Radiologico
JTextArea tacdia,tacobr; 
JButton beder;
static Checkbox cha1,cha2,cha3,cha4,cha5,cha6,cha7,cha8,cha9,cha10,cha11,cha12,cha13,cha14,cha15,cha16;
static Checkbox chb1,chb2,chb3,chb4,chb5,chb6,chb7,chb8,chb9,chb10,chb11,chb12,chb13,chb14,chb15,chb16;

public void editardp()
{
	System.out.println(si);	
    banmostdp="editardp";
	feddp=new JFrame("Editar Datos Personales");
	ltdpe=new JLabel("EDITAR DATOS PERSONALES");
	ltdpe.setBounds(150,0,200,30);
	
	//Label Datos personales
	lnom = new JLabel("Nombre:");
        lnom.setBounds(0, 30, 200, 30);
        lape = new JLabel("Apellido:");
        lape.setBounds(300, 30, 200, 30);
        lide = new JLabel("No.Identificacion:");
        lide.setBounds(0, 60, 200, 30);
        leda = new JLabel("Edad:");
        leda.setBounds(300, 60, 120, 30);
        lsex = new JLabel("Sexo:");
        lsex.setBounds(0, 90, 120, 30);
        ltel = new JLabel("Telefono:");
        ltel.setBounds(300, 90, 100, 30);
        ldir = new JLabel("Direccion:");
        ldir.setBounds(0, 120, 200, 30);
        lciu = new JLabel("Ciudad:");
        lciu.setBounds(300, 120, 200, 30);
        lprof = new JLabel("Profesion:");
        lprof.setBounds(0, 150, 200, 30);
        lhcl = new JLabel("Historia Clinica:");
        lhcl.setBounds(0, 180, 200, 30);
        lsag = new JLabel("Salud General:");
        lsag.setBounds(0, 240, 200, 30);
        lrea = new JLabel("Reaccion a la anestesia:");
        lrea.setBounds(300, 240, 200, 30);
        lenc = new JLabel("Enfermedades circulatorias:");
        lenc.setBounds(0, 320, 200, 30);
        lenr = new JLabel("Enfermedades respiratorias:");
        lenr.setBounds(0, 350, 200, 30);
        lale = new JLabel("Alergias:");
        lale.setBounds(0, 380, 200, 30);
        legb = new JLabel("Estado General de la boca:");
        legb.setBounds(0, 410, 200, 30);
        lobs = new JLabel("Observaciones:");
        lobs.setBounds(300, 410, 200, 30);
   
   	//Cajas de texto
	tfcnom=new JTextField(20);
	tfcnom.setBounds(50,35,240,20);
	tfcape=new JTextField(20);
	tfcape.setBounds(350,35,240,20);
	tfcide=new JTextField(20);
	tfcide.setBounds(100,65,190,20);
	tfctel=new JTextField(20);
	tfctel.setBounds(360,95,230,20);
	tfcdir=new JTextField(20);
	tfcdir.setBounds(60,125,230,20);
	tfcciu=new JTextField(20);
	tfcciu.setBounds(350,125,240,20);
	tfcprof=new JTextField(90);
	tfcprof.setBounds(70,155,520,20);
		
	//TextArea
	tachcl=new JTextArea(1,1);
   tachcl.setBounds(0, 210, 590, 30);
   tacsag=new JTextArea(1,1);
   tacsag.setBounds(0, 270, 290, 50);
   tacrea=new JTextArea(1,1);
   tacrea.setBounds(300, 270, 290, 50);
   tacegb=new JTextArea(1,1);
   tacegb.setBounds(0, 440, 290, 50);
   tacobs=new JTextArea(1,1);
   tacobs.setBounds(300, 440, 290, 50);
   
	//Choice
	choeda=new Choice();
	choeda.setBounds(350,65,50,20);
	for(i=1;i<=80;i++)
	{
		si=Integer.toString(i);
		choeda.addItem(si);
	}
	//Checkbox
	chgsex=new CheckboxGroup();
	chmas=new Checkbox("Masculino",chgsex,false); 
	chmas.setBounds(140,95,100,20);
	chfem=new Checkbox("Femenino",chgsex,false);
	chfem.setBounds(50,95,100,20);
	
	chgenc=new CheckboxGroup();
	checs=new Checkbox("Si",chgenc,false); 
	checs.setBounds(180,325,30,20);
	checn=new Checkbox("No",chgenc,false);
	checn.setBounds(220,325,40,20);
	
	chgenr=new CheckboxGroup();
	chers=new Checkbox("Si",chgenr,false); 
	chers.setBounds(180,355,30,20);
	chern=new Checkbox("No",chgenr,false);
	chern.setBounds(220,355,40,20);
	
	chgale=new CheckboxGroup();
	chals=new Checkbox("Si",chgale,false); 
	chals.setBounds(70,385,30,20);
	chaln=new Checkbox("No",chgale,false);
	chaln.setBounds(110,385,40,20);
	//Botones
	beddp=new JButton("Aceptar");
	beddp.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){guardardp();}});
	beddp.setBounds(250,500,100,20);
	
    if(cc!=0)
	{
		tfcnom.setText(snomb);
		tfcape.setText(sapel);
		tfcide.setText(siden);
	    choeda.select(sedad);
		if(ssexo.equals("Masculino"))
		{
			chmas.setState(true);
		}
		else if(ssexo.equals("Femenino"))
				{
				chfem.setState(true);
				}
		tfctel.setText(stele);
		tfcdir.setText(sdire);
		tfcciu.setText(sciud);
		tfcprof.setText(sprof);
		tachcl.setText(shicl);
		tacsag.setText(ssage);
		tacrea.setText(srean);
		if(senci.equals("Si"))
		{
			checs.setState(true);
		}
		else if(senci.equals("No"))
				{
				checn.setState(true);
				}
				
		if(senre.equals("Si"))
		{
			chers.setState(true);
		}
		else if(senre.equals("No"))
				{
				chern.setState(true);
				}
				
		if(saler.equals("Si"))
		{
			chals.setState(true);
		}
		else if(saler.equals("No"))
				{
				chaln.setState(true);
				}

		tacegb.setText(sesgb);
		tacobs.setText(sobse);
	}
	
	feddp.add(choeda);
	feddp.add(chmas);
	feddp.add(chfem);
	feddp.add(checs);
	feddp.add(checn);
	feddp.add(chers);
	feddp.add(chern);
	feddp.add(chals);
	feddp.add(chaln);
	
		feddp.add(ltdpe);
        feddp.add(lnom);
        feddp.add(lape);
        feddp.add(lide);
        feddp.add(leda);
        feddp.add(lsex);
        feddp.add(ltel);
        feddp.add(lciu);
        feddp.add(ldir);
        feddp.add(lprof);
        feddp.add(lhcl);
        feddp.add(lsag);
        feddp.add(lrea);
        feddp.add(lenc);
        feddp.add(lenr);
        feddp.add(lale);
        feddp.add(legb);
        feddp.add(lobs);
                
        feddp.add(tfcnom);
        feddp.add(tfcape);
        feddp.add(tfcide);
        feddp.add(tfctel);
        feddp.add(tfcdir);
        feddp.add(tfcciu);
        feddp.add(tfcprof);
     
        feddp.add(tachcl);
        feddp.add(tacsag);
        feddp.add(tacrea);
        feddp.add(tacegb);
        feddp.add(tacobs);
	
		feddp.add(beddp);

	feddp.setLayout(null);
	feddp.setSize(600,550);
	feddp.setLocationRelativeTo(null);
	feddp.setResizable(false);
	feddp.show();

}

public void editarer()
{
 feder = new JFrame("Editar Examen Radiologico");
        ltexr = new JLabel("EXAMEN RADIOLOGICO");
        ltexr.setBounds(230, 10, 200, 30);
        iexr = new ImageIcon("content//examrad2.png");
        liexr = new JLabel(iexr);
        liexr.setBounds(175, 60, 260, 48);
        cha1 = new Checkbox("", false);
        cha1.setBounds(175, 45, 15, 15);
        cha2 = new Checkbox("", false);
        cha2.setBounds(191, 45, 15, 15);
        cha3 = new Checkbox("", false);
        cha3.setBounds(207, 45, 15, 15);
        cha4 = new Checkbox("", false);
        cha4.setBounds(223, 45, 15, 15);
        cha5 = new Checkbox("", false);
        cha5.setBounds(239, 45, 15, 15);
        cha6 = new Checkbox("", false);
        cha6.setBounds(255, 45, 15, 15);
        cha7 = new Checkbox("", false);
        cha7.setBounds(271, 45, 15, 15);
        cha8 = new Checkbox("", false);
        cha8.setBounds(287, 45, 15, 15);
        cha9 = new Checkbox("", false);
        cha9.setBounds(312, 45, 15, 15);
        cha10 = new Checkbox("", false);
        cha10.setBounds(328, 45, 15, 15);
        cha11 = new Checkbox("", false);
        cha11.setBounds(344, 45, 15, 15);
        cha12 = new Checkbox("", false);
        cha12.setBounds(360, 45, 15, 15);
        cha13 = new Checkbox("", false);
        cha13.setBounds(376, 45, 15, 15);
        cha14 = new Checkbox("", false);
        cha14.setBounds(392, 45, 15, 15);
        cha15 = new Checkbox("", false);
        cha15.setBounds(408, 45, 15, 15);
        cha16 = new Checkbox("", false);
        cha16.setBounds(424, 45, 15, 15);
        chb1 = new Checkbox("", false);
        chb1.setBounds(175, 110, 15, 15);
        chb2 = new Checkbox("", false);
        chb2.setBounds(191, 110, 15, 15);
        chb3 = new Checkbox("", false);
        chb3.setBounds(207, 110, 15, 15);
        chb4 = new Checkbox("", false);
        chb4.setBounds(223, 110, 15, 15);
        chb5 = new Checkbox("", false);
        chb5.setBounds(239, 110, 15, 15);
        chb6 = new Checkbox("", false);
        chb6.setBounds(255, 110, 15, 15);
        chb7 = new Checkbox("", false);
        chb7.setBounds(271, 110, 15, 15);
        chb8 = new Checkbox("", false);
        chb8.setBounds(287, 110, 15, 15);
        chb9 = new Checkbox("", false);
        chb9.setBounds(312, 110, 15, 15);
        chb10 = new Checkbox("", false);
        chb10.setBounds(328, 110, 15, 15);
        chb11 = new Checkbox("", false);
        chb11.setBounds(344, 110, 15, 15);
        chb12 = new Checkbox("", false);
        chb12.setBounds(360, 110, 15, 15);
        chb13 = new Checkbox("", false);
        chb13.setBounds(376, 110, 15, 15);
        chb14 = new Checkbox("", false);
        chb14.setBounds(392, 110, 15, 15);
        chb15 = new Checkbox("", false);
        chb15.setBounds(408, 110, 15, 15);
        chb16 = new Checkbox("", false);
        chb16.setBounds(424, 110, 15, 15);
        ldia = new JLabel("Diagnostico");
        ldia.setBounds(5, 120, 223, 30);
        lobr = new JLabel("Observaciones");
        lobr.setBounds(5, 200, 223, 30);
        tacdia = new JTextArea(1, 1);
        tacdia.setBounds(5, 150, 585, 50);
        tacobr = new JTextArea(1, 1);
        tacobr.setBounds(5, 230, 585, 50);

   
   beder=new JButton("Aceptar");
   beder.setBounds(250,290,100,20);
   beder.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){guardarer();}});

   if(!baninsOupd.equals("nuevo"))
	{
		tacdia.setText(serdiag);
		tacobr.setText(serobse);
		System.out.println("editarer "+sa1);
		if(sa1.equals("X")){cha1.setState(true);} else if(sa1.equals(" ")){cha1.setState(false);}
		if(sa2.equals("X")){cha2.setState(true);} else if(sa2.equals(" ")){cha2.setState(false);}
		if(sa3.equals("X")){cha3.setState(true);} else if(sa3.equals(" ")){cha3.setState(false);}
		if(sa4.equals("X")){cha4.setState(true);} else if(sa4.equals(" ")){cha4.setState(false);}
		if(sa5.equals("X")){cha5.setState(true);} else if(sa5.equals(" ")){cha5.setState(false);}
		if(sa6.equals("X")){cha6.setState(true);} else if(sa6.equals(" ")){cha6.setState(false);}
		if(sa7.equals("X")){cha7.setState(true);} else if(sa7.equals(" ")){cha7.setState(false);}
		if(sa8.equals("X")){cha8.setState(true);} else if(sa8.equals(" ")){cha8.setState(false);}
		if(sa9.equals("X")){cha9.setState(true);} else if(sa9.equals(" ")){cha9.setState(false);}
		if(sa10.equals("X")){cha10.setState(true);} else if(sa10.equals(" ")){cha10.setState(false);}
		if(sa11.equals("X")){cha11.setState(true);} else if(sa11.equals(" ")){cha11.setState(false);}
		if(sa12.equals("X")){cha12.setState(true);} else if(sa12.equals(" ")){cha12.setState(false);}
		if(sa13.equals("X")){cha13.setState(true);} else if(sa13.equals(" ")){cha13.setState(false);}
		if(sa14.equals("X")){cha14.setState(true);} else if(sa14.equals(" ")){cha14.setState(false);}
		if(sa15.equals("X")){cha15.setState(true);} else if(sa15.equals(" ")){cha15.setState(false);}
		if(sa16.equals("X")){cha16.setState(true);} else if(sa16.equals(" ")){cha16.setState(false);}
		
		if(sb1.equals("X")){chb1.setState(true);} else if(sb1.equals(" ")){chb1.setState(false);}
		if(sb2.equals("X")){chb2.setState(true);} else if(sb2.equals(" ")){chb2.setState(false);}
		if(sb3.equals("X")){chb3.setState(true);} else if(sb3.equals(" ")){chb3.setState(false);}
		if(sb4.equals("X")){chb4.setState(true);} else if(sb4.equals(" ")){chb4.setState(false);}
		if(sb5.equals("X")){chb5.setState(true);} else if(sb5.equals(" ")){chb5.setState(false);}
		if(sb6.equals("X")){chb6.setState(true);} else if(sb6.equals(" ")){chb6.setState(false);}
		if(sb7.equals("X")){chb7.setState(true);} else if(sb7.equals(" ")){chb7.setState(false);}
		if(sb8.equals("X")){chb8.setState(true);} else if(sb8.equals(" ")){chb8.setState(false);}
		if(sb9.equals("X")){chb9.setState(true);} else if(sb9.equals(" ")){chb9.setState(false);}
		if(sb10.equals("X")){chb10.setState(true);} else if(sb10.equals(" ")){chb10.setState(false);}
		if(sb11.equals("X")){chb11.setState(true);} else if(sb11.equals(" ")){chb11.setState(false);}
		if(sb12.equals("X")){chb12.setState(true);} else if(sb12.equals(" ")){chb12.setState(false);}
		if(sb13.equals("X")){chb13.setState(true);} else if(sb13.equals(" ")){chb13.setState(false);}
		if(sb14.equals("X")){chb14.setState(true);} else if(sb14.equals(" ")){chb14.setState(false);}
		if(sb15.equals("X")){chb15.setState(true);} else if(sb15.equals(" ")){chb15.setState(false);}
		if(sb16.equals("X")){chb16.setState(true);} else if(sb16.equals(" ")){chb16.setState(false);}
		
	}
    feder.add(ltexr);
	feder.add(liexr);
	feder.add(cha1);
	feder.add(cha2);
	feder.add(cha3);
	feder.add(cha4);
	feder.add(cha5);
	feder.add(cha6);
	feder.add(cha7);
	feder.add(cha8);
	feder.add(cha9);
	feder.add(cha10);
	feder.add(cha11);
	feder.add(cha12);
	feder.add(cha13);
	feder.add(cha14);
	feder.add(cha15);
	feder.add(cha16);
	feder.add(chb1);
	feder.add(chb2);
	feder.add(chb3);
	feder.add(chb4);
	feder.add(chb5);
	feder.add(chb6);
	feder.add(chb7);
	feder.add(chb8);
	feder.add(chb9);
	feder.add(chb10);
	feder.add(chb11);
	feder.add(chb12);
	feder.add(chb13);
	feder.add(chb14);
	feder.add(chb15);
	feder.add(chb16);
		
    feder.add(ldia);
    feder.add(tacdia);
    feder.add(lobr);
    feder.add(tacobr);
    feder.add(beder);
    feder.setLayout(null);
    feder.setSize(600, 350);
    feder.setLocationRelativeTo(null);
    feder.setResizable(false);
    feder.show();
	

}

public void editarec()
{
	 avisosalir();
	try{
		File cmdoec= new File("oec.cmd");
		FileWriter escmdoec= new FileWriter(cmdoec,true);
		escmdoec.write("@echo off");
		escmdoec.write(System.getProperty("line.separator"));
		escmdoec.write("ExamenClin\\Paint.exe ExamenClin\\"+siden+".png");
		escmdoec.write(System.getProperty("line.separator"));
		escmdoec.write("erase oec.cmd");
		escmdoec.close();
		Process proiuv= Runtime.getRuntime().exec("cmd.exe /K  oec.cmd");
	  
		}catch(Exception e){	}
	}
public void editarct()
{
	 avisosalir();
	try{
		File cmdoct= new File("oct.cmd");
		FileWriter escmdoct= new FileWriter(cmdoct,true);
		escmdoct.write("@echo off");
		escmdoct.write(System.getProperty("line.separator"));
		escmdoct.write("CursoTra\\Paint.exe CursoTra\\"+siden+".png");
		escmdoct.write(System.getProperty("line.separator"));
		escmdoct.write("erase oct.cmd");
		escmdoct.close();
		Process proiuv= Runtime.getRuntime().exec("cmd.exe /K  oct.cmd");
	}catch(Exception e){	}
}
JFrame faviso;
JLabel laviso;
JButton bsi,bno;

public void avisosalir()
    {
        faviso = new JFrame("ADVERTENCIA");
        laviso = new JLabel("Desea reiniciar el programa para vizualizar los odontogramas");
        bsi = new JButton("SI");
        bsi.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent actionevent){
        try{
		File cmdop= new File("op.cmd");
		FileWriter escmdop= new FileWriter(cmdop,true);
		escmdop.write("@echo off");
		escmdop.write(System.getProperty("line.separator"));
		escmdop.write("CartaDental.exe");
		escmdop.write(System.getProperty("line.separator"));
		escmdop.write("erase op.cmd");
		escmdop.close();
		Process proop= Runtime.getRuntime().exec("cmd.exe /K  op.cmd");
		}catch(Exception e){	}
        System.exit(0);
        }});

        bno = new JButton("NO");
        bno.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent actionevent){ faviso.setVisible(false);     }});
 
        faviso.setLayout(new FlowLayout());
        faviso.add(laviso);
        faviso.add(bsi);
        faviso.add(bno);
        faviso.setSize(370, 100);
        faviso.setLocationRelativeTo(null);
        faviso.show();
    }
 
 JScrollPane edscrollPane1,edscrollPane2;


 JTextField edtfplan,edtfvalt,tfpfech,tfpdeta,tfpabon,tfpsald,tfffech,tffdien,tfftrat,tffvalo;
 JButton bcal,bapre,bafac,bepre;
 JFrame fpres;
 JLabel lpfech,lpdeta,lpabon,lpsald,lffech,lfdien,lftrat,lfvalo;
 public void editarpre()
    {
    
        ltrat = new JLabel("TRATAMIENTO");
        ltrat.setBounds(210, 0, 100, 30);
        lfact = new JLabel("FACTURACION");
        lfact.setBounds(210, 210, 100, 30);
        lpres = new JLabel("Plan total presupuesto");
        lpres.setBounds(0, 20, 270, 30);
        lvtr = new JLabel("Valor tratamiento");
        lvtr.setBounds(0, 50, 300, 30);
        lpfech = new JLabel("Fecha");
        lpfech.setBounds(35, 80, 100, 30);
        lpdeta = new JLabel("Detalle");
        lpdeta.setBounds(180, 80, 200, 30);
        lpabon = new JLabel("Abono");
        lpabon.setBounds(330, 80, 100, 30);
        lpsald = new JLabel("Saldo");
        lpsald.setBounds(430, 80, 100, 30);
        lffech = new JLabel("Fecha");
        lffech.setBounds(35, 250, 100, 30);
        lfdien = new JLabel("Diente");
        lfdien.setBounds(130, 250, 100, 30);
        lftrat = new JLabel("Tratamiento");
        lftrat.setBounds(260, 250, 200, 30);
        lfvalo = new JLabel("Valor");
        lfvalo.setBounds(430, 250, 100, 30);
        
        tfpfech = new JTextField();
        tfpfech.setBounds(0, 110, 100, 20);
        tfpdeta = new JTextField();
        tfpdeta.setBounds(100, 110, 200, 20);
        tfpabon = new JTextField();
        tfpabon.setBounds(300, 110, 100, 20);
        tfpsald = new JTextField();
        tfpsald.setBounds(400, 110, 100, 20);
        tfffech = new JTextField();
        tfffech.setBounds(0, 280, 100, 20);
        tffdien = new JTextField();
        tffdien.setBounds(100, 280, 100, 20);
        tfftrat = new JTextField();
        tfftrat.setBounds(200, 280, 200, 20);
        tffvalo = new JTextField();
        tffvalo.setBounds(400, 280, 100, 20);
        
        edtfplan = new JTextField(400);
        edtfplan.setBounds(140, 25, 360, 20);
        edtfvalt = new JTextField(400);
        edtfvalt.setBounds(110, 55, 100, 20);
        
        if(sabono[0][2].equals(""))
    	{
     	
        }
        else
        {
        edtfplan.setText(splan);
        edtfvalt.setText(svalt);
        }    
        bepre = new JButton("Terminar Tratamiento");
        bepre.setBounds(250, 55, 200, 20);
        bepre.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent actionevent) {
	    for(i = 0; i <= 29; i++)
		 {
		    for(j = 0; j <= 3; j++)
		    {
			sabono[i][j] ="";
			tpres.setValueAt(sabono[i][j], i, j);
			}
			}
		splan="";
		svalt="";
		tfplan.setText("");
		tfvalt.setText("");
		edtfplan.setText("");
		edtfvalt.setText("");
        eliminapre();}});
            
        bcal = new JButton("Calcular");
        bcal.setBounds(150, 160, 100, 20);
        bcal.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent actionevent) {calcularpre();}});
        bcal.setEnabled(true);
        bapre = new JButton("Guardar");
        bapre.setBounds(270, 160, 100, 20);
        bapre.setEnabled(false);
        bapre.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent actionevent){guardarpre();}});
        bafac = new JButton("Guardar");
        bafac.setBounds(200, 310, 100, 20);
        bafac.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent actionevent) {guardarfac();}});   
        fpres = new JFrame("Editar Presupuesto");
        fpres.setLayout(null);
        fpres.add(ltrat);
        fpres.add(lpres);
        fpres.add(lvtr);
        fpres.add(edtfplan);
        fpres.add(edtfvalt);
        fpres.add(lpfech);
        fpres.add(lpdeta);
        fpres.add(lpabon);
        fpres.add(lpsald);
        fpres.add(lffech);
        fpres.add(lfdien);
        fpres.add(lftrat);
        fpres.add(lfvalo);
        fpres.add(tfpfech);
        fpres.add(tfpdeta);
        fpres.add(tfpabon);
        fpres.add(tfpsald);
        fpres.add(tfffech);
        fpres.add(tffdien);
        fpres.add(tfftrat);
        fpres.add(tffvalo);
        
        fpres.add(lfact);
        fpres.add(bepre);
        fpres.add(bcal);
        fpres.add(bapre);
        fpres.add(bafac);
        fpres.setSize(520, 370);
        fpres.setLocationRelativeTo(null);
        fpres.setResizable(false);
        fpres.show();
    }


//BASE DE DATOS
static String snomb,sapel,siden,sedad,ssexo,stele,sdire,sciud,sprof,shicl,ssage,srean,senci,senre,saler,sesgb,sobse;
static int cc,ccc;
public void guardardp()
{
	snomb=tfcnom.getText();
	sapel=tfcape.getText();
	siden=tfcide.getText();
	cc=Integer.parseInt(siden);
	sedad=choeda.getSelectedItem();
	if(chmas.getState()){ssexo="Masculino";	}
	else if(chfem.getState()){ssexo="Femenino";	}
	stele=tfctel.getText();
	sdire=tfcdir.getText();
	sciud=tfcciu.getText();
	sprof=tfcprof.getText();
	shicl=tachcl.getText();
	ssage=tacsag.getText();
	srean=tacrea.getText();
	if(checs.getState()){senci="Si";	}
	else if(checn.getState()){senci="No";	}
	if(chers.getState()){senre="Si";	}
	else if(chern.getState()){senre="No";	}
	if(chals.getState()){saler="Si";	}
	else if(chaln.getState()){saler="No";	}
	sesgb=tacegb.getText();
	sobse=tacobs.getText();
		
	try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	
	//Conexión a la base de datos
	Connection con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
	Statement st=con.createStatement();
	
    ResultSet resultado=st.executeQuery("SELECT * FROM DATOSPERSONALES where "+cc+" = CC");
	//Realiza el recorrido en la base de datos	
	while(resultado.next())
	{
	//Captura el contenido de los campos de la base de datos y los muestra por pantalla
	ccc=resultado.getInt("CC");
	
	}
	String sccc=Integer.toString(ccc);
	String scc=Integer.toString(cc);
	System.out.println("CCC "+ccc+" CC "+cc);
	if (ccc!=cc)
	{
 	String insertar="INSERT INTO DATOSPERSONALES Values ("+cc+",'"+snomb+"','"+sapel+"','"+siden+"','"+sedad+"','"+ssexo+"','"+stele+"','"+sdire+"','"+sciud+"','"+sprof+"','"+shicl+"','"+ssage+"','"+srean+"','"+senci+"','"+senre+"','"+saler+"','"+sesgb+"','"+sobse+"')";
	st.executeUpdate(insertar);
	}
	
	if(ccc==cc)
	{
	
	String actualizar="UPDATE DATOSPERSONALES SET Nombre='"+snomb+"',Apellido='"+sapel+"',Identificacion='"+siden+"',Edad='"+sedad+"',Sexo='"+ssexo+"',Telefono='"+stele+"',Direccion='"+sdire+"',Ciudad='"+sciud+"',Profesion='"+sprof+"',Historiacli='"+shicl+"',Saludgen='"+ssage+"',Reaccionane='"+srean+"',Enfermedadescir='"+senci+"',Enfermedadesres='"+senre+"',Alergias='"+saler+"',Estadogenboc='"+sesgb+"',Observaciones='"+sobse+"' WHERE CC="+cc;
	st.executeUpdate(actualizar);

	}
	st.close();
	con.close();
    ccc=0;
	
	
		File cmdoec= new File("oec.cmd");
		FileWriter escmdoec= new FileWriter(cmdoec,true);
		escmdoec.write("@echo off");
		escmdoec.write(System.getProperty("line.separator"));
		escmdoec.write("copy Content\\oec.png ExamenClin");
		escmdoec.write(System.getProperty("line.separator"));
		escmdoec.write("rename ExamenClin\\oec.png "+siden+".png");
		escmdoec.write(System.getProperty("line.separator"));
		escmdoec.write("erase oec.cmd");
		escmdoec.close();
		Process proiuv= Runtime.getRuntime().exec("cmd.exe /K  oec.cmd");
		
		File cmdoct= new File("oct.cmd");
		FileWriter escmdoct= new FileWriter(cmdoct,true);
		escmdoct.write("@echo off");
		escmdoct.write(System.getProperty("line.separator"));
		escmdoct.write("copy Content\\oct.png CursoTra");
		escmdoct.write(System.getProperty("line.separator"));
		escmdoct.write("rename CursoTra\\oct.png "+siden+".png");
		escmdoct.write(System.getProperty("line.separator"));
		escmdoct.write("erase oct.cmd");
		escmdoct.close();
		Process creoct= Runtime.getRuntime().exec("cmd.exe /K  oct.cmd");
		cargardp();
}catch (Exception e){	}
}

public  void cargardp()
{
	
	
	
	if(banmostdp.equals("abrircc"))
	{
		siden=tfacc.getText();
		cc=Integer.parseInt(siden);
		facc.setVisible(false);
		ccc=Integer.parseInt(siden);
			
    	 for(i = 0; i <= 29; i++)
         {
            for(j = 0; j <= 3; j++)
            {
        	sabono[i][j] ="";
        	sdafact[i][j]="";
	  		}
	  	}
	  	splan="";
	    svalt="";
		}
	if(banmostdp.equals("editardp")){feddp.setVisible(false);	}
	if(banmostdp.equals("connombre")){fanom.setVisible(false);	
    	 for(i = 0; i <= 29; i++)
         {
            for(j = 0; j <= 3; j++)
            {
        	sabono[i][j] ="";
        	sdafact[i][j]="";
	  		}
	  	}
	  	splan="";
	    svalt="";	}

	try
	{
	if(baninsOupd.equals("nuevo")||banmostdp.equals("abrircc")||banmostdp.equals("connombre"))
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
	Statement st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet resultado=st.executeQuery("SELECT * FROM DATOSPERSONALES where "+cc+" = CC");
	//Realiza el recorrido en la base de datos

	cc=0;
	while(resultado.next())
	{
	//Captura el contenido de los campos de la base de datos y los muestra por pantalla
	cc=resultado.getInt("CC");
	snomb=resultado.getString("Nombre");
	sapel=resultado.getString("Apellido");
	siden=resultado.getString("Identificacion");
	sedad=resultado.getString("Edad");
	ssexo=resultado.getString("Sexo");
	stele=resultado.getString("Telefono");
	sdire=resultado.getString("Direccion");
	sciud=resultado.getString("Ciudad");
	sprof=resultado.getString("Profesion");
	shicl=resultado.getString("Historiacli");
	ssage=resultado.getString("Saludgen");
	srean=resultado.getString("Reaccionane");
	senci=resultado.getString("Enfermedadescir");
	senre=resultado.getString("Enfermedadesres");
	saler=resultado.getString("Alergias");
	sesgb=resultado.getString("Estadogenboc");
	sobse=resultado.getString("Observaciones");

	}
	
	st.close();
	con.close();
	}
		}	catch (Exception e){	}
		
	if(cc==0) { JOptionPane.showMessageDialog(null,"No existe en el registro");pfond.setVisible(true);
	pcont.setVisible(false);
	medit.setEnabled(false);	}

	
	tfnom.setText(snomb);
	tfape.setText(sapel);
	tfide.setText(siden);
	tfeda.setText(sedad+" Años");
	tfsex.setText(ssexo);
	tftel.setText(stele);
	tfdir.setText(sdire);
	tfciu.setText(sciud);
	tfprof.setText(sprof);
	tahcl.setText(shicl);
	tasag.setText(ssage);
	tarea.setText(srean);
	tfenc.setText(senci);
	tfenr.setText(senre);
	tfale.setText(saler);
	taegb.setText(sesgb);
	taobs.setText(sobse);
	
	if((banmostdp.equals("abrircc")&&cc!=0)||banmostdp.equals("connombre"))
	{
		pfond.setVisible(false);
		pcont.setVisible(true);
		medit.setEnabled(true);
		
		urlec="ExamenClin\\"+siden+".png";
		ioec=new ImageIcon(urlec);
		lioec.setIcon(ioec);
		
		urlct="CursoTra\\"+siden+".png";
		ioct=new ImageIcon(urlct);
		lioct.setIcon(ioct);
		
	
	}
  

	 
	 
}

//Examen Radiologico
static String sa1="",sa2="",sa3="",sa4="",sa5="",sa6="",sa7="",sa8="",sa9="",sa10="",sa11="",sa12="",sa13="",sa14="",sa15="",sa16=""; 
static String sb1="",sb2="",sb3="",sb4="",sb5="",sb6="",sb7="",sb8="",sb9="",sb10="",sb11="",sb12="",sb13="",sb14="",sb15="",sb16=""; 
static String serdiag,serobse;

public void guardarer()
{

feder.setVisible(false);
if(cha1.getState()){ sa1="X";} else{sa1=" ";}
if(cha2.getState()){ sa2="X";} else{sa2=" ";}
if(cha3.getState()){ sa3="X";} else{sa3=" ";}
if(cha4.getState()){ sa4="X";} else{sa4=" ";}
if(cha5.getState()){ sa5="X";} else{sa5=" ";}
if(cha6.getState()){ sa6="X";} else{sa6=" ";}
if(cha7.getState()){ sa7="X";} else{sa7=" ";}
if(cha8.getState()){ sa8="X";} else{sa8=" ";}
if(cha9.getState()){ sa9="X";} else{sa9=" ";}
if(cha10.getState()){ sa10="X";} else{sa10=" ";}
if(cha11.getState()){ sa11="X";} else{sa11=" ";}
if(cha12.getState()){ sa12="X";} else{sa12=" ";}
if(cha13.getState()){ sa13="X";} else{sa13=" ";}
if(cha14.getState()){ sa14="X";} else{sa14=" ";}
if(cha15.getState()){ sa15="X";} else{sa15=" ";}
if(cha16.getState()){ sa16="X";} else{sa16=" ";}

if(chb1.getState()){ sb1="X";} else{sb1=" ";}
if(chb2.getState()){ sb2="X";} else{sb2=" ";}
if(chb3.getState()){ sb3="X";} else{sb3=" ";}
if(chb4.getState()){ sb4="X";} else{sb4=" ";}
if(chb5.getState()){ sb5="X";} else{sb5=" ";}
if(chb6.getState()){ sb6="X";} else{sb6=" ";}
if(chb7.getState()){ sb7="X";} else{sb7=" ";}
if(chb8.getState()){ sb8="X";} else{sb8=" ";}
if(chb9.getState()){ sb9="X";} else{sb9=" ";}
if(chb10.getState()){ sb10="X";} else{sb10=" ";}
if(chb11.getState()){ sb11="X";} else{sb11=" ";}
if(chb12.getState()){ sb12="X";} else{sb12=" ";}
if(chb13.getState()){ sb13="X";} else{sb13=" ";}
if(chb14.getState()){ sb14="X";} else{sb14=" ";}
if(chb15.getState()){ sb15="X";} else{sb15=" ";}
if(chb16.getState()){ sb16="X";} else{sb16=" ";}

serdiag=tacdia.getText();
serobse=tacobr.getText();
try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	
	//Conexión a la base de datos
	Connection con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
	Statement st=con.createStatement();
	
	
	ResultSet resultado=st.executeQuery("SELECT * FROM EXAMENRADIOLOGICO where "+cc+" = CC");
	//Realiza el recorrido en la base de datos

	while(resultado.next())
	{
		//Captura el contenido de los campos de la base de datos y los muestra por pantalla
		ccc=resultado.getInt("CC");
	
	}
	if (ccc!=cc)
	{
	
	String insertar="INSERT INTO EXAMENRADIOLOGICO Values ("+cc+",'"+serdiag+"','"+serobse+"','"+sa1+"','"+sa2+"','"+sa3+"','"+sa4+"','"+sa5+"','"+sa6+"','"+sa7+"','"+sa8+"','"+sa9+"','"+sa10+"','"+sa11+"','"+sa12+"','"+sa13+"','"+sa14+"','"+sa15+"','"+sa16+"','"+sb1+"','"+sb2+"','"+sb3+"','"+sb4+"','"+sb5+"','"+sb6+"','"+sb7+"','"+sb8+"','"+sb9+"','"+sb10+"','"+sb11+"','"+sb12+"','"+sb13+"','"+sb14+"','"+sb15+"','"+sb16+"')";
	st.executeUpdate(insertar);
	}

	
	if(ccc==cc)
	{
	String actualizar="UPDATE EXAMENRADIOLOGICO SET CC="+cc+",Diagnostico='"+serdiag+"',Observaciones='"+serobse+"',a1='"+sa1+"',a2='"+sa2+"',a3='"+sa3+"',a4='"+sa4+"',a5='"+sa5+"',a6='"+sa6+"',a7='"+sa7+"',a8='"+sa8+"',a9='"+sa9+"',a10='"+sa10+"',a11='"+sa11+"',a12='"+sa12+"',a13='"+sa13+"',a14='"+sa14+"',a15='"+sa15+"',a16='"+sa16+"',b1='"+sb1+"',b2='"+sb2+"',b3='"+sb3+"',b4='"+sb4+"',b5='"+sb5+"',b6='"+sb6+"',b7='"+sb7+"',b8='"+sb8+"',b9='"+sb9+"',b10='"+sb10+"',b11='"+sb11+"',b12='"+sb12+"',b13='"+sb13+"',b14='"+sb14+"',b15='"+sb15+"',b16='"+sb16+"' WHERE CC="+cc;
	st.executeUpdate(actualizar);

	}
	st.close();
	con.close();
	ccc=0;
	cargarer();	
}catch (Exception e){	}	
}

public void cargarer()
{
try
	{
	if(banmostdp.equals("abrircc"))
	{
		siden=tfacc.getText();
		cc=Integer.parseInt(siden);
		facc.setVisible(false);
		}
	if(banmostdp.equals("editardp")){feddp.setVisible(false);	}
	if(banmostdp.equals("connombre")){fanom.setVisible(false);	}
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
	Statement st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet resultado=st.executeQuery("SELECT * FROM EXAMENRADIOLOGICO where "+cc+" = CC");
	//Realiza el recorrido en la base de datos
	ccc=0;
	while(resultado.next())
	{
	//Captura el contenido de los campos de la base de datos y los muestra por pantalla
	cc=resultado.getInt("CC");
	ccc=cc;
	
	serdiag=resultado.getString("Diagnostico");
	serobse=resultado.getString("Observaciones");
	sa1=resultado.getString("a1");
	sa2=resultado.getString("a2");
	sa3=resultado.getString("a3");
	sa4=resultado.getString("a4");
	sa5=resultado.getString("a5");
	sa6=resultado.getString("a6");
	sa7=resultado.getString("a7");
	sa8=resultado.getString("a8");
	sa9=resultado.getString("a9");
	sa10=resultado.getString("a10");
	sa11=resultado.getString("a11");
	sa12=resultado.getString("a12");
	sa13=resultado.getString("a13");
	sa14=resultado.getString("a14");
	sa15=resultado.getString("a15");
	sa16=resultado.getString("a16");
	sb1=resultado.getString("b1");
	sb2=resultado.getString("b2");
	sb3=resultado.getString("b3");
	sb4=resultado.getString("b4");
	sb5=resultado.getString("b5");
	sb6=resultado.getString("b6");
	sb7=resultado.getString("b7");
	sb8=resultado.getString("b8");
	sb9=resultado.getString("b9");
	sb10=resultado.getString("b10");
	sb11=resultado.getString("b11");
	sb12=resultado.getString("b12");
	sb13=resultado.getString("b13");
	sb14=resultado.getString("b14");
	sb15=resultado.getString("b15");
	sb16=resultado.getString("b16");
	}

	st.close();
	con.close();
	
	if(ccc==0) { sa1="";sa2="";sa3="";sa4="";sa5="";sa6="";sa7="";sa8="";sa9="";sa10="";sa11="";sa12="";sa13="";sa14="";sa15="";sa16="";
	sb1="";sb2="";sb3="";sb4="";sb5="";sb6="";sb7="";sb8="";sb9="";sb10="";sb11="";sb12="";sb13="";sb14="";sb15="";sb16="";
	serdiag="";
	serobse="";
	}	
	la1.setText(sa1);
	la2.setText(sa2);
	la3.setText(sa3);
	la4.setText(sa4);
	la5.setText(sa5);
	la6.setText(sa6);
	la7.setText(sa7);
	la8.setText(sa8);
	la9.setText(sa9);
	la10.setText(sa10);
	la11.setText(sa11);
	la12.setText(sa12);
	la13.setText(sa13);
	la14.setText(sa14);
	la15.setText(sa15);
	la16.setText(sa16);
	
	lb1.setText(sb1);
	lb2.setText(sb2);
	lb3.setText(sb3);
	lb4.setText(sb4);
	lb5.setText(sb5);
	lb6.setText(sb6);
	lb7.setText(sb7);
	lb8.setText(sb8);
	lb9.setText(sb9);
	lb10.setText(sb10);
	lb11.setText(sb11);
	lb12.setText(sb12);
	lb13.setText(sb13);
	lb14.setText(sb14);
	lb15.setText(sb15);
	lb16.setText(sb16);

	tadia.setText(serdiag);
	taobr.setText(serobse);
	ccc=0;
  
}	catch (Exception e){	}	
}

//Eliminar
JFrame feli;
JLabel msjeli;
JButton baeli,bceli;
public void igeliminar()
{
	feli=new JFrame ("Advertencia");
	msjeli= new JLabel ("¿Esta seguro de Eliminar?");
	baeli=new JButton("Aceptar");
	baeli.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){eliminardp();}});
	bceli=new JButton("Cancelar");
	bceli.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){feli.setVisible(false);}});
	feli.setLayout(new FlowLayout());
	feli.add(msjeli);
	feli.add(baeli);
	feli.add(bceli);
	feli.setSize(200,100);
	feli.setLocationRelativeTo(null);
	feli.setResizable(false);
	feli.show();
}

public void eliminardp()
{
	feli.setVisible(false);
	try
	{
	File cmdeec= new File("eec.cmd");
		FileWriter escmdeec= new FileWriter(cmdeec,true);
		escmdeec.write("@echo off");
		escmdeec.write(System.getProperty("line.separator"));
		escmdeec.write("del ExamenClin\\"+siden+".png");
		escmdeec.write(System.getProperty("line.separator"));
		escmdeec.write("del CursoTra\\"+siden+".png");
		escmdeec.write(System.getProperty("line.separator"));
		escmdeec.write("erase eec.cmd");
		escmdeec.close();
		Process proel= Runtime.getRuntime().exec("cmd.exe /K  eec.cmd");
	
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection	con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
    Statement 	st=con.createStatement();
	//Extrae los datos de la base de datos
	ResultSet eliminardp=st.executeQuery("Delete * From DATOSPERSONALES where "+cc+" =CC");
	st.close();
	con.close();
	
	}catch (Exception e){	}
	inicio();
	eliminarer();
	eliminapre();
	eliminafac();
	JOptionPane.showMessageDialog(null,"Ha eliminado el registro correctamente");

}

public void eliminarer()
{

	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection	con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
    Statement 	st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet eliminarer=st.executeQuery("Delete * From EXAMENRADIOLOGICO where "+cc+" =CC");
	st.close();
	con.close();
	
	
}	catch (Exception e){	}
	
	
	
}

public void eliminapre()
{

	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection	con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
    Statement 	st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet eliminarer=st.executeQuery("Delete * From PRESUPUESTO where "+cc+" =CC");
	st.close();
	con.close();
	
	
}	catch (Exception e){	}
}
	
public void eliminafac()
{

	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection	con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
    Statement 	st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet eliminarer=st.executeQuery("Delete * From FACTURA where "+cc+" =CC");
	st.close();
	con.close();
	
	
}	catch (Exception e){	}
	
}

//MOSTRAR 
//PRESUPUESTO
static int valt,abono,saldo=0;
static String svalt,sabon,ssaldo,spfech,sdeta,splan,sffech,sdien,strat,svalor;
String sabono [][]= new String[30][4], sdafact[][]= new String[30][4];
public void calcularpre()
    {
    	if(h>=1)
    	{
    		saldo=saldo+abono;
    	}
    	svalt=edtfvalt.getText();
    	sabon=tfpabon.getText();
    	valt=Integer.parseInt(svalt);
    	abono=Integer.parseInt(sabon);
    	if(sabono[0][2].equals(""))
    	{
        	saldo=valt-abono;
    	}
    	else
    	{
    		saldo=saldo-abono;
    	}
    	ssaldo=Integer.toString(saldo);
    	tfpsald.setText(ssaldo);
    	
    bapre.setEnabled(true);	
    
    h++;
    	
  }
    
public void guardarpre()
    {
    h=0;
    fpres.setVisible(false);
	splan=edtfplan.getText();	
	spfech=tfpfech.getText();
	sdeta=tfpdeta.getText();
    try
	{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String s = "Datos/bdcardent.mdb";
        String s1 = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
        s1 = (new StringBuilder()).append(s1).append(s).append(";DriverID=22;READONLY=true)").toString();
        Connection connection = DriverManager.getConnection(s1, "", "");
        Statement statement = connection.createStatement();
        
        String insertar ="INSERT INTO PRESUPUESTO (CC,Plan,Valor,Fecha,Detalle,Abono,Saldo) Values ("+cc+",'"+splan+"','"+svalt+"','"+spfech+"','"+sdeta+"','"+sabon+"','"+ssaldo+"')";
        statement.executeUpdate(insertar);

        statement.close();
        connection.close();
        cargarpre();
    }
    catch(Exception exception) { }
    }

public void cargarpre()
{
	try{

	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
	Statement st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet resultado=st.executeQuery("SELECT * FROM PRESUPUESTO where "+cc+" = CC");
	//Realiza el recorrido en la base de datos
	
	while(resultado.next())
	{
		splan=resultado.getString("Plan");	
		svalt=resultado.getString("Valor");	
    	sabono[f][0]=spfech=resultado.getString("Fecha");	
    	sabono[f][1]=sdeta=resultado.getString("Detalle");	
    	
    	sabono[f][2]=sabon=resultado.getString("Abono");	
       	sabono[f][3]=ssaldo=resultado.getString("Saldo");
       	f++;	
	}
	f=0;
	for(i = 0; i <= 29; i++)
    {
        for(j = 0; j <= 3; j++)
        {
    
		tpres.setValueAt(sabono[i][j], i, j);
	 	}
	 }
	 tfplan.setText(splan); 
	 tfvalt.setText(svalt);
	 saldo=Integer.parseInt(ssaldo);
	 st.close();
     con.close();
}
     catch(Exception exception) { }
}

public void guardarfac()
{
	fpres.setVisible(false);
	sffech=tfffech.getText();	
	sdien=tffdien.getText();
	strat=tfftrat.getText();
	svalor=tffvalo.getText();
	 try
	{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String s = "Datos/bdcardent.mdb";
        String s1 = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
        s1 = (new StringBuilder()).append(s1).append(s).append(";DriverID=22;READONLY=true)").toString();
        Connection connection = DriverManager.getConnection(s1, "", "");
        Statement statement = connection.createStatement();
        
        String insertar ="INSERT INTO FACTURA (CC,Fecha,Diente,Detalle,Valor) Values ("+cc+",'"+sffech+"','"+sdien+"','"+strat+"','"+svalor+"')";
        statement.executeUpdate(insertar);

        statement.close();
        connection.close();
        cargarfac();
    }
    catch(Exception exception) { }
 }
public void cargarfac()
{
	try{

	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	String dataSourceName = "Datos/bdcardent.mdb";
	String dbURL = "jdbc:odbc:Driver={Driver do Microsoft Access (*.mdb)};DBQ=";
	dbURL += dataSourceName +";DriverID=22;READONLY=true)";
	Connection con=DriverManager.getConnection(dbURL,"","");
	//Conduce la información a la base de datos
	Statement st=con.createStatement();
	//Extrae los datos de la base de datos

	ResultSet resultado=st.executeQuery("SELECT * FROM FACTURA where "+cc+" = CC");
	//Realiza el recorrido en la base de datos
	
	while(resultado.next())
	{
	
    	sdafact[f][0]=spfech=resultado.getString("Fecha");	
    	sdafact[f][1]=sdeta=resultado.getString("Diente");	
    	
    	sdafact[f][2]=sabon=resultado.getString("Detalle");	
       	sdafact[f][3]=ssaldo=resultado.getString("Valor");
       	f++;	
	}
	f=0;
	for(i = 0; i <= 29; i++)
    {
        for(j = 0; j <= 3; j++)
        {
		tfact.setValueAt(sdafact[i][j], i, j);
	 	}
	 }

	 st.close();
     con.close();
}
     catch(Exception exception) { }
}

static ImageIcon iintro;
static JLabel limintro;
static JWindow winer,wintro;
public static void	main (String[]args)
{

wintro= new JWindow ();
iintro= new ImageIcon("Content//introcartadent.gif");
limintro = new JLabel(iintro);
wintro.add(limintro);
wintro.setSize(272,114);
wintro.setLayout(new FlowLayout());
wintro.setLocationRelativeTo(null);
wintro.show();
try
{
Thread.sleep(9000);
}catch (Exception e){}

wintro.setVisible(false);
 cartdent j =new cartdent();
 j.igmain();	

}

}
//CONSTRUCTOR
package test;

import java.awt.*;

import java.io.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import java.lang.*;

//	Modelo de Tabla, Modificando el Default	//
class myDataModel extends DefaultTableModel implements TableCellRenderer {
  public myDataModel() {
    super(100, 100);
    nuevo();
  }

  public void nuevo() {
    int i, j;
    for (i = 0; i <= super.getColumnCount() - 1; i++) {
      for (j = 0; j <= super.getRowCount() - 1; j++) {
        super.setValueAt(new CellData(), i, j);
      }
    }

  }

  public void setvect(Vector c) {
    dataVector = null;
    dataVector = c;
  }

  public void setColorAt(Color val, int r, int c) {
    CellData b = (CellData)super.getValueAt(r, c);
    b.b = val;
  }

  public void setFColorAt(Color val, int r, int c) {
    CellData b = (CellData)super.getValueAt(r, c);
    b.f = val;
  }

  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    if (aValue instanceof CellData) {
      super.setValueAt(aValue, rowIndex, columnIndex);
    } else {
      CellData b = (CellData)super.getValueAt(rowIndex, columnIndex);
      b.s = aValue.toString();
      super.setValueAt(b, rowIndex, columnIndex);
    }
  }

  public Component getTableCellRendererComponent(JTable tabla, Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus, int row,
                                                 int column) {
    DefaultTableCellRenderer f = new DefaultTableCellRenderer();
    if (value instanceof CellData && !isSelected) {
      CellData b = (CellData)super.getValueAt(row, column);
      f.setBackground(b.b);
      f.setForeground(b.f);
      f.setText(b.s);
      return (Component)f;
    } else if (hasFocus) {
      CellData b = (CellData)super.getValueAt(row, column);
      Color t =
        new Color(255 - b.b.getRed(), 255 - b.b.getGreen(), 255 - b.b.getBlue());
      f.setBackground(t);
      f.setForeground(new Color(255 - t.getRed(), 255 - t.getGreen(),
                                255 - t.getBlue()));
      f.setText(b.s);
      return (Component)f;

    } else {
      return f.getTableCellRendererComponent(tabla, value, isSelected,
                                             hasFocus, row, column);
    }
  }
}

//	Dato de Celda, para poder Guardar y Copiar las Celdas	//
class CellData extends Object implements Serializable, Cloneable {
  public String s = new String("");
  public Color b = Color.white;
  public Color f = Color.black;

  public CellData() {
  }

  public String toString() {
    return s;
  }

  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

public class P2 extends Frame {
  myDataModel data = new myDataModel();
  JTable tabla = new JTable(data);
  JScrollPane panelScroll = new JScrollPane(tabla);
  CellData[][] clipboard;
  info in = new info(P2.this, true);
  Screen Scr = new Screen(P2.this, true);
  User us = new User(P2.this, true);

  public class Calc extends JPanel {
    public Calc() {
      setLayout(new BorderLayout());
      tabla.setDefaultRenderer(Object.class, data);
      tabla.setRowSelectionAllowed(true);
      tabla.setColumnSelectionAllowed(true);
      tabla.setSelectionForeground(Color.blue);
      tabla.setSelectionBackground(Color.green);
      tabla.setAutoResizeMode(0);
      tabla.getTableHeader().setReorderingAllowed(false);
      tabla.setDoubleBuffered(true);
      add(panelScroll);
    }
  }

  public P2() {


    MenuBar menuBar = new MenuBar();
    Menu menuFile = new Menu("Archivo");
    Menu menuEdit = new Menu("Edicion");
    Menu menuForm = new Menu("Formato");
    Menu menuHelp = new Menu("Ayuda");
    MenuItem menuFileNew = new MenuItem("Nuevo");
    MenuItem menuFileOpen = new MenuItem("Abrir");
    MenuItem menuFileSave = new MenuItem("Guardar");
    MenuItem menuFileClos = new MenuItem("Cerrar");
    MenuItem menuFileExit = new MenuItem("Salir");
    MenuItem menuEditCopy = new MenuItem("Copiar");
    MenuItem menuEditPaste = new MenuItem("Pegar");
    MenuItem menuEditCut = new MenuItem("Cortar");
    MenuItem menuEditSelec = new MenuItem("Seleccionar Todo");
    MenuItem menuFormCF = new MenuItem("Color De Fondo");
    MenuItem menuFormCB = new MenuItem("Color De Letra");
    MenuItem menuHelpSc = new MenuItem("Ayuda En Pantalla");
    MenuItem menuHelpMU = new MenuItem("Manual Del Usuario");
    MenuItem menuHelpMy = new MenuItem("Acerca de...");

    menuFileNew.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          P2.this.panelScroll.show(true);
          P2.this.tabla.setVisible(true);
          P2.this.data.nuevo();
          panelScroll.repaint();
          P2.this.repaint();
        }

      });

    menuFileOpen.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

          int result =
            JOptionPane.showConfirmDialog(P2.this, "DESEA ABRIR UN ARCHIVO");
          if (result == JOptionPane.YES_OPTION) {


            JFileChooser fil = new JFileChooser();
            int i = fil.showOpenDialog(P2.this);
            if (i == JFileChooser.APPROVE_OPTION) {
              File f = fil.getSelectedFile();
              fil = null;
              try {
                FileInputStream in = new FileInputStream(f);
                ObjectInputStream s = new ObjectInputStream(in);
                data.setvect((Vector)s.readObject());
                panelScroll.setVisible(true);
                tabla.setVisible(true);
                P2.this.repaint();
              } catch (Exception xx) {
              }
            }

          } else if (result == JOptionPane.NO_OPTION) {
          }
        }
      });

    menuFileSave.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

          int result =
            JOptionPane.showConfirmDialog(P2.this, "DESEA GUARDAR EL TRABAJO ACTUAL");
          if (result == JOptionPane.YES_OPTION) {

            JFileChooser fil = new JFileChooser();
            int i = fil.showSaveDialog(null);
            if (i == JFileChooser.APPROVE_OPTION) {
              File f = fil.getSelectedFile();
              fil = null;
              try {
                FileOutputStream in = new FileOutputStream(f);
                ObjectOutputStream s = new ObjectOutputStream(in);
                s.writeObject(data.getDataVector());
                s.flush();
              } catch (Exception xx) {
                xx.printStackTrace();
              }
            }
          } else if (result == JOptionPane.NO_OPTION) {
          }
        }
      });

    menuFileClos.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          panelScroll.setVisible(false);
          tabla.setVisible(false);
          P2.this.repaint();
        }
      });

    menuFileExit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

          int result =
            JOptionPane.showConfirmDialog(P2.this, "DESEA SALIR DEL PROGRAMA");
          if (result == JOptionPane.YES_OPTION) {
            P2.this.windowClosed();
          } else if (result == JOptionPane.NO_OPTION) {
          }
        }
      });

    menuEditCut.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
          clipboard = new CellData[b.length][a.length];
          CellData temp;
          int i, j;
          for (i = 0; i <= a.length - 1; i++) {
            for (j = 0; j <= b.length - 1; j++) {
              temp = (CellData)data.getValueAt(b[j], a[i]);
              try {
                clipboard[j][i] = (CellData)temp.clone();
              } catch (CloneNotSupportedException ex) {
              }
              data.setValueAt(new CellData(), b[j], a[i]);
            }
          }
        }
      });


    menuEditCopy.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
          clipboard = new CellData[b.length][a.length];
          CellData temp;
          int i, j;
          for (i = 0; i <= a.length - 1; i++) {
            for (j = 0; j <= b.length - 1; j++) {
              temp = (CellData)data.getValueAt(b[j], a[i]);
              try {
                clipboard[j][i] = (CellData)temp.clone();
              } catch (CloneNotSupportedException ex) {
              }
            }
          }
        }
      });

    menuEditPaste.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int a = tabla.getSelectedColumn(), b = tabla.getSelectedRow();
          if (clipboard != null) {
            int i, j;
            for (i = 0; i <= clipboard[0].length - 1; i++) {
              if (a + i <= tabla.getColumnCount() - 1) {
                for (j = 0; j <= clipboard.length - 1; j++) {
                  if (b + j <= tabla.getRowCount() - 1) {
                    data.setValueAt(clipboard[j][i], b + j, a + i);
                  }
                }
              }
            }
          }
        }
      });

    menuEditSelec.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          tabla.selectAll();
        }
      });

    menuFormCF.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Color c =
            JColorChooser.showDialog(P2.this, "Selector de Color", Color.black);
          int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
          int i, j;
          for (i = 0; i <= a.length - 1; i++) {
            for (j = 0; j <= b.length - 1; j++) {
              data.setColorAt(c, b[j], a[i]);
            }
          }
          tabla.clearSelection();
        }
      });

    menuFormCB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Color c =
            JColorChooser.showDialog(P2.this, "Selector de Color", Color.black);
          int[] a = tabla.getSelectedColumns(), b = tabla.getSelectedRows();
          int i, j;
          for (i = 0; i <= a.length - 1; i++) {
            for (j = 0; j <= b.length - 1; j++) {
              data.setFColorAt(c, b[j], a[i]);
            }
          }
          tabla.clearSelection();
        }
      });


    menuHelpMy.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          P2.this.in.my.setVisible(true);
        }
      });


    menuHelpSc.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          P2.this.Scr.SC.setVisible(true);
        }
      });

    menuHelpMU.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          P2.this.us.UM.setVisible(true);

        }
      });


    menuFile.add(menuFileNew);
    menuFile.addSeparator();
    menuFile.add(menuFileOpen);
    menuFile.add(menuFileSave);
    menuFile.addSeparator();
    menuFile.add(menuFileClos);
    menuFile.addSeparator();
    menuFile.add(menuFileExit);
    menuEdit.add(menuEditCut);
    menuEdit.add(menuEditCopy);
    menuEdit.add(menuEditPaste);
    menuEdit.addSeparator();
    menuEdit.add(menuEditSelec);
    menuForm.add(menuFormCF);
    menuForm.add(menuFormCB);
    menuHelp.add(menuHelpSc);
    menuHelp.add(menuHelpMU);
    menuHelp.addSeparator();
    menuHelp.add(menuHelpMy);
    menuBar.add(menuFile);
    menuBar.add(menuEdit);
    menuBar.add(menuForm);
    menuBar.add(menuHelp);

    add(new Calc());
    setTitle("Proyecto 2");
    setMenuBar(menuBar);
    setSize(new Dimension(600, 500));

    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          int result =
            JOptionPane.showConfirmDialog(P2.this, "DESEA SALIR DEL PROGRAMA");
          if (result == JOptionPane.YES_OPTION) {
            P2.this.windowClosed();
          } else if (result == JOptionPane.NO_OPTION) {
          }
        }
      });
  }


  protected void windowClosed() {
    System.exit(0);
  }
}

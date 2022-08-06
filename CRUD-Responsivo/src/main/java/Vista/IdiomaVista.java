package Vista;

import Controlador.ControladorIdioma;
import Controlador.ControladorValidacion;
import Modelo.Idioma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class IdiomaVista extends javax.swing.JPanel {

    private ControladorIdioma controlador;
    private ControladorValidacion validar;

    public IdiomaVista() {
        initComponents();
        controlador = new ControladorIdioma();
        H2.setVisible(false);
        tabla.setModel(new DefaultTableModel());
        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarTabla();
                H2.setVisible(false);
            }
        });

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col1.setVisible(false);
                cod_idioma.setVisible(false);
                H2.setVisible(true);
                guardar.setVisible(true);
                guardarModificacion.setVisible(false);
                cod_idioma.setText("");
                lengua.setText("");
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lengua_txt = lengua.getText();
                if (controlador.crearIdioma(lengua_txt)) {
                    JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se logro agregar, intente nuevamente");
                }
                H2.setVisible(false);
                lengua.setText("");
                llenarTabla();
            }
        });

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                col1.setVisible(true);
                cod_idioma.setVisible(true);
                cod_idioma.setEditable(false);
                if (filaSeleccionada > -1) {
                    H2.setVisible(true);
                    guardar.setVisible(false);
                    guardarModificacion.setVisible(true);

                    String lengua_txt = (String) tabla.getValueAt(filaSeleccionada, 1);
                    Integer id_txt = (Integer) tabla.getValueAt(filaSeleccionada, 0);

                    lengua.setText(lengua_txt);
                    cod_idioma.setText(id_txt.toString());

                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila");
                }
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int filaSeleccionada = tabla.getSelectedRow();
                col1.setVisible(true);
                cod_idioma.setVisible(true);
                cod_idioma.setEditable(false);
                if (filaSeleccionada > -1) {
                    int op = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?",
                            "Estás a punto de eliminar el idioma",
                            JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (op == 0) {
                        H2.setVisible(true);
                        guardar.setVisible(false);
                        guardarModificacion.setVisible(true);

                        String lengua_txt = (String) tabla.getValueAt(filaSeleccionada, 1);
                        Integer id_txt = (Integer) tabla.getValueAt(filaSeleccionada, 0);

                        controlador.eliminarIdioma(id_txt);
                        JOptionPane.showMessageDialog(null, "Eliminado satisfactoriamente");
                        H2.setVisible(false);
                        llenarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila");
                }
            }
        }
        );

        guardarModificacion.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String nombre_idioma;
                Integer id_idioma;

                nombre_idioma = lengua.getText();
                id_idioma = new Integer(cod_idioma.getText());

                if (controlador.cambiarIdioma(id_idioma, nombre_idioma)) {
                    int op = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?",
                            "Estás a punto de modificar el idioma",
                            JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (op == 0) {
                        JOptionPane.showMessageDialog(null, "Modificado exitosamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se logro modificar, intente nuevamente");
                }
                cod_idioma.setText("");
                lengua.setText("");
                H2.setVisible(false);
                llenarTabla();
            }
        }
        );
    }

    public void llenarTabla() {
        ArrayList<Idioma> lista = controlador.getIdiomas();

        String[] cabecera = {"Código", "Lengua"};

        int cantFilas = lista.size();

        Object[][] datos = new Object[cantFilas][];

        for (int i = 0; i < cantFilas; i++) {
            datos[i] = (Object[]) lista.get(i).toArray();
        }

        DefaultTableModel model = new DefaultTableModel(datos, cabecera);

        tabla.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollTabla = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        mostrar = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        H2 = new javax.swing.JPanel();
        col1 = new javax.swing.JLabel();
        col2 = new javax.swing.JLabel();
        cod_idioma = new javax.swing.JTextField();
        lengua = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        guardarModificacion = new javax.swing.JButton();

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Lengua"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.setToolTipText("");
        ScrollTabla.setViewportView(tabla);

        mostrar.setText("Mostrar Idiomas");

        insertar.setText("Insertar Idioma");

        modificar.setText("Modificar Idioma");

        eliminar.setText("Eliminar Idioma");

        col1.setText("ID :");

        col2.setText("Nombre :");

        cod_idioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cod_idiomaKeyTyped(evt);
            }
        });

        lengua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lenguaKeyTyped(evt);
            }
        });

        guardar.setText("Guardar");

        guardarModificacion.setText("Modificar");

        javax.swing.GroupLayout H2Layout = new javax.swing.GroupLayout(H2);
        H2.setLayout(H2Layout);
        H2Layout.setHorizontalGroup(
            H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(H2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(H2Layout.createSequentialGroup()
                        .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cod_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(H2Layout.createSequentialGroup()
                        .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lengua, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, H2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardarModificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        H2Layout.setVerticalGroup(
            H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(H2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(col1)
                    .addComponent(cod_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(col2)
                    .addComponent(lengua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(guardarModificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(insertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(mostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(H2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar))
                    .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cod_idiomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_idiomaKeyTyped
        validar.limitarCaracteres(evt, cod_idioma, 2);
        validar.soloNumeros(evt);
    }//GEN-LAST:event_cod_idiomaKeyTyped

    private void lenguaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lenguaKeyTyped
        validar.limitarCaracteres(evt, lengua, 10);
        validar.soloLetras(evt);
    }//GEN-LAST:event_lenguaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel H2;
    private javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JTextField cod_idioma;
    private javax.swing.JLabel col1;
    private javax.swing.JLabel col2;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarModificacion;
    private javax.swing.JButton insertar;
    private javax.swing.JTextField lengua;
    private javax.swing.JButton modificar;
    private javax.swing.JButton mostrar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

}

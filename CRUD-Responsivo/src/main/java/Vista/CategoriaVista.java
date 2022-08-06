package Vista;

import Controlador.ControladorCategoria;
import Controlador.ControladorValidacion;
import Modelo.Categoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */
public class CategoriaVista extends javax.swing.JPanel {

    private ControladorCategoria controlador;
    private ControladorValidacion validar;

    public CategoriaVista() {
        initComponents();
        validar = new ControladorValidacion();
        controlador = new ControladorCategoria();
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
                cod_cate.setVisible(false);
                H2.setVisible(true);
                guardar.setVisible(true);
                guardarModificacion.setVisible(false);
                cod_cate.setText("");
                nombre.setText("");
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre_txt = nombre.getText();
                if (controlador.crearCategoria(nombre_txt)) {
                    JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se logro agregar, intente nuevamente");
                }
                H2.setVisible(false);
                nombre.setText("");
                llenarTabla();
            }
        });

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                col1.setVisible(true);
                cod_cate.setVisible(true);
                cod_cate.setEditable(false);
                if (filaSeleccionada > -1) {
                    H2.setVisible(true);
                    guardar.setVisible(false);
                    guardarModificacion.setVisible(true);

                    String nom_txt = (String) tabla.getValueAt(filaSeleccionada, 1);
                    Integer id_txt = (Integer) tabla.getValueAt(filaSeleccionada, 0);

                    nombre.setText(nom_txt);
                    cod_cate.setText(id_txt.toString());

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
                cod_cate.setVisible(true);
                cod_cate.setEditable(false);
                if (filaSeleccionada > -1) {
                    int op = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?",
                            "Estás a punto de eliminar la categoría",
                            JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (op == 0) {
                        H2.setVisible(true);
                        guardar.setVisible(false);
                        guardarModificacion.setVisible(true);

                        String nom_txt = (String) tabla.getValueAt(filaSeleccionada, 1);
                        Integer id_txt = (Integer) tabla.getValueAt(filaSeleccionada, 0);

                        controlador.eliminarCategoria(id_txt);
                        JOptionPane.showMessageDialog(null, "Eliminado satisfactoriamente");
                        H2.setVisible(false);
                        llenarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila");
                }
            }
        });

        guardarModificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre_cat;
                Integer id_cat;

                nombre_cat = nombre.getText();
                id_cat = new Integer(cod_cate.getText());

                if (validar.esVacio(cod_cate) || validar.esVacio(nombre)) {
                    JOptionPane.showMessageDialog(null, "Rellenar los campos");
                } else {

                    int op = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?",
                            "Estás a punto de modificar la categoría",
                            JOptionPane.CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (op == 0) {
                        if (controlador.cambiarCategoria(id_cat, nombre_cat)) {
                            JOptionPane.showMessageDialog(null, "Modificado exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se logro modificar, intente nuevamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se logro modificar, intente nuevamente");
                    }
                }

                cod_cate.setText("");
                nombre.setText("");
                H2.setVisible(false);
                llenarTabla();
            }
        });
    }

    public void llenarTabla() {
        ArrayList<Categoria> lista = controlador.getCategorias();

        String[] cabecera = {"Código", "Nombre"};

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
        cod_cate = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
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
                "Código", "Nombre"
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

        mostrar.setText("Mostrar Categorías");

        insertar.setText("Insertar Categoría");

        modificar.setText("Modificar Categoría");

        eliminar.setText("Eliminar Categoría");

        col1.setText("ID :");

        col2.setText("Nombre :");

        cod_cate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cod_cateKeyTyped(evt);
            }
        });

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
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
                        .addComponent(cod_cate, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(H2Layout.createSequentialGroup()
                        .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(cod_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(H2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(col2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
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

    private void cod_cateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_cateKeyTyped
        validar.limitarCaracteres(evt, cod_cate, 2);
        validar.soloNumeros(evt);
    }//GEN-LAST:event_cod_cateKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        validar.limitarCaracteres(evt, nombre, 20);
        validar.soloLetras(evt);
    }//GEN-LAST:event_nombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel H2;
    private javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JTextField cod_cate;
    private javax.swing.JLabel col1;
    private javax.swing.JLabel col2;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarModificacion;
    private javax.swing.JButton insertar;
    private javax.swing.JButton modificar;
    private javax.swing.JButton mostrar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

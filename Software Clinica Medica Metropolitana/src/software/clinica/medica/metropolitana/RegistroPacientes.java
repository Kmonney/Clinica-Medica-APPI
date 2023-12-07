/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package software.clinica.medica.metropolitana;
import javax.swing.table.DefaultTableModel;
import BaseDatos.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author kmonn
 */
public class RegistroPacientes extends javax.swing.JFrame {
    
    DefaultTableModel modeloTablaPacientes;
    ArrayList<Pacientes> ListadoPacientes;
    int Contador;
    

    /**
     * Creates new form RegistroPacientes
     */
    public RegistroPacientes() {
        initComponents();
        ListadoPacientes = new ArrayList<>();
        InicializarRegistro();
        InicializarModeloTabla();
        CargarJTabla();
        ActivarControles(false);
        ModificarPacientes();
        EliminarPaciente();
        RegistrarPacientes();
        InicializarControles();
    }
    
    void InicializarRegistro(){
        
    
    
    
    
    
    
    
    }
    void ModificarPacientes(){
    int filaSeleccionada = jTblPacientes.getSelectedRow();
    
    String Cedula = (String)modeloTablaPacientes.getValueAt(filaSeleccionada, 0);
    int posicion = -1;
    
    for(int i = 0; i < ListadoPacientes.size(); i++) {
        if (ListadoPacientes.get(i).getCedula().equals(Cedula)){
        posicion = i;
        break;
        }
    }
     if( posicion >= 0) {
    Pacientes aux = ListadoPacientes.get(posicion);
    ListadoPacientes.remove(aux);
    
    aux.setNombre(txtNombre.getText());
    aux.setPrimerApellido(txtPrimerApellido.getText());
    aux.setSegundoApellido(txtSegundoApellido.getText());
    char Genero = cmbGenero.getSelectedIndex() ==0 ? 'M' : 'F';
    aux.setGenero(Genero);
    aux.setAlergias(txtAlergias.getText());
    aux.setObservaciones(txtObservaciones.getText());
    aux.setEnfermedades(txtEnfermedades.getText());
    ListadoPacientes.add(aux);
    
    
    
}
    }
    void RegistrarPacientes(){
    
    Pacientes oPaciente = new Pacientes();
    oPaciente.setCedula(txtCedula.getText());
    oPaciente.setNombre(txtNombre.getText());
    oPaciente.setPrimerApellido(txtPrimerApellido.getText());
    oPaciente.setSegundoApellido(txtSegundoApellido.getText());
    char Genero = cmbGenero.getSelectedIndex() == 0 ? 'M' : 'F'; 
    oPaciente.setAlergias(txtAlergias.getText());
    oPaciente.setEnfermedades(txtEnfermedades.getText());
    oPaciente.setObservaciones(txtObservaciones.getText());
    oPaciente.setPeso(txtPeso.getText());
    oPaciente.setAltura(txtAltura.getText());
    oPaciente.setNumAsegurado(txtAsegurado.getText());
    oPaciente.setNumero(txtNumero.getText());
    oPaciente.setCorreo(txtCorreo.getText());
    oPaciente.setNacimiento(txtNacimiento.getText());
    
    

}
    void CargarJTabla(){
        if (ListadoPacientes == null) {
        System.err.println("ListadoPacientes is null. Cannot Load jTabla");
        return;
        
        }
    Object [] fila;
    
    for(Pacientes oPaciente : ListadoPacientes){
    fila = new Object[6];
    fila [0] = oPaciente.getCedula();
    fila [1] = oPaciente.getNombre()+" "+oPaciente.getPrimerApellido()+" "+oPaciente.getSegundoApellido();
    fila [2] = oPaciente.getGenero();
    fila [3] = oPaciente.getEnfermedades();
    fila [4] = oPaciente.getAlergias();
    fila [5] = oPaciente.getObservaciones();
    modeloTablaPacientes.addRow(fila);
    
       }
    
    
    
    
    }
    
    
    void InicializarModeloTabla(){
        
    modeloTablaPacientes = new DefaultTableModel();
    modeloTablaPacientes.addColumn("Cedula");
    modeloTablaPacientes.addColumn("Paciente");
    modeloTablaPacientes.addColumn("Genero");
    modeloTablaPacientes.addColumn("Enfermedades");
    modeloTablaPacientes.addColumn("Alergias");
    modeloTablaPacientes.addColumn("Observaciones");
    jTblPacientes.setModel(modeloTablaPacientes);
    
    
    }
    
    
    void CargaClientesBd(){
        ListadoPacientes = new ArrayList<>();
        Pacientes oPaciente = new Pacientes();
        oPaciente.setCedula("123456789");
        oPaciente.setPrimerApellido("Monney");
        oPaciente.setSegundoApellido("Arias");
        oPaciente.setGenero('M');
        oPaciente.setEnfermedades("Asma");
        oPaciente.setAlergias("NO Presenta Alergias");
        oPaciente.setObservaciones("No ha presentado cirugias, presenta un grado agudo de dolor de espalda");
        oPaciente.setAltura("1.70");
        oPaciente.setPeso("70 Kilos");
        oPaciente.setNumAsegurado("222556");
        oPaciente.setCorreo("kemonney13@gmail.com");
        oPaciente.setTipoSangre("0Positivo");
        oPaciente.setNumero("22-2222-22");
        ListadoPacientes.add(oPaciente);
       
     
    
    }
    
    
    void InicializarControles(){
    txtCedula.setText("");
    txtNombre.setText("");
    txtPrimerApellido.setText("");
    txtSegundoApellido.setText("");
    txtNacimiento.setText("");
    cmbGenero.setSelectedIndex(0);
    txtCorreo.setText("");
    txtAsegurado.setText("");
    txtAlergias.setText("");
    txtEnfermedades.setText("");
    txtObservaciones.setText("");
    txtPeso.setText("");
    txtAltura.setText("");
    
    }
    void ActivarControles(boolean activar){
    txtCedula.setEditable(activar);
    txtNombre.setEditable(activar);
    txtPrimerApellido.setEditable(activar);
    txtSegundoApellido.setEditable(activar);
    txtNacimiento.setEditable(activar);
    cmbGenero.setEnabled(activar);
    txtNumero.setEditable(activar);
    txtCorreo.setEditable(activar);
    txtAsegurado.setEditable(activar);
    txtAlergias.setEditable(activar);
    txtEnfermedades.setEditable(activar);
    txtObservaciones.setEditable(activar);
    txtPeso.setEditable(activar);
    txtAltura.setEditable(activar);
 
    }
    void EliminarPaciente(){
        int filaSeleccionada = jTblPacientes.getSelectedRow();
        
        if(filaSeleccionada >=0){
            String Cedula = (String) modeloTablaPacientes.getValueAt(filaSeleccionada, 0);
            int posicion = -1;
            
            for(int i = 0; i < ListadoPacientes.size(); i++) {
                
                if(ListadoPacientes.get(i).getCedula().equals(Cedula)) {
                   posicion = 1;
                   break;
                
                
                }
            
            
            }
            
            if(posicion >= 0){
            Pacientes pacienteEliminado = ListadoPacientes.remove(posicion);
            
            LimpiarCampos();
            }
        
        
        
        }
    
    }
    void LimpiarCampos(){
    txtCedula.setText("");
    txtNombre.setText("");
    txtPrimerApellido.setText("");
    txtSegundoApellido.setText("");
    txtNacimiento.setText("");
    cmbGenero.setSelectedIndex(0);
    txtCorreo.setText("");
    txtAsegurado.setText("");
    txtAlergias.setText("");
    txtEnfermedades.setText("");
    txtObservaciones.setText("");
    txtPeso.setText("");
    txtAltura.setText("");
    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrimerApellido = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        txtNacimiento = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cmbGenero = new javax.swing.JComboBox<>();
        txtAsegurado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblPacientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtObservaciones = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAlergias = new javax.swing.JTextField();
        txtEnfermedades = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Pacientes");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setForeground(new java.awt.Color(102, 153, 255));

        jLabel1.setText("Nombre");

        jLabel2.setText("Primer Apellido");

        jLabel3.setText("Segundo Apellido");

        jLabel4.setText("Fecha de Nacimiento");

        jLabel5.setText("Genero");

        jLabel6.setText("Numero Telefonico");

        jLabel7.setText("Correo Electronico");

        jLabel8.setText("Numero Asegurado");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino M", "Femenino F", " " }));

        jTblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre Completo", "Genero", "Enfermedades", "Alergias", "Observaciones"
            }
        ));
        jTblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblPacientes);

        jButton1.setText("Buscar");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setToolTipText("");
        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        jSeparator1.setName("Observaciones"); // NOI18N

        jLabel10.setText("Alergias");

        jLabel11.setText("Enfermedades");

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));

        btnRegistrar.setText("Nuevo");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("Atras");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("Cedula");

        jLabel13.setText("Peso");

        jLabel14.setText("Altura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtObservaciones)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                            .addComponent(jButton5)
                            .addGap(179, 179, 179))
                        .addComponent(jSeparator1)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtAsegurado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumero)
                                    .addComponent(txtCorreo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNacimiento)
                                    .addComponent(txtSegundoApellido)
                                    .addComponent(txtPrimerApellido)
                                    .addComponent(txtCedula))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAlergias, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                        .addComponent(txtEnfermedades))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtAltura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtAsegurado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtEnfermedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
     // TODO add your handling code here:}
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        volverPantallaPrincipal();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (btnRegistrar.getText().equals("Nuevo")){
            
        btnRegistrar.getText().equals("Registrar");
        InicializarControles();
        ActivarControles(true);
        txtCedula.requestFocus();
        return;
        
        }
        int respuesta = JOptionPane.showConfirmDialog(null,"¿ Desea crear Cliente?","Confirmación", JOptionPane.YES_NO_OPTION);
        
        if(respuesta == JOptionPane.YES_OPTION){
        RegistrarPacientes();
        InicializarModeloTabla();
        CargarJTabla();
        btnRegistrar.setText("Nuevo");
        InicializarControles();
        ActivarControles(false);
                
        }else{
        
        
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jTblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblPacientesMouseClicked
        
        int filaSeleccionada = jTblPacientes.getSelectedRow();
        
        String Cedula = (String)modeloTablaPacientes.getValueAt(filaSeleccionada, 0);
        int posicion = -1;
        
        for(int i = 0; i < ListadoPacientes.size();i++) {
            
        if (ListadoPacientes.get(i).getCedula().equals(Cedula)){
        posicion = i;
        break;
        }
        
        }
        
        if(posicion >=0){
        Pacientes aux = ListadoPacientes.get(posicion);
        txtCedula.setText(aux.getCedula());
        txtNombre.setText(aux.getNacimiento());
        txtPrimerApellido.setText(aux.getPrimerApellido());
        txtSegundoApellido.setText(aux.getSegundoApellido());
        int Genero = aux.getGenero() == 'M'?0:1;
        cmbGenero.setSelectedIndex(Genero);
        txtEnfermedades.setText(aux.getEnfermedades());
        txtAlergias.setText(aux.getAlergias());
        txtObservaciones.setText(aux.getObservaciones());
        
 
        }
        ActivarControles(true);
    }//GEN-LAST:event_jTblPacientesMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        ActivarControles(true);
        ModificarPacientes();
        InicializarModeloTabla();
        CargarJTabla();
        ActivarControles(false);
        
    }//GEN-LAST:event_btnModificarActionPerformed
private void volverPantallaPrincipal(){
    try {
    new PantallaMain().setVisible(true);
    this.dispose();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegistroPacientes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTblPacientes;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtAsegurado;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEnfermedades;
    private javax.swing.JTextField txtNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtSegundoApellido;
    // End of variables declaration//GEN-END:variables

     
    }
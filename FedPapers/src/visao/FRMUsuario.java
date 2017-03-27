package visao;

import controle.AreaControl;
import controle.CargoControl;
import controle.LoginControl;
import controle.ControleSetor;
import controle.ManipularImagem;
import controle.TipoUsuarioControl;
import controle.UsuarioControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.AreaBEAN;
import modelo.CargoBEAN;
import modelo.LoginBEAN;
import modelo.SetorBEAN;
import modelo.TipoUsuarioBEAN;
import modelo.UsuarioBEAN;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mateu
 */
public class FRMUsuario extends javax.swing.JFrame {

    private DefaultTableModel dTable;
    ArrayList<AreaBEAN> pegaArea;
    ArrayList<SetorBEAN> pegaSetor;
    ArrayList<CargoBEAN> pegaCargo;
    ArrayList<TipoUsuarioBEAN> pegaTipoU;
    private TipoUsuarioControl t = new TipoUsuarioControl();
    private AreaControl a = new AreaControl();
    private ControleSetor ser = new ControleSetor();
    private CargoControl k = new CargoControl();
    private UsuarioControl uc = new UsuarioControl();
    private LoginControl lc = new LoginControl();
    private ArrayList<UsuarioBEAN> dados;
    private int cod;
    private String tipoUser;
    private String senha;

    public void setDadosUsuer(int cod, String s, String se) {
        this.cod = cod;
        ArrayList<UsuarioBEAN> dados = new ArrayList<UsuarioBEAN>();
        UsuarioControl uc = new UsuarioControl();
        dados = uc.localizar(cod);
        lbUser.setText(dados.get(0).getNome());
        ManipularImagem m = new ManipularImagem();
        m.exibiImagemLabel(dados.get(0).getFoto(), lbFotoUser);
        this.tipoUser = s;
        this.senha = se;
    }

    public FRMUsuario() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ArrayList<AreaBEAN> pegaArea = a.pegaArea();
        ArrayList<CargoBEAN> pegaCargo = k.listarALL();
        ArrayList<SetorBEAN> pegaSetor = ser.verTodosSetores();
        ArrayList<TipoUsuarioBEAN> pegaTipoU = t.pegaTipoU();
        UsuarioControl uc = new UsuarioControl();

        this.pegaArea = pegaArea;
        this.pegaSetor = pegaSetor;
        this.pegaCargo = pegaCargo;
        this.pegaTipoU = pegaTipoU;
        this.preencheCombo();
        dados = uc.listarALL();
        this.preencheTabela(dados);
     this.HORAS();
       Timer time = new Timer(1000, ativar);
        time.start();
    }

    private void HORAS() {

        hora = Calendar.getInstance();
        hh = hora.get(Calendar.HOUR_OF_DAY);
        mm = hora.get(Calendar.MINUTE);
        ss = hora.get(Calendar.SECOND);
        lbHoras.setText(formatar(hh) + ":" + formatar(mm) + ":" + formatar(ss));

    }

    private String formatar(int num) {
        formato = new DecimalFormat("00");
        return formato.format(num);
    }
    ActionListener ativar = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            HORAS();
        }
    });
    int hh, mm, ss, dd; //*
    Calendar hora; //*Hora
    DecimalFormat formato;


    private void preencheCombo() {
        for (AreaBEAN ar : pegaArea) {
            comboArea.addItem(ar.getNome());
        }
        for (SetorBEAN set : pegaSetor) {
            comboSetor.addItem(set.getNome());
        }
        for (CargoBEAN car : pegaCargo) {
            comboCargo.addItem(car.getNome());
        }
        for (TipoUsuarioBEAN tu : pegaTipoU) {
            comboTipoUser.addItem(tu.getNome());
        }
    }

    private void preencheTabela(ArrayList<UsuarioBEAN> dados) {
        dTable = criaTabela();
        //seta o nome das colunas da tabela
        dTable.addColumn("Código");
        dTable.addColumn("Nome");
        dTable.addColumn("Sobrenome");
        dTable.addColumn("CPF");
        dTable.addColumn("RG");
        dTable.addColumn("DataNascimento");
        dTable.addColumn("SIAPE");
        dTable.addColumn("Endereço Eletronico");
        dTable.addColumn("E-mail");
        dTable.addColumn("Telefone");
        dTable.addColumn("Celular");
        dTable.addColumn("Cargo");
        dTable.addColumn("Área");
        dTable.addColumn("Setor");
        dTable.addColumn("Tipo_Usuario");
        //pega os dados do ArrayList

        //cada célula do arrayList vira uma linha(row) na tabela
        for (UsuarioBEAN dado : dados) {
            dTable.addRow(new Object[]{dado.getCod(), dado.getNome(),
                dado.getSobreNome(), dado.getCPF(), dado.getRG(), dado.getData(), dado.getSiape(), dado.getEnderecoEletronico(), dado.getEmail(), dado.getTelefone(), dado.getCelular(), dado.getCargo().getNome(), dado.getArea().getNome(), dado.getSetor().getNome(), dado.getTipoUsu().getNome()});
        }
        //set o modelo da tabela
        tableUsuario.setModel(dTable);

    }

    private DefaultTableModel criaTabela() {
        //sempre que usar JTable é necessário ter um DefaulttableModel
        DefaultTableModel dTable = new DefaultTableModel() {
            //Define o tipo dos campos (coluna) na mesma ordem que as colunas foram criadas
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            //define se os campos podem ser editados na propria tabela
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        ;

        };
        //retorna o DefaultTableModel
    return dTable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        grupoArea = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel23 = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        lbFotoUser = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        lbHoras = new javax.swing.JLabel();
        btnLocalizar = new javax.swing.JButton();
        painelADMUsuario = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuario = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        comboTipoUser = new javax.swing.JComboBox<>();
        tfUsuario = new javax.swing.JTextField();
        pfSenha = new javax.swing.JPasswordField();
        jLabel84 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        tfDataNas = new javax.swing.JTextField();
        tfCPF = new javax.swing.JTextField();
        tfSiape = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        tfSobrenome = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfRG = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        lbAssinatura = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        tfCelular = new javax.swing.JTextField();
        tfEnderecoEletronico = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        comboSetor = new javax.swing.JComboBox<>();
        comboCargo = new javax.swing.JComboBox<>();
        jLabel96 = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox<>();
        lbHoras1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem20.setText("jMenuItem20");

        jMenuItem21.setText("jMenuItem21");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FedPapers 1.0");

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(20, 105, 20), 2));

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/add-user (1).png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarjButton6ActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/edit-user (1).png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarjButton7ActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/remove-user (1).png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirjButton8ActionPerformed(evt);
            }
        });

        btnVerTodos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerTodos.setText("Ver Todos...");
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });

        lbFotoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/INTERFACE GRAFICA/user (2).png"))); // NOI18N

        lbUser.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        lbUser.setForeground(new java.awt.Color(0, 102, 0));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/visao.icons/logoFed4.png"))); // NOI18N

        lbHoras.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        lbHoras.setForeground(new java.awt.Color(0, 153, 51));
        lbHoras.setText(".");

        btnLocalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/magnifier.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        painelADMUsuario.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        tableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sobrenome", "EnderecoEletronico", "Setor", "Cargo", "Telefone", "Celular", "E-mail", "SIAPE", "CPF", "RG", "Data Nascimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUsuario);
        if (tableUsuario.getColumnModel().getColumnCount() > 0) {
            tableUsuario.getColumnModel().getColumn(0).setResizable(false);
            tableUsuario.getColumnModel().getColumn(1).setResizable(false);
            tableUsuario.getColumnModel().getColumn(2).setResizable(false);
            tableUsuario.getColumnModel().getColumn(3).setResizable(false);
            tableUsuario.getColumnModel().getColumn(4).setResizable(false);
            tableUsuario.getColumnModel().getColumn(5).setResizable(false);
            tableUsuario.getColumnModel().getColumn(6).setResizable(false);
            tableUsuario.getColumnModel().getColumn(7).setResizable(false);
            tableUsuario.getColumnModel().getColumn(8).setResizable(false);
            tableUsuario.getColumnModel().getColumn(9).setResizable(false);
            tableUsuario.getColumnModel().getColumn(10).setResizable(false);
            tableUsuario.getColumnModel().getColumn(11).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        painelADMUsuario.addTab("All", jPanel2);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel83.setText("Usuario :");

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel85.setText("Tipo :");

        comboTipoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insira um tipo de usuário" }));
        comboTipoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoUserActionPerformed(evt);
            }
        });

        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuariojTextField11ActionPerformed(evt);
            }
        });

        pfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfSenhaActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel84.setText("Senha :");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel85)
                    .addComponent(jLabel83)
                    .addComponent(jLabel84))
                .addGap(23, 23, 23)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfUsuario)
                    .addComponent(comboTipoUser, 0, 395, Short.MAX_VALUE)
                    .addComponent(pfSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(comboTipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Usuários"));

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel86.setText("SIAPE :");

        s2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        s2.setText("Data Nascimento :");

        tfDataNas.setAutoscrolls(false);
        tfDataNas.setMinimumSize(new java.awt.Dimension(6, 23));
        tfDataNas.setPreferredSize(new java.awt.Dimension(6, 23));
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("####-##-##");
            tfDataNas = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        tfDataNas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataNasActionPerformed(evt);
            }
        });
        tfDataNas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDataNasKeyTyped(evt);
            }
        });

        tfCPF.setMinimumSize(new java.awt.Dimension(6, 23));
        tfCPF.setPreferredSize(new java.awt.Dimension(6, 23));
        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            tfCPF = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }
        tfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCPFActionPerformed(evt);
            }
        });
        tfCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCPFKeyTyped(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel82.setText("Sobrenome :");

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel81.setText("Nome :");

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        tfRG.setMinimumSize(new java.awt.Dimension(6, 23));
        tfRG.setPreferredSize(new java.awt.Dimension(6, 23));
        tfRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRGActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel87.setText("RG :");

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel93.setText("CPF :");

        jLabel2.setText("Código :");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel86)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSiape, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel81)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(s2)
                            .addComponent(jLabel87)
                            .addComponent(jLabel82))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDataNas, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(tfSobrenome)
                            .addComponent(tfRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(s2)
                            .addComponent(tfDataNas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSiape, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel88.setText("Celular :");

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel89.setText("Assinatura Digital :");

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel90.setText("Telefone :");

        lbAssinatura.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbAssinatura.setText("img");

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel92.setText("E-mail :");

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("(##)#####-####");
            tfCelular = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        tfCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCelularActionPerformed(evt);
            }
        });
        tfCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCelularKeyTyped(evt);
            }
        });

        tfEnderecoEletronico.setText("joao.silva.edu.br");
        tfEnderecoEletronico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfEnderecoEletronicoMouseClicked(evt);
            }
        });
        tfEnderecoEletronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEnderecoEletronicoActionPerformed(evt);
            }
        });
        tfEnderecoEletronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEnderecoEletronicoKeyTyped(evt);
            }
        });

        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("(##)#####-####");
            tfTelefone = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        tfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefoneActionPerformed(evt);
            }
        });
        tfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefoneKeyTyped(evt);
            }
        });

        jLabel1.setText("Endereço Eletronico :");

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfEnderecoEletronico, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel90)
                            .addComponent(jLabel92))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(tfEmail))))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel88)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCelular)
                    .addComponent(lbAssinatura, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88)
                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfEnderecoEletronico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel94.setText("Setor : ");

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel95.setText("Cargo : ");

        comboSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Setor..." }));
        comboSetor.setAutoscrolls(true);
        comboSetor.setPreferredSize(new java.awt.Dimension(105, 30));
        comboSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSetorActionPerformed(evt);
            }
        });

        comboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Cargo..." }));
        comboCargo.setAutoscrolls(true);
        comboCargo.setPreferredSize(new java.awt.Dimension(105, 30));
        comboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCargoActionPerformed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel96.setText("Área :");

        comboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a Area..." }));
        comboArea.setAutoscrolls(true);
        comboArea.setPreferredSize(new java.awt.Dimension(105, 30));
        comboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96)
                    .addComponent(jLabel94)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(comboSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        painelADMUsuario.addTab("Add", jPanel24);

        lbHoras1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        lbHoras1.setForeground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(jSeparator15)
                                .addComponent(jSeparator16)
                                .addComponent(btnLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(lbFotoUser)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(92, 92, 92)))))
                .addComponent(painelADMUsuario))
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbHoras1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel79)
                .addGap(10, 10, 10)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbFotoUser)
                .addGap(31, 31, 31)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbHoras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelADMUsuario))
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbHoras1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jMenu5.setText("Arquivo");

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem19.setText("Perfil");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setText("Modo Servidor");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem18);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/refresh-button.png"))); // NOI18N
        jMenuItem2.setText("Trocar Usuário");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/shutdown.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem22.setText("Voltar");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem22);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("Usuários");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/add-user.png"))); // NOI18N
        jMenuItem3.setText("Adicionar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/edit-user.png"))); // NOI18N
        jMenuItem4.setText("Editar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/remove-user.png"))); // NOI18N
        jMenuItem5.setText("Remover");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/magnifier.png"))); // NOI18N
        jMenuItem6.setText("Localizar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Ver Todos...");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cargos");

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/plus-black-symbol.png"))); // NOI18N
        jMenuItem8.setText("Adicionar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BOTÕES/edit.png"))); // NOI18N
        jMenuItem9.setText("Editar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/trash-can-with-cover-from-side-view.png"))); // NOI18N
        jMenuItem15.setText("Remover");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/magnifier.png"))); // NOI18N
        jMenuItem16.setText("Localizar");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setText("Ver Todos...");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem17);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Setores");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/plus-black-symbol.png"))); // NOI18N
        jMenuItem10.setText("Adicionar ");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BOTÕES/edit.png"))); // NOI18N
        jMenuItem11.setText("Editar ");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/trash-can-with-cover-from-side-view.png"))); // NOI18N
        jMenuItem12.setText("Excluir ");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/ICONES-FEDPAPERS/BARRA DE TAREFAS/magnifier.png"))); // NOI18N
        jMenuItem13.setText("Localizar");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setText("Ver Todos");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ajuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarjButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarjButton6ActionPerformed
        boolean aux = this.verificaCampos();
        if (aux == true) {
            boolean aux1 = this.verificaCamposLogin();
            if (aux1 == true) {
                UsuarioBEAN u = this.pegaCampos();
                if (u == null) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                } else {
                    LoginBEAN a = this.pegaLoguin();
                    LoginBEAN i = lc.adicionar(a);
                    if (i == null) {
                        JOptionPane.showMessageDialog(null, "Senha invalida!..tente nova senha ou login");
                    } else {
                        u.setLogin(i);
                        String m = uc.adicionar(u);
                        dados = uc.listarALL();
                        this.preencheTabela(dados);
                        if (m.equals("Cadastro feito com sucesso")) {
                            this.limparCampos();
                        }
                        JOptionPane.showMessageDialog(null, m);
                    }
                }
            }else{JOptionPane.showMessageDialog(null, "Preencha os campos de login!");}
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

        }
    }//GEN-LAST:event_btnAdicionarjButton6ActionPerformed

    private void btnEditarjButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarjButton7ActionPerformed
       if(lbCodigo.getText().equals("")){
           JOptionPane.showMessageDialog(null, "localize o usuario para editar");
       }else{
        boolean aux = this.verificaCampos();
        if (aux == true) {
            UsuarioBEAN u = this.pegaCampos();
            if (u == null) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                int opc = JOptionPane.showConfirmDialog(null, "Deseja editar o Usuario " + tfNome.getText());
                if (opc == 0) {
                    String m = uc.editarUser(u);
                    dados = uc.listarALL();
                    this.preencheTabela(dados);
                    JOptionPane.showMessageDialog(null, m);
                    if (m.equals("Edição feita com sucesso!")) {
                        this.limparCampos();
                    }
                } else {

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
       }
    }//GEN-LAST:event_btnEditarjButton7ActionPerformed

    private void btnExcluirjButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirjButton8ActionPerformed
        UsuarioBEAN usu = new UsuarioBEAN();
        if (!lbCodigo.getText().equals("")) {
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o Usuario de codigo" + lbCodigo.getText());
            if (i == 0) {
                ArrayList<UsuarioBEAN> aux = uc.localizar(Integer.parseInt(lbCodigo.getText()));
                for (UsuarioBEAN u : aux) {
                    usu.setCod(u.getCod());
                }
                uc.excluir(Integer.parseInt(lbCodigo.getText()), usu.getCod());
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Localize o Usuario!");
        }
        this.limparCampos();
        dados = uc.listarALL();
        this.preencheTabela(dados);
    }//GEN-LAST:event_btnExcluirjButton8ActionPerformed

    private void tfUsuariojTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuariojTextField11ActionPerformed
        btnAdicionarjButton6ActionPerformed(evt);
    }//GEN-LAST:event_tfUsuariojTextField11ActionPerformed

    private void tfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCPFActionPerformed

    private void tfCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCelularActionPerformed

    private void tfEnderecoEletronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEnderecoEletronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEnderecoEletronicoActionPerformed

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

    private void tfRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRGActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        boolean aux = this.verificaCampos();
        if (aux == true) {
            UsuarioBEAN u = this.pegaCampos();
            if (u == null) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                LoginBEAN a = this.pegaLoguin();
                LoginBEAN i = lc.adicionar(a);
                if (i == null) {
                    JOptionPane.showMessageDialog(null, "Senha invalida!..tente nova senha ou login");
                } else {
                    u.setLogin(i);
                    String m = uc.adicionar(u);
                    dados = uc.listarALL();
                    this.preencheTabela(dados);
                    JOptionPane.showMessageDialog(null, m);
                    this.limparCampos();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        UsuarioBEAN usu = new UsuarioBEAN();
        if (!lbCodigo.getText().equals("")) {
            int i = JOptionPane.showConfirmDialog(null, "Deseja excluir o Usuario de codigo" + lbCodigo.getText());
            if (i == 0) {
                ArrayList<UsuarioBEAN> aux = uc.localizar(Integer.parseInt(lbCodigo.getText()));
                for (UsuarioBEAN u : aux) {
                    usu.setCod(u.getCod());
                }
                uc.excluir(Integer.parseInt(lbCodigo.getText()), usu.getCod());
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Localize o Usuario!");
        }
        this.limparCampos();
        dados = uc.listarALL();
        this.preencheTabela(dados);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String i = JOptionPane.showInputDialog("Entere com o código do Usuario!");
        ArrayList<UsuarioBEAN> aux = uc.localizar(Integer.parseInt(i));
        if (aux != null) {
            this.preencheCampos(aux);
            this.preencheTabela(aux);
            painelADMUsuario.setSelectedIndex(1);
            tfUsuario.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario não encontrado!");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        FRMSetor s = new FRMSetor();
        s.setDadosUsuer(cod, tipoUser, senha);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void tfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefoneKeyTyped
        String caracteres = "0987654321()-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfTelefoneKeyTyped

    private void tfCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCPFKeyTyped
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCPFKeyTyped

    private void tfDataNasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDataNasKeyTyped
        String caracteres = "0987654321-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfDataNasKeyTyped

    private void tfCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCelularKeyTyped
        String caracteres = "0987654321()-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCelularKeyTyped

    private void tfEnderecoEletronicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEnderecoEletronicoKeyTyped
        String caracteres = "abcdefghijklmnopqrstuvwxyz.@0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfEnderecoEletronicoKeyTyped

    private void comboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreaActionPerformed

    }//GEN-LAST:event_comboAreaActionPerformed

    private void comboSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSetorActionPerformed

    }//GEN-LAST:event_comboSetorActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfDataNasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataNasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataNasActionPerformed

    private void tfEnderecoEletronicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfEnderecoEletronicoMouseClicked

    }//GEN-LAST:event_tfEnderecoEletronicoMouseClicked

    private void tableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsuarioMouseClicked
        if (tableUsuario.getRowCount() == 1) {
            ArrayList<UsuarioBEAN> aux = uc.localizar(Integer.parseInt((tableUsuario.getValueAt(0, 0) + "")));
            this.pegaSelecionado(aux);
        } else {
            dados = uc.listarALL();
            this.pegaSelecionado(dados);

            painelADMUsuario.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tableUsuarioMouseClicked

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        dados = uc.listarALL();
        this.preencheTabela(dados);
        painelADMUsuario.setSelectedIndex(0);
        this.limparCampos();
    }//GEN-LAST:event_btnVerTodosActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String i = JOptionPane.showInputDialog("Entere com o código do Usuario!");
        if (i.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo vasio");
        } else {
            ArrayList<UsuarioBEAN> aux = uc.localizar(Integer.parseInt(i));
            if (aux != null) {
                this.preencheCampos(aux);
                this.preencheTabela(aux);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario não encontrado!");
            }
        }
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        boolean aux = this.verificaCampos();
        if (aux == true) {
            UsuarioBEAN u = this.pegaCampos();
            if (u == null) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                int opc = JOptionPane.showConfirmDialog(null, "Deseja editar o Usuario " + tfNome.getText());
                if (opc == 0) {
                    String m = uc.editarUser(u);
                    dados = uc.listarALL();
                    this.preencheTabela(dados);
                    JOptionPane.showMessageDialog(null, m);
                    this.limparCampos();
                } else {

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        dados = uc.listarALL();
        this.preencheTabela(dados);
        painelADMUsuario.setSelectedIndex(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        FRMCargo c = new FRMCargo();
        c.setDadosUsuer(cod, tipoUser, senha);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        FRMCargo c = new FRMCargo();
        c.setDadosUsuer(cod, tipoUser, senha);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        FRMCargo c = new FRMCargo();
        c.setDadosUsuer(cod, tipoUser, senha);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        FRMCargo c = new FRMCargo();
        c.setDadosUsuer(cod, tipoUser, senha);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        FRMCargo c = new FRMCargo();
        c.setDadosUsuer(cod, tipoUser, senha);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        FRMSetor s = new FRMSetor();
        s.setDadosUsuer(cod, tipoUser, senha);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        FRMSetor s = new FRMSetor();
        s.setDadosUsuer(cod, tipoUser, senha);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        FRMSetor s = new FRMSetor();
        s.setDadosUsuer(cod, tipoUser, senha);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        FRMSetor s = new FRMSetor();
        s.setDadosUsuer(cod, tipoUser, senha);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        FRMPerfil p = new FRMPerfil();        
        p.setDadosUsuer(cod, tipoUser, senha);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        FRMPrincipalUsuario p = new FRMPrincipalUsuario();
        p.setDadosUsuer(cod +"", tipoUser, senha);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FRMLogin l = new FRMLogin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
        if (opc == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        FRMPrincipalAdministrador p = new FRMPrincipalAdministrador();
        p.setDadosUsuer(cod+"", tipoUser, senha);
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void comboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCargoActionPerformed

    }//GEN-LAST:event_comboCargoActionPerformed

    private void comboTipoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoUserActionPerformed

    }//GEN-LAST:event_comboTipoUserActionPerformed

    private void pfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfSenhaActionPerformed
        btnAdicionarjButton6ActionPerformed(evt);
    }//GEN-LAST:event_pfSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(FRMUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboArea;
    private javax.swing.JComboBox<String> comboCargo;
    private javax.swing.JComboBox<String> comboSetor;
    private javax.swing.JComboBox<String> comboTipoUser;
    private javax.swing.ButtonGroup grupoArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JLabel lbAssinatura;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbFotoUser;
    private javax.swing.JLabel lbHoras;
    private javax.swing.JLabel lbHoras1;
    private javax.swing.JLabel lbUser;
    private javax.swing.JTabbedPane painelADMUsuario;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JLabel s2;
    private javax.swing.JTable tableUsuario;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfCelular;
    private javax.swing.JTextField tfDataNas;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEnderecoEletronico;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfRG;
    private javax.swing.JTextField tfSiape;
    private javax.swing.JTextField tfSobrenome;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables

    private boolean verificaCampos() {
        if (!tfNome.getText().equals("") && !tfSobrenome.getText().equals("") && !tfDataNas.getText().equals("")
                && !tfCPF.getText().equals("") && !tfRG.getText().equals("") && !tfEmail.getText().equals("")
                && !tfSiape.getText().equals("") && !tfEnderecoEletronico.getText().equals("")
                && !tfCelular.getText().equals("") && !tfTelefone.getText().equals("")
                && !tfCelular.getText().equals("")
                && (comboCargo.getSelectedIndex() != 0) && (comboSetor.getSelectedIndex() != 0)) {
            return true;
        } else {
            return false;
        }

    }

    private boolean verificaCamposLogin() {
        if (!tfUsuario.getText().equals("") && !pfSenha.getText().equals("") && (comboTipoUser.getSelectedIndex() != 0)) {
            return true;
        } else {
            return false;
        }
    }

    private int retornaLinha() {
        int linha = tableUsuario.getSelectedRow();
        return linha;
    }

    private void pegaSelecionado(ArrayList<UsuarioBEAN> dados) {
        int linha = retornaLinha();
        tfNome.setText(dados.get(linha).getNome());
        tfCPF.setText(dados.get(linha).getCPF());
        tfSiape.setText(dados.get(linha).getSiape() + "");
        tfCelular.setText(dados.get(linha).getCelular());
        tfDataNas.setText(dados.get(linha).getData());
        tfEmail.setText(dados.get(linha).getEmail());
        tfRG.setText(dados.get(linha).getRG());
        tfEnderecoEletronico.setText(dados.get(linha).getEnderecoEletronico());
        tfNome.setText(dados.get(linha).getNome());
        tfSobrenome.setText(dados.get(linha).getSobreNome());
        tfTelefone.setText(dados.get(linha).getTelefone());
        comboArea.setSelectedItem(dados.get(linha).getArea().getNome());
        comboCargo.setSelectedItem(dados.get(linha).getCargo().getNome());
        comboSetor.setSelectedItem(dados.get(linha).getSetor().getNome());
        comboTipoUser.setSelectedItem(dados.get(linha).getTipoUsu().getNome());
        lbCodigo.setText(dados.get(linha).getCod() + "");
        tfEnderecoEletronico.setEditable(false);
        painelADMUsuario.setSelectedIndex(1);
        tfUsuario.setEditable(false);
        pfSenha.setEditable(false);
        tfCPF.setEditable(false);
        tfSiape.setEditable(false);

    }

    private void limparCampos() {
        tfCPF.setText("");
        tfCelular.setText("");
        tfSiape.setText("");
        tfDataNas.setText("");
        tfEmail.setText("");
        tfRG.setText("");
        tfEnderecoEletronico.setText("");
        tfNome.setText("");
        tfSobrenome.setText("");
        tfTelefone.setText("");
        tfUsuario.setText("");
        pfSenha.setText("");
        comboArea.setSelectedIndex(0);
        comboCargo.setSelectedIndex(0);
        comboSetor.setSelectedIndex(0);
        comboTipoUser.setSelectedIndex(0);
        lbCodigo.setText("");
        tfEnderecoEletronico.setEditable(true);
        tfUsuario.setEditable(true);
        pfSenha.setEditable(true);
        tfCPF.setEditable(true);
        tfSiape.setEditable(true);

    }

    private void preencheCampos(ArrayList<UsuarioBEAN> au) {
        for (UsuarioBEAN aux : au) {
            tfCPF.setText(aux.getCPF());
            tfCelular.setText(aux.getCelular());
            tfSiape.setText(aux.getSiape() + "");
            tfDataNas.setText(aux.getData());
            tfEmail.setText(aux.getEmail());
            tfRG.setText(aux.getRG());
            tfEnderecoEletronico.setText(aux.getEnderecoEletronico());
            tfNome.setText(aux.getNome());
            tfSobrenome.setText(aux.getSobreNome());
            tfTelefone.setText(aux.getTelefone());
            comboArea.setSelectedItem(aux.getArea().getNome());
            comboCargo.setSelectedItem(aux.getCargo().getNome());
            comboSetor.setSelectedItem(aux.getSetor().getNome());
            comboTipoUser.setSelectedItem(aux.getTipoUsu().getNome());
            lbCodigo.setText(aux.getCod() + "");
            painelADMUsuario.setSelectedIndex(1);
            tfUsuario.setEditable(false);
            pfSenha.setEditable(false);
            tfCPF.setEditable(false);
            tfSiape.setEditable(false);
            tfEnderecoEletronico.setEditable(false);
        }
    }

    private UsuarioBEAN pegaCampos() {
        UsuarioBEAN u = this.pegaCombos();
        LoginBEAN l = new LoginBEAN();
        if (u == null) {
            return null;
        } else {
            if (!lbCodigo.getText().equals("")) {
                u.setCod(Integer.parseInt(lbCodigo.getText()));
            }
            u.setCPF(tfCPF.getText());
            u.setCelular(tfCelular.getText());
            u.setTelefone(tfTelefone.getText());
            u.setData(tfDataNas.getText());
            u.setEnderecoEletronico(tfEnderecoEletronico.getText());
            u.setNome(tfNome.getText());
            u.setRG(tfRG.getText());
            u.setSobreNome(tfSobrenome.getText());
            u.setSiape(Integer.parseInt(tfSiape.getText()));
            u.setEmail(tfEmail.getText());
            l.setSenha(pfSenha.getText());
            l.setLogin(tfUsuario.getText());
            u.setLogin(l);

            return u;
        }
    }

    public UsuarioBEAN pegaCombos() {
        UsuarioBEAN u = new UsuarioBEAN();
        String area = (String) this.comboArea.getSelectedItem();
        String cargo = (String) this.comboCargo.getSelectedItem();
        String setor = (String) this.comboSetor.getSelectedItem();
        String tipoUser = (String) this.comboTipoUser.getSelectedItem();
        if (cargo.equals("Selecione o Cargo...") || setor.equals("Selecione o Setor...") || tipoUser.equals("Insira um tipo de usuário")) {

            return null;
        } else {

            if (!area.equals("Selecione a Area...")) {
                AreaBEAN ar = a.pegaCodigo(area);
                System.out.println(ar.getCod());
                u.setArea(ar);
            } else {
                u.setArea(null);
            }
            CargoBEAN car = k.pegaCodigo(cargo);
            u.setCargo(car);
            SetorBEAN s = ser.pegaCodigo(setor);
            u.setSetor(s);
            TipoUsuarioBEAN tipo = t.pegaCodigo(tipoUser);
            u.setTipoUsu(tipo);
        }
        return u;
    }

    private LoginBEAN pegaLoguin() {
        LoginBEAN l = new LoginBEAN();
        UsuarioBEAN a = new UsuarioBEAN();
        l.setLogin(tfUsuario.getText());
        l.setSenha(pfSenha.getText());
        return l;
    }

}

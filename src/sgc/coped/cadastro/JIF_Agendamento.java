package sgc.coped.cadastro;

import sgc.PrincipalView;
import sgc.bean.AgendaAula;
import sgc.bean.Calendario;
import sgc.bean.Cursos;
import sgc.bean.Evento;
import sgc.bean.Instrutores;
import sgc.bean.SalasAula;
import sgc.bean.UnidadeCurricular;
import sgc.coped.calendario.Bean_Calendario;
import sgc.coped.calendario.Bean_Dia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.RollbackException;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JIF_Agendamento extends javax.swing.JInternalFrame {

    Evento eventoSelecionado;
    ArrayList<JComponent> listComponents = new ArrayList<>();
    Bean_Calendario bean_calendario;
    
    public JIF_Agendamento() {
        initComponents();
        listComponents.add(jc_periodo);
        listComponents.add(txt_inicioAula);
        listComponents.add(txt_cargaHoraria);
        listComponents.add(jc_sala);
        listComponents.add(jc_unidade);
        listComponents.add(jc_instrutor);
        listComponents.add(bt_agendar);
        entityManager.getTransaction().begin();
        setVisible(true);
        criaCalendario();
        jc_instrutor.setSelectedIndex(-1);
    }

    /**
     *  Criação do JP_Calendario passando mês e ano atual
     *  
     */
    final void criaCalendario(){
        GregorianCalendar gc = new GregorianCalendar();
        bean_calendario = new Bean_Calendario(gc.get(GregorianCalendar.MONTH)+1, gc.get(GregorianCalendar.YEAR));
        jp_calendario.add(bean_calendario).setBounds(0, 0, 350, 250);
    }
    
    /**
     * * @param indice 
     *   Desbloqueia os próximos campos conforme o preenchimento
     */
    void desbloqueiaCampo(int indice){
        listComponents.get(indice-1).setEnabled(true);
        listComponents.get(indice-1).requestFocus();
        if(listComponents.get(indice-1) instanceof JComboBox)
            ((JComboBox)listComponents.get(indice-1)).setSelectedIndex(-1);
        for(int i = indice; i<listComponents.size(); i++){
            listComponents.get(i).setEnabled(false);
            if(listComponents.get(i) instanceof JComboBox)
                ((JComboBox)listComponents.get(i)).setSelectedIndex(-1);
        }
    }
    
    /**
     *  verifica se evento já existe para cadastro ou alteração
     * @return Evento
     */
    Evento verificaEventoExistente(){
        try{
            int i = Integer.parseInt(txt_numeroEvento.getText());
            for(Evento e:listEvento)
                if(e.getNumero()==i)
                    return e;
        }catch(Exception e){}
        return null;
    }
    
    void salvar(){
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            JOptionPane.showMessageDialog(null, "Agendamento salvo com sucesso!");
        } catch (RollbackException rex) {
            entityManager.getTransaction().begin();
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        }
    }
    
    /**
     *  Filtra por periodo E sala ou instrutor ocupados
     *  busca entre os filtrados suas datas e as destaca
     */
    void filtraDados(){
        bean_calendario.liberaDias();
        ArrayList<Calendario> list = new ArrayList<>();
        for(Calendario c:listCalendarioFull)
            if(
                   (c.getPeriodo() == jc_periodo.getSelectedIndex()+1)
                && ((c.getSalasAulaId() == listSala.get(jc_sala.getSelectedIndex()))
                || (jc_instrutor.getSelectedIndex()!=-1 
                && (c.getAgendaAulaId().getInstrutoresId() == listInstrutor.get(jc_instrutor.getSelectedIndex())))))
                        list.add(c);
            
        GregorianCalendar gc = new GregorianCalendar();
        GregorianCalendar gc1 = new GregorianCalendar();
        for(Calendario c:list){
            gc1.setTime(c.getDiaAula());
            if(gc.get(GregorianCalendar.MONTH)==gc1.get(GregorianCalendar.MONTH))
                bean_calendario.diaOcupado(gc1.get(GregorianCalendar.DAY_OF_MONTH));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AgendaCopedPU").createEntityManager();
        queryEvento = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Evento e");
        queryCursos = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Cursos c");
        querySala = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM SalasAula e");
        queryUnidade = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM UnidadeCurricular e");
        queryInstrutor = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Instrutores e");
        queryCalendario = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Calendario c\n");
        listEvento = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : queryEvento.getResultList();
        listCursos = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : queryCursos.getResultList();
        listSala = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : querySala.getResultList();
        listUnidade = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : queryUnidade.getResultList();
        listInstrutor = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : queryInstrutor.getResultList();
        listCalendarioFull = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : queryCalendario.getResultList();
        listCalendarioAgendado = new ArrayList<>();
        jd_evento = new javax.swing.JDialog();
        txt_numeroEvento = new javax.swing.JTextField();
        cb_curso = new javax.swing.JComboBox();
        btn_carregar = new javax.swing.JButton();
        jl_eventoStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_eventoBloq = new javax.swing.JTextField();
        txt_cargaHoraria = new javax.swing.JFormattedTextField();
        txt_inicioAula = new javax.swing.JFormattedTextField();
        jc_instrutor = new javax.swing.JComboBox();
        jc_periodo = new javax.swing.JComboBox();
        jc_unidade = new javax.swing.JComboBox();
        jc_sala = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jp_calendario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        bt_salvar = new javax.swing.JButton();
        bt_agendar = new javax.swing.JButton();

        jd_evento.setTitle("Cadastro de Evento");
        jd_evento.setAlwaysOnTop(true);
        jd_evento.setMinimumSize(new java.awt.Dimension(350, 105));
        jd_evento.setModal(true);
        jd_evento.setResizable(false);

        txt_numeroEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_numeroEventoKeyReleased(evt);
            }
        });

        cb_curso.setEnabled(false);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCursos, cb_curso);
        bindingGroup.addBinding(jComboBoxBinding);

        btn_carregar.setText("Carregar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, txt_numeroEvento, org.jdesktop.beansbinding.ELProperty.create("${text!=''}"), btn_carregar, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btn_carregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carregarActionPerformed(evt);
            }
        });

        jl_eventoStatus.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jd_eventoLayout = new javax.swing.GroupLayout(jd_evento.getContentPane());
        jd_evento.getContentPane().setLayout(jd_eventoLayout);
        jd_eventoLayout.setHorizontalGroup(
            jd_eventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_eventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_eventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jd_eventoLayout.createSequentialGroup()
                        .addComponent(txt_numeroEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jd_eventoLayout.createSequentialGroup()
                        .addComponent(jl_eventoStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_carregar)))
                .addContainerGap())
        );
        jd_eventoLayout.setVerticalGroup(
            jd_eventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_eventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_eventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_numeroEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jd_eventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_carregar)
                    .addComponent(jl_eventoStatus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Agendamento");
        setPreferredSize(new java.awt.Dimension(800, 400));

        jLabel2.setText("Instrutor");

        jLabel3.setText("Unidade");

        jLabel7.setText("Período");

        jLabel4.setText("Sala");

        jLabel5.setText("Hora de ínicio");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/cancelar.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel6.setText("Carga Horária");

        jLabel1.setText("Evento");

        txt_eventoBloq.setEditable(false);
        txt_eventoBloq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_eventoBloqMouseClicked(evt);
            }
        });

        txt_cargaHoraria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txt_cargaHoraria.setEnabled(false);
        txt_cargaHoraria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cargaHorariaFocusLost(evt);
            }
        });

        try {
            txt_inicioAula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_inicioAula.setEnabled(false);
        txt_inicioAula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_inicioAulaFocusLost(evt);
            }
        });
        txt_inicioAula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_inicioAulaKeyReleased(evt);
            }
        });

        jc_instrutor.setEnabled(false);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listInstrutor, jc_instrutor);
        bindingGroup.addBinding(jComboBoxBinding);

        jc_instrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_instrutorActionPerformed(evt);
            }
        });

        jc_periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manhã", "Tarde", "Noite", "Integral" }));
        jc_periodo.setSelectedIndex(-1);
        jc_periodo.setEnabled(false);
        jc_periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_periodoActionPerformed(evt);
            }
        });

        jc_unidade.setEnabled(false);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedItem.unidadeCurricularCollection}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cb_curso, eLProperty, jc_unidade);
        bindingGroup.addBinding(jComboBoxBinding);

        jc_unidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_unidadeActionPerformed(evt);
            }
        });

        jc_sala.setEnabled(false);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listSala, jc_sala);
        bindingGroup.addBinding(jComboBoxBinding);

        jc_sala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_salaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_eventoBloq)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jc_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_inicioAula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jc_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jc_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jc_instrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_cargaHoraria, txt_inicioAula});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txt_eventoBloq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_inicioAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jc_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(txt_cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jc_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jc_sala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jc_instrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_cargaHoraria, txt_eventoBloq, txt_inicioAula});

        jp_calendario.setBackground(new java.awt.Color(255, 255, 255));
        jp_calendario.setMaximumSize(new java.awt.Dimension(350, 250));
        jp_calendario.setMinimumSize(new java.awt.Dimension(350, 250));
        jp_calendario.setPreferredSize(new java.awt.Dimension(350, 250));

        javax.swing.GroupLayout jp_calendarioLayout = new javax.swing.GroupLayout(jp_calendario);
        jp_calendario.setLayout(jp_calendarioLayout);
        jp_calendarioLayout.setHorizontalGroup(
            jp_calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jp_calendarioLayout.setVerticalGroup(
            jp_calendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias de Aulas"));

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCalendarioAgendado, jList1, "teste");
        bindingGroup.addBinding(jListBinding);

        jScrollPane1.setViewportView(jList1);

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/salvar.png"))); // NOI18N
        bt_salvar.setText("Salvar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_agendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/Agendamento 24x24.png"))); // NOI18N
        bt_agendar.setText("Agendar");
        bt_agendar.setEnabled(false);
        bt_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_agendar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_salvar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(bt_salvar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bt_agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jp_calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_eventoBloqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_eventoBloqMouseClicked
        jd_evento.setLocation(350, 240);
        jd_evento.setVisible(true);
        txt_numeroEvento.setText("");
        jd_evento.revalidate();
    }//GEN-LAST:event_txt_eventoBloqMouseClicked

    private void txt_numeroEventoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numeroEventoKeyReleased
        if(txt_numeroEvento.getText().isEmpty()){
            jl_eventoStatus.setText("");
            cb_curso.setEnabled(false);
            cb_curso.setSelectedIndex(-1);
        }else{
            Evento e = verificaEventoExistente();
            if(e==null){
                jl_eventoStatus.setText("Criação de Evento");
                cb_curso.setEnabled(true);
                cb_curso.setSelectedIndex(-1);
            }else{
                jl_eventoStatus.setText("Alteração de Evento");
                cb_curso.setEnabled(false);
                cb_curso.setSelectedItem(e.getCursosId());
            }
        }
    }//GEN-LAST:event_txt_numeroEventoKeyReleased

    private void btn_carregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carregarActionPerformed
        Evento e = verificaEventoExistente();
        if(e==null){
            Evento evento = new Evento();
            evento.setNumero(Integer.parseInt(txt_numeroEvento.getText()));
            evento.setCursosId((Cursos) cb_curso.getSelectedItem());
            listEvento.add(evento);
            eventoSelecionado = evento;
        }else
            eventoSelecionado = e;
        if(cb_curso.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar!","Atenção",JOptionPane.WARNING_MESSAGE);
            return;
        }
  
        entityManager.persist(eventoSelecionado);
        jd_evento.setVisible(false);
        txt_eventoBloq.setText(eventoSelecionado.getNumero()+"");
        desbloqueiaCampo(1);
        bean_calendario.liberaDias();
    }//GEN-LAST:event_btn_carregarActionPerformed

    private void jc_periodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_periodoActionPerformed
        if(jc_periodo.getSelectedIndex()!=-1 && evt.getModifiers()!=0){
            desbloqueiaCampo(2);
            bean_calendario.liberaDias();
        }
    }//GEN-LAST:event_jc_periodoActionPerformed

    private void txt_inicioAulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_inicioAulaFocusLost
        if(!txt_inicioAula.getText().isEmpty()){
            desbloqueiaCampo(3);
            bean_calendario.liberaDias();
        }
    }//GEN-LAST:event_txt_inicioAulaFocusLost

    private void txt_cargaHorariaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cargaHorariaFocusLost
        if(!txt_cargaHoraria.getText().isEmpty()){
            desbloqueiaCampo(4);
            bean_calendario.liberaDias();
        }
    }//GEN-LAST:event_txt_cargaHorariaFocusLost

    private void jc_salaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_salaActionPerformed
        if(jc_sala.getSelectedIndex()!=-1 && evt.getModifiers()!=0){
            desbloqueiaCampo(5);
            filtraDados();
        }
    }//GEN-LAST:event_jc_salaActionPerformed

    private void jc_unidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_unidadeActionPerformed
        if(jc_unidade.getSelectedIndex()!=-1 && evt.getModifiers()!=0){
            desbloqueiaCampo(6);
            filtraDados();
        }
    }//GEN-LAST:event_jc_unidadeActionPerformed

    private void jc_instrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_instrutorActionPerformed
        if(jc_instrutor.getSelectedIndex()!=-1 && evt.getModifiers()!=0){
            desbloqueiaCampo(7);
            filtraDados();
        }
    }//GEN-LAST:event_jc_instrutorActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        for (JComponent lc : listComponents) {
            lc.setEnabled(false);
            if (lc instanceof JComboBox) 
                ((JComboBox) lc).setSelectedIndex(-1);
            else
                if (lc instanceof JTextField) 
                    ((JTextField) lc).setText("");
        }
        listCursos.clear();
        listInstrutor.clear();
        listSala.clear();
        listUnidade.clear();
        listCursos.addAll(queryCursos.getResultList());
        listInstrutor.addAll(queryInstrutor.getResultList());
        listUnidade.addAll(queryUnidade.getResultList());
        listSala.addAll(querySala.getResultList());
        bindingGroup.unbind();
        bindingGroup.bind();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void bt_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agendarActionPerformed
        ArrayList<Bean_Dia> listDiasSelecionados = bean_calendario.getDiasSelecionados();
        if(listDiasSelecionados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione os dias para prosseguir!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        AgendaAula agendaAula = new AgendaAula();
        agendaAula.setInstrutoresId(listInstrutor.get(jc_instrutor.getSelectedIndex()));
        agendaAula.setUnidadeCurricularId(listUnidade.get(jc_unidade.getSelectedIndex()));
        agendaAula.setEventoId(eventoSelecionado);
        entityManager.persist(agendaAula);
        
        GregorianCalendar gc = new GregorianCalendar();
        
        for(Bean_Dia dia:listDiasSelecionados){
            gc.set(bean_calendario.getAno(), bean_calendario.getMes(), dia.getId());
            Calendario calendario = new Calendario();
            calendario.setAgendaAulaId(agendaAula);
            calendario.setSalasAulaId(listSala.get(jc_sala.getSelectedIndex()));
            calendario.setDiaAula(gc.getTime());
            calendario.setHoraAula(Integer.parseInt(txt_cargaHoraria.getText()));
            try {
                SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
                calendario.setHoraInicio(sf.parse(txt_inicioAula.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
            }
            calendario.setPeriodo(jc_periodo.getSelectedIndex()+1);
            entityManager.persist(calendario);
            listCalendarioAgendado.add(calendario);
            listCalendarioFull.add(calendario);
            bindingGroup.getBinding("teste").unbind();
            bindingGroup.getBinding("teste").bind();
        }
    }//GEN-LAST:event_bt_agendarActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        salvar();
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void txt_inicioAulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inicioAulaKeyReleased
        System.out.println(txt_inicioAula.isEditValid());
    }//GEN-LAST:event_txt_inicioAulaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_agendar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton btn_carregar;
    private javax.swing.JComboBox cb_curso;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jc_instrutor;
    private javax.swing.JComboBox jc_periodo;
    private javax.swing.JComboBox jc_sala;
    private javax.swing.JComboBox jc_unidade;
    private javax.swing.JDialog jd_evento;
    private javax.swing.JLabel jl_eventoStatus;
    private javax.swing.JPanel jp_calendario;
    private java.util.List<Calendario> listCalendarioAgendado;
    private java.util.List<Calendario> listCalendarioFull;
    private java.util.List<Cursos> listCursos;
    private java.util.List<Evento> listEvento;
    private java.util.List<Instrutores> listInstrutor;
    private java.util.List<SalasAula> listSala;
    private java.util.List<UnidadeCurricular> listUnidade;
    private javax.persistence.Query queryCalendario;
    private javax.persistence.Query queryCursos;
    private javax.persistence.Query queryEvento;
    private javax.persistence.Query queryInstrutor;
    private javax.persistence.Query querySala;
    private javax.persistence.Query queryUnidade;
    private javax.swing.JFormattedTextField txt_cargaHoraria;
    private javax.swing.JTextField txt_eventoBloq;
    private javax.swing.JFormattedTextField txt_inicioAula;
    private javax.swing.JTextField txt_numeroEvento;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
package agendacoped.cadastro;

import agendacoped.PrincipalView;
import agendacoped.bean.Cursos;
import agendacoped.bean.UnidadeCurricular;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class JIF_Curso_UnidadeCurricular extends javax.swing.JInternalFrame {

    Cursos cursoSelecionado;
    
    public JIF_Curso_UnidadeCurricular() {
        initComponents();
        entityManager.getTransaction().begin();
        setVisible(true);
    }

    void busca(String txt){
        TableRowSorter sorter = new TableRowSorter(masterTable.getModel());
        if(!txt.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);
                sb.append('[').append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append(']');
            }
            sorter.setRowFilter(RowFilter.regexFilter(".*"+sb+".*"));
            masterTable.setRowSorter(sorter);
        }else
            masterTable.setRowSorter(sorter);
    }
    
    void atualiza(){
        busca("");
        txt_busca.setText("");
        bindingGroup.unbind();
        bindingGroup.bind();
    }
    
    void calculaCargaCurso(){
        int carga = 0;
        for(UnidadeCurricular c:listUnidade)
            carga += c.getCargaH();
        jl_cargaCurso.setText(""+carga);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AgendaCopedPU").createEntityManager();
        queryCurso = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Cursos a");
        queryArea = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Areas a");
        listCursos = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryCurso.getResultList());
        listArea = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryArea.getResultList());
        listUnidade = new ArrayList<>();
        JIF_UnidadeCurricular = new javax.swing.JInternalFrame();
        cargaHLabel = new javax.swing.JLabel();
        nomeLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jl_nomeCurso = new javax.swing.JLabel();
        jl_cargaCurso = new javax.swing.JLabel();
        btn_excluirUnidade = new javax.swing.JButton();
        btn_concluir = new javax.swing.JButton();
        btn_novaUnidade = new javax.swing.JButton();
        masterScrollPane2 = new javax.swing.JScrollPane();
        masterTableUnidade = new javax.swing.JTable();
        txt_nomeUnidade = new javax.swing.JTextField();
        txt_cargaHoraria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        modalidadeLabel = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        combo_area = new javax.swing.JComboBox();
        txt_nome = new javax.swing.JTextField();
        txt_busca = new javax.swing.JTextField();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        label_cargaTotal = new javax.swing.JLabel();
        bt_cadastrarUnidade = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        JIF_UnidadeCurricular.setTitle("Cadastro de Unidades");
        JIF_UnidadeCurricular.setVisible(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), JIF_UnidadeCurricular, org.jdesktop.beansbinding.BeanProperty.create("preferredSize"));
        bindingGroup.addBinding(binding);

        cargaHLabel.setText("Carga Horária");

        nomeLabel1.setText("Nome");

        jLabel5.setText("Curso");

        jLabel6.setText("Carga Horária Total do Curso");

        jl_nomeCurso.setText("NOME DO CURSO");

        jl_cargaCurso.setText("HORAS");

        btn_excluirUnidade.setText("Excluir");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableUnidade, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), btn_excluirUnidade, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btn_excluirUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirUnidadeActionPerformed(evt);
            }
        });

        btn_concluir.setText("Concluir");
        btn_concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_concluirActionPerformed(evt);
            }
        });

        btn_novaUnidade.setText("Novo");
        btn_novaUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novaUnidadeActionPerformed(evt);
            }
        });

        masterTableUnidade.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listUnidade, masterTableUnidade);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cargaH}"));
        columnBinding.setColumnName("Carga Horária");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane2.setViewportView(masterTableUnidade);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableUnidade, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txt_nomeUnidade, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableUnidade, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), txt_nomeUnidade, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableUnidade, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cargaH}"), txt_cargaHoraria, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableUnidade, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), txt_cargaHoraria, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        txt_cargaHoraria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cargaHorariaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout JIF_UnidadeCurricularLayout = new javax.swing.GroupLayout(JIF_UnidadeCurricular.getContentPane());
        JIF_UnidadeCurricular.getContentPane().setLayout(JIF_UnidadeCurricularLayout);
        JIF_UnidadeCurricularLayout.setHorizontalGroup(
            JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JIF_UnidadeCurricularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JIF_UnidadeCurricularLayout.createSequentialGroup()
                        .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JIF_UnidadeCurricularLayout.createSequentialGroup()
                                .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JIF_UnidadeCurricularLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jl_nomeCurso))
                                    .addGroup(JIF_UnidadeCurricularLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jl_cargaCurso)))
                                .addGap(18, 148, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JIF_UnidadeCurricularLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_novaUnidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_excluirUnidade)
                                .addGap(10, 10, 10)))
                        .addComponent(btn_concluir))
                    .addComponent(masterScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGroup(JIF_UnidadeCurricularLayout.createSequentialGroup()
                        .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JIF_UnidadeCurricularLayout.createSequentialGroup()
                                .addComponent(nomeLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(JIF_UnidadeCurricularLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(txt_nomeUnidade)))
                        .addGap(18, 18, 18)
                        .addComponent(cargaHLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JIF_UnidadeCurricularLayout.setVerticalGroup(
            JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JIF_UnidadeCurricularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jl_nomeCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_cargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargaHLabel)
                    .addComponent(txt_nomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jl_cargaCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JIF_UnidadeCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_concluir, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_excluirUnidade, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_novaUnidade, javax.swing.GroupLayout.Alignment.CENTER))
                .addContainerGap())
        );

        setClosable(true);
        setTitle("Cadastro de Cursos");

        jLabel2.setText("limpar");

        jLabel1.setText("Buscar");

        jLabel4.setText("Carga Horária");

        jLabel3.setText("Área");

        nomeLabel.setText("Nome");

        modalidadeLabel.setText("Modalidade");

        masterTable.getTableHeader().setReorderingAllowed(false);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCursos, masterTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${modalidade}"));
        columnBinding.setColumnName("Modalidade");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${areasId.nome}"));
        columnBinding.setColumnName("Área");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listArea, combo_area);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.areasId}"), combo_area, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), combo_area, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txt_nome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), txt_nome, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        txt_busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscaKeyReleased(evt);
            }
        });

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_salvar.setText("Salvar");
        btn_salvar.setEnabled(false);
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), btn_excluir, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cargaH}"), label_cargaTotal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        bt_cadastrarUnidade.setText("Cadastrar Unidades Curriculares");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), bt_cadastrarUnidade, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        bt_cadastrarUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarUnidadeActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aperfeiçoamento", "Aprendizagem Industrial", "Habilitação Técnica", "Iniciação", "Qualificação Básica" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.modalidade}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_cargaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_busca)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(nomeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_nome))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(modalidadeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_area, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_cadastrarUnidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_novo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_excluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_salvar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modalidadeLabel)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel3)
                        .addComponent(combo_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bt_cadastrarUnidade)
                    .addComponent(label_cargaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_excluir, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_novo, javax.swing.GroupLayout.Alignment.CENTER))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        busca("");
        agendacoped.bean.Cursos a = new agendacoped.bean.Cursos();
        entityManager.persist(a);
        listCursos.add(a);
        int row = listCursos.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        txt_nome.requestFocus();
        btn_novo.setEnabled(false);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        int[] selected = masterTable.getSelectedRows();
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir "+((selected.length==1)?"este registro?":"estes registros?"))==0){
            List<agendacoped.bean.Cursos> toRemove = new ArrayList<>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                agendacoped.bean.Cursos a = listCursos.get(masterTable.convertRowIndexToModel(selected[idx]));
                toRemove.add(a);
                entityManager.remove(a);
            }
            listCursos.removeAll(toRemove);
            btn_salvarActionPerformed(null);
        }
        btn_novo.setEnabled(true);
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            masterTable.clearSelection();
        } catch (RollbackException rex) {
            entityManager.getTransaction().begin();
            List<agendacoped.bean.Cursos> merged = new ArrayList<>(listCursos.size());
            for (agendacoped.bean.Cursos a : listCursos) {
                merged.add(entityManager.merge(a));
            }
            listCursos.clear();
            listCursos.addAll(merged);
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        }
        btn_novo.setEnabled(true);
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void txt_buscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscaKeyReleased
        busca(txt_busca.getText());
    }//GEN-LAST:event_txt_buscaKeyReleased

    private void bt_cadastrarUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarUnidadeActionPerformed
        cursoSelecionado = listCursos.get(masterTable.getSelectedRow());
        jl_nomeCurso.setText(cursoSelecionado.getNome());
        listUnidade.addAll(cursoSelecionado.getUnidadeCurricularCollection());
        calculaCargaCurso();
        atualiza();
        PrincipalView._this.addPanelExibicao(JIF_UnidadeCurricular, false);
        this.setVisible(false);
    }//GEN-LAST:event_bt_cadastrarUnidadeActionPerformed

    private void btn_novaUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novaUnidadeActionPerformed
        agendacoped.bean.UnidadeCurricular a = new agendacoped.bean.UnidadeCurricular();
        listUnidade.add(a);
        int row = listUnidade.size() - 1;
        masterTableUnidade.setRowSelectionInterval(row, row);
        masterTableUnidade.scrollRectToVisible(masterTableUnidade.getCellRect(row, 0, true));
        txt_nomeUnidade.requestFocus();
    }//GEN-LAST:event_btn_novaUnidadeActionPerformed

    private void btn_excluirUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirUnidadeActionPerformed
        int[] selected = masterTableUnidade.getSelectedRows();
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir "+((selected.length==1)?"este registro?":"estes registros?"))==0){
            List<agendacoped.bean.UnidadeCurricular> toRemove = new ArrayList<>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                agendacoped.bean.UnidadeCurricular a = listUnidade.get(masterTableUnidade.convertRowIndexToModel(selected[idx]));
                toRemove.add(a);
            }
            listUnidade.removeAll(toRemove);
        }
        atualiza();
    }//GEN-LAST:event_btn_excluirUnidadeActionPerformed

    private void btn_concluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_concluirActionPerformed
        
    }//GEN-LAST:event_btn_concluirActionPerformed

    private void txt_cargaHorariaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cargaHorariaFocusLost
        calculaCargaCurso();
    }//GEN-LAST:event_txt_cargaHorariaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame JIF_UnidadeCurricular;
    private javax.swing.JButton bt_cadastrarUnidade;
    private javax.swing.JButton btn_concluir;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_excluirUnidade;
    private javax.swing.JButton btn_novaUnidade;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel cargaHLabel;
    private javax.swing.JComboBox combo_area;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jl_cargaCurso;
    private javax.swing.JLabel jl_nomeCurso;
    private javax.swing.JLabel label_cargaTotal;
    private java.util.List<agendacoped.bean.Areas> listArea;
    private java.util.List<agendacoped.bean.Cursos> listCursos;
    private java.util.List<UnidadeCurricular> listUnidade;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JScrollPane masterScrollPane2;
    private javax.swing.JTable masterTable;
    private javax.swing.JTable masterTableUnidade;
    private javax.swing.JLabel modalidadeLabel;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel nomeLabel1;
    private javax.persistence.Query queryArea;
    private javax.persistence.Query queryCurso;
    private javax.swing.JTextField txt_busca;
    private javax.swing.JTextField txt_cargaHoraria;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_nomeUnidade;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
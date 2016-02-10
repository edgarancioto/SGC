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

public class JIF_Curso extends javax.swing.JInternalFrame {

    public JIF_Curso() {
        initComponents();
        entityManager.getTransaction().begin();
        setVisible(true);
    }

    void busca(String txt){
        TableRowSorter sorter = new TableRowSorter(masterTableCursos.getModel());
        if(!txt.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);
                sb.append('[').append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append(']');
            }
            sorter.setRowFilter(RowFilter.regexFilter(".*"+sb+".*"));
            masterTableCursos.setRowSorter(sorter);
        }else
            masterTableCursos.setRowSorter(sorter);
    }
    
    void atualiza(){
        busca("");
        txt_busca.setText("");
        bindingGroup.unbind();
        bindingGroup.bind();
    }
    
    boolean validaDados(){
        if(txt_nome.getText().isEmpty() || cb_modalidade.getSelectedItem()==null ||
                cb_area.getSelectedItem()==null || txt_cargaTotal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de continuar!","Atenção",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
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
        stringVerifier1 = new agendacoped.verifier.StringVerifier();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        modalidadeLabel = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTableCursos = new javax.swing.JTable();
        cb_area = new javax.swing.JComboBox();
        txt_nome = new javax.swing.JTextField();
        txt_busca = new javax.swing.JTextField();
        txt_cargaTotal = new javax.swing.JFormattedTextField();
        btn_novo = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        bt_cadastrarUnidade = new javax.swing.JButton();
        cb_modalidade = new javax.swing.JComboBox();
        btn_moduloUnico = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Cadastro de Cursos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/Agendamento 16x16.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/cancelar.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setText("Buscar");

        jLabel4.setText("Carga Horária");

        jLabel3.setText("Área");

        nomeLabel.setText("Nome");

        modalidadeLabel.setText("Modalidade");

        masterTableCursos.getTableHeader().setReorderingAllowed(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCursos, masterTableCursos);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTableCursos);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listArea, cb_area);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.areasId}"), cb_area, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), cb_area, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        txt_nome.setInputVerifier(stringVerifier1);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txt_nome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), txt_nome, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        txt_busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscaKeyReleased(evt);
            }
        });

        txt_cargaTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), txt_cargaTotal, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.cargaH}"), txt_cargaTotal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/novo.png"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/excluir.png"))); // NOI18N
        btn_excluir.setText("Excluir");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), btn_excluir, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        bt_cadastrarUnidade.setText("Cadastrar Unidades Curriculares");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), bt_cadastrarUnidade, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        bt_cadastrarUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarUnidadeActionPerformed(evt);
            }
        });

        cb_modalidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_modalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aperfeiçoamento", "Aprendizagem Industrial", "Habilitação Técnica", "Iniciação", "Qualificação Básica" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.modalidade}"), cb_modalidade, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTableCursos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement!=null}"), cb_modalidade, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btn_moduloUnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendacoped/icon/salvar.png"))); // NOI18N
        btn_moduloUnico.setText("Módulo Único");
        btn_moduloUnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moduloUnicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masterScrollPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_busca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modalidadeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_area, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cargaTotal)
                                .addGap(18, 18, 18)
                                .addComponent(bt_cadastrarUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nomeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_novo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_excluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_moduloUnico)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_excluir, btn_novo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txt_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modalidadeLabel)
                        .addComponent(cb_modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel3)
                        .addComponent(cb_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bt_cadastrarUnidade)
                    .addComponent(jLabel4)
                    .addComponent(txt_cargaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_moduloUnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_novo))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_excluir, btn_moduloUnico});

        cb_area.getAccessibleContext().setAccessibleDescription("Área");
        txt_nome.getAccessibleContext().setAccessibleDescription("Nome");
        cb_modalidade.getAccessibleContext().setAccessibleDescription("Modalidade");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        busca("");
        agendacoped.bean.Cursos a = new agendacoped.bean.Cursos();
        listCursos.add(a);
        int row = listCursos.size() - 1;
        masterTableCursos.setRowSelectionInterval(row, row);
        masterTableCursos.scrollRectToVisible(masterTableCursos.getCellRect(row, 0, true));
        txt_nome.requestFocus();
        btn_novo.setEnabled(false);
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        int[] selected = masterTableCursos.getSelectedRows();
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir "+((selected.length==1)?"este registro?":"estes registros?"))==0){
            List<agendacoped.bean.Cursos> toRemove = new ArrayList<>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                agendacoped.bean.Cursos a = listCursos.get(masterTableCursos.convertRowIndexToModel(selected[idx]));
                toRemove.add(a);
                entityManager.remove(a);
            }
            listCursos.removeAll(toRemove);
            
            try {
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
                masterTableCursos.clearSelection();
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
        }
        btn_novo.setEnabled(true);
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void txt_buscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscaKeyReleased
        busca(txt_busca.getText());
    }//GEN-LAST:event_txt_buscaKeyReleased

    private void bt_cadastrarUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarUnidadeActionPerformed
        if(validaDados())
            PrincipalView._this.addPanelExibicao(new JIF_UnidadeCurricular(listCursos.get(masterTableCursos.getSelectedRow())), true);
    }//GEN-LAST:event_bt_cadastrarUnidadeActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        txt_busca.setText("");
        busca("");
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_moduloUnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moduloUnicoActionPerformed
        Cursos curso = listCursos.get(masterTableCursos.getSelectedRow());
        if(validaDados()){
            if(curso.getUnidadeCurricularCollection()!=null)
                if(!curso.getUnidadeCurricularCollection().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Já existem Unidades cadastradas para esse curso!","Atenção",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            UnidadeCurricular uc = new UnidadeCurricular();
            uc.setCursosId(curso);
            uc.setCargaH(Integer.parseInt(txt_cargaTotal.getText()));
            uc.setNome(curso.getNome());

            if(curso.getId()!=null)
                entityManager.merge(curso);
            else
                entityManager.persist(curso);
            entityManager.persist(uc);
            
            try {
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
                masterTableCursos.clearSelection();
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
            PrincipalView._this.addPanelExibicao(new JIF_Curso(), true);
        }
    }//GEN-LAST:event_btn_moduloUnicoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrarUnidade;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_moduloUnico;
    private javax.swing.JButton btn_novo;
    private javax.swing.JComboBox cb_area;
    private javax.swing.JComboBox cb_modalidade;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private java.util.List<agendacoped.bean.Areas> listArea;
    private java.util.List<agendacoped.bean.Cursos> listCursos;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTableCursos;
    private javax.swing.JLabel modalidadeLabel;
    private javax.swing.JLabel nomeLabel;
    private javax.persistence.Query queryArea;
    private javax.persistence.Query queryCurso;
    private agendacoped.verifier.StringVerifier stringVerifier1;
    private javax.swing.JTextField txt_busca;
    private javax.swing.JFormattedTextField txt_cargaTotal;
    private javax.swing.JTextField txt_nome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
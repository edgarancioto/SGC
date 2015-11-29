package agendacoped.calendario;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class JP_Calendario extends javax.swing.JPanel {

    int mes, ano;
    int[] posicoes_h = new int[]{0,50,100,150,200,250,300};
    int[] posicoes_v = new int[]{0,25,50,75,100,125};
    String[] meses = new String[]{"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", 
        "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};
    
    public JP_Calendario(int mes, int ano) {
        this.mes = mes-1;
        this.ano = ano;
        initComponents();
        
        exibeDias(this.mes, this.ano);
    }

    final void exibeDias(int mes, int ano){
        panel_exibicao.removeAll();
        jl_mes.setText(meses[mes]);
        posicionaDias(mes, ano);
        panel_exibicao.revalidate();
        panel_exibicao.repaint();
        revalidate();
    }
    
    final void posicionaDias(int mes, int ano){
        int contador = 1;
        int dia_da_semana = new GregorianCalendar(ano, mes, 1).get(Calendar.DAY_OF_WEEK)-1;
        int quantidade_dias = new GregorianCalendar(ano, mes, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
        
        for(int j = 0; j < 6; j++){
            for(int i = dia_da_semana; i < 7; i++)
                if(contador <= quantidade_dias){
                    JL_Dia l = new JL_Dia(contador++);
                    panel_exibicao.add(l).setBounds(posicoes_h[i], posicoes_v[j], 50, 25);
                }
            dia_da_semana = 0;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jl_mes = new javax.swing.JLabel();
        jl_anterior = new javax.swing.JLabel();
        jl_proximo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panel_exibicao = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(360, 250));
        setMinimumSize(new java.awt.Dimension(360, 250));
        setPreferredSize(new java.awt.Dimension(360, 250));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jl_mes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jl_mes.setForeground(new java.awt.Color(255, 255, 255));
        jl_mes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_mes.setText("NOVEMBRO");

        jl_anterior.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jl_anterior.setForeground(new java.awt.Color(255, 255, 255));
        jl_anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_anterior.setText("<");
        jl_anterior.setMaximumSize(new java.awt.Dimension(60, 30));
        jl_anterior.setMinimumSize(new java.awt.Dimension(60, 30));
        jl_anterior.setPreferredSize(new java.awt.Dimension(60, 30));
        jl_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_anteriorMouseClicked(evt);
            }
        });

        jl_proximo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jl_proximo.setForeground(new java.awt.Color(255, 255, 255));
        jl_proximo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_proximo.setText(">");
        jl_proximo.setMaximumSize(new java.awt.Dimension(60, 30));
        jl_proximo.setMinimumSize(new java.awt.Dimension(60, 30));
        jl_proximo.setPreferredSize(new java.awt.Dimension(60, 30));
        jl_proximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl_proximoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("D");
        jLabel2.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("S");
        jLabel3.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("T");
        jLabel4.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Q");
        jLabel5.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel5.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Q");
        jLabel6.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("S");
        jLabel7.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel7.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel7.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("S");
        jLabel8.setMaximumSize(new java.awt.Dimension(60, 30));
        jLabel8.setMinimumSize(new java.awt.Dimension(60, 30));
        jLabel8.setPreferredSize(new java.awt.Dimension(60, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jl_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jl_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jl_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_mes)
                    .addComponent(jl_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_exibicao.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_exibicaoLayout = new javax.swing.GroupLayout(panel_exibicao);
        panel_exibicao.setLayout(panel_exibicaoLayout);
        panel_exibicaoLayout.setHorizontalGroup(
            panel_exibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_exibicaoLayout.setVerticalGroup(
            panel_exibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel_exibicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_exibicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jl_anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_anteriorMouseClicked
        mes--;
        if(mes<0){
            mes = 11;
            ano--;
        }
        exibeDias(mes, ano);
    }//GEN-LAST:event_jl_anteriorMouseClicked

    private void jl_proximoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl_proximoMouseClicked
        mes++;
        if(mes>11){
            mes = 0;
            ano++;
        }
        exibeDias(mes, ano);
    }//GEN-LAST:event_jl_proximoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jl_anterior;
    private javax.swing.JLabel jl_mes;
    private javax.swing.JLabel jl_proximo;
    private javax.swing.JPanel panel_exibicao;
    // End of variables declaration//GEN-END:variables
}
package agendacoped.calendario;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Bean_Dia extends JLabel{

    int id;
    boolean ocupado = false;
    boolean selecionado = false;
    
    public Bean_Dia(int id) {
        this.id = id;
        setOpaque(true);
        setBackground(Color.white);
        setSize(60, 30);
        setText(""+id);
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setFont(new Font("Tahoma", 1, 18));
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleciona(); 
                revalidate();
            }
        });
    }
    
    public int getId(){
        return id;
    }
    void setDomingo(){
        setForeground(Color.red);
    }
    
    void setOcupado(){
        this.setBackground(Color.ORANGE);
        ocupado = true;
    }
    
    void setDesocupado(){
        this.setBackground(Color.white);
        ocupado = false;
    }
    
    void seleciona(){
        if(ocupado){
            JOptionPane.showMessageDialog(null, "Data indisponível!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        selecionado = !selecionado;
        if(selecionado)
            this.setBackground(Color.cyan);
        else
            this.setBackground(Color.white);
        this.repaint();
        this.revalidate();
    }
    
    boolean getSelecionado(){
        return selecionado;
    }
}
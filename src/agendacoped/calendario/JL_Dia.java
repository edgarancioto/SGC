package agendacoped.calendario;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class JL_Dia extends JLabel{

    int id;
    
    public JL_Dia(int id) {
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
                if(evt.getClickCount()>1)
                    marca(); 
                else
                    setOcupado();
                revalidate();
            }
        });
    }
    
    void setDomingo(){
        setForeground(Color.red);
    }
    
    void setOcupado(){
        System.out.println("ocupado");
        this.setBackground(Color.gray);
        revalidate();
    }

    void setDesocupado(){
        System.out.println("desocupado");
        this.setBackground(Color.white);
        revalidate();
    }
    
    void marca(){
        this.setBackground(Color.red);
    }
}
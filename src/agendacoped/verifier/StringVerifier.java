package agendacoped.verifier;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class StringVerifier extends InputVerifier{
    
        private int TAMANHO_MINIMO = 1;
        private int TAMANHO_MAXIMO = 100;
        private int TAMANHO_MASCARA = 0;

        private Color COR = new Color(255,153,153);
    
    public Color getCOR() {
        return COR;
    }

    public void setCOR(Color COR) {
        this.COR = COR;
    }

    public int getTAMANHO_MASCARA() {
        return TAMANHO_MASCARA;
    }

    public void setTAMANHO_MASCARA(int TAMANHO_MASCARA) {
        this.TAMANHO_MASCARA = TAMANHO_MASCARA;
    }

    public int getTAMANHO_MAXIMO() {
        return TAMANHO_MAXIMO;
    }

    public void setTAMANHO_MAXIMO(int TAMANHO_MAXIMO) {
        this.TAMANHO_MAXIMO = TAMANHO_MAXIMO;
    }

    public int getTAMANHO_MINIMO() {
        return TAMANHO_MINIMO;
    }

    public void setTAMANHO_MINIMO(int TAMANHO_MINIMO) {
        this.TAMANHO_MINIMO = TAMANHO_MINIMO;
    }
        
    @Override
    public boolean shouldYieldFocus(JComponent input){
        input.setBackground(Color.white);
        if(verify(input))
            return true;

        JOptionPane.showMessageDialog(input, "O campo '"+input.getAccessibleContext().getAccessibleDescription()+"' não está preenchido corretamente!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        input.setBackground(COR);
        input.requestFocus();
        return false;
    }
    
    @Override
    public boolean verify(JComponent input){
        if(input instanceof JTextComponent){
            String conteudo = ((JTextComponent)input).getText();
            if((conteudo.trim().length()>=TAMANHO_MINIMO+TAMANHO_MASCARA)&&(conteudo.trim().length()<=TAMANHO_MAXIMO+TAMANHO_MASCARA))
                return true;
        }
        return false;
    }
}
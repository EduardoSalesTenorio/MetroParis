package metroparis;

import javax.swing.JOptionPane;

public class MetroParis {

    String Origem;
    String Destino;

    double ValorReal;
    double ValorEuristico;
    double SomaTotal = 0;

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Digite a sua Origem e Destino para Tentarmos Encontrar a melhor rota");

        new MetroParis().start();
    }

    public void start() {

        Origem = JOptionPane.showInputDialog(null, "Onde vc esta?");

        while (!"E1".equals(Origem) && !"E2".equals(Origem) && !"E3".equals(Origem) && !"E4".equals(Origem) && !"E5".equals(Origem) && !"E6".equals(Origem) && !"E7".equals(Origem) && !"E8".equals(Origem) && !"E9".equals(Origem) && !"E10".equals(Origem) && !"E11".equals(Origem) && !"E12".equals(Origem) && !"E13".equals(Origem) && !"E14".equals(Origem)) {
            JOptionPane.showMessageDialog(null, "Origem Invalida");
            Origem = JOptionPane.showInputDialog(null, "Digite Novamente Onde vc Esta?");
        }

        Destino = JOptionPane.showInputDialog(null, "Onde vc quer ir?");

        while (!"E1".equals(Destino) && !"E2".equals(Destino) && !"E3".equals(Destino) && !"E4".equals(Destino) && !"E5".equals(Destino) && !"E6".equals(Destino) && !"E7".equals(Destino) && !"E8".equals(Destino) && !"E9".equals(Destino) && !"E10".equals(Destino) && !"E11".equals(Destino) && !"E12".equals(Destino) && !"E13".equals(Destino) && !"E14".equals(Destino)) {
            JOptionPane.showMessageDialog(null, "Destino Invalida");
            Destino = JOptionPane.showInputDialog(null, "Onde vc quer ir?");
        }

        if (Origem == Destino) {
            JOptionPane.showMessageDialog(null, "Vc ja esta no lugar, BURRO");
        } else {

            JOptionPane.showMessageDialog(null, "Doido");
            chamarMetodoOrigem();
        }
    }

    public void chamarMetodoOrigem() {

        if ("E1".equals(Origem)) {
            eUm();
        }
        if ("E2".equals(Origem)) {
            eDois();
        }
        if ("E3".equals(Origem)) {
            eTres();
        }
        if ("E4".equals(Origem)) {
            eQuatro();
        }
        if ("E5".equals(Origem)) {
            eCinco();
        }
        if ("E6".equals(Origem)) {
            eSeis();
        }
        if ("E7".equals(Origem)) {
            eSete();
        }
        if ("E8".equals(Origem)) {
            eOito();
        }
        if ("E9".equals(Origem)) {
            eNove();
        }
        if ("E10".equals(Origem)) {
            eDez();
        }
        if ("E11".equals(Origem)) {
            eOnze();
        }
        if ("E12".equals(Origem)) {
            eDoze();
        }
        if ("E13".equals(Origem)) {
            eTreze();
        }
        if ("E14".equals(Origem)) {
            eQuatoze();
        }
    }

    public void eUm() {

    }

    public void eDois() {

    }

    public void eTres() {

    }

    public void eQuatro() {

    }

    public void eCinco() {

    }

    public void eSeis() {

    }

    public void eSete() {

    }

    public void eOito() {

    }

    public void eNove() {

    }

    public void eDez() {

    }

    public void eOnze() {

    }

    public void eDoze() {

    }

    public void eTreze() {

    }

    public void eQuatoze() {

    }
}

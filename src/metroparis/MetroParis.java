package metroparis;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class MetroParis {

    double[] E1 = {0, 10, 18.5, 24.8, 36.4, 38.8, 35.8, 25.4, 17.6, 9.1, 16.7, 27.3, 27.6, 29.8};
    double[] E2 = {10, 0, 8.5, 14.8, 26.6, 29.1, 26.1, 17.3, 10, 3.5, 15.5, 20.9, 19.1, 21.8};
    double[] E3 = {18.5, 8.5, 0, 6.3, 18.2, 20.6, 17.6, 13.6, 9.4, 10.3, 19.5, 19.1, 12.1, 16.6};
    double[] E4 = {24.8, 14.8, 6.3, 0, 12, 14.4, 11.5, 12.4, 12.6, 16.7, 23.6, 18.6, 20.6, 25.4};
    double[] E5 = {36.4, 26.6, 18.2, 12, 0, 3, 2.4, 19.4, 23.3, 28.2, 34.2, 24.8, 14.5, 17.9};
    double[] E6 = {38.8, 29.1, 20.6, 14.4, 3, 0, 3.3, 22.3, 25.7, 30.3, 36.7, 27.6, 15.2, 18.2};
    double[] E7 = {35.8, 26.1, 17.6, 11.5, 2.4, 3.3, 0, 20, 23, 27.3, 34.2, 25.7, 12.4, 15.6};
    double[] E8 = {25.4, 17.3, 13.6, 12.4, 19.4, 22.3, 20, 0, 8.2, 20.3, 16.1, 6.4, 22.7, 27.6};
    double[] E9 = {17.6, 10, 9.4, 12.6, 23.3, 25.7, 23, 8.2, 0, 13.5, 11.2, 10.9, 21.2, 26.6};
    double[] E10 = {9.1, 3.5, 10.3, 16.7, 28.2, 30.3, 27.3, 20.3, 13.5, 0, 17.6, 24.2, 18.7, 21.2};
    double[] E11 = {16.7, 15.5, 19.5, 23.6, 34.2, 36.7, 34.2, 16.1, 11.2, 17.6, 0, 14.2, 31.5, 35.5};
    double[] E12 = {27.3, 20.9, 19.1, 18.6, 24.8, 27.6, 25.7, 6.4, 10.9, 24.2, 14.2, 0, 28.8, 33.6};
    double[] E13 = {27.6, 19.1, 12.1, 10.6, 14.5, 15.2, 12.4, 22.7, 21.2, 18.7, 31.5, 28.8, 0, 5.1};
    double[] E14 = {29.8, 21.8, 16.6, 15.4, 17.9, 18.2, 15.6, 27.6, 26.6, 21.2, 35.5, 33.6, 5.1, 0};

    String Origem;
    String Destino;

    int OrigemBuscar;
    int DestinoBuscar;

    String OndePassou = "";

    String Chegou;
    String anterior = "a";

    double ValorEuristico;
    double SomaTotal = 0;

    int contador = 0;
    double valorReal = 0;

    double Comparacao[] = new double[5];
    double buscarValorReal[] = new double[5];

    static String Metodo[] = new String[5];

    public static void main(String[] args) {

        //JOptionPane.showMessageDialog(null, "Digite a sua Origem e Destino para Tentarmos Encontrar a melhor rota");
        new MetroParis().start();
    }

    public void start() {

        // ValorHeuristico Chamar = new ValorHeuristico();
//        SomaTotal = Chamar.Teste(a);
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
            JOptionPane.showMessageDialog(null, "Vc já esta no lugar, BURRO");
        } else {
            contribuirBuscaDestino();
            chamarMetodoOrigem();
        }
    }

    public void chamarMetodoOrigem() {

        if ("E1".equals(Origem)) {
            OrigemBuscar = 0;
            eUm();
        }
        if ("E2".equals(Origem)) {
            OrigemBuscar = 1;
            eDois();
        }
        if ("E3".equals(Origem)) {
            OrigemBuscar = 2;
            eTres();
        }
        if ("E4".equals(Origem)) {
            OrigemBuscar = 3;
            eQuatro();
        }
        if ("E5".equals(Origem)) {
            OrigemBuscar = 4;
            eCinco();
        }
        if ("E6".equals(Origem)) {
            OrigemBuscar = 5;
            eSeis();
        }
        if ("E7".equals(Origem)) {
            OrigemBuscar = 6;
            eSete();
        }
        if ("E8".equals(Origem)) {
            OrigemBuscar = 7;
            eOito();
        }
        if ("E9".equals(Origem)) {
            OrigemBuscar = 8;
            eNove();
        }
        if ("E10".equals(Origem)) {
            OrigemBuscar = 9;
            eDez();
        }
        if ("E11".equals(Origem)) {
            OrigemBuscar = 10;
            eOnze();
        }
        if ("E12".equals(Origem)) {
            OrigemBuscar = 11;
            eDoze();
        }
        if ("E13".equals(Origem)) {
            OrigemBuscar = 12;
            eTreze();
        }
        if ("E14".equals(Origem)) {
            OrigemBuscar = 13;
            eQuatoze();
        }
    }

    public void contribuirBuscaDestino() {
        JOptionPane.showMessageDialog(null, "Busca");
        if ("E1".equals(Destino)) {
            DestinoBuscar = 0;
        }
        if ("E2".equals(Destino)) {
            DestinoBuscar = 1;
        }
        if ("E3".equals(Destino)) {
            DestinoBuscar = 2;
        }
        if ("E4".equals(Destino)) {
            DestinoBuscar = 3;
        }
        if ("E5".equals(Destino)) {
            DestinoBuscar = 4;
        }
        if ("E6".equals(Destino)) {
            DestinoBuscar = 5;
        }
        if ("E7".equals(Destino)) {
            DestinoBuscar = 6;
        }
        if ("E8".equals(Destino)) {
            DestinoBuscar = 7;
        }
        if ("E9".equals(Destino)) {
            DestinoBuscar = 8;
        }
        if ("E10".equals(Destino)) {
            DestinoBuscar = 9;
        }
        if ("E11".equals(Destino)) {
            DestinoBuscar = 10;
        }
        if ("E12".equals(Destino)) {
            DestinoBuscar = 11;
        }
        if ("E13".equals(Destino)) {
            DestinoBuscar = 12;
        }
        if ("E14".equals(Destino)) {
            DestinoBuscar = 13;
        }
    }

    public void chegou() {
        if (Chegou.equals(Destino)) {
            JOptionPane.showMessageDialog(null, "Estações que deve pegar " + OndePassou);
            JOptionPane.showMessageDialog(null, valorReal);
            System.exit(0);
        }
    }

    public void buscarValor() {
        for (int i = 0; Metodo.length > i; i++) {
            if ("E1".equals(this.Metodo[i])) {
                contador = i;

                Comparacao[contador] += E1[DestinoBuscar];
            }
            if ("E2".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E2[DestinoBuscar];
            }
            if ("E3".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E3[DestinoBuscar];
            }
            if ("E4".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E4[DestinoBuscar];
            }
            if ("E5".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E5[DestinoBuscar];
            }
            if ("E6".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E6[DestinoBuscar];
            }
            if ("E7".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E7[DestinoBuscar];
            }
            if ("E8".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E8[DestinoBuscar];
            }
            if ("E9".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E9[DestinoBuscar];
            }
            if ("E10".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E10[DestinoBuscar];
            }
            if ("E11".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E11[DestinoBuscar];
            }
            if ("E12".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E12[DestinoBuscar];
            }
            if ("E13".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E13[DestinoBuscar];
            }
            if ("E14".equals(this.Metodo[i])) {
                contador = i;
                Comparacao[contador] += E14[DestinoBuscar];
            }
        }

    }

    public void compararValores() {
        double mim = 0;
        int Cont = 0;
        String Result = "";

        mim = Comparacao[0];

        for (int i = 0; Comparacao.length > contador; contador++) {

            if (Comparacao[contador] < mim) {
                mim = Comparacao[i];
                Cont = i;
            }

        }
        contador = 0;

        valorReal += buscarValorReal[Cont];

        //Result = Metodo[Cont];
        Result = this.Metodo[Cont];

        if ("E1".equals(Result)) {

            eUm();
        }
        if ("E2".equals(Result)) {

            eDois();
        }
        if ("E3".equals(Result)) {

            eTres();
        }
        if ("E4".equals(Result)) {

            eQuatro();
        }
        if ("E5".equals(Result)) {

            eCinco();
        }
        if ("E6".equals(Result)) {

            eSeis();
        }
        if ("E7".equals(Result)) {

            eSete();
        }
        if ("E8".equals(Result)) {

            eOito();
        }
        if ("E9".equals(Result)) {

            eNove();
        }
        if ("E10".equals(Result)) {

            eDez();
        }
        if ("E11".equals(Result)) {

            eOnze();
        }
        if ("E12".equals(Result)) {

            eDoze();
        }
        if ("E13".equals(Result)) {

            eTreze();
        }
        if ("E14".equals(Result)) {

            eQuatoze();
        }

    }

    public void eUm() {
        OndePassou += ", E1"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, DestinoBuscar);
        Chegou = "E1"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        if ("E2" != anterior) {
            this.Metodo[0] = "E2";
            Comparacao[0] = 10 + valorReal;
            buscarValorReal[0] = 10;
        }

        anterior = "E1";

        buscarValor();
        compararValores();
    }

    public void eDois() {
        OndePassou += ", E2"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E2"; //Ver se ela chegou no destinho correto
        chegou();

        if (!"E3".equals(anterior)) {
            this.Metodo[0] = "E3";
            Comparacao[0] = 8.5 + valorReal;
            buscarValorReal[0] = 8.5;
        }

        if (!"E9".equals(anterior)) {
            this.Metodo[1] = "E9";
            Comparacao[1] = 10 + valorReal;
            buscarValorReal[1] = 10;
        }

        if (!"E10".equals(anterior)) {
            this.Metodo[2] = "E10";
            Comparacao[2] = 3.5 + valorReal;
            buscarValorReal[2] = 3.5;
        }

        if (!"E1".equals(anterior)) {
            this.Metodo[3] = "E1";
            Comparacao[3] = 10 + valorReal;
            buscarValorReal[3] = 10;
        }

        anterior = "E2";

        buscarValor();
        compararValores();
    }

    public void eTres() {

        OndePassou += ", E3"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E3"; //Ver se ela chegou no destinho correto
        chegou();

        if (!"E2".equals(anterior)) {
            this.Metodo[0] = "E2";
            Comparacao[0] = 8.5 + valorReal;
            buscarValorReal[0] = 8.5;
        }

        if (!"E4".equals(anterior)) {
            this.Metodo[1] = "E4";
            Comparacao[1] = 6.3 + valorReal;
            buscarValorReal[1] = 6.3;
        }

        if (!"E9".equals(anterior)) {
            this.Metodo[2] = "E9";
            Comparacao[2] = 9.4 + valorReal;
            buscarValorReal[2] = 9.4;
        }

        anterior = "E3";

        buscarValor();
        compararValores();

    }

    public void eQuatro() {

        OndePassou += "E4, "; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E4"; //Ver se ela chegou no destinho correto
        chegou();

        if (!"E5".equals(anterior)) {
            Metodo[0] = "E5";
            Comparacao[0] = 13 + valorReal;
            buscarValorReal[0] = 13;
        }

        if (!"E8".equals(anterior)) {
            this.Metodo[1] = "E8";
            Comparacao[1] = 15.3 + valorReal;
            buscarValorReal[1] = 15.3;
        }

        if (!"E13".equals(anterior)) {
            this.Metodo[2] = "E13";
            Comparacao[2] = 12.8 + valorReal;
            buscarValorReal[2] = 12.8;
        }

        anterior = "E4";

        buscarValor();
        compararValores();
    }

    public void eCinco() {

        OndePassou += ", E5"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E5"; //Ver se ela chegou no destinho correto
        chegou();

        if (!"E4".equals(anterior)) {
            this.Metodo[0] = "E4";
            Comparacao[0] = 13 + valorReal;
            buscarValorReal[0] = 13;
        }

        if (!"E6".equals(anterior)) {
            this.Metodo[1] = "E6";
            Comparacao[1] = 3 + valorReal;
            buscarValorReal[1] = 3;
        }

        if (!"E7".equals(anterior)) {
            this.Metodo[2] = "E7";
            Comparacao[2] = 2.4 + valorReal;
            buscarValorReal[2] = 2.4;
        }

        if (!"E8".equals(anterior)) {
            this.Metodo[3] = "E8";
            Comparacao[3] = 30 + valorReal;
            buscarValorReal[3] = 30;
        }

        anterior = "E5";
        buscarValor();
        compararValores();
    }

    public void eSeis() {
        OndePassou += ", E6"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E6"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E5";
        Comparacao[0] = 3 + valorReal;
        buscarValorReal[0] = 3;

        buscarValor();
        compararValores();
    }

    public void eSete() {
        OndePassou += ", E7"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E7"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E5";
        Comparacao[0] = 2.4 + valorReal;
        buscarValorReal[0] = 2.4;

        buscarValor();
        compararValores();
    }

    public void eOito() {
        OndePassou += ", E8"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E8"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E4";
        Comparacao[0] = 15.3 + valorReal;
        buscarValorReal[0] = 15.3;

        this.Metodo[1] = "E5";
        Comparacao[1] = 30 + valorReal;
        buscarValorReal[1] = 30;

        this.Metodo[2] = "E9";
        Comparacao[2] = 9.6 + valorReal;
        buscarValorReal[2] = 9.6;

        this.Metodo[3] = "E12";
        Comparacao[3] = 6.4 + valorReal;
        buscarValorReal[3] = 6.4;

        buscarValor();
        compararValores();
    }

    public void eNove() {
        OndePassou += ", E9"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E9"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E2";
        Comparacao[0] = 10 + valorReal;
        buscarValorReal[0] = 10;

        this.Metodo[1] = "E3";
        Comparacao[1] = 9.4 + valorReal;
        buscarValorReal[1] = 9.4;

        this.Metodo[2] = "E8";
        Comparacao[2] = 9.6 + valorReal;
        buscarValorReal[2] = 9.6;

        this.Metodo[3] = "E11";
        Comparacao[3] = 12.2 + valorReal;
        buscarValorReal[3] = 12.2;

        buscarValor();
        compararValores();
    }

    public void eDez() {
        OndePassou += ", E10"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E10"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E2";
        Comparacao[0] = 3.5 + valorReal;
        buscarValorReal[0] = 3.5;

        buscarValor();
        compararValores();
    }

    public void eOnze() {
        OndePassou += ", E11"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E11"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E9";
        Comparacao[0] = 12.2 + valorReal;
        buscarValorReal[0] = 12.2;

        buscarValor();
        compararValores();
    }

    public void eDoze() {
        OndePassou += ", E12"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E12"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E8";
        Comparacao[0] = 6.4 + valorReal;
        buscarValorReal[0] = 6.4;

        buscarValor();
        compararValores();
    }

    public void eTreze() {
        OndePassou += ", E13"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E13"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E3";
        Comparacao[0] = 18.7 + valorReal;
        buscarValorReal[0] = 18.7;

        this.Metodo[1] = "E4";
        Comparacao[1] = 12.8 + valorReal;
        buscarValorReal[1] = 12.8;

        this.Metodo[2] = "E14";
        Comparacao[2] = 5.1 + valorReal;
        buscarValorReal[2] = 5.1;

        buscarValor();
        compararValores();
    }

    public void eQuatoze() {
        OndePassou += ", E14"; // Coloca na String as Estações que ele deve pegar

        JOptionPane.showMessageDialog(null, OndePassou);

        this.Metodo = new String[5];
        this.Comparacao = new double[5];
        this.buscarValorReal = new double[5];

        Chegou = "E14"; //Ver se ela chegou no destinho correto
        chegou();

        this.Metodo[0] = "E13";
        Comparacao[0] = 5.1 + valorReal;
        buscarValorReal[0] = 5.1;

        buscarValor();
        compararValores();
    }
}

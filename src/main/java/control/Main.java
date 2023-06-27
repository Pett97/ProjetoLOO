package control;
import util.MinhaExcecao;
import view.InterfaceTexto;
//import view.TelaPrincipal;
public class Main {

    private Main() {}

    public static void main(String[] args) throws MinhaExcecao {
        //TelaPrincipal principal = new TelaPrincipal();
        //principal.setVisible(true);
        
        InterfaceTexto i = new InterfaceTexto();
        i.renderizar();
    }
}
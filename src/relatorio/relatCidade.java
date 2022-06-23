package relatorio;

import java.util.HashMap;
import javax.swing.JOptionPane;

//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRResultSetDataSource;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;

import utilitarios.conexao;

/**
 *
 * @author Adriano Silva
 */
public class relatCidade {

    
    conexao con = new conexao();

    /**
     *
     */
    public relatCidade() {
  try 
  {
      con.conecta();
      con.executeSQL("SELECT * from cidade");
      //JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
      //JasperPrint jasperPrint = JasperFillManager.fillReport(
      //"relatorios/relCidades.jasper", new HashMap(), jrRS);
     // JasperViewer.viewReport(jasperPrint);
  } catch (Exception erro){
             JOptionPane.showMessageDialog(null,"deu erro ="+erro);
   }
}

    /**
     *
     * @param args
     */
    public static void main (String args[]) 
  {
    new relatCidade(); 
  }
}



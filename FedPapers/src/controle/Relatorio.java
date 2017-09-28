/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import modelo.DocumentoDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel
 */
public class Relatorio {
    public static void geraRelatorioPedDetalhado(String sql) throws JRException, Exception {
        DocumentoDAO d = new DocumentoDAO();
        //Código SQL que ira retornar a consulta e que vc vai passar para o relatório
        ResultSet rs = d.consulta(sql);
        /* implementação da interface JRDataSource para DataSource ResultSet */
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        /* HashMap de parametros utilizados no relatório. Sempre instanciados */
        Map parameters = new HashMap();
        //Passa as imagens como parâmetro para aparecer no relatório
        String imagem = "C:/Users/Daniel/Desktop/IFMG/FedParpes/FedPapers/report/l1.png";
        String imagem2 = "C:/Users/Daniel/Desktop/IFMG/FedParpes/FedPapers/report/l3.png";
        
        parameters.put("logo1", imagem);
        parameters.put("logo2", imagem2);
        //parameters.put("logo3", imagem3);
        

        /* Preenche o relatório com os dados. */
       // JasperViewer.viewReport(JasperFillManager.fillReport("C:/Users/Daniel/Desktop/IFMG/FedParpes/FedPapers/report/memorando.jasper", parameters, jrRS));
       String jasperPrint = JasperFillManager.fillReportToFile("C:/Users/Daniel/Desktop/IFMG/FedParpes/FedPapers/report/memorando.jasper", parameters, jrRS);//Aqui vc chama o relatório
        JasperViewer viewer = new JasperViewer(jasperPrint, false, false);
       viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);//Coloca em maximizado
        viewer.setTitle("Memorando");//Coloca um título no relatório
        viewer.setVisible(true);
    }

}
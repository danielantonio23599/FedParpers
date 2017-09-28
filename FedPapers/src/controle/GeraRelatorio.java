package controle;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import net.sf.jasperreports.engine.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import static modelo.ConnectionFactory.getConnection;

public class GeraRelatorio {

    public GeraRelatorio() {
    }

    //Método responsável por gerar o relatório
    public static void gerarRelatorio(String jrxml, String nomeArquivo, int usuCodigo) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        //Try Catch necessário caso ocorra algum erro durante a geração do relatório
        try {
            //Formatando a data para nomear o arquivo PDF gerado
            SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
            //Pega a conexão para efetuar as operações no BD
            Connection con = getConnection();
            HashMap parameters = new HashMap();
            parameters.put("imgURL", "C:\\Users\\Daniel\\Desktop\\IFMG\\FedParpes\\FedPapers\\report\\l2.jpg");
            parameters.put("usuCodigo", usuCodigo);

            //Busca o relatório .jrxml
            JasperReport report = JasperCompileManager.compileReport("report/"+nomeArquivo+".jrxml");
            //Chama o relatório passando o caminho, parâmtros especificados e a conexão com o BD
            JasperPrint impressao = JasperFillManager.fillReport(report, parameters, con);
            //Após ser gerado, a próxima linha exportará o documento em formato PDF
            JasperExportManager.exportReportToPdfFile(impressao, "C:/Users/Daniel/Desktop/IFMG/FedParpes/FedPapers/report/"+nomeArquivo+".jrxml" + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            //Busca e exibe automaticamnete o arquivo PDF gerado
            File arquivo = new File("C:/Users/Daniel/Desktop/IFMG/FedParpes/FedPapers/report/"+nomeArquivo+".jrxml" + "-" + dt.format(Calendar.getInstance().getTime()) + ".pdf");
            Desktop.getDesktop().open(arquivo);
        } catch (IOException | JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar o Relatório, " + e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
        }

    }

    public static void geraRelatorio(int usuCodigo,String nome) {
        gerarRelatorio(nome, nome , usuCodigo);
    }

}

//Tutorial sobre tables jasper: http://blog.tiagosousa.eti.br/2015/10/criando-relatorios-com-jaspersoft_13.html
//Conexão entre NetBeans e Jasper: http://ensode.net/jasperreports_intro.html
//Documentação: https://community.jaspersoft.com/documentation?version=36816

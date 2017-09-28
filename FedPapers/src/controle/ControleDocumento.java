/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.DocumentoBEAN;
import modelo.DocumentoDAO;

/**
 *
 * @author Daniel
 */
public class ControleDocumento {

    DocumentoDAO d = new DocumentoDAO();

    public int cadastrarDoc(DocumentoBEAN doc) {
        int c = d.cadastrarDoc(doc);
        return c;
    }

    public void enviar(int doc, int usu) {
        d.enviar(doc, usu);
    }

    public ArrayList<DocumentoBEAN> docRecebidos(int cod) {
        return d.docRecebidos(cod);
    }

    public ArrayList<DocumentoBEAN> docNotLidos(int cod) {
        return d.docNotLidos(cod);
    }

    public ArrayList<DocumentoBEAN> docTodos(int cod) {
        return d.docTodos(cod);
    }

    public ArrayList<DocumentoBEAN> docEnviados(int cod) {
        return d.docEnviados(cod);
    }

    public void setDataRecebido(String dh, int cod) {

        d.setDataRecebido(dh, cod);
    }

    public void setDataLido(String dh, int cod) {

        d.setDataLido(dh, cod);
    }

    public void mudaStatus(int i) {
        d.mudaStatusLido(i);
    }

}

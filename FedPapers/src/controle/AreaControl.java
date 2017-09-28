/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.AreaBEAN;
import modelo.AreaDAO;

/**
 *
 * @author Daniel
 */
public class AreaControl {

    private AreaDAO a = new AreaDAO();

    public ArrayList<AreaBEAN> pegaArea() {
        ArrayList<AreaBEAN> area = a.pegaArea();
        return area;
    }

    public AreaBEAN pegaCodigo(String area) {
        AreaBEAN are = a.pegaCodigo(area);
        return are;
    }

}

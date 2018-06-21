package Elecciones;

import Conexion.conexion_Bd;
import Elecciones.VotosPOA;
import javax.swing.JOptionPane;

/**
 *
 * @author LabInfo01
 */
public class EleccionImpl extends VotosPOA {

    conexion_Bd bd = new conexion_Bd();

    @Override
    public boolean votar(String matriculaVotante, String candidato) {
        boolean voto=false;        
        if (bd.nohaVotado(matriculaVotante)) {
            if (bd.Votar(matriculaVotante, candidato)) {
                bd.yaVoto(matriculaVotante);
                voto=true;
                System.out.println("Se completó el voto");
            }
        }
        return voto;
    }

    @Override
    public boolean verificarMatricula(String matricula) {
        boolean respuesta=false;
        if(bd.Usuario_existe(matricula)){
            if(bd.nohaVotado(matricula)){
                respuesta=true;
            }
        }
        return respuesta;

    }

    @Override
    public int obtenerResultados(String candidato) {
        return bd.Contar_voto_personal(candidato);
    }

}

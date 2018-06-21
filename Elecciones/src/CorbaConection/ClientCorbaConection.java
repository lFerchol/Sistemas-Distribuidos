/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorbaConection;
import Elecciones.Votos;
import Elecciones.VotosHelper;
import java.util.Scanner;
import java.util.Scanner;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author humberto
 */
public class ClientCorbaConection {
    private String[] args;
    public ClientCorbaConection(String [] args) {
        this.args=args;
    }

        
    public boolean votar(String matriculaVotante, String candidato) {
        boolean band=false;
        try {
            //String[] args = null;
            ORB orb = ORB.init(this.args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            Votos voto=VotosHelper.narrow(ncRef.resolve_str("Elecciones"));
            
            boolean vota=voto.votar(matriculaVotante, candidato);
            
            if(vota){
                System.out.println("El voto ha sido exitoso");
                
                band=true;
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
        return band;
    }
    
    
    public boolean verificarMatricula(String matriculaVotante) {
        boolean existe=false;
        System.out.println("mat"+matriculaVotante);
        try {
            //String[] args = null;
            ORB orb = ORB.init(this.args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            Votos voto=VotosHelper.narrow(ncRef.resolve_str("Elecciones"));
            
            existe=voto.verificarMatricula(matriculaVotante);
            
            if(existe){
                System.out.println("La matrícula existe, si puede votar");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
        return existe;
    }
    
    public int obtenerResultados(String candidato){
        int res=0;
        try {
            //String[] args = null;
            ORB orb = ORB.init(this.args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            Votos voto=VotosHelper.narrow(ncRef.resolve_str("Elecciones"));
            
            res=voto.obtenerResultados(candidato);

        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
        return res;
    }
}


package Elecciones;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


public class EleccionServer {
    
    public static void main(String[] args) {

     try {
            //crea instancua al ORB
            ORB orb = ORB.init(args, null);            
            //crea instancia a POA 
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));       
            //activa POA Manager
            rootpoa.the_POAManager().activate();
            
            EleccionImpl elecImpl = new EleccionImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(elecImpl);
            Votos href = VotosHelper.narrow(ref);
            
             //obtiene referencia
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt rootContext = NamingContextExtHelper.narrow(objRef);
            
            NameComponent nameComponent[] = rootContext.to_name("Elecciones");
            rootContext.rebind(nameComponent, href);
            
            //listo para recibir peticiones
            System.out.println("Servidor> listo y en espera");
            orb.run(); 
    }catch (Exception ex){
        ex.printStackTrace();
    }
        }
    
    
    public static void cargarAlumnos (){
        
    }
}

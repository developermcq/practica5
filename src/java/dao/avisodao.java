
package dao;

import java.util.List;
import modelo.almacen;


public interface avisodao 
{
    
     public void insertar (almacen almacen)  throws Exception;
     public void actualizar(almacen almacen ,int id) throws Exception;
     public void eliminar (int id) throws Exception;
     public almacen mostrar(int id) throws Exception;
     public List<almacen> lista () throws Exception;
     
}

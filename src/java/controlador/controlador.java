
package controlador;

import dao.avisodao;
import dao.implementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.almacen;


@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      PrintWriter salida=response.getWriter();
		HttpSession session=request.getSession();
		
		
		try {
			avisodao dao =new implementacion(); 
			int id;
			
			almacen obj =new almacen();
			
			String action =(request.getParameter("action")) != null ? request.getParameter("action") : "view";
			
			switch (action) 
			{
			case "nuevo":
				request.setAttribute("aviso", obj);
				request.getRequestDispatcher("nuevo.jsp").forward(request, response);
				
				break;
			case "editar":
				id=Integer.parseInt(request.getParameter("id"));
			        obj =dao.mostrar(id);
			        request.setAttribute("aviso",obj);
			        request.getRequestDispatcher("nuevo.jsp").forward(request, response);
				break;
			case "eliminar":	
				id=Integer.parseInt(request.getParameter("id"));
				dao.eliminar(id);
				response.sendRedirect("controlador");
				
				break;
			
			case "view":
				try {
					
					List<almacen> lista=dao.lista();
					request.setAttribute("avisos", lista);
					
					request.getRequestDispatcher("salida.jsp").forward(request, response);
					
				} catch (Exception e) {
					
				}
				
			   
				break;
			
				
			}
			
		} catch (Exception e) 
		{
			
		}
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
               PrintWriter salida =response.getWriter();
	        avisodao dao =new implementacion(); 
		int id=Integer.parseInt(request.getParameter("id"));
		String descripcion =request.getParameter("descripcion");
		int stock=Integer.parseInt(request.getParameter("stock"));
		almacen obj= new almacen();
		obj.setDescripcion(descripcion);
		obj.setStock(stock);
		
		if(id==0)
		{
			try {
				dao.insertar(obj);
				response.sendRedirect("controlador");
			} catch (Exception e) {
			 
				salida.print("error"+e.getMessage());
				
			}
		}
		else
		{
			try {
				dao.actualizar(obj,id);
				response.sendRedirect("controlador");
			} catch (Exception e) {
			 
				salida.print("error"+e.getMessage());
				
			}
		}
	}
        
    

    
    @Override
    public String getServletInfo() 
{
        return "Short description";
    }

}

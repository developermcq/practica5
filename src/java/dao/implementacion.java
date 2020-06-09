
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.almacen;
import utiles.conexion;


public class implementacion  extends conexion implements avisodao{

   
    
	@Override
	public void insertar(almacen almacen) throws Exception {
		try {
			this.getCon();
			String sql ="Insert into producto (descripcion,stock) values (?,?)";
			PreparedStatement ps= this.con.prepareStatement(sql);
			ps.setString(1, almacen.getDescripcion());
			ps.setInt(2, almacen.getStock());
			ps.execute();
			
		} catch (Exception e) 
		{
			throw e;
		} finally {
			this.desconectar();
		}
		
		
	}

	@Override
	public void actualizar(almacen almacen ,int id) throws Exception {

		
	try {
		this.getCon();
		String sql ="update producto set descripcion=?,stock=? where id="+id;
		PreparedStatement ps= this.con.prepareStatement(sql);
		ps.setString(1, almacen.getDescripcion());
		ps.setInt(2, almacen.getStock());
		
		
		
		ps.executeUpdate();
	} catch (Exception e)
	{
		throw e;
	}finally
	{
		this.desconectar();
	}
}

	@Override
	public void eliminar(int id) throws Exception {

		try {
			this.getCon();
			String sql ="delete from producto where id =?";
			java.sql.PreparedStatement ps= this.con.prepareStatement(sql);
		        ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e)
		{
			throw e;
		}finally
		{
			this.desconectar();
		}
		
	}

	@Override
	public almacen mostrar(int id) throws Exception
	{
		 almacen obj = new almacen();
		try {
			this.getCon();
			String sql ="select * from producto where id =?";
			PreparedStatement ps=this.con.prepareStatement(sql);
			ps.setInt(1, id);
		  ResultSet rs=	ps.executeQuery();
		  
		  if(rs.next())
		  {             obj.setId(rs.getInt("id"));
			  	obj.setDescripcion(rs.getString("descripcion"));
			  	obj.setStock(rs.getInt("Stock"));
			  	
		  }
			
		} catch (Exception e) 
		{
			throw e;
		} finally {
			this.desconectar();
		}
		
		
		return obj;
	}

	@Override
	public List<almacen> lista() throws Exception {
		List<almacen> li=null;
		
		try{
			this.getCon();
			String sql="select*from producto ";
			PreparedStatement ps=this.con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			li= new ArrayList<almacen>();
			
			while (rs.next())
			{
				almacen obj=new almacen();
                                obj.setId(rs.getInt("id"));
				obj.setDescripcion(rs.getString("descripcion"));
				obj.setStock(rs.getInt("stock"));
				li.add(obj);
				
			}
			
		} catch (Exception e) {
			
		}
		finally {
			this.desconectar();
		}
		return li;
	}
}

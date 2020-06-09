
package utiles;

import java.sql.*;


public class conexion 
{
     
	private String usuario ="root";
	private String contra="";
	private String host="localhost";
	private String bd="bd_almacen";
	private String puerto="3306";
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://"+host+":"+puerto+"/"+bd;
	
	protected Connection con;
	
	public conexion()
	{
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,usuario,contra);
			
			if(con != null)
			{
				System.out.println("conexion exitosa");
			}
			
			
		} catch (ClassNotFoundException e) 
		{
			System.out.println("error en el driver");
		}
		catch(SQLException e)
		{
			System.out.println("error al conectar");
		}
		
	}
	
		public Connection getCon()
		{
			return con;
		}
		public void desconectar()
		{
			try {
				con.close();
			} catch (Exception e) {
				System.out.println("Error al desconectar");
                                
			}
		}
	
	public static void main(String[] args) 
	{
		conexion obj =new conexion();
		obj.getCon();
	}
}

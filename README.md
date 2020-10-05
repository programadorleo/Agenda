## Agenda


## Crud Agenda utilizando la arquitectura MVC.

#### El patrón MVC  permite separar la aplicación en tres capas que aunque estén relacionadas Vista,  Controlador y el Modelo.

![](Agenda/img/mvc.jpg)


**Modelo:**  es la información que el usuario puede visualizar en pantalla.

**Vista:** es la representación gráfica o pantalla que estas viendo en este momento, La vista requiere del Modelo para mostrar la información en la pantalla.

**Controlador:**  es el puente entre la vista y el modelo, ya que desde el controlador podemos hacer operaciones que cambien el modelo lo cual representa un cambio en los datos de la vista.




## Manejo de base de datos JDBC Java Data Base Connectivity

### Pasos para conectar a una base de datos 



##### Agragar Driver :  boton derecho proyecto elijo properties Java Build Path --> Libraries -->  Add External JARs   Seleccionamos mysql-connector-java-version.jar


#### JDBC: Driver que concecta o puente en una aplicacion java y una base de datos 

	 a Establece una conexion
	 b Permite manipular a BBDD para leer insertar actualizar o borrar registro de la misma,
	   son distintos gestores dependiento de la base de datos que tengamos 
	 	
Vamos necesitar dos paquetes  java.sql y javax.sql 	 
	  	
	 	
Pasos para conectar

	1 Establecer una conexion con la BBDD
		 Modelo Mysql													  ip o url
		Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java","root", "" );
		                                                  driver Protocolo driver   Detalles conexion
		
		Modelo sqlserver  Microsoft
		jdbc:odbc:DNS_gestionPedidos
		
		Modelo oracle 
		jdbc:oracle:juan@dervidor:9999:gestionPedidos
		
	
	2 Crear un objeto statement
		Statement miStatement = miConexion.createStatement();  
		
	3 Ejecutar la sentencia sql  devuelve una table que se almacena en memoria
		ResultSet miResultSet=miStatement.executeQuery("SELECT * FROM PRODUCTOS");	
		
	4 Leer resultset tabla   mediante getString() next()
	
		while(miResultSet.next()) {
				
				System.out.println(miResultSet.getString("CODIGOARTICULO")+ " " + miResultSet.getString("NOMBREARTICULO")+ 
				" "+ miResultSet.getString("PRECIO"));
			}
			

    Las conexiones lanzan excepciones debe estar dentro de try catch
    
   

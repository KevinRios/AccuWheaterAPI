# AccuWheaterAPI
Clima APP


Esta es una aplp te permite obtener información meteorológica y guardarla en una base de datos local. Esta informacion se obtiene consultando a las APIS publicas de AccuWeather (https://developer.accuweather.com/)


Requisitos Para ejecutar 
Es necesario tener instalado lo siguiente

Java Development Kit (JDK) - versión 8 o superior (Java 8 es la version utilizada en este proyecto)
Maven - para las dependencias
Git - para clonar el repositorio



Configuración

1) Clonar el repositorio 

2) Abrir el proyecto en algun IDE

3) Configura las variables de entorno necesarias en el archivo application.properties.
   
   Solo hay que cambiar la key de la API de AccuWeather accuweather.api.api-key=API_KEY
   API_KEY seria tu clave de API AccuWeather




Ejecución
Esta es una aplicacion SpringBoot. Se va a ejecutar el proyecto desde la clase  ClimaApplication
![image](https://github.com/KevinRios/AccuWheaterAPI/assets/16569777/30b3b34a-86cd-4f16-bda3-878fdc90119e)



Para probar la API, se puede utilizar POSTMAN. 
URl: http://localhost:8080/clima/search-and-save
Tipo: POST

La peticion se genera desde el body -> Raw -> JSON y con un unico parametro "cityName" que es el nombre de la ciudad. De esa ciudad voy a obtener el clima


La peticion se veria de la siguiente manera
![image](https://github.com/KevinRios/AccuWheaterAPI/assets/16569777/f95570c5-3047-4797-b680-75ccbcbccf0b)


En caso de que la peticion sea exitosa, se va a ver el siguiente mensaje
![image](https://github.com/KevinRios/AccuWheaterAPI/assets/16569777/1e56b6cd-c996-49d2-b54e-24286c2d0f67)




Base de Datos
Al obtener, exitosamente, los datos del clima, se guardan en una base de datos relacional H2, la cual corre en memoria

Con la configuracion definida en application.properties, se va a estar generando una base de datos H2 en memoria llamada "testdb".
 La consola H2 estará habilitada y accesible en http://localhost:8080/h2-console.
 Las credenciales para ingresar son usuario:root y contraseña:root.

Hay que tener en cuenta que los datos en una base de datos H2 en memoria se perderán cuando la aplicación se detenga, ya que esta base de datos existe solo en la memoria mientras la aplicación está en ejecución.

Al ejececutar la aplicacion y entrar a http://localhost:8080/h2-console, se deberia ver de la siguiente manera:
![image](https://github.com/KevinRios/AccuWheaterAPI/assets/16569777/440bd2b0-2ecf-46d9-a35a-9c10114058d5)




La base solo va a contener una tabla: CLIMA_ENTITY. Si se hace una consulta a esa tabla, se van a poder visualizar los registros ingresados durante la ejecucion de la aplicacion
![image](https://github.com/KevinRios/AccuWheaterAPI/assets/16569777/1cb68bcf-2468-4275-bbb2-30f38ae3b38a)




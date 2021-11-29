#	:bulb:	 Chambea

Chambea es una plataforma que proporciona a trabajadores de todo tipo la posibilidad de ofrecer sus servicios a través de ella.

Como empleador, podrás publicar ofertas laborales, y esperar las propuestas de los usuarios de la plataforma. O también podrás buscar entre nuestra gran cantidad de trabajadores, y ponerte en contacto con aquellos con las habilidades necesarias para llevar a cabo tu proyecto.

Como trabajador, podrás crear y modificar tu perfil, seleccionando aquellas habilidades que deseas destacar; y así llamar la atención de potenciales empleadores. También podrás buscar entre las ofertas laborales y postularte a aquellas que creas conveniente.

#Perusable

Perusable es el nombre de nuestra startup, somos un grupo de estudiantes de la carrera de Ingeniería de Computación y Sistemas de la UPAO; los cuales con los conocimientos adquiridos a lo largo de los semestres académicos, buscamos ponernos a prueba desarrollando una aplicación web para la oferta de servicios.

#	:handshaking:	Integrantes

- Siccha Siccha Luis Gabriel
- Grados Urtecho Gabriel Andre
- Ibañez Arteaga Kevin Raul
- Desrosiers Perez Patrick David
- Quispe Cueva Manuel Alberto
- Campero Barr Carlos Daniel

#	:construction:	 Sobre la aplicación
##	:gear:	Tecnologías
###Backend
Nuestro backend está constituido por una base de datos, construida haciendo uso del sistema gestor de base de datos **PostgreSQL**; y una **API RESTful** escrita en java, haciendo uso del framework Spring y los módulos mencionados a continuación:
- **Spring Boot:** Nos brinda la posibilidad de configurar nuestra aplicación de forma rápida y sencilla, haciendo uso de los starters proporcionados por Spring Boot, podemos, de forma sencilla, agregar a nuestro proyecto las dependencias que veamos necesarias. Gracias a esto, podemos ahorrarnos el tiempo de configuración y enfocarnos principalmente en el desarrollo de la aplicación en sí.

- **Spring MVC:** Un framework orientado a HTTP que sigue el patrón Modelo Vista Controlador, nos permite implementar métodos los cuales pueden ser accedidos mediante solicitudes HTTP.


###Frontend
- Nuestro Frontend es una aplicación web de una sola página; desarrollada haciendo uso del framework **Angular**, escrito en TypeScript.


#	:rocket:	Uso 
###Backend
Para poder ejecutar el backend, es necesario contar con las siguientes herramientas:
-	**Java (JDK 17)**
-	**Apache Maven 3.8.2**
-	** PostgreSQL**

Una vez en nuestro repositorio local, simplemente ejecutamos los siguientes comandos:
```bash
cd backend
```
Esto instalara todas las dependencias necesarias para ejecutar la aplicación y creara el .jar
```bash
mvn clean install
```
Luego, simplemente ejecutamos el jar generado anteriormente.
```bash
java -jar target\API-0.0.1-SNAPSHOT.jar
```
###Frontend
Para poder ejecutar el frontend, es necesario tener instalado el gestor de paquetes npm (Node Package Manager).

-	**npm (6.14.15)**

En la raíz del proyecto, nos movemos al módulo frontend.

```bash
cd frontend
```
Ejecutamos el siguiente comando:
```bash
npm install
```
Y, finalmente:
```bash
ng serve
```

## Laboratorio 3 - Crear un Servidor y Cliente de Spring Cloud Config

**Parte 1 - Servidor de Configuración:**


1. Crea una nueva aplicación Spring Boot utilizando Spring Initializr https://start.spring.io/. Nomina el proyecto "lab-3-server" y utiliza este valor para el Artifact. Utiliza el empaquetado Jar y las últimas versiones de Java (JDK11). Utiliza una versión de Boot superior a 2.7.x. No es necesario seleccionar ninguna dependencia.

2. Añade la dependencia correspondiente a Spring Config Server.

![Configuración del Servidor](config_server_configuration.png)


3. Descarga y descomprime el proyecto creado. Importa  el proyecto maven creado en el IDE que utilices (Eclipse, VS Code, etc.)


4. Edita la clase principal de la aplicación (probablemente llamada Lab3ServerApplication). Agrega la anotación `@EnableConfigServer` a esta clase.

5. Crea un nuevo repositorio en GitHub para almacenar los datos de configuración de tu aplicación. Llama al repositorio "ConfigData" o con un nombre de tu elección. Toma nota de la URI completa del repositorio, la necesitarás en un paso posterior.

6. Agrega un nuevo archivo a tu repositorio de GitHub llamado "lab-3-client.yml" (o lab-3-client.properties). Agrega una propiedad llamada "lucky-word" y un valor como "Irish", "Pata de Conejo", "Serendipia" o cualquier otro valor de tu elección. En general, cada microservicio tendría un archivo `.yml` o `.properties` con las propiedades que se deseen configurar. 
 
**Recuerda** que el archivo `.properties` contiene un conjunto de `claves  = valor`, mientras que el archivo `.yml` estará en formato `YAML` donde las propiedades suelen dividirse en tokens hasta el punto, se añaden dos puntos y después se salta de linea para continuar con la definición. El último token se separa del valor por dos puntos.

Ejemplo sencillo:

```bash
#application.properties

server.port=8001
```


```yaml
#application.yml

server:
   port: 8001
```

7. De vuelta en tu proyecto, crea un archivo `application.yml` (o `application.properties`) en la raíz de tu classpath (`src/main/resources` es recomendado). Agrega la clave `spring.cloud.config.server.git.uri` y el valor `https://github.com/"TU-ID-DE-GITHUB"/ConfigData`, sustituyendo el valor de tu ID de GitHub y el nombre del repositorio según sea necesario.

   ```bash
   spring.cloud.config.server.git.uri=https://github.com/pjclemente/ConfigData
   ```

8. También en `application.yml` (o `application.properties`), configura el "server.port" en 8001.

   ```bash
   server.port=8001
   ```

9. Ejecuta la aplicación. Abre la URL [http://localhost:8001/lab-3-client/default/](http://localhost:8001/lab-3-client/default/). Deberías ver el resultado JSON que realmente utilizará Spring. Si el servidor no funciona, revisa los pasos anteriores para encontrar el problema antes de continuar.

```json
{
  "name": "lab-3-client",
  "profiles": [
    "default"
  ],
  "label": null,
  "version": "624a8660be89a5093b01325d60960c14cce3c3d3",
  "state": null,
  "propertySources": [
    {
      "name": "https://github.com/pjclemente/ConfigData/lab-3-client.properties",
      "source": {
        "lucky-word": "Irish"
      }
    }
  ]
}
```

**Parte 2 - Cliente de Configuración:**


10. Crea una nueva aplicación Spring Boot separada. Utiliza una versión de Boot superior a 2.7.x. Nombra el proyecto "lab-3-client" y utiliza este valor para el Artifact. Agrega la dependencia web. Puedes hacer que sea un proyecto JAR o WAR, pero las instrucciones aquí asumen un proyecto JAR.

11. Añade las dependencias correspondiente a **Spring Config Client** y *Spring Web**.


![Cliente de Configuración](config_client.png.png)


12. Descarga, descomprime e importa el proyecto creado. Puedes importar el proyecto maven en tu IDE favorito (Eclipse, VS Code, etc.)

13. Agrega un archivo `application.yml` (o `application.properties`) en la raíz de tu classpath (se recomienda `src/main/resources`). 
Agrega las siguientes propiedades y valores utilizando el formato adecuado:

   ```yaml
   spring.application.name=lab-3-client
   spring.cloud.config.uri=http://localhost:8001
   server.port=8002
   ```

   Nota. En principio, el archivo de configuración debía llamarse `bootstrap.properties o bootstrap.yml`, pero en la última versión de SpringBoot este archivo de configuración ha pasado a _deprecated_. La configuración del puerto del servidor se puede especificar en cualquiera de los archivos, pero la URI del servidor de configuración afecta a la secuencia de inicio.

14. Agrega un controlador REST para obtener y mostrar la palabra de la suerte:

   ```java
   @RestController
   public class LuckyWordController {
  
     @Value("${lucky-word}") 
     String luckyWord;
  
     @GetMapping("/lucky-word")
     public String showLuckyWord() {
       return "La palabra de la suerte es: " + luckyWord;
     }
   }
   ```

15. Inicia tu cliente. Abre [http://localhost:8002/lucky-word](http://localhost:8002/lucky-word). Deberías ver el mensaje de la palabra de la suerte en tu navegador.

> (Nota: si recibes un error y tu servidor [arriba] funciona correctamente, primero confirma que tu cliente está contactando efectivamente a tu servidor. La salida en la consola del cliente debería contener información al respecto):

```bash
2023-10-13 10:47:14.615  INFO 198268 --- [           main] o.s.c.c.c.ConfigServerConfigDataLoader   : Fetching config from server at : http://localhost:8001
2023-10-13 10:47:14.615  INFO 198268 --- [           main] o.s.c.c.c.ConfigServerConfigDataLoader   : Located environment: name=lab-3-client, profiles=[default], label=null, version=624a8660be89a5093b01325d60960c14cce3c3d3, state=null
```


16. Podría crearse un script para ejecutar todas la aplicaciones involucradas en el proyecto 

```bash
#!/bin/bash 


# Ejecutar confir-server
sleep 2
cd config_server
pwd
x-terminal-emulator -e mvn spring-boot:run & 
cd ..

# Ejecutar cliente config server
sleep 2
cd config-client
pwd
x-terminal-emulator -e mvn spring-boot:run & 
cd ..
```
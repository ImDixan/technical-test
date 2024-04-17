# Bienvenidos a Waste Managers System

El presente sistema de gestión, construido con Spring Boot, está diseñado para revolucionar la forma en que gestionas los residuos.
Con Spring Boot, ofrecemos una plataforma robusta, eficiente y fácil de usar. Waste Managers System aprovecha la simplicidad y
la flexibilidad de Spring Boot para proporcionarte una solución de gestión de residuos de alto rendimiento. Lleva tu gestión de residuos al siguiente nivel

---

### Requerimientos

Para compilar y ejecutar la aplicación, necesita tener **Java 21** y **Maven 3** instalados en su máquina.

---

### Compilación y Ejecución de la Aplicación

Después de instalar el software requerido, puede compilar y ejecutar los diversos servicios usando los siguientes comandos:

#### Windows

- Abra un símbolo del sistema y navegue hasta el directorio raíz del proyecto. Luego, ejecute el siguiente comando para compilar
  la aplicación:

  > mvn clean install

  Esto creará un archivo JAR en el directorio de destino "target" de cada módulo.


- Para ejecutar los servicios en perfil dev, ejecute el siguiente comando en el directorio destino ( remplazar [modulo] por el nombre del modulo):
  > java -jar [modulo]-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=dev

---
### Servicios de la aplicación

El sistema esta compuesto por varios servicios o módulos los cuales van a ser descritos a continuación:

- **eureka-server** : Es el encargado del registro y descubrimiento de microservicios.
- **cloud-config-server** : Gestiona de manera centralizada y las configuraciones de lo microservicios del entorno.
- **gateway-service** : Proporciona un punto centralizado para manejar las solicitudes Http entrantes y las enruta a los microservicios apropiados.
- **waste-manager-service** : Servicio que gestiona los Waste Managers.
- **waste-manager-address-service** : Servicio que gestiona la dirección de los Waste Managers de manera externa.

#### Orden de ejecución de los servicios

Para el correcto funcionamiento del sistema se deben levantar los servicios en el siguiente orden:

1. **eureka-server**.
2. **cloud-config-server**.
3. **waste-manager-address-service**.
4. **waste-manager-service**.
5. **gateway-service**.

#### Herramienta opcional

Puede ejecutar los servicios en orden de manera automatica de la siguiente manera:

1. Copie los archivos de compilacion de salida de cada servicio (ejemplo: **_waste-manager-service-0.0.1-SNAPSHOT.jar_**) en el siguiente directirio en la raiz del repositorio : **_Utiles\Microservicios\Servicios_**.
2. Doble click en el archivo **_Iniciar_Servicios.bat_** ubicado en el directorio **_z-utiles\Microservicios\Servicios_**.
- Puede ejecutar los servicios de manera independiente dando doble click en los otros archivos **_.bat_**.


---

### Probando Endpoints con Postman

Puede probar los endpoints de la aplicación Spring Boot usando Postman siguiendo estos pasos:

- Importe en Postman el archivo llamado: **_Waste Management.postman_collection.json_** localizado en la carpeta **_"z-utiles"_** en la raiz del repositorio.
- Inicie los sevicios de Spring Boot en el orden correspondiente.
- Utilice las request contenidas en la colección importada.

---

### Sobre la Aplicación

TEste sistema ha sido desarrollado bajo el entorno Java utilizando Spring Boot, así como un conjunto de frameworks y
bibliotecas para lograr un rendimiento óptimo de la aplicación.
Dispone de una organización y agrupación de clases en paquetes para facilitar el trabajo en equipo y el apoyo:

- **controllers:** Contiene los endpoints de las funcionalidades requeridas que utilizan los servicios.
- **services:** Contiene la lógica de las funcionalidades requeridas utilizando modelos y repositorios..
- **repositories:** Este contiene los repositorios que son responsables de las interacciones con la base de datos utilizando los modelos.
- **models:** Representación de las entidades que serán gestionadas en el caso de uso.
- **dtos:** Modificaciones de los modelos con el fin de manejar, organizar y proteger los datos en las peticiones cliente-servidor web.


Las bases de datos H2 se encuentra en la raíz del proyecto en: **_data/ *.mv.db_**.


---

### _Autor:_ _Ing. Dixan Hernández Matos_
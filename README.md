# UnidadesMetrobus

Este proyecto consiste en analizar los datos abiertos de la ciudad de mexico relacionados con las unidades y su ubicacion

En la carpeta Diagramas se pueden encontrar los casos de uso de solucion para ver :
  Caso 1: Lista de Unidades Disponibles
  Caso 2: Historial de una unidad por ID
  Caso 3: Alcladiass disponibles
  Caso 4: Unidades dentro de una alcaldia

En la carpeta Modelo se puede encontrar la creacion de la bd, el archivo de carga inicial, el diagrama de la bd asi como una imagen del mismo y un respaldo de la bd con ya datos previos.
En la carpeta apis-metrobus-service se encuentra el proyecto desarrollado en Java con la implementacion de la solucion.
  Internamente aqui tambien se encuentre el archivo Dockerfile y el apis-metrobus-deployment.yml para kubernetes

Adicionalmente se puede ver la coleccion de postman con los casos de prueba
apis-ubicacion-unidades-metrobus.postman_collection.json
tambien el archivo Despliegue kubernetes.txt contien informacion referente a la creacion de la imagen del proyecto con docker y lo necesario para su despliegue en kubernetes.

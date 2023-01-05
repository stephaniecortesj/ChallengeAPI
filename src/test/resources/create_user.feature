#language: es
#Autor: Stephanie Cortes

Característica: Yo como usuario de Reqres
  deseo realizar el consumo de los diferentes apis
  para validar la creación, consulta, actualización y eliminación de usuarios


  @create
  Esquema del escenario: crear usuarios
    Cuando Luis envia <name> y <job>
    Entonces obtengo el codigo de respuesta 201
    Y valido que el usuario se cree correctamente

    Ejemplos:
    |name   |   job     |
    |stepha | Automation|


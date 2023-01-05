#language: es
#Autor: Stephanie Cortes

Característica: Yo como usuario de Reqres
  deseo realizar el consumo de los diferentes apis
  para validar la creación, consulta, actualización y eliminación de usuarios


  @test
  Escenario: Listar usuarios existentes
    Cuando Luis realiza la consulta de los usuarios existentes
    Entonces obtengo el estado 200
    Y valido que la lista de usuarios exista George
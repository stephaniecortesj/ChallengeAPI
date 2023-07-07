#language: en
#Autor: Stephanie Cortes

Feature: As a user of Reqres
  I wish to perform the consumption of the different apis
  to validate the creation, consultation, update and deletion of users.


  @test
  Scenario: List existing users
    When Luis querying existing users
    Then I get the status 200
    And valid user list exists George
#language: en
#Autor: Stephanie Cortes

Feature: As a user of Reqres
I wish to perform the consumption of the different apis
to validate the creation, consultation, update and deletion of users.



@create
Scenario Outline: create users successfully
   When Luis sends <name> and <job>
   Then I get response code 201
   And valid that the user <name> is created correctly


Examples:
   |name    |   job     |
   |stepha  | Automation|
   |carlos  | QA|
   |alberto | Engineer|


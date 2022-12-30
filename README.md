# Appium-Java-Cucumber
Projeto portifólio de automação de testes de aplicações mobile

# O que preciso Ter Configurado para Rodar o Projeto

Appium Server 

Android Home

Java Home

Node

Android Studio instalado

Xcode Instalado ( Se quiser rodar IOS )


#Como faço para rodar o projeto local?


Android:
mvn test -Dlocal=local -Dplatform=android

IOS:
mvn test -Dlocal=local -Dplatform=ios

#Como faço para rodar o projeto no device farm?
OBS:
Configurar antes os parâmetros do Browserstack. Depois de configurado, rodar os comandos abaixo:

Android:
mvn test -Dlocal=devicefarm -Dplatform=android

IOS:
mvn test -Dlocal=devicefarm -Dplatform=ios


Quer conhecer mais de meus trabalhos?
Acesse meu repositório GIT.
https://github.com/israfaioli?tab=repositories

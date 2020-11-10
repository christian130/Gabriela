English
=====
If you want to see an in-action video of this software please you can go to https://drive.google.com/file/d/0B0CMYtyUcMLPT2FEQ1VaajhBNDA/view?usp=sharing

In order to run this code you should follow the steps bellow

Spanish
=====
Si quieres ver una demostracion del despliegue de este software en este branch en particular, por favor ve a este link https://drive.google.com/file/d/0B0CMYtyUcMLPT2FEQ1VaajhBNDA/view?usp=sharing
si deseas levantar este software debes clonar este repositorio y entrar en esta rama y lanzar los comandos desde esta rama

Pasos a seguir / Steps
=====

In order to to run this code you have to install GIT and MAVEN https://maven.apache.org/install.html

```
git clone https://github.com/christian130/Gabriela.git
sh getBranches.sh
git checkout branch-estable
```

```
mvn -Dmaven.test.skip=true clean install
mvn spring-boot:run
```


```
ir a la siguiente direccion e ingresar el usuario y contraseña suministrados aqui
http://localhost:12000
```
luego
```
usuario: user
password: 123456
```
luego a esto al caer en login.html (el responsive no funciona), ingresar 
```
admin
12345
```

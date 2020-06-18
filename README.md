```
#!java
IMPORTANTE: NO SE NECESITA ALGUN IDE PARA LEVANTAR LA APLICACION... BASTA CON EL JDK 8
git clone https://christian130@bitbucket.org/christian130/conexus.git
```

o puede loguearse desde la web a bitbucket.org y va a tener acceso como administrador para ese repositorio

una vez ahi los pasos para levantar el servidor estan embedidos, y es como sigue


```
#!java

mvn -Dmaven.test.skip=true clean install
mvn spring-boot:run
```


```
ir a la siguiente direccion e ingresar el usuario y contraseña suministrados aqui (esto es obra de spring security)
http://localhost:12000
```
luego
```
usuario: user
password: 123456
```
luego a esto al caer en login.html (el responsive no funciona), ingresar 
```
en el usuario admin
y en el password 12345
```

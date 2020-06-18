IMPORTANTE, NO COMPILA EL CODIGO! TAMBIEN SE TIENE QUE INSTALAR UNA BASE DE DATOS ORACLE LA CUAL NO ESTA DISPONIBLE
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
```
#!java
localhost:12000
```

```
#!java
usuario: user
password: 123456

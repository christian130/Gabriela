
```
#!java

git clone https://christian130@bitbucket.org/christian130/conexus.git
```

o puede loguearse desde la web a bitbucket.org y va a tener acceso como administrador para ese repositorio

una vez ahi los pasos para levantar el servidor estan embedidos, y es como sigue


```
#!java

mvn -Dmaven.test.skip=true clean install
mvn spring-boot:run
```

cuando ingrese este comando el spring security esta activado y le va a aparecer una clave de seguridad algo parecido a esto


```
#!java

Using default security password: 520774a4-3ff8-4e38-abe1-ae3c9215fea9
```



el usuario es user y la clave es la suministrada por spring security... en este caso es: 520774a4-3ff8-4e38-abe1-ae3c9215fea9
luego de esto sigo con el avancehe configurado para que el puerto por defecto del tomcat sea el 12000


```
#!java

localhost:12000
```
# Variaciones sobre una lista simple

Partiendo del código de listas básicas revisado en clase, y publicado [aquí](/src/listas/basica/)

El reto consiste en agregar funcionalidad sin alterar la esencia del código.

||
|-|
Optimizar el proceso de saber cuántos elementos tiene la lista.
Para este caso concreto, hacer más descriptivo el proceso de entrada y salida de elementos (*entró xxx*, *salió yyy*).
Verificar que los cambios en las clases Node y List funcionan ejecutandolas a través de la clase Ejemplo.

## Reglas de entrega

- Tener resueltos ambos retos.
- Se exige código limpio.
- Se reciben entregas a la rama Reto-003 hasta las 23:59:59 del jueves 19 de octubre de 2023.

### Sugerencia de presentación

#### Presentación actual

```
LA FILA------------------
-------------------------
Esta vacia? true
Esta vacia? false
LA FILA------------------
Juanito
Pepito
Anita
-------------------------
Tamaño: 4
Tamaño: 3
LA FILA------------------
Juanito
Pepito
Anita
-------------------------
```

#### Presentación deseada

```
LA FILA------------------
-------------------------
Esta vacia? true
 > Llegó Juanito
 > Llegó Pepito
 > Llegó Anita
Esta vacia? false
LA FILA------------------
Juanito
Pepito
Anita
-------------------------
 > Llegó Luisito
Tamaño: 4
Se fue Luisito
Tamaño: 3
LA FILA------------------
Juanito
Pepito
Anita
-------------------------
┏[manuel]--[main ≡ ● ]
┖[~/misRepos/23-24-eda1]
```
# ATRIBUTOS PRIVADOS PYTHON

En python para declarar un atributo privado se debe anteponer dos guiones bajos al nombre del atributo.

```python
class Persona:
    def __init__(self, nombre, apellido, edad):
        self.__nombre = nombre
        self._apellido = apellido
        self.edad = edad
```

* No poner nada declara el atributo como público. Puede ser accedido desde fuera de la clase.

* Un guion bajo(_apellido) antes del nombre del atributo indica que el atributo es privado y no debería ser accedido directamente desde fuera de la clase. Es más una convención que una restricción fuerte. Otros programadores que vean el código entenderán que es un detalle de implementación interno y deberían evitar acceder a él directamente.

* Dos guiones bajos(__nombre) antes del nombre del atributo activan un mecanismo en Python llamado "name mangling" (alteración de nombre). Python cambiará el nombre del atributo para incluir el nombre de la clase, lo que hace que el atributo sea difícil de acceder desde fuera de la clase y ayuda a prevenir conflictos de nombres en subclases.

# Examen Final EDA I 💻🌐

A continuación en la presente estructura de carpetas se pueden ver la carpeta de Documentación que contiene el **Diagrama de clases** y el **Diagrama de Objetos** tanto en código como imagen .svg para su mejor visualización, por otro lado está la carpeta de DeArrayList-TO-Arboles que tendrá la programación solicitada en el examen final.

## Documentación 📄

### Digrama de Clases

![Texto Alternativo](/entregas/sergioMayen/ExamenFinal/Documentacion/imagenes/DiagramaClases.svg)

<details>
  <summary>Código UML</summary>

    @startuml

    class Main{
    }

    class Paciente{
        + nombre
        + fechaAlta
    }

    class Encuesta{
        - realizarEncuesta()
        - agregarAlimento()
    }

    class Dia{
        - validarNumeroDias()
        - agregarAlimento()
    }

    class Alimento{
        + nombre
    }

    Main -- Paciente
    Main -- Dia
    Dia -- Encuesta
    Encuesta -- Alimento

    @enduml
</details>

### Diagrama de Objetos 

![Texto Alternativo](/entregas/sergioMayen/ExamenFinal/Documentacion/imagenes/DiagramaObjetos.svg)

<details>
  <summary>Código UML</summary>

    @startuml

    class Main{
    }

    class Paciente{
        + nombre
        + fechaAlta
    }

    class Encuesta{
        - realizarEncuesta()
        - agregarAlimento()
    }

    class Dia{
        - validarNumeroDias()
        - agregarAlimento()
    }

    class Alimento{
        + nombre
    }

    Main -- Paciente
    Main -- Dia
    Dia -- Encuesta
    Encuesta -- Alimento

    @enduml
</details>
# Encuestas y dietas

La valoración nutricional a partir de encuestas de 24 horas se refiere a un método utilizado en nutrición para evaluar la ingesta dietética de una persona durante un período específico de 24 horas. 

Esta técnica es una herramienta común en estudios epidemiológicos y en la práctica clínica para obtener una instantánea de los hábitos alimentarios de un individuo. 

## Proceso 

### Recolección de datos

Se realiza una entrevista detallada con el individuo, donde se le pide que recuerde y describa todo lo que comió y bebió durante las últimas 24 horas. Esto incluye comidas, bebidas, snacks, y cualquier suplemento.

### Detalles específicos

Se solicita al individuo que proporcione detalles específicos como la cantidad de alimentos consumidos, los métodos de preparación, las marcas de los productos, y los tamaños de las porciones.

### Análisis de nutrientes

Los datos recopilados se analizan para estimar la ingesta de nutrientes como calorías, proteínas, grasas, carbohidratos, vitaminas y minerales. Esto se hace utilizando tablas de composición de alimentos o software de análisis dietético.

### Evaluación de la ingesta dietética

La ingesta de nutrientes se compara con las recomendaciones dietéticas estándar para determinar si el individuo está consumiendo una dieta equilibrada y suficiente.

### Identificación de patrones alimentarios

Además de evaluar la ingesta de nutrientes, las encuestas de 24 horas pueden ayudar a identificar patrones alimentarios, como el consumo de alimentos altos en azúcar, grasas saturadas, o la falta de frutas y verduras.

### Consideraciones de variabilidad

Dado que las dietas pueden variar de un día a otro, a menudo se realizan múltiples encuestas de 24 horas en días no consecutivos, incluyendo días de semana y fines de semana, para obtener una imagen más precisa de la dieta habitual de la persona.

## Aplicabilidad

- En el contexto clínico, estos datos ayudan en la planificación de intervenciones nutricionales personalizadas.

- En la investigación, sirve para estudiar las relaciones entre la dieta y la salud en poblaciones.

La valoración nutricional a partir de encuestas de 24 horas es un método valioso, pero tiene limitaciones, como el sesgo de memoria y la variabilidad en la ingesta diaria. Por ello, a menudo se utiliza junto con otros métodos de evaluación dietética para obtener una visión más completa del estado nutricional de una persona o de una población.


## Reto

Desarrollar un sistema para gestionar encuestas de 24 horas que recopilen datos sobre la ingesta alimentaria de individuos. Utilizaremos las estructuras de datos vistas en la asignatura para organizar y almacenar los datos de las encuestas.


|Paciente|Encuesta|Dias|Ingestas|Alimentos|
|-|-|-|-|-
Nombre|Fecha de toma|Hasta 5 días|Desayuno|Los que indique el paciente
Fecha alta|||Media mañana
||||Almuerzo
||||Merienda
||||Cena

```
Paciente
    Encuesta
        Dia 1
            Desayuno
                Café con leche
                Tostadas
                Huevos revueltos
            Media mañana
            Almuerzo
            Merienda
            Cena
        Dia 2
        Dia 3
        Dia 4
        Dia 5
```

## Propuesta de interfaz

Modo texto

```
Paciente: Jose Manuel R.
Seleccione día: 3
Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)
1
Ingrese un alimento del Desayuno del día 3 (-1 para terminar / -2 para listar alimentos ingresados)
Café con leche
Ingrese un alimento del Desayuno del día 3 (-1 para terminar / -2 para listar alimentos ingresados)
Tostadas
Ingrese un alimento del Desayuno del día 3 (-1 para terminar / -2 para listar alimentos ingresados)
Huevos revueltos
Ingrese un alimento del Desayuno del día 3 (-1 para terminar / -2 para listar alimentos ingresados)
-1
Seleccione ingesta: 1 (Desayuno) / 2 (Media mañana) / 3 (Almuerzo) / 4 (Merienda) / 5 (Cena) / -1 (Menu anterior)
-1
```
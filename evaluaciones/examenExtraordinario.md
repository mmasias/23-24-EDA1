# Examen extraordinario

- Parte 1 - _in plan english_
- Parte 2 - Dev...

## Caso

### Refactorización del modelo

[**En este punto del repositorio**](https://github.com/mmasias/23-24-pyBurguer/tree/7802b921fdc026a6459ca21f31ee0864b29bb818/src), en la carpeta src tiene una propuesta de solución planteada por un alumno de Programación 2. Esta propuesta, aunque técnicamente interesante, se apoya en los conocimientos que se adquieren en esa asignatura: orientación a objetos y matrices, lo cual  presenta limitaciones evidentes: tamaño restringido, poca capacidad de "actualización", etc.

No se puede:

- Reorganizar los elementos.
- Quitar elementos.
- Agregar elementos intermedios.

Refactorice el modelo para permitir mayor flexibilidad, agregando los conceptos vistos en la asignatura.

### Solución propuesta

Convertir la hamburguesa en una lista de ingredientes:

- Ajuste en [Hamburguesa](https://github.com/mmasias/23-24-pyBurguer/blob/refactoringEDA1/src/Hamburguesa.java), inclusión de clases [Nodo](https://github.com/mmasias/23-24-pyBurguer/blob/refactoringEDA1/src/Nodo.java) y [ListaIngredientes](https://github.com/mmasias/23-24-pyBurguer/blob/refactoringEDA1/src/ListaIngredientes.java).

# Documentación Proyecto Encuestas
## Jose Manuel Rasilla Paz

Se ha desarrollado un proyecto entorno a la propuesta [Reto007](https://github.com/mmasias/23-24-eda1/blob/main/retos/007-Dietas/README.md) con la guía de utilizar Listas y Arboles como estructuras base.

Se ha tomado la decisión de crear un Paciente que tiene una lista de días. Cada uno de estos días es la raiz de un árbol. Cada comida es un nodo de ese arbol y cada alimento es una hoja.

El diagrama [UML](/Diagrama.puml) recoge las clases y funciones que se han desarrollado para el proyecto.

Partimos de tres clases para generar las estructuras Lista y Árbol. JavaList y ListNode para la lista y TreeNode para el árbol.

En orden las clases podría explicarse de la siguiente manera:
Un *Patient* tiene un *Survey* que tiene una lista de *Day*. Cada *Day* tiene 5 nodos *Meal* que tienen a su vez un número variable de nodos *Intake*.
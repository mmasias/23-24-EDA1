# Proyecto de Encuestas Nutricionales (ÁRBOLES)

Este proyecto se centra en la gestión de encuestas nutricionales que recopilan información sobre la ingesta alimentaria de individuos durante un período de 24 horas. El proyecto está estructurado en varias clases interconectadas que se utilizan para administrar y organizar los datos de las encuestas.

## Clases del Proyecto

### Clase Alimento

La clase **Alimento** representa un alimento individual y almacena su nombre. Esta clase es fundamental para registrar los alimentos consumidos en la encuesta. Sus características incluyen:

- **nombre**: Un atributo que almacena el nombre del alimento.
- **Constructor**: La clase cuenta con un constructor que recibe el nombre del alimento.
- **getNombre()**: Un método que permite obtener el nombre del alimento.

### Clase Nodo

La clase **Nodo** se utiliza para crear una estructura de árbol que organiza los datos de la encuesta. Puede contener datos de tipo String o una lista de String. Sus principales características son:

- **dato**: Un atributo que almacena el dato (String o lista de String) contenido en el nodo.
- **padre**: Un atributo que mantiene una referencia al nodo padre en la estructura del árbol.
- **Constructores**: La clase ofrece varios constructores para crear nodos con diferentes tipos de datos.
- **crearaiz()**: Un método para crear un nodo raíz en el árbol.
- **crearhijo()**: Un método para crear nodos hijos y agregarlos al árbol.

### Clase Arbol

La clase **Arbol** representa la estructura de árbol utilizada para organizar los datos de las encuestas nutricionales. Sus principales atributos y métodos son:

- **raiz**: Un atributo que almacena la referencia a la raíz del árbol.
- **EncuestaNutricional**: Una referencia a la clase de EncuestaNutricional que utiliza esta estructura de árbol.
- **arbol**: Una referencia a sí misma, que se utiliza para gestionar el árbol.
- **dato**: Un atributo que almacena datos (String).
- **Comida**: Una referencia a la clase de Comida que se utiliza para registrar alimentos consumidos.
- **dias**: Un contador de días que lleva un registro de los días de la encuesta.
- **Métodos**: La clase incluye métodos para crear el árbol, añadir ramas, definir el día actual y obtener el día actual.

### Clase Comida

La clase **Comida** se encarga de gestionar la información relacionada con los alimentos consumidos durante la encuesta. Sus características clave son:

- **alimentos**: Un atributo que almacena una cadena de alimentos.
- **lista**: Una lista que almacena los alimentos consumidos.
- **arbol**: Una referencia a la clase de Arbol para gestionar la estructura del árbol.
- **EncuestaNutricional**: Una referencia a la clase de EncuestaNutricional para registrar la información de la encuesta.
- **Métodos**: La clase ofrece métodos para añadir alimentos, mostrar alimentos ingresados y crear diferentes tipos de comidas (comida, media mañana, almuerzo, merienda, cena).

### Clase EncuestaNutricional

La clase **EncuestaNutricional** representa una encuesta de 24 horas relacionada con la ingesta alimentaria. Sus atributos y funcionalidades son:

- **Nodos**: Una lista de nodos utilizados para organizar la estructura de la encuesta.
- **arbol**: Una referencia a la clase de Arbol para gestionar la estructura del árbol.
- **Comida**: Una referencia a la clase de Comida para registrar alimentos consumidos.
- **Nodos Especiales**: La clase incluye nodos que representan días y tipos de comidas (comida, media mañana, almuerzo, merienda, cena).
- **Métodos**: Ofrece métodos para añadir nodos, crear una nueva encuesta nutricional y registrar la ingesta de alimentos para cada día.

## Resumen

En resumen, este proyecto utiliza una estructura de árbol para organizar la información de las encuestas nutricionales de 24 horas. La clase **Alimento** se encarga de representar los alimentos individualmente, mientras que las clases **Arbol**, **Comida** y **EncuestaNutricional** se utilizan para gestionar la estructura de las encuestas y registrar la ingesta alimentaria de los individuos en diferentes días y comidas. La interconexión de estas clases permite una gestión detallada de los datos de las encuestas nutricionales.

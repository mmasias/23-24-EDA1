# Encuesta Nutricional 

Este programa en Java implementa una aplicación de encuesta nutricional que permite a los usuarios registrar información sobre la ingesta diaria de alimentos. La aplicación utiliza una estructura de árbol para organizar los alimentos según el tipo de ingesta en cada día.

---
### Alimento

La clase `Alimento` representa un componente fundamental en la encuesta, ya que modela un alimento individual. Cada instancia de esta clase contiene el nombre de un alimento, permitiendo registrar información detallada sobre lo que consume el paciente.

### Dia

La clase `Dia` se encarga de representar un día específico en la encuesta nutricional. Utiliza un enfoque basado en árboles (`TreeNode`) para organizar los alimentos según el tipo de ingesta. Esto facilita la estructuración y visualización de los datos, permitiendo una representación jerárquica de la información.

### EncuestaNutricional

La clase `EncuestaNutricional` encapsula toda la información relacionada con la encuesta nutricional de un paciente. Contiene detalles como el nombre del paciente, la fecha de alta y una lista de días registrados. Su función principal es actuar como contenedor principal y gestionar la información global de la encuesta.

### GestorEncuesta

La clase `GestorEncuesta` actúa como una interfaz entre el usuario y el sistema, permitiendo simular la entrada de datos en la encuesta. Utiliza objetos de las clases anteriores para coordinar la interacción del usuario, agregando días, registrando alimentos y mostrando la encuesta completa.

### Ingesta

La clase `Ingesta` estaba presente en versiones anteriores del programa, pero se eliminó en esta versión. Su funcionalidad podría haber estado relacionada con la representación de una ingesta específica, pero actualmente no juega un papel activo en el programa.

### Main

La clase `Main` contiene el método principal (`main`) que inicia la ejecución del programa. Sirve como punto de entrada y crea una instancia del `GestorEncuesta`, dando inicio a la interacción con el usuario.

### TreeNode

La clase `TreeNode` se utiliza para construir la estructura de árbol en la clase `Dia`. Cada nodo puede representar un tipo de ingesta o un alimento específico. Los nodos se organizan jerárquicamente, proporcionando una visualización clara de la ingesta diaria en forma de árbol.

---
## Clases

### Alimento

**Descripción**
La clase `Alimento` representa un alimento individual y contiene información sobre su nombre.

**Atributos**
- `nombre` (String): Nombre del alimento.

**Métodos**
- `Alimento(String nombre)`: Constructor que inicializa el nombre del alimento.
- `getNombre()`: Retorna el nombre del alimento.

### Dia

**Descripción**
La clase `Dia` representa un día específico en la encuesta nutricional. Utiliza un árbol (`TreeNode`) para organizar los alimentos según el tipo de ingesta.

**Atributos**
- `numero` (int): Número del día.
- `ingestas` (TreeNode): Raíz del árbol que organiza las ingestas.

**Métodos**
- `Dia(int numero)`: Constructor que inicializa el número del día y la raíz del árbol de ingestas.
- `agregarAlimento(String tipoIngesta, Alimento alimento)`: Agrega un alimento asociado a un tipo de ingesta específico en el árbol.
- `findOrCreateTipoIngestaNode(String tipoIngesta)`: Método privado para encontrar o crear un nodo para un tipo de ingesta dado.
- `getNumero()`: Retorna el número del día.
- `getIngestas()`: Retorna la raíz del árbol de ingestas.

### EncuestaNutricional

**Descripción**
La clase `EncuestaNutricional` representa la encuesta nutricional en su totalidad. Contiene información sobre el nombre del paciente, la fecha de alta y una lista de días registrados.

**Atributos**
- `nombrePaciente` (String): Nombre del paciente.
- `fechaAlta` (String): Fecha de alta en formato dd/MM/yyyy.
- `dias` (List<Dia>): Lista de días registrados en la encuesta.

**Métodos**
- `EncuestaNutricional(String nombrePaciente, String fechaAlta)`: Constructor que inicializa el nombre del paciente, la fecha de alta y la lista de días.
- `getNombrePaciente()`: Retorna el nombre del paciente.
- `getFechaAlta()`: Retorna la fecha de alta.
- `getDias()`: Retorna la lista de días registrados.
- `agregarDia(Dia dia)`: Agrega un día a la lista de días registrados.

### GestorEncuesta

**Descripción**
La clase `GestorEncuesta` es responsable de interactuar con el usuario para simular la entrada de datos en la encuesta nutricional. Utiliza un objeto de la clase `EncuestaNutricional` para gestionar la encuesta.

**Atributos**
- `scanner` (Scanner): Objeto Scanner para la entrada de datos desde la consola.
- `encuesta` (EncuestaNutricional): Objeto que representa la encuesta nutricional.

**Métodos**
- `GestorEncuesta()`: Constructor que inicializa el Scanner.
- `simular()`: Método principal que simula la interacción con el usuario.
- `mostrarMenu()`: Muestra el menú de opciones.
- `agregarDia()`: Permite al usuario agregar un día a la encuesta.
- `registrarAlimento()`: Permite al usuario registrar un alimento asociado a un día y tipo de ingesta.
- `mostrarEncuesta()`: Muestra la información completa de la encuesta nutricional.
- `mostrarArbol(TreeNode node, int nivel)`: Método privado que muestra la estructura del árbol de ingestas.

### Main

**Descripción**
La clase `Main` contiene el método principal (`main`) que inicia la ejecución del programa creando un objeto `GestorEncuesta` y llamando al método `simular()`.

**Métodos**
- `main(String[] args)`: Método principal que inicia el programa.

### TreeNode

**Descripción**
La clase `TreeNode` representa un nodo en el árbol de ingestas. Cada nodo puede contener un tipo de ingesta o un alimento y tiene una lista de nodos hijos.

**Atributos**
- `tipoIngesta` (String): Tipo de ingesta si el nodo representa un tipo de ingestas.
- `alimento` (Alimento): Alimento asociado si el nodo representa un alimento.
- `children` (List<TreeNode>): Lista de nodos hijos.

**Métodos**
- `TreeNode(String tipoIngesta)`: Constructor para nodos que representan tipos de ingestas.
- `TreeNode(Alimento alimento)`: Constructor para nodos que representan alimentos.
- `getTipoIngesta()`: Retorna el tipo de ingesta del nodo.
- `addChild(TreeNode child)`: Agrega un nodo hijo al nodo actual.
- `getAlimento()`: Retorna el alimento asociado al nodo.
- `getChildren()`: Retorna la lista de nodos hijos.

## Ejecución del Programa

Para ejecutar el programa, simplemente inicia la clase `Main`. La aplicación guiará al usuario a través de opciones para agregar días, registrar alimentos y mostrar la encuesta completa. El proceso continúa hasta que el usuario decide salir.





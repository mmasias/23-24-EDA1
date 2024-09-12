
# Encuestas de Dietas 
EL proyecto consiste en desarrollar un programa sencillo que realice un encuesta alimentaria al usuario, recolectando los alimentos ingeridos en cada ingesta (Desayuno, almuerzo, comida, merienda y cena) sobre 5 días.

### Main
La clase **Main** es la clase principal del programa. Esta clase se encarga de crear una instancia de la clase **InterfazUsuario** para interactuar con el usuario y luego ejecutar la encuesta alimentaria a través de una instancia de la clase EncuestaAlimentaria.
___
### EncuestaAlimentaria
Esta clase maneja la lógica de la encuesta alimentaria. Se encarga de iniciar la encuesta, recopilar información sobre la alimentación diaria del paciente y mostrar un resumen al final. Mantiene una asociación con la clase **Paciente**, ya que necesita datos del paciente para la encuesta.
___
### InterfazUsuario
Esta clase se ocupa de la interacción con el **usuario**. Muestra instrucciones, recopila información del usuario (como nombre, edad, peso, etc.) y valida estas entradas. Actúa como **intermediaria entre el usuario** y el resto del programa.
___
### Paciente
Representa a un paciente en el sistema. Almacena datos personales como nombre, edad, altura, peso y frecuencia de ejercicio. Esta clase es crucial para personalizar la experiencia de la encuesta según las características del paciente.
___
### DiaAlimentacion
Se encarga de representar un día específico en la **encuesta alimentaria**. Contiene un **conjunto de Ingesta**, cada una representando una comida o momento de ingesta (como desayuno, almuerzo, etc.) durante ese día.
___
### Ingesta
Representa una ingesta específica de alimentos (por ejemplo, el desayuno). Contiene una **lista de Alimento**, que son los diferentes alimentos consumidos en esa ingesta.
___
### Alimento
Esta clase representa un **alimento individual**. Básicamente, es la ***unidad más pequeña*** de información en nuestra encuesta, detallando un ítem específico de comida o bebida.
___
### Tree y TreeNode
Estas clases son un poco más técnicas y se utilizan para **almacenar y organizar los datos** en una estructura de **árbol**. Tree es una **estructura genérica** que puede almacenar diferentes tipos de datos **(como DiaAlimentacion e Ingesta)**, y TreeNode representa cada **nodo** en este árbol, conteniendo datos y referencias a otros nodos **(hijos)**.
___
### List y Node
La **clase List** es una implementación genérica de una lista enlazada.
**Atributo head:** Es el primer **nodo** (o elemento) de la lista. Si la lista está vacía, head es null.
**Método add(T data):** Permite **agregar un nuevo elemento al final de la lista**. Si la lista está vacía (es decir, head es null), el nuevo nodo se convierte en el head. Si no, recorre la lista hasta encontrar el último nodo y agrega el nuevo nodo allí.
**Método getFirst():** **Devuelve** los datos almacenados en el **primer nodo** de la lista. Si la lista está vacía, devuelve null o podría manejarse de otra manera según sea necesario.

La clase **Node** representa un nodo individual en una **lista enlazada**. Cada nodo contiene datos y una referencia al siguiente nodo en la lista.


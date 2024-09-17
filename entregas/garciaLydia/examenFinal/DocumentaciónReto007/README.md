# Encuesta Nutricional

Este programa en Java implementa una aplicación de encuesta nutricional que permite a los usuarios registrar información sobre la ingesta diaria de alimentos. La aplicación se divide en varias clases, cada una con un propósito específico.

## Funcionalidad del Programa

El programa consta de las siguientes clases:

- **Alimento**: Representa un alimento individual con su respectivo nombre.
- **Dia**: Representa un día específico en la encuesta nutricional, incluyendo información sobre el número del día, los tipos de ingestas registradas y los alimentos asociados a cada tipo.
- **EncuestaNutricional**: Representa la encuesta nutricional en su totalidad, incluyendo el nombre del paciente, la fecha de alta y una lista de días registrados.
- **GestorEncuesta**: Gestiona la interacción con el usuario, permitiéndole simular la entrada de datos en la encuesta nutricional.
- **Ingesta**: Representa una ingesta específica en un día de la encuesta, incluyendo el tipo de ingesta y el alimento asociado.
- **Main**: Contiene el método principal que inicia la ejecución del programa.

## Alimento

**Descripción**
La clase `Alimento` representa un alimento individual y contiene información sobre su nombre.

**Atributos**
- `nombre` (String): Nombre del alimento.

**Métodos**
- `Alimento(String nombre)`: Constructor que inicializa el nombre del alimento.
- `getNombre()`: Retorna el nombre del alimento.

---

## Dia

**Descripción**
La clase `Dia` representa un día específico en la encuesta nutricional. Contiene información sobre el número del día, los tipos de ingestas registradas y los alimentos asociados a cada tipo de ingesta.

**Atributos**
- `numero` (int): Número del día.
- `tiposIngesta` (List<String>): Lista de tipos de ingestas registradas en el día.
- `alimentosPorTipo` (List<List<Alimento>>): Lista de listas que contiene alimentos asociados a cada tipo de ingesta.

**Métodos**
- `Dia(int numero)`: Constructor que inicializa el número del día y las listas de tipos de ingestas y alimentos asociados.
- `agregarAlimento(String tipoIngesta, Alimento alimento)`: Agrega un alimento asociado a un tipo de ingesta específico.
- `getNumero()`: Retorna el número del día.
- `getTiposIngesta()`: Retorna la lista de tipos de ingestas registradas.
- `getAlimentosPorTipo()`: Retorna la lista de listas de alimentos asociados a cada tipo de ingesta.

---

## EncuestaNutricional

**Descripción**
La clase `EncuestaNutricional` representa la encuesta nutricional en su totalidad. Contiene información sobre el nombre del paciente, la fecha de alta y una lista de días registrados en la encuesta.

**Atributos**
- `nombrePaciente` (String): Nombre del paciente.
- `fechaAlta` (String): Fecha de alta en formato dd/MM/yyyy.
- `dias` (List<Dia>): Lista de días registrados en la encuesta.

**Métodos**
- `EncuestaNutricional(String nombrePaciente, String fechaAlta)`: Constructor que inicializa el nombre del paciente, la fecha de alta y la lista de días.
- `getNombrePaciente()`: Retorna el nombre del paciente.
- `getFechaAlta()`: Retorna la fecha de alta.

---

## GestorEncuesta

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

---

## Ingesta

**Descripción**
La clase `Ingesta` representa una ingesta específica en un día de la encuesta nutricional. Contiene información sobre el tipo de ingesta y el alimento asociado.

**Atributos**
- `tipo` (String): Tipo de ingesta (Desayuno, Media mañana, Almuerzo, Merienda, Cena).
- `alimento` (Alimento): Objeto de la clase Alimento asociado a la ingesta.

**Métodos**
- `Ingesta(String tipo, Alimento alimento)`: Constructor que inicializa el tipo de ingesta y el alimento asociado.
- `getTipo()`: Retorna el tipo de ingesta.
- `getAlimento()`: Retorna el alimento asociado.

---

## Main

**Descripción**
La clase `Main` contiene el método principal (`main`) que inicia la ejecución del programa creando un objeto `GestorEncuesta` y llamando al método `simular()`.

**Métodos**
- `main(String[] args)`: Método principal que inicia el programa.

---

**Ejecución del Programa**
Para ejecutar el programa, se debe ejecutar la clase `Main`. Esta clase crea un objeto `GestorEncuesta` y llama al método `simular()`, que guía al usuario a través de las opciones de la encuesta nutricional. El programa permite agregar días, registrar alimentos y mostrar la encuesta completa. El proceso continúa hasta que el usuario elige salir.

---

![Diagrama](https://github.com/lydiaa-gr/23-24-eda1/blob/main/entregas/garciaLydia/examenFinal/Imagenes/UML.png)

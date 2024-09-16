
## Clases

### 1. Alimento

La clase `Alimento` representa un alimento con los siguientes atributos:
- `nombre`: Nombre del alimento.
- `cantidad`: Cantidad del alimento consumida.
- `unidad`: Unidad de medida de la cantidad del alimento (por ejemplo, gramos, unidades).

#### Métodos en la Clase `Alimento`

- **Constructor**: El constructor `public Alimento(String nombre, double cantidad, String unidad)` inicializa los atributos del objeto `Alimento` con los valores proporcionados.

### 2. DiaAlimentos

La clase `DiaAlimentos` gestiona la lista de alimentos consumidos en un día específico. Tiene el siguiente atributo:
- `alimentos`: Lista (`ArrayList`) de objetos `Alimento`.

#### Métodos en la Clase `DiaAlimentos`

- **Constructor**: El constructor `public DiaAlimentos()` inicializa la lista de alimentos vacía.
- **`agregarAlimento`**: El método `public void agregarAlimento(Alimento alimento)` añade un objeto `Alimento` a la lista de alimentos del día.
- **`listarAlimentos`**: El método `public void listarAlimentos()` imprime por consola los alimentos ingresados en el día.

### 3. Encuesta24Horas

La clase principal `Encuesta24Horas` gestiona la encuesta completa. Tiene los siguientes atributos:
- `persona`: Nombre de la persona para la cual se realiza la encuesta.
- `alimentosPorDia`: Lista (`ArrayList`) de objetos `DiaAlimentos`, organizados por día de la encuesta.

#### Métodos en la Clase `Encuesta24Horas`

- **Constructor**: El constructor `public Encuesta24Horas(String persona)` inicializa la encuesta con el nombre de la persona y una lista de días vacía.
- **`agregarAlimento`**: El método `public void agregarAlimento(int dia, Alimento alimento)` añade un objeto `Alimento` a la lista de alimentos del día especificado.
- **`realizarEncuesta`**: El método `public void realizarEncuesta(Scanner scanner)` inicia la interacción con el usuario, solicitando el día de la encuesta y llamando a `realizarEncuestaDia`.
- **`realizarEncuestaDia`**: El método `private void realizarEncuestaDia(int dia, Scanner scanner)` gestiona la encuesta para un día específico, solicitando al usuario que seleccione una ingesta y llamando a `realizarEncuestaComida`.
- **`realizarEncuestaComida`**: El método `private void realizarEncuestaComida(int dia, int ingesta, Scanner scanner)` permite al usuario ingresar alimentos para una ingesta específica del día.

## Ejecución del Programa

El programa inicia desde la clase `Main`, que instancía un objeto `Encuesta24Horas` y llama al método `realizarEncuesta` para comenzar la interacción con el usuario.

## Diagrama

![Diagrama](https://github.com/LavinAguado/23-24-eda1/blob/main/entregas/lavinDaniel/imagenes/Markdownreto007.png)



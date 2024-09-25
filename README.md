# TallerLab02
_Eduardo Huidobro -> vaass0_

### Analisis del codigo

El primer error se presenta al inicializar el array registro:

`String [][] registro = new double[50][3];`

Intenta definir un array de Strings pero inicializa un array de double, por lo que hay error del tipo de dato que maneja el array.
Este es el principal error del codigo, ya que luego al intentar tratar los datos de registro, estos no podran ser tratados.

Luego cuando al presentar el memnu no considera la opcion de que el usuario ponga numeros mayores a 6, por lo que no lo identifica como error si no que terminaria el programa, al igual que con numeros menores a 0.

`try {
a = new Scanner(System.in).nextInt();
} catch (InputMismatchException e) {
System.err.println("Opción inválida");
}
}while (a > 0 || a < 6)`

Tambien en uno de los scanners de mas abajo se solicita un int y este scanner entrega un string.

`try {
edad = new Scanner(System.in).nextLine();
} catch (InputMismatchException e) {
System.err.println("Opción inválida");`

Mas abajo se prensenta un error similar intentando utilizar un metodo de string a un double.

`if (persona[2] >= 60 && persona[1].equals("casado/a")) {
mmmm++;
} else if(persona[2] >= 65 && persona[1].equals("soltero/a")) {
mmmm++;
}`

Por esto en el codigo ademas de arreglar los errores mencionados, utilizaremos un array de Strings y luego los transformaremos al dato necesario cuando debamos tratar con ellos,
esto nos permitira un desarrollo mas comodo y ordenado del programa, ademas de un mayor control en los datos.

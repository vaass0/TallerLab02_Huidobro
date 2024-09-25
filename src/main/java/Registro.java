import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
       mostrarMenu();
    }
    public static void mostrarMenu(){
        String [][] registro = new String[50][3];
        int a = 0; // se cambio el valor de a por 0

        do {
            System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);

                // se elimina el do while por un while solo y se añade un verificador para las opciones
                while(true){
                 try {
                    System.out.print("Ingrese opcion: ");
                    a = new Scanner(System.in).nextInt();
                    if( a<= 6 && a > 0){
                        break;
                    }
                    System.out.println("Ingrese un opcion invalida");
                 } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                 }
                }


            if(a == 1) {
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    String edad; //cambio de int a string

                    while(true) {
                        try {
                            System.out.print("Ingrese nombre: ");
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }

                    while(true) {
                        try {
                            System.out.print("Ingrese estado civil: ");
                            Estadocivil = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }

                    while(true) {
                        try {
                            System.out.print("Ingrese edad: ");
                            edad = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }

                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if(a == 2) {
                int mayoresDeEdad = 0;

                for (String [] persona : registro) {
                    if (Integer.parseInt(persona[2]) >= 18) mayoresDeEdad++;
                }

                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(a == 3) {
                int menoresDeEdad = 0;
                // se elimina queSera ya que es innecesario y poco representativo

                for (String [] persona : registro) {
                    // se cambia las condicional para que se pueda realizar la comparacion.
                    if (Integer.parseInt(persona[2]) < 18) menoresDeEdad++;
                }

                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(a == 4) {
                int terceraEdad = 0;// se cambia la variable a una mas representativa

                //se elimina el condicional de casado o soltero ya que no es necesario y se cambia a 65 el condicional de edad
                for (String [] persona : registro) {
                    if (Integer.parseInt(persona[2]) >= 65 ) {
                        terceraEdad++;
                    }
                }
                System.out.println("Hay " + terceraEdad + " personas de tercera edad");
            } else if(a == 5) {
                //se cambio el nombre de las variables a unos mas representativos
                int casados = 0;
                int solteros = 0;
                for(String[] persona : registro) {
                    if(persona[1].equals("casado/a")) {
                        casados++;
                    } else if(persona[1].equals("soltero/a")) {
                        solteros++;
                    }
                }
                //las variables estaban en las posiciones incorrectas, ahora estan bien.
                System.out.println("Hay " + casados + " casados/as.");
                System.out.println("Hay " + solteros + " solteros/as.");
            } else if(a == 6) {
                System.out.println("Programa finalizado");
            }
        }while (a != 6); // se cambia la condicion a distinto de 6 para que este cierre cuando alcance la posicion...
    }

//Mucha info en el main, cambiar a un metodo menu...


    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - espaciosDisponibles(registro);
    }

    public static boolean hayCupo(String [][] registro) {
        return espaciosDisponibles(registro) != 0;
    }

    //corregir nombre de opa a espaciosDisponibles
    public static int espaciosDisponibles(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].isEmpty()){
                return registro.length - i;
            }
        }
        return 0;
    }
}

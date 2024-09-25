import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {

    }
    public static void menu(){
        String [][] registro = new String[50][3];
        int a; // se cambio el valor de a para que no tenga valor hasta que el usuario lo agregue...

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

            do {
                try {
                    a = new Scanner(System.in).nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
            }while (a > 0 || a < 6);

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
                int queSera = obtenerUltimoEspacio(registro);




                for (int i = 0; i < queSera; i++) {
                    if (registro[i][2] < 18) menoresDeEdad++;
                }




                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(a == 4) {
                int mmmm = 0;




                for (double [] persona : registro) {
                    if (persona[2] >= 60 && persona[1].equals("casado/a")) {
                        mmmm++;
                    } else if(persona[2] >= 65 && persona[1].equals("soltero/a")) {
                        mmmm++;
                    }
                }
                System.out.println("Hay " + mmmm + " personas de tercera edad");
            } else if(a == 5) {
                int c = 0;
                int d = 0;
                for(double[] persona : registro) {
                    if(persona[1].equals("casado/a")) {
                        c++;
                    } else if(persona[1].equals("soltero/a")) {
                        d++;
                    }
                }




                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if(a == 6) {
                System.out.println("Programa finalizado");
            }
        }while (a != 6); // se cambia la condicion a distinto de 6 para que este cierre cuando alcance la posicion...
    }

//Mucha info en el main, cambiar a un metodo menu...


    public static int obtenerUltimoEspacio(double [][] registro) {
        return registro.length - opa(registro);
    }




    public static boolean hayCupo(double [][] registro) {
        return opa(registro) != 0;
    }




    public static int opa(double [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }




        return 0;
    }
}

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    @org.junit.jupiter.api.Test
    void agregarPersonaTest() {
        String[][] registro = new String[50][3];
        Registro.agregarPersona(registro,"Eduardo","soltero/a","20");
        assertEquals("Eduardo",registro[0][0]);
    }

    @org.junit.jupiter.api.Test
    void obtenerUltimoEspacioTest() {
        String[][] registro = new String[50][3];
        Registro.agregarPersona(registro,"Eduardo","soltero/a","20");
        assertEquals(1,Registro.obtenerUltimoEspacio(registro));
    }

    @org.junit.jupiter.api.Test
    void hayCupoTest() {
        String[][] registro = new String[50][3];
        Registro.agregarPersona(registro,"Eduardo","soltero/a","20");
        assertTrue(Registro.hayCupo(registro));
    }

    @org.junit.jupiter.api.Test
    void espaciosDisponiblesTest() {
        String[][] registro = new String[50][3];
        Registro.agregarPersona(registro,"Eduardo","soltero/a","20");
        assertEquals(49,Registro.espaciosDisponibles(registro));
    }
}
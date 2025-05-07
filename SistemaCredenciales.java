import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Patron Singleton
class ConfiguracionGlobal {
    private static ConfiguracionGlobal instancia;
    private String idioma;
    private String logo;

    private ConfiguracionGlobal() {
        this.idioma = "Español";
        this.logo = "Logo por defecto";
    }

    public static ConfiguracionGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionGlobal();
        }
        return instancia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

// Patron Prototype - Credenciales Simples
class Credenciales implements Cloneable {
    private String nombre;
    private String cargo;
    private String rut;

    public Credenciales(String nombre, String cargo, String rut) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public Credenciales clone() {
        try {
            return (Credenciales) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Cargo: " + cargo + " | RUT: " + rut;
    }
}

// Patron Prototype - Credenciales Avanzadas
class Credenciales2 implements Cloneable {
    private String titulo;
    private List<String> campos;

    public Credenciales2(String titulo) {
        this.titulo = titulo;
        this.campos = new ArrayList<>();
    }

    public void personalizar(String titulo, String campo) {
        this.titulo = titulo;
        this.campos.add(campo);
    }

    @Override
    public Credenciales2 clone() {
        try {
            Credenciales2 clon = (Credenciales2) super.clone();
            clon.campos = new ArrayList<>(this.campos);
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void mostrar() {
        System.out.println("Título: " + titulo);
        System.out.println("Campos: " + campos);
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        System.out.println("Idioma: " + config.getIdioma());
        System.out.println("Logo: " + config.getLogo());
    }
}

// Clase principal
public class SistemaCredenciales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Credenciales> listaCredenciales = new ArrayList<>();
        Credenciales plantilla = new Credenciales("Plantilla", "Cargo Base", "RUT Base");

        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar nueva credencial (tipo básica)");
            System.out.println("2. Ver credenciales generadas (básicas)");
            System.out.println("3. Generar y mostrar credenciales tipo 2 (con configuración global)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Credenciales clon = plantilla.clone();
                    System.out.print("Ingrese el nombre: ");
                    clon.setNombre(scanner.nextLine());
                    System.out.print("Ingrese el cargo: ");
                    clon.setCargo(scanner.nextLine());
                    System.out.print("Ingrese el RUT: ");
                    clon.setRut(scanner.nextLine());
                    listaCredenciales.add(clon);
                    System.out.println("Credencial básica agregada exitosamente.");
                    break;

                case 2:
                    if (listaCredenciales.isEmpty()) {
                        System.out.println("No hay credenciales básicas generadas.");
                    } else {
                        System.out.println("\nCredenciales generadas:");
                        for (Credenciales c : listaCredenciales) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3:
                    ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
                    config.setIdioma("Inglés");
                    config.setLogo("Logo del Evento");

                    Credenciales2 base = new Credenciales2("Credencial Base");
                    base.personalizar("Credencial Base", "Nombre del Asistente");
                    base.personalizar("Credencial Base", "Correo Electrónico");

                    Credenciales2 registro = base.clone();
                    registro.personalizar("Credencial de Registro", "Teléfono");

                    Credenciales2 encuesta = base.clone();
                    encuesta.personalizar("Credencial de Encuesta", "Edad");

                    System.out.println("\n--- Credenciales con configuración global ---");
                    System.out.println("Base:");
                    base.mostrar();
                    System.out.println("\nRegistro:");
                    registro.mostrar();
                    System.out.println("\nEncuesta:");
                    encuesta.mostrar();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}

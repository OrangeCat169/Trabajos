import java.util.ArrayList;
import java.util.List;

public class TrabajoOpcional {

    // Clase para guardar la config global del sistema (Singleton) //
    public static class ConfigGlobal {
        private static ConfigGlobal instancia;
        private String idioma;
        private String logo;

        // Constructor privado para que no se pueda instanciar desde fuera //
        private ConfigGlobal() {
            this.idioma = "Español";
            this.logo = "Logo por defecto";
        }

        // Devuelve la única instancia (como Singleton) //
        public static ConfigGlobal getInstance() {
            if (instancia == null) {
                instancia = new ConfigGlobal();
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

    // Clase del formulario, que se puede clonar //
    public static class FormularioContacto implements Cloneable {
        private String titulo;
        private List<String> campos;

        public FormularioContacto(String titulo) {
            this.titulo = titulo;
            this.campos = new ArrayList<>();
        }

        // Le mete más campos y cambia el título //
        public void personalizar(String nuevoTitulo, String campoNuevo) {
            this.titulo = nuevoTitulo;
            this.campos.add(campoNuevo);
        }

        // Método para clonar el formulario //
        @Override
        public FormularioContacto clone() {
            try {
                FormularioContacto clon = (FormularioContacto) super.clone();
                clon.campos = new ArrayList<>(this.campos);
                return clon;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("No se pudo clonar el formulario, compadre.");
            }
        }

        // Muestra el formulario con toda la info //
        public void mostrar() {
            System.out.println("Título del Formulario: " + titulo);
            System.out.println("Campos: " + campos);
            ConfigGlobal config = ConfigGlobal.getInstance();
            System.out.println("Idioma Configurado: " + config.getIdioma());
            System.out.println("Logo Usado: " + config.getLogo());
        }
    }

    public static void main(String[] args) {

        // Configuración general del sistema (esto queda para todos los formularios) //
        ConfigGlobal config = ConfigGlobal.getInstance();
        config.setIdioma("Inglés");
        config.setLogo("Logo personalizado");

        // Creamos un formulario base para usar de molde //
        FormularioContacto base = new FormularioContacto("Formulario Base");
        base.personalizar("Formulario Base", "Nombre");
        base.personalizar("Formulario Base", "Correo");

        // Clonamos el formulario base y le metemos datos distintos //
        FormularioContacto registro = base.clone();
        registro.personalizar("Formulario de Registro", "Teléfono");

        FormularioContacto encuesta = base.clone();
        encuesta.personalizar("Formulario de Encuesta", "Edad");

        // Mostramos los formularios con toda la info //
        System.out.println("=== Formulario Base ===");
        base.mostrar();

        System.out.println("\n=== Formulario Registro ===");
        registro.mostrar();

        System.out.println("\n=== Formulario Encuesta ===");
        encuesta.mostrar();
    }
}
// Fin del código //
// Este código es un ejemplo de cómo implementar el patrón Singleton para la configuración global del sistema y el patrón Prototype para clonar formularios de contacto.

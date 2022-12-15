package pe.perico.client.backend.constants;

/**
 * @author rluisz14  on 08/10/2022
 */
public class Constants {

    private Constants() {
    }

    public static final String ZONE_AMERICA = "America/Lima";

    public static final String ACTIVE_CODE = "A";
    public static final String INACTIVE_CODE = "I";
    public static final String EMPLOYEE_TYPE_USER = "EMPLOYEE";
    public static final String PERICO_HEADER = "PERICO_CLIENT";
    public static final String CLIENT_NOT_EXISTS = "No se encontró usuario para ese documento";
    public static final String USER_NOT_EXISTS = "No se encontró usuario para ese usuario y clave";
    public static final String USER_INACTIVE = "Usuario está inactivo";
    public static final String EMPLOYEE_NOT_EXISTS = "No se encontró empleado para generar la orden";
    public static final String USERNAME_EMAIL_DOCUMENT_ALREADY_EXISTS = "Email, usuario y documento ya se encuentran en uso";
    public static final String USERNAME_ALREADY_EXISTS = "Usuario ya se encuentra en uso";
    public static final String DOCUMENT_ALREADY_EXISTS = "Documento ya se encuentra en uso";
    public static final String EMAIL_ALREADY_EXISTS = "Email ya se encuentra en uso";
    public static final String USERNAME_DOCUMENT_ALREADY_EXISTS = "Usuario y documento ya se encuentran en uso";
    public static final String EMAIL_DOCUMENT_ALREADY_EXISTS = "Email y documento ya se encuentran en uso";
    public static final String USERNAME_EMAIL_ALREADY_EXISTS = "Email y usuario ya se encuentran en uso";
    public static final String SUPPLY_NOT_AVAILABLE = "No hay insumos disponibles para alguno de los productos de la orden";
    public static final String SUPPLY_NOT_EXISTS = "No se encontró el insumo";
}

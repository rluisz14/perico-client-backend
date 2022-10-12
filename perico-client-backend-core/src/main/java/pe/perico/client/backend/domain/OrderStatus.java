package pe.perico.client.backend.domain;

/**
 * @author rluisz14  on 08/10/2022
 */
public enum OrderStatus {

    IN_PROGRESS("EN_CURSO"),
    COMPLETE("COMPLETADA");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package pe.perico.client.backend.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author X10144 on 21/10/2020
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Service implements Serializable {
    private static final long serialVersionUID = 1383397937801800049L;
    private String name;
    @JsonIgnore
    private Boolean publisher;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isPublisher() {
        return this.publisher;
    }

    public void setPublisher(Boolean publisher) {
        this.publisher = publisher;
    }

    public Service() {
        this.publisher = true;
    }

    public Service(String name) {
        this.name = name;
        this.publisher = true;
    }

    public Service(String name, Boolean publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, true);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

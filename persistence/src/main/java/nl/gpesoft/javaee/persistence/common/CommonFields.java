package nl.gpesoft.javaee.persistence.common;

import javax.persistence.*;

@MappedSuperclass
public abstract class CommonFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
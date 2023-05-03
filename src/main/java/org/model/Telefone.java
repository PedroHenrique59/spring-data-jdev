package org.model;

import javax.persistence.*;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String tipo;

    private String numero;

    @ManyToOne(optional = false)
    private UsuarioSpringData usuarioSpringData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UsuarioSpringData getUsuarioSpringData() {
        return usuarioSpringData;
    }

    public void setUsuarioSpringData(UsuarioSpringData usuarioSpringData) {
        this.usuarioSpringData = usuarioSpringData;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", numero='" + numero + '\'' +
                ", usuarioSpringData=" + usuarioSpringData +
                '}';
    }
}

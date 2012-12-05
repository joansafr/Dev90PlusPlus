/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "proveedor", catalog = "konecta", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByProveedorNombreComercial", query = "SELECT p FROM Proveedor p WHERE p.proveedorNombreComercial = :proveedorNombreComercial"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByProveedorRuc", query = "SELECT p FROM Proveedor p WHERE p.proveedorRuc = :proveedorRuc"),
    @NamedQuery(name = "Proveedor.findByProveedorRazonSocial", query = "SELECT p FROM Proveedor p WHERE p.proveedorRazonSocial = :proveedorRazonSocial"),
    @NamedQuery(name = "Proveedor.findByProveedorDomicilioLegal", query = "SELECT p FROM Proveedor p WHERE p.proveedorDomicilioLegal = :proveedorDomicilioLegal")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "proveedor_nombre_comercial", length = 50)
    private String proveedorNombreComercial;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proveedor", nullable = false)
    private Integer idProveedor;
    @Size(max = 12)
    @Column(name = "proveedor_ruc", length = 12)
    private String proveedorRuc;
    @Size(max = 100)
    @Column(name = "proveedor_razon_social", length = 100)
    private String proveedorRazonSocial;
    @Size(max = 100)
    @Column(name = "proveedor_domicilio_legal", length = 100)
    private String proveedorDomicilioLegal;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedorNombreComercial() {
        return proveedorNombreComercial;
    }

    public void setProveedorNombreComercial(String proveedorNombreComercial) {
        this.proveedorNombreComercial = proveedorNombreComercial;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedorRuc() {
        return proveedorRuc;
    }

    public void setProveedorRuc(String proveedorRuc) {
        this.proveedorRuc = proveedorRuc;
    }

    public String getProveedorRazonSocial() {
        return proveedorRazonSocial;
    }

    public void setProveedorRazonSocial(String proveedorRazonSocial) {
        this.proveedorRazonSocial = proveedorRazonSocial;
    }

    public String getProveedorDomicilioLegal() {
        return proveedorDomicilioLegal;
    }

    public void setProveedorDomicilioLegal(String proveedorDomicilioLegal) {
        this.proveedorDomicilioLegal = proveedorDomicilioLegal;
    }

    @XmlTransient
    public Collection<TransporteDiaTrabajo> getTransporteDiaTrabajoCollection() {
        return transporteDiaTrabajoCollection;
    }

    public void setTransporteDiaTrabajoCollection(Collection<TransporteDiaTrabajo> transporteDiaTrabajoCollection) {
        this.transporteDiaTrabajoCollection = transporteDiaTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return proveedorNombreComercial;
    }
    
}

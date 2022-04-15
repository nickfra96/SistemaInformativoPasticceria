package entity;

import entity.Cliente;
import entity.Dettaglioordine;
import entity.Fatturavendita;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Ordine.class)
public class Ordine_ { 

    public static volatile SingularAttribute<Ordine, String> tipo;
    public static volatile ListAttribute<Ordine, Fatturavendita> fatturavenditaList;
    public static volatile SingularAttribute<Ordine, String> data;
    public static volatile SingularAttribute<Ordine, Cliente> clientePiva;
    public static volatile SingularAttribute<Ordine, Integer> id;
    public static volatile ListAttribute<Ordine, Dettaglioordine> dettaglioordineList;

}
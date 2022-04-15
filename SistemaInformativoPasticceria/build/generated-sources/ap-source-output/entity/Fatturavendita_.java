package entity;

import entity.Consegna;
import entity.FatturavenditaPK;
import entity.Ordine;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Fatturavendita.class)
public class Fatturavendita_ { 

    public static volatile SingularAttribute<Fatturavendita, Ordine> ordineId;
    public static volatile SingularAttribute<Fatturavendita, String> data;
    public static volatile SingularAttribute<Fatturavendita, Double> importo;
    public static volatile SingularAttribute<Fatturavendita, Consegna> consegnaId;
    public static volatile SingularAttribute<Fatturavendita, FatturavenditaPK> fatturavenditaPK;

}
package entity;

import entity.DettaglioordinePK;
import entity.Magazzinouscita;
import entity.Ordine;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Dettaglioordine.class)
public class Dettaglioordine_ { 

    public static volatile SingularAttribute<Dettaglioordine, Ordine> ordine;
    public static volatile SingularAttribute<Dettaglioordine, DettaglioordinePK> dettaglioordinePK;
    public static volatile SingularAttribute<Dettaglioordine, Magazzinouscita> magazzinouscita;
    public static volatile SingularAttribute<Dettaglioordine, Integer> quantita;

}
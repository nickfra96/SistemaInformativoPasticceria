package entity;

import entity.Dettagliofornituramateriaprima;
import entity.Magazzinoingresso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Materiaprima.class)
public class Materiaprima_ { 

    public static volatile SingularAttribute<Materiaprima, String> descrizione;
    public static volatile SingularAttribute<Materiaprima, Integer> codice;
    public static volatile SingularAttribute<Materiaprima, Magazzinoingresso> magazzinoingresso;
    public static volatile ListAttribute<Materiaprima, Dettagliofornituramateriaprima> dettagliofornituramateriaprimaList;

}
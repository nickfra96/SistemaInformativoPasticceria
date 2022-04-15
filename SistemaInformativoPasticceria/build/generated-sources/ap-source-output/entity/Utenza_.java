package entity;

import entity.Dettaglioforniturautenza;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Utenza.class)
public class Utenza_ { 

    public static volatile SingularAttribute<Utenza, String> descrizione;
    public static volatile SingularAttribute<Utenza, Integer> codice;
    public static volatile ListAttribute<Utenza, Dettaglioforniturautenza> dettaglioforniturautenzaList;

}
package entity;

import entity.Manutenzione;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Attrezzatura.class)
public class Attrezzatura_ { 

    public static volatile SingularAttribute<Attrezzatura, String> descrizione;
    public static volatile SingularAttribute<Attrezzatura, Integer> periodicitaIntervento;
    public static volatile SingularAttribute<Attrezzatura, String> dataAcquisto;
    public static volatile ListAttribute<Attrezzatura, Manutenzione> manutenzioneList;
    public static volatile SingularAttribute<Attrezzatura, Integer> seriale;

}
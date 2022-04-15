package entity;

import entity.Attrezzatura;
import entity.Dipendente;
import entity.Fornitore;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Manutenzione.class)
public class Manutenzione_ { 

    public static volatile SingularAttribute<Manutenzione, String> descrizione;
    public static volatile SingularAttribute<Manutenzione, String> tipo;
    public static volatile SingularAttribute<Manutenzione, String> data;
    public static volatile SingularAttribute<Manutenzione, Attrezzatura> attrezzaturaSeriale;
    public static volatile SingularAttribute<Manutenzione, Fornitore> fornitoreExtraPiva;
    public static volatile SingularAttribute<Manutenzione, Dipendente> dipendenteCf;

}
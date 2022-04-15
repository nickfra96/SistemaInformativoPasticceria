package entity;

import entity.Magazzinoingresso;
import entity.Prodottofinito;
import entity.RicettaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Ricetta.class)
public class Ricetta_ { 

    public static volatile SingularAttribute<Ricetta, RicettaPK> ricettaPK;
    public static volatile SingularAttribute<Ricetta, Double> quantita;
    public static volatile SingularAttribute<Ricetta, Magazzinoingresso> magazzinoingresso;
    public static volatile SingularAttribute<Ricetta, Prodottofinito> prodottofinito;

}
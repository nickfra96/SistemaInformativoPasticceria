package entity;

import entity.Dettaglioordine;
import entity.Prodottofinito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Magazzinouscita.class)
public class Magazzinouscita_ { 

    public static volatile SingularAttribute<Magazzinouscita, Integer> prodottofinitoCodice;
    public static volatile SingularAttribute<Magazzinouscita, Integer> quantita;
    public static volatile SingularAttribute<Magazzinouscita, Prodottofinito> prodottofinito;
    public static volatile ListAttribute<Magazzinouscita, Dettaglioordine> dettaglioordineList;

}
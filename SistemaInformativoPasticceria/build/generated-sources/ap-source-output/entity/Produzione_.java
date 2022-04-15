package entity;

import entity.Dipendente;
import entity.Prodottofinito;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Produzione.class)
public class Produzione_ { 

    public static volatile SingularAttribute<Produzione, String> tipo;
    public static volatile SingularAttribute<Produzione, String> data;
    public static volatile SingularAttribute<Produzione, Prodottofinito> prodottofinitoCodice;
    public static volatile SingularAttribute<Produzione, Integer> numLotto;
    public static volatile SingularAttribute<Produzione, String> quantita;
    public static volatile SingularAttribute<Produzione, Dipendente> capoproduzioneCf;
    public static volatile SingularAttribute<Produzione, Dipendente> dipendenteCf;

}
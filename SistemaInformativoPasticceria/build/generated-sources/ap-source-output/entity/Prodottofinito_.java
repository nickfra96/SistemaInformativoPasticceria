package entity;

import entity.Magazzinouscita;
import entity.Produzione;
import entity.Ricetta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Prodottofinito.class)
public class Prodottofinito_ { 

    public static volatile SingularAttribute<Prodottofinito, String> descrizione;
    public static volatile SingularAttribute<Prodottofinito, String> tipo;
    public static volatile ListAttribute<Prodottofinito, Ricetta> ricettaList;
    public static volatile SingularAttribute<Prodottofinito, Integer> durataFreschezza;
    public static volatile ListAttribute<Prodottofinito, Produzione> produzioneList;
    public static volatile SingularAttribute<Prodottofinito, Magazzinouscita> magazzinouscita;
    public static volatile SingularAttribute<Prodottofinito, Integer> codice;
    public static volatile SingularAttribute<Prodottofinito, Double> prezzoUnitario;

}
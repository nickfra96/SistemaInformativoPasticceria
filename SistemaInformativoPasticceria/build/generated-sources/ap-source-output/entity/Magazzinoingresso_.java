package entity;

import entity.Materiaprima;
import entity.Ricetta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Magazzinoingresso.class)
public class Magazzinoingresso_ { 

    public static volatile ListAttribute<Magazzinoingresso, Ricetta> ricettaList;
    public static volatile SingularAttribute<Magazzinoingresso, Materiaprima> materiaprima;
    public static volatile SingularAttribute<Magazzinoingresso, Double> quantita;
    public static volatile SingularAttribute<Magazzinoingresso, Integer> materiaprimaCodice;

}
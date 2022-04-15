package entity;

import entity.Dettagliofornituramateriaprima;
import entity.Dettaglioforniturautenza;
import entity.Fatturaacquisto;
import entity.Fornitore;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Fornitura.class)
public class Fornitura_ { 

    public static volatile SingularAttribute<Fornitura, Character> tipo;
    public static volatile SingularAttribute<Fornitura, String> data;
    public static volatile SingularAttribute<Fornitura, Fatturaacquisto> fatturaacquisto;
    public static volatile SingularAttribute<Fornitura, Fornitore> fornitorePiva;
    public static volatile SingularAttribute<Fornitura, Integer> id;
    public static volatile ListAttribute<Fornitura, Dettagliofornituramateriaprima> dettagliofornituramateriaprimaList;
    public static volatile ListAttribute<Fornitura, Dettaglioforniturautenza> dettaglioforniturautenzaList;

}
package entity;

import entity.Dipendente;
import entity.Fatturavendita;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Consegna.class)
public class Consegna_ { 

    public static volatile ListAttribute<Consegna, Fatturavendita> fatturavenditaList;
    public static volatile SingularAttribute<Consegna, String> data;
    public static volatile SingularAttribute<Consegna, Dipendente> addettoConsegneCf;
    public static volatile SingularAttribute<Consegna, Integer> id;

}
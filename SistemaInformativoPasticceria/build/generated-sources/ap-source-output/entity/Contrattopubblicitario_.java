package entity;

import entity.ContrattopubblicitarioPK;
import entity.Fornitore;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Contrattopubblicitario.class)
public class Contrattopubblicitario_ { 

    public static volatile SingularAttribute<Contrattopubblicitario, String> descrizione;
    public static volatile SingularAttribute<Contrattopubblicitario, Fornitore> fornitore;
    public static volatile SingularAttribute<Contrattopubblicitario, ContrattopubblicitarioPK> contrattopubblicitarioPK;
    public static volatile SingularAttribute<Contrattopubblicitario, Integer> durata;

}
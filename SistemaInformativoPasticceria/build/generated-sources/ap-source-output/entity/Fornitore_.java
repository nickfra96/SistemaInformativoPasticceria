package entity;

import entity.Contrattopubblicitario;
import entity.Fornitura;
import entity.Manutenzione;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Fornitore.class)
public class Fornitore_ { 

    public static volatile SingularAttribute<Fornitore, String> piva;
    public static volatile SingularAttribute<Fornitore, Character> tipo;
    public static volatile ListAttribute<Fornitore, Fornitura> fornituraList;
    public static volatile SingularAttribute<Fornitore, String> sede;
    public static volatile ListAttribute<Fornitore, Contrattopubblicitario> contrattopubblicitarioList;
    public static volatile SingularAttribute<Fornitore, String> nome;
    public static volatile ListAttribute<Fornitore, Manutenzione> manutenzioneList;
    public static volatile SingularAttribute<Fornitore, String> telefono;

}
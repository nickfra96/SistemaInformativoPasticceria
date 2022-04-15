package entity;

import entity.DettaglioforniturautenzaPK;
import entity.Fornitura;
import entity.Utenza;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Dettaglioforniturautenza.class)
public class Dettaglioforniturautenza_ { 

    public static volatile SingularAttribute<Dettaglioforniturautenza, DettaglioforniturautenzaPK> dettaglioforniturautenzaPK;
    public static volatile SingularAttribute<Dettaglioforniturautenza, Fornitura> fornitura;
    public static volatile SingularAttribute<Dettaglioforniturautenza, Utenza> utenza;
    public static volatile SingularAttribute<Dettaglioforniturautenza, Double> prezzoUnitario;
    public static volatile SingularAttribute<Dettaglioforniturautenza, Double> quantita;

}
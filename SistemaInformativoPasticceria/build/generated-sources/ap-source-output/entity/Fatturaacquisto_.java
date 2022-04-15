package entity;

import entity.Fornitura;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Fatturaacquisto.class)
public class Fatturaacquisto_ { 

    public static volatile SingularAttribute<Fatturaacquisto, String> tipo;
    public static volatile SingularAttribute<Fatturaacquisto, Integer> anno;
    public static volatile SingularAttribute<Fatturaacquisto, Integer> numero;
    public static volatile SingularAttribute<Fatturaacquisto, String> data;
    public static volatile SingularAttribute<Fatturaacquisto, Fornitura> fornitura;
    public static volatile SingularAttribute<Fatturaacquisto, Double> importo;
    public static volatile SingularAttribute<Fatturaacquisto, Integer> fornituraId;

}
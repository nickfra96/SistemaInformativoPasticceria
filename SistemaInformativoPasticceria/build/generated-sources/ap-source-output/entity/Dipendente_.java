package entity;

import entity.Assenzalavoro;
import entity.Consegna;
import entity.Manutenzione;
import entity.Produzione;
import entity.Turnolavoro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-03T21:12:38")
@StaticMetamodel(Dipendente.class)
public class Dipendente_ { 

    public static volatile SingularAttribute<Dipendente, String> tipo;
    public static volatile SingularAttribute<Dipendente, String> cf;
    public static volatile SingularAttribute<Dipendente, String> cognome;
    public static volatile ListAttribute<Dipendente, Produzione> produzioneList;
    public static volatile ListAttribute<Dipendente, Consegna> consegnaList;
    public static volatile ListAttribute<Dipendente, Assenzalavoro> assenzalavoroList;
    public static volatile SingularAttribute<Dipendente, String> nome;
    public static volatile ListAttribute<Dipendente, Turnolavoro> turnolavoroList;
    public static volatile ListAttribute<Dipendente, Manutenzione> manutenzioneList;
    public static volatile SingularAttribute<Dipendente, String> telefono;
    public static volatile ListAttribute<Dipendente, Produzione> produzioneList1;

}
package main2;

import dao.BureauVoteDao;
import dao.ElecteurDao;
import dao.impl.BureauVoteDaoImpl;
import dao.impl.ElecteurDaoImpl;
import dao.impl.VilleDaoImpl;
import entity.Electeur;
import entity.Ville;
import entity.utils.KeyBureauVote;

/**
 * Created by dialal14 on 23/01/17.
 */
public class Test {
    public static void main(String arg[]) throws Exception {

        /*
        Lecture de Electeur 2L si il exite
         */
//        ElecteurDao electeurDao = new ElecteurDaoImpl();
//        System.out.println(electeurDao.readBureauVote(electeurDao.read(1L)));
        System.out.println(new BureauVoteDaoImpl().read(new KeyBureauVote(7L,new Ville()))
        );

//    /*
//        Creation d'une ville
//     */
//
//        Ville villeAlpha = new Ville();
//        villeAlpha.setNom("burr Alpha");
//        Adresse adresse = new Adresse();
//        adresse.setRue("king alpha");
//        adresse.setCp(92210L);
//        System.out.println(new VilleDaoImpl().save(villeAlpha));
//
//        /*
//        creation d'un bureau de vote
//         */
//        BureauVoteDao bureauVoteDao = new BureauVoteDaoImpl();
//        BureauVote bureauVote = new BureauVote();
//
//        bureauVote.setKeyBureauVote(new KeyBureauVote(7L,4L));
//        bureauVote.setNom("alpha bur");
//        bureauVote.setVille(villeAlpha);
//        bureauVote.setAdresse(adresse);
//        System.out.println(bureauVoteDao.save(bureauVote));
//
//        /*
//        Vreation d'un electeur
//         */
//        Electeur aissatouDialloCreate = new Electeur();
//        aissatouDialloCreate.setBureauVote(bureauVote);
//        aissatouDialloCreate.setNom("Diallo");
//        aissatouDialloCreate.setPrenom("Aissatou");
////        aissatouDialloCreate.setVille(villeAlpha);
//
//        System.out.println(electeurDao.save(aissatouDialloCreate));
//
//        /*
//        Liste tous les eleceteurs
//         */
//        ElecteurDao electeurDao = new ElecteurDaoImpl();
//        List<Electeur> electeurs = electeurDao.list();
//        if(electeurs!=null)for (Electeur b:electeurs) System.out.println(electeurDao.readBureauVote(b));
//
//        /*
//        Get en mode lazy
//         */
//        System.out.println();
//        Electeur aissatouDialloRead = null;
//        try {
//            aissatouDialloRead = electeurDao.read(1L);
//            System.out.println(electeurDao.readBureauVote(aissatouDialloRead));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        /*
//          part 3
//         */
//        aissatouDialloRead = electeurDao.readBureauVote(aissatouDialloRead);
//        System.out.println(aissatouDialloRead);
//
//
//        System.out.println(new VilleDaoImpl().list());
//        System.out.println();
//        try {
//            System.out.println(new VilleDaoImpl().read(17L));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println();
////        System.out.println(new VilleDaoImpl().getByProperty("nom","burr Alpha"));
//
//        /*
//        Update Electeur
//         */
//        System.out.println();
//        aissatouDialloRead.setPrenom("Aissatou t");;
//        electeurDao.update(aissatouDialloRead);
//        System.out.println(aissatouDialloRead);
//        System.out.println();
//
//        /*
//        lecture electeur
//         */
//        try {
//            System.out.println(electeurDao.read(4L));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        /*
//        print ville
//         */
//        System.out.println("************************");
//
//        Ville ville2 = null;
//        try {
//            ville2 = new VilleDaoImpl().read(2L);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(ville2);
//
//        ville2 = new VilleDaoImpl().readBureauVote(ville2);
//
//        System.out.println(ville2);
//        /*
//        fonction qui affiche le ville et c est bureau de vote
//         */
//        System.out.println(ville2.printWithBureauVote());


//        Ville ville = new Ville();
//        ville.setNom("Riviere du Loup");
//
//        BureauVote bureauVote1 = new BureauVote();
//        bureauVote1.setKeyBureauVote(new KeyBureauVote(6L));
//        bureauVote1.setNom("Alpha Pres");
//        Adresse adresse1 = new Adresse();
//        adresse1.setRue("king alpha Pres");
//        adresse1.setCp(92110L);
//        bureauVote1.setAdresse(adresse1);
//
//        BureauVote bureauVote2 = new BureauVote();
//        bureauVote2.setKeyBureauVote(new KeyBureauVote(7L));
//        bureauVote2.setNom("Alpha delta");
//        Adresse adresse = new Adresse();
//        adresse.setRue("king alpha delta");
//        adresse.setCp(92110L);
//        bureauVote2.setAdresse(adresse);
//
//        ville.addBureauVote(bureauVote1);
//        ville.addBureauVote(bureauVote2);
//        VilleDao villeDao = new VilleDaoImpl();
//        villeDao.save( ville );

//        ElecteurDao electeurDao = new ElecteurDaoImpl();
//        Electeur electeurProxy = electeurDao.load(1L);
//
//        electeurProxy = electeurDao.initialiseProxy(electeurProxy);
//        System.out.println(electeurProxy);

//        System.out.println("************SOUS SELCT*********");
//        for (Ville ville :new VilleDaoImpl().list()){
//            System.out.println(ville.printWithBureauVote());
//        }

//        System.out.println(new VilleDaoImpl().getCollectionSize(1L));
//        System.out.println(new VilleDaoImpl().getCollectionSQLNativeSize(1L));
//        System.out.println(new VilleDaoImpl().getCollectionCriteariaSize(1L));
//        System.out.println(new VilleDaoImpl().getCollectionHQLSize(1L));
//        System.out.println(new VilleDaoImpl().read(1L));
    }
}

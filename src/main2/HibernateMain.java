package main2;

import dao.ElecteurDao;
import dao.VilleDao;
import dao.impl.BureauVoteDaoImpl;
import dao.impl.ElecteurDaoImpl;
import dao.impl.VilleDaoImpl;
import entity.Adresse;
import entity.BureauVote;
import entity.Electeur;
import entity.Ville;
import entity.utils.KeyBureauVote;

import java.util.List;

/**
 * Created by DIALLO on 26/03/2017.
 */
public class HibernateMain {

    public static void main(String args[]) throws Exception {


        /*
            Seletion d'un Bureau de la ville 1L
         */
        final BureauVoteDaoImpl bureauVoteDao = new BureauVoteDaoImpl();
        final VilleDaoImpl villeDao = new VilleDaoImpl();
        final ElecteurDao electeurDao = new ElecteurDaoImpl();

//        System.out.println(bureauVoteDao.read(new KeyBureauVote(7L,villeDao.read(1L))));

        /*
             Seletion d'un Bureau de la ville 1L
         */
//        final Ville ville = new Ville();
//        ville.setVid(1L);
//        System.out.println(bureauVoteDao.read(new KeyBureauVote(7L,ville)));

         /*
            Get en mode lazy Collection
         */
//        for (Ville ville :villeDao.list()){
//            System.out.println(ville.printWithBureauVote());
//        }
        /*
            Proxy initialisation
         */

//        Electeur electeurProxy = electeurDao.load(1L);

//        System.out.println("GET PROXY");
//        electeurProxy = electeurDao.initialiseProxy(electeurProxy);
//        System.out.println(electeurProxy);

        final BureauVote bureauVote2 = new BureauVote();
        bureauVote2.setKeyBureauVote(new KeyBureauVote(7L));
        bureauVote2.setNom("Alpha delta");

        final Adresse adresse = new Adresse();
        adresse.setRue("king alpha delta");
        adresse.setCp(92110L);
        bureauVote2.setAdresse(adresse);

        final Ville ville = villeDao.read(4L);
        ville.addBureauVote(bureauVote2);

        villeDao.saveOrUpdate( ville );

        /*
        Liste tous les villes avec et sans electeurs
         */
//        List<Ville> villes = villeDao.list();
//        if(villes!=null)
//            for (Ville b:villes)
//                System.out.println(b);
//                System.out.println(villeDao.readBureauVote(b).printWithBureauVote());

    }
}

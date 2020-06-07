package dao;

import java.sql.Connection;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public abstract class DataAccessObject<T> {

    // Variable de connexion à la BDD
    protected Connection connect = null;

    // On se connecte à la BDD
    public DataAccessObject() {
        connect = Connector.getConnection();
    }

    /**
     * Classe abstraite pour créer.
     *
     * @param objet
     * @return
     */
    public abstract boolean creer(T objet);

    /**
     * Classe abstraite pour effacer.
     *
     * @param objet
     * @return
     */
    public abstract boolean effacer(T objet);

    /**
     * Classe abstraite pour mettre à jour.
     *
     * @param objet
     * @return
     */
    public abstract boolean mettreAJour(T objet);

    /**
     * Classe abstraire pour chercher à partir de l'Id.
     *
     * @param id
     * @return
     */
    public abstract T chercher(int id);
}

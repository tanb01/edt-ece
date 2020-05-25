package dao;

import java.sql.Connection;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public abstract class DataAccessObject<T> {

    protected Connection connect = null;

    public DataAccessObject() {
        connect = Connector.getConnection();
    }

    public abstract boolean creer(T objet);

    public abstract boolean effacer(T objet);

    public abstract boolean mettreAJour(T objet);

    public abstract T chercher(int id);
}

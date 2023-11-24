/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package distribuicaoembalagem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import view.FrLogin;
import view.FrSelectActionAdmin;

/**
 *
 * @author vinic
 */
public class DistribuicaoEmbalagem {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.close();
        factory.close();
//        FrLogin login = new FrLogin();
//        login.setVisible(true);
        FrSelectActionAdmin select = new FrSelectActionAdmin();
        select.setVisible(true);
    }
}

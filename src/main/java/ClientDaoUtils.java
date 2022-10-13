import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDaoUtils implements ClientDao{

    private SessionFactoryUtils sessionFactoryUtils;

    @Autowired
    public ClientDaoUtils(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Client findById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.getTransaction().commit();
            return client;
        }
    }

    @Override
    public List<Client> findAll() {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Client> clients = session.createQuery("select c from Client c").getResultList();
            session.getTransaction().commit();
            return clients;
        }
    }

    @Override
    public Client findByName(String name) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.createQuery("select c from Client c where c.name = :name", Client.class).setParameter("name", name).getSingleResult();
            session.getTransaction().commit();
            return client;
        }
    }

    @Override
    public void save(Client client) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Long id, String name) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            client.setName(name);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
            session.getTransaction().commit();
        }
    }


    @Override
    public void saveOrUpdate(Client client) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Client> getClientsByProductId(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Client> clients = session.createQuery("SELECT DISTINCT c FROM Client c left join fetch c.products AS p where p.title.id = :id").setParameter("id",id).getResultList();
            session.getTransaction().commit();
            return clients;
        }
    }
}

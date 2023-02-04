import java.util.List;

public interface ClientDao {

        Client findById(Long id);

        List<Client> findAll();

        Client findByName(String name);

        void save(Client client);

        void update(Long id, String name);

        void deleteById(Long id);

        void saveOrUpdate(Client client);

        List<Client> getClientsByProductId(Long id);


}

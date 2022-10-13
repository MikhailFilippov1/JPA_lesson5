import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("JPA_lesson5")
public class Hibernate_HW1 {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try{
            ProductDao productDao = new ProductDaoUtils(sessionFactoryUtils);
            ClientDao clientDao = new ClientDaoUtils(sessionFactoryUtils);
//            Product product = productDao.findById(1L);
//            Client client = clientDao.findById(1L);
//            System.out.println(product);
//            System.out.println(client);
//            System.out.println(productDao.findAll());
//            System.out.println(clientDao.findAll());
            System.out.println(productDao.getProductsByClientId(2L));
            System.out.println(clientDao.getClientsByProductId(3L));
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            sessionFactoryUtils.shutdown();
        }
    }
}

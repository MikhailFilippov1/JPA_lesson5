import org.hibernate.Session;

import java.util.List;

public class ProductDaoUtils implements ProductDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoUtils(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findByTitle(String title) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("select p from Product p where p.title = :title", Product.class).setParameter("title", title).getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void save(Product product) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Long id, String title) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
//            session.createQuery("update Product p set p.title = :title where p.id = :id", Product.class)
//                            .setParameter("title", title)
//                                    .setParameter("id", id)
//                    .executeUpdate();
            Product product = session.get(Product.class, id);
            product.setTitle(title);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}



public class Hibernate_HW1 {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try{
            ProductDao productDao = new ProductDaoUtils(sessionFactoryUtils);
            Product product = new Product("VINE", 777);
            productDao.save(product);
            System.out.println(productDao.findAll());
            productDao.update(6L, "BEER");
            System.out.println(productDao.findAll());
            productDao.deleteById(1L);
            System.out.println(productDao.findAll());
            productDao.saveOrUpdate(product);
            System.out.println(productDao.findAll());//Понятна разница между save и update: в 1 раз не закомиттила
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            sessionFactoryUtils.shutdown();
        }
    }
}

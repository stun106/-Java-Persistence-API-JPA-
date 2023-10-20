package br.com.stun106;

import br.com.stun106.dao.CategoryDao;
import br.com.stun106.dao.ProductDao;
import br.com.stun106.models.Category;
import br.com.stun106.models.Product;
import br.com.stun106.util.JpaUtil;

import javax.persistence.EntityManager;

import java.util.List;

import java.math.BigDecimal;


public class Main {
    public static void main (String[] args){
            EntityManager em = JpaUtil.getEntityManager();
            ProductDao prodDao = new ProductDao(em);
            CategoryDao catDao = new CategoryDao(em);

            try{
                Category cat1 = new Category("COLECOES DE VELAS");
                Category cat2 = new Category("COLCOES_DE_CHAKRAS");
                
                Product prod1 = new Product("Ceb","Artefato criado para boa sorte!",
                        new BigDecimal("300"),catDao.findById(3l));
                Product prod2 = new Product("Galho da arvore do Eden","Galho retirado por lucifé da arvore do Eden",
                        new BigDecimal("2000000"),cat2);
                
                em.getTransaction().begin();
                catDao.create(cat1);
                catDao.create(cat2);
                prodDao.create(prod1);
                prodDao.create(prod2);
                em.getTransaction().commit();

            }catch (Exception e){
                if (em.getTransaction().isActive()){
                    em.getTransaction().rollback();
                }
                e.printStackTrace();
            }finally {
                List<Product> allProdCate = prodDao.findAllByCategory("COLECOES DE VELAS");
                allProdCate.forEach(p -> System.out.println(p.getName()));
                em.close();
                
            }
    }
}

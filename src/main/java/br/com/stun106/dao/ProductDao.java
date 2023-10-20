package br.com.stun106.dao;

import br.com.stun106.models.Category;
import br.com.stun106.models.Product;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

public class ProductDao {
    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void create(Product product){
        this.em.persist(product);
    } 

    public List<Product> index(){
        return this.em.createQuery("SELECT p FROM Product p",Product.class).getResultList();
    }
    public Product findById(long id){
        var prod = this.em.find(Product.class, id);
        return prod;
    }

    public List<Product> findByName(String name){
        return this.em.createQuery("SELECT p FROM Product p WHERE p.name = ?1",Product.class)
        .setParameter(1, name)
        .getResultList();
        
    }

    public List<Product> findAllByCategory(String name){
        return this.em.createQuery("SELECT p FROM Product p WHERE p.category.nameCategorie = :name", Product.class)
        .setParameter("name", name)
        .getResultList();
    }

    public BigDecimal getvalueProduct(String value){
        return this.em.createQuery("SELECT p.valor FROM Product p WHERE p.name = :value", BigDecimal.class)
        .setParameter("value", (String)value)
        .getSingleResult();
    }
    
    public void update(long id, String newName, String newDescrition, String newValor){
        var prod = this.em.find(Product.class,id);
        if (prod != null){
        }
    }

    public void destroy(long id){
        var prod = findById((long) id);
        this.em.remove(prod);
    }

}
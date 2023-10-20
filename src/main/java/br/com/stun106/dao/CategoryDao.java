package br.com.stun106.dao;

import br.com.stun106.models.Category;

import javax.persistence.EntityManager;

import java.util.List;

public class CategoryDao {
    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }
    public void create(Category category){
        this.em.persist(category);
    }

    public Category findById(Long id){
        return this.em.find(Category.class,id );
    }

    public Category findByName(String name){
        return this.em.createQuery("SELECT p FROM Product p WHERE p.name = ?1",Category.class)
        .setParameter(1, name)
        .getSingleResult();
    
}

    public List<Category> index(){
        return this.em.createQuery("SELECT c FROM Category c",Category.class).getResultList();
    }

    public void update(Long id, String request){
        var item = findById((Long) id);
        if (item != null){
            item.setNameCategorie(request);
            System.out.println("Updade de Categorias realizado com sucesso!");
        }else{
            System.out.println("Categoria não encontrada, verifique seus dados.");
        }
    }

    public void destroy(long id){
        var item = findById((long) id);
        this.em.remove(item);
    }
}

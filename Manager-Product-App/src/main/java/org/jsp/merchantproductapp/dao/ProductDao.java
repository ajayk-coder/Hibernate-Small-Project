
package org.jsp.merchantproductapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;

@SuppressWarnings("unchecked")
public class ProductDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();

	public Product saveProduct(Product product, int merchant_id) {
		Merchant merchant = manager.find(Merchant.class, merchant_id);
		if (merchant != null) {
			EntityTransaction transaction = manager.getTransaction();
			merchant.getProducts().add(product);// Adding product to merchant
			product.setMerchant(merchant);// Assigning Merchant to Product
			manager.persist(product);
			transaction.begin();
			transaction.commit();
			return product;
		}
		return null;
	}

	public Product updateProduct(Product product) {
		Product dbProduct = manager.find(Product.class, product.getId());
		EntityTransaction transaction = manager.getTransaction();
		if (dbProduct != null) {
			dbProduct.setName(product.getName());
			dbProduct.setBrand(product.getBrand());
			dbProduct.setCategory(product.getCategory());
			dbProduct.setDescription(product.getDescription());
			dbProduct.setImage_url(product.getImage_url());
			dbProduct.setCost(product.getCost());
			transaction.begin();
			transaction.commit();
			return dbProduct;
		}

		return null;
	}

	public Product findById(int id) {
		return manager.find(Product.class, id);
	}

	public List<Product> findByBrand(String brand) {
//		return manager.createQuery("select p from Product p where p.brand=?1").setParameter(1, brand).getResultList();
		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, brand);
		return q.getResultList();
	}

	public List<Product> findByCategory(String category) {
		Query q = manager.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, category);
		return q.getResultList();
	}

	public List<Product> findByName(String name) {
		Query q = manager.createQuery("select p from Product p where p.name=?1");
		q.setParameter(1, name);
		return q.getResultList();
	}

	public List<Product> findByMerchantId(int merchant_id) {
		Query q = manager.createQuery("select m.products from Merchant m where m.id=?1");
		q.setParameter(1, merchant_id);
		return q.getResultList();
	}

	public List<Product> findAll() {
		return manager.createQuery("select p from Product p ").getResultList();
	}
}


package org.jsp.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Product;

public class ProductController {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		System.out.println("🙂 Chaaalo Select kro");
		System.out.println("1.Save Product");
		System.out.println("2.Update Product");
		System.out.println("3.Find Products By Brand");
		System.out.println("4.Find Products By Category");
		System.out.println("5.Find Products By Name");
		System.out.println("6.Find Product By id");
		System.out.println("7.Find Products By Merchant Id");
		System.out.println("8.Find All Products");
		Scanner sc = new Scanner(System.in);
		System.out.println("               ");
		System.out.print("Jaldi kro 😖😖 : ");
		System.out.println("           ");
		switch (sc.nextInt()) {
		case 1: {
			System.out.println("Enter the Merchant Id to add product");
			System.out.println("           ");
			System.out.println("👇👇👇👇👇👇");
			System.out.println("           ");
			System.out.print("ID: ");
			int merchant_id = sc.nextInt();
			System.out.println("Enter the Name, Brand, Category, Description, Cost and Image_Url to add product");
			Product product = new Product();
			System.out.print("NAME: ");
			product.setName(sc.next());
			System.out.print("BRAND: ");
			product.setBrand(sc.next());
			System.out.print("CATEGORY: ");
			product.setCategory(sc.next());
			System.out.print("DESCRIPTION: ");
			product.setDescription(sc.next());
			System.out.print("COST: ");
			product.setCost(sc.nextDouble());
			System.out.print("IMAGE_URL: ");
			product.setImage_url(sc.next());
			product = productDao.saveProduct(product, merchant_id);
			if (product != null)
				System.out.println("Product added with Id:" + product.getId());
			else
				System.err.println("Cannot Add Product as Merchant Id is Invalid");
			break;
		}
		case 2: {
			System.out.println("Enter the id,Name, Brand, Category ,Description, Cost and Image_url to add product");
			Product product = new Product();
			
			System.out.print("ID: ");
			product.setId(sc.nextInt());
			System.out.print("NAME: ");
			product.setName(sc.next());
			System.out.print("BRAND: ");
			product.setBrand(sc.next());
			System.out.print("CATEGORY: ");
			product.setCategory(sc.next());
			System.out.print("DESCRIPTION: ");
			product.setDescription(sc.next());
			System.out.print("COST: ");
			product.setCost(sc.nextDouble());
			System.out.print("IMAGE_URL: ");
			product.setImage_url(sc.next());
			product = productDao.updateProduct(product);
			if (product != null)
				System.out.println("Product with Id:" + product.getId() + " updated");
			else
				System.err.println("Cannot Update Product as  Id is Invalid");
			break;
		}
		case 3: {
			System.out.println("Enter the Brand to find Products");
			System.out.print("BRAND: ");
			String brand = sc.next();
			List<Product> products = productDao.findByBrand(brand);
			if (products.isEmpty())
				System.err.println("No Product found with entered brand");
			else
				for (Product p : products) {
					System.out.println(p);
				}
			break;
		}
		case 4: {
			System.out.println("Enter the category to find products");
			String category = sc.next();
			List<Product> products = productDao.findByCategory(category);
			if (products.isEmpty())
				System.err.println("No Product found with entered category");
			else
				for (Product p : products) {
					System.out.println(p);
			
				}
			break;
		}
		case 5: {
			System.out.println("Enter the name to find products");
			System.out.println("NAME: ");
			String name = sc.next();
			List<Product> products = productDao.findByName(name);
			if (products.isEmpty())
				System.err.println("No Product found with entered name");
			else
				for (Product p : products) {
					System.out.println(p);
					
				}
			break;
		}
		case 6: {
			System.out.println("Enter the Id to find Product");
			System.out.println("ID: ");
			int id = sc.nextInt();
			Product product = productDao.findById(id);
			if (product != null)
				System.out.println(product);
			else
				System.err.println("Invalid Product Id");
			break;
		}
		case 7: {
			System.out.println("Enter the Merchant Id to find products");
			System.out.println("ID: ");
			int merchant_id = sc.nextInt();
			List<Product> products = productDao.findByMerchantId(merchant_id);
			if (products.isEmpty())
				System.err.println("No Product found for entered Merchant Id");
			else
				for (Product p : products) {
					System.out.println(p);
				
				}
			break;
		}
		case 8: {
			List<Product> products = productDao.findAll();
			for (Product p : products) {
				System.out.println(p);
				
			}
			break;
		}
		}
	}
}

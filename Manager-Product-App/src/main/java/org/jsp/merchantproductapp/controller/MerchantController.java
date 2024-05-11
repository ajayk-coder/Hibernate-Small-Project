
package org.jsp.merchantproductapp.controller;

import java.util.Scanner;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class MerchantController {
	public static void main(String[] args) {
		MerchantDao dao = new MerchantDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("❤️ SELECT YOUR CHOICE ❤️");
		System.out.println("1: Save Merchant");
		System.out.println("2: Update Merchant");
		System.out.println("3: Find by Id");
		System.out.println("4: Verify By Phone & Password");
		System.out.println("5: Verify By Email & Password");
		switch (sc.nextInt()) {
		case 1: {
			System.out.println("Enter name,phone,email, gst_number and password to save Merchant");
			Merchant m = new Merchant();
			System.out.print("Name: ");
			m.setName(sc.next());
			System.out.print("Phone: ");
			m.setPhone(sc.nextLong());
			System.out.print("Email: ");
			m.setEmail(sc.next());
			System.out.print("GST Number: ");
			m.setGst_number(sc.next());
			System.out.print("Password: ");
			m.setPassword(sc.next());
			m = dao.saveMerchant(m);
			System.out.println("Merchant Saved with Id:" + m.getId());
			break;
		}
		case 2: {
			System.out.println("Enter the Id, name,phone, email, gst_number and password to update Merchhant");
			Merchant m = new Merchant();
			System.out.println("ID: ");
			m.setId(sc.nextInt());
			System.out.println("Name: ");
			m.setName(sc.next());
			System.out.println("Phone: ");
			m.setPhone(sc.nextLong());
			System.out.println("Email: ");
			m.setEmail(sc.next());
			System.out.println("Gst_Number: ");
			m.setGst_number(sc.next());
			System.out.println("Password: ");
			m.setPassword(sc.next());
			m = dao.updateMerchant(m);
			if (m != null) {
				System.out.println("Merchant Updated Succesfully");
			} else
				System.out.println("Sahi Detail daal na");
				System.err.println("Cannot Update Merchant as Id is Invalid");
			break;
		}
		case 3: {
			System.out.println("Enter the Merchant Id to display details");
			System.out.println("ID: ");
			Merchant merchant = dao.findById(sc.nextInt());
			if (merchant != null) {
				System.out.println(merchant);
			} else
				System.err.println("Kya Dikkat Hai!!  Invalid Merchant Id hai");
			break;
		}
		case 4: {
			System.out.println("Enter the Phone Number and Password to verify Merchant");
			System.out.println("Phone No.: ");
			long phone = sc.nextLong();
			System.out.println("Password: ");
			String password = sc.next();
			Merchant merchant = dao.verify(phone, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else
				System.err.println("Are Yaar Invalid Phone Number or Password kyu daal rahe ho");
			break;
		}
		case 5: {
			System.out.println("Enter the Email Id and Password to verify Merchant");
			System.out.println("Email: ");
			String email = sc.next();
			System.out.println("Password: ");
			String password = sc.next();
			Merchant merchant = dao.verify(email, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else
				System.err.println("Hey-Heee Invalid Email Id or Password kaahe daal rahe ho");
			break;
		}
		default: {
			sc.close();
			System.err.println("Are yaar Sahi to chun le");
		}
		}
	}
}

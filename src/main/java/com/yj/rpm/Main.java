package com.yj.rpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yj.rpm.mcr.MethodCallRecord;
import com.yj.rpm.mcr.MethodCallRecordRepository;
import com.yj.rpm.mcr.MethodCallRecordService;

@SpringBootApplication
public class Main implements CommandLineRunner {
		@Autowired
		private MethodCallRecordRepository repository;
		@Autowired
		private MethodCallRecordService recordService;
		

		public static void main(String[] args) {
			SpringApplication.run(Main.class, args);
		}

		
		public void run(String... args) throws Exception {

			repository.deleteAll();

//			// save a couple of customers
			MethodCallRecord r = new MethodCallRecord();
			r.setAppName("raptorApp");
			r.setHostName("localhost");
			r.setRunId("12345678");
//			r.setCalledTimes(10);
			r.setClassName("com.ebay.common.user.userDao");
			r.setMethodName("findAll");
			r.setTimestamp(System.currentTimeMillis());
//			r.setTotalCostTimeInMills(1000);
//			repository.save(r);
			recordService.saveMethodCallRecord(r);
//			repository.save(new Customer("Bob", "Smith"));
//
//			// fetch all customers
//			System.out.println("Customers found with findAll():");
//			System.out.println("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				System.out.println(customer);
//			}
//			System.out.println();
//
//			// fetch an individual customer
//			System.out.println("Customer found with findByFirstName('Alice'):");
//			System.out.println("--------------------------------");
//			System.out.println(repository.findByFirstName("Alice"));
//
//			System.out.println("Customers found with findByLastName('Smith'):");
//			System.out.println("--------------------------------");
//			for (Customer customer : repository.findByLastName("Smith")) {
//				System.out.println(customer);
//			}

		}

}

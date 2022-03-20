package com.kloudspot;

import com.kloudspot.model.WebShow;
import com.kloudspot.service.IWebShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebshowDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebshowDemoApplication.class, args);
	}

	@Autowired
	private IWebShowService iWebShowService;

	@Override
	public void run(String... args) throws Exception {
//		WebShow webShow = new WebShow("Little things","Dhruv sihgal","mithila palkar","neel",4,4.3);
//		iWebShowService.addWebShow(webShow);


		System.out.println("\nlist of all web shows");
		iWebShowService.getAllWebShow().forEach(System.out::println);

		System.out.println("\nlist of web show with given director name");
		iWebShowService.getByDirectorName("neel").forEach(System.out::println);

		System.out.println("\nlist of web show with given male actor name");
		iWebShowService.getByMaleactorName("Ali Faizal").forEach(System.out::println);

		System.out.println("\nlist of web show with given female actor name");
		iWebShowService.getByFemaleactorName("Sweety").forEach(System.out::println);

		System.out.println("\nget by given ID");
		WebShow webShow = iWebShowService.getById(2);
		System.out.println(webShow);

		System.out.println("\nget by web show Name");
		iWebShowService.getByWebshowName("Mirzapur").forEach(System.out::println);

		System.out.println("\nget by male actor and female actor name");
		iWebShowService.getByMaleactorNameAndFemaleactorName("Dhruv sihgal","mithila palkar");

	}
}

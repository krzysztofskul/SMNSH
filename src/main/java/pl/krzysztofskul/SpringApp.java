package pl.krzysztofskul;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {

	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext(AppConfig.class);
		
    }


	


	
}

package cs544.sdi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App 
{
	//@Autowired
	//IProductService productService

	public App(){

	}

	public static void main(String[] args) {
//		App app = new App();
//		app.initialize();
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		IProductService productService = context.getBean(IProductService.class);
		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}

		System.out.println("Weh have " +productService.getNumberInStock(423)+
				"products wiht product number 423");
		System.out.println("Weh have " +productService.getNumberInStock(239)+
				"products wiht product number 239");
	}

//	public void initialize(){
//		Product product1 = productService.getProduct(423);
//		if (product1 != null) {
//			System.out.println(product1.toString());
//		}
//		Product product2 = productService.getProduct(239);
//		if (product2 != null) {
//			System.out.println(product2.toString());
//		}
//	}
}

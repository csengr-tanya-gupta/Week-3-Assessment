package xml_annotation.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.JavaConfigurationFile;
import xml_annotation.entity.Product;
import xml_annotation.entity.Project;
import xml_annotation.entity.Student;

public class JavaApp {
	
	public static void execution() {
		
		ConfigurableApplicationContext configurableApplicationContext;
		configurableApplicationContext = new AnnotationConfigApplicationContext(JavaConfigurationFile.class);
		Student student =configurableApplicationContext.getBean(Student.class);
		System.out.println(student);
		Project project = student.getProject();
		System.out.println(project);
		configurableApplicationContext.close();
	}

}

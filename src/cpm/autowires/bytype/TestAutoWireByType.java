package cpm.autowires.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByType {
	public static void main(String[] args) {
		

	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"application-context.xml"});
	Person person=(Person)context.getBean(Person.class);
	System.out.println(""+person.getAbility().getSkill());
	

	}
}

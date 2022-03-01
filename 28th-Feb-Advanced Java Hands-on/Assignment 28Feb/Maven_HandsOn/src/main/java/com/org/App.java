package com.org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        Configuration conf = new Configuration();
        conf.configure("Hibernate.cfg.xml");
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();  
        
        Employee obj = new Employee();
        obj.setName("shubham");
        obj.setEmail("shubham.sahu@genpact.com");
        obj.setSkill("Java");
        
        Employee obj1 = new Employee();
        obj1.setName("Akash");
        obj1.setEmail("akash@genpact.com");
        obj1.setSkill("Cpp");
        
        
        Employee obj2 = new Employee();
        obj2.setName("Avni");
        obj2.setEmail("Avni@Amazone.com");
        obj2.setSkill("Machine learnning");
        
        
        Employee obj3 = new Employee();
        obj3.setName("Rajiv kumar");
        obj3.setEmail("Rajiv.kumar@upstox.com");
        obj3.setSkill("Java");
        
        Employee obj4 = new Employee();
        obj4.setName("Himansi");
        obj4.setEmail("Himansi@Amazone.com");
        obj4.setSkill("Java");
        
        
        
       
        session.save(obj);
        tr.commit();
    }
}

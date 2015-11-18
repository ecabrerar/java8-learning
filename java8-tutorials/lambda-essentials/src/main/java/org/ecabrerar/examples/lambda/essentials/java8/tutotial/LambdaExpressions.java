/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ecabrerar.examples.lambda.essentials.java8.tutotial;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author ecabrerar
 */
public class LambdaExpressions {

    
    private void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {

        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    private void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    private void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    private <X, Y> void processElements(Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {

        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }

    }

    private void processElementsWithAggregateOperationsAndLambdaExpressions(List<Person> roster) {

        roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

    }

    public void runExamples() {

      System.out.println("JDK 8 Lambdas Essentials");
      
       
       System.out.println("printPersonsWithPredicate");
       
        System.out.println("printPersonsWithinAgeRange");
        printPersonsWithPredicate(new ArrayList<>(),
                p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25
        );

      
          
        processPersons(new ArrayList<>(),
                p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
                p -> p.printPerson());

        System.out.println("processPersonsWithFunction");
        
        processPersonsWithFunction(new ArrayList<>(),
                p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        
        System.out.println("processElements");

        processElements(new ArrayList<Person>(),
                p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        
           System.out.println("processElements with Aggregate Operations That Accept Lambda Expressions as Parameters");
        
        processElementsWithAggregateOperationsAndLambdaExpressions(new ArrayList<>());

    }

    public static void main(String[] args) {

        LambdaExpressions lambda = new LambdaExpressions();
        lambda.runExamples();
    }
}

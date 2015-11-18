/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ecabrerar.examples.lambda.essentials.java8.tutotial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class SearchCriteriaJava7 {
    
    private void printPersonsOlderThan(List<Person> roster, int age) {

        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }

        }
    }

    private void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    private void printPersons(List<Person> roster, CheckPerson tester) {

        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    
    public void runExamples(){
                
       System.out.println("Search Criteria in Local Class in Java 7"); 
              
       System.out.println("printPersons");
       
        printPersons(new ArrayList<>(), new CheckPersonEligibleForSelectiveService());        
        
        printPersons(new ArrayList<>(), new CheckPerson() {

            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });
        
      System.out.println("printPersonsWithinAgeRange");

        printPersons(new ArrayList<>(),
                (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);

    }
    
    public static void main(String[] args) {
        SearchCriteriaJava7 searchCriteria = new SearchCriteriaJava7();
        searchCriteria.runExamples();
    }

}

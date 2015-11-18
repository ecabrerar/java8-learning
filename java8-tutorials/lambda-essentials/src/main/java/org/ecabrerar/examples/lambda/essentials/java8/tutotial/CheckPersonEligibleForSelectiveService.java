/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ecabrerar.examples.lambda.essentials.java8.tutotial;

/**
 *
 * @author ecabrerar
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson{

    @Override
    public boolean test(Person p) {
        return p.getGender()==Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25;
    }
    
}

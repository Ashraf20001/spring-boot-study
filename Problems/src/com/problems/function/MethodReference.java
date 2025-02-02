package com.problems.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {

        List<Reference> references = new ArrayList<>();
        references.add(new Reference("asifa","jamuna"));
        references.add(new Reference("mariyam","nasreen"));
        references.add(new Reference("aysha","fathima"));

        references.stream().forEach(Reference::printReference);

    }
}

class Reference{
    String name1;
    String name2;

    public Reference(String name1,String name2){
        this.name1 = name1;
        this.name2 = name2;
    }

    public void printReference(){
        System.out.println("Reference has been printed");
    }

    public int compare(Reference name1,Reference name2){
        return  name1.name1.compareTo(name2.name2);
    }
}

package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean result = true;
            int counter = 0;
            for (int i = 0; i < x.size(); i++) {
                if(!Character.isUpperCase(x.get(i).charAt(0))) {
                    counter++;
                }
            }
            result = counter <= 0;
            return result;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if(list.get(i) % 2 == 0)
                    list.add(list.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < values.size(); i++) {
                String sentence = values.get(i);
                //System.out.println(sentence);
                boolean c1 = Character.isUpperCase(sentence.charAt(0));
                int charIndex = sentence.lastIndexOf(".");
                boolean c2 =  charIndex != -1 && charIndex == sentence.length() - 1;
                boolean c3 = sentence.split(" ").length > 3;
                if(c1 && c2 && c3) {
                    result.add(sentence);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> result = new HashMap<>();
            list.forEach(str -> {
                result.put(str, str.length());
            });
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}

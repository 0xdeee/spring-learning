package com.learning.spring.basics.springbasics.basics.tutorial;

import org.springframework.stereotype.Repository;

// Changing @Component to @Repositorty but this will have the same functionality as @Compoenent 
// but also adds features that other spring modules provide

@Repository
public class BubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
	// logic for bubble sort
	return arr;
    }
}

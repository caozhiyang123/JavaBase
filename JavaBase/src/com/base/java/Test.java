package com.base.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		//sameVariableName();
		
		//setMethod();
		
		//fastSearch();
	}

	public static void fastSearch() {
		String[] arr = {"Java", "8", "is", "great","Java9","Java10"};
		List<String> src = Arrays.asList(arr);
		
		//A
		//JDK9 supported it but res.add will throw UnSupportedOperationException
		/*List<String> res = List.of();
		src.stream()
		   .peek(v -> { if (v.contains("Java")) res.add(v); })
		   .count();
		int a = (res.size() > 0);*/
		//B
		Optional<String> findAny = src.stream().filter(v -> v.contains("Java")).findAny();
		System.out.print(findAny.get());
		//C is the fast
		boolean anyMatch = src.stream().anyMatch(v -> v.contains("Java"));
		//option C  equal to the below code
		/*boolean exist = false;
		for (String str : src) {
			if(str.contains("Java")){
				exist = true;
			}
		}
		System.out.println(exist);*/
		//D
		List<String> list = src.stream()
		           .filter(v -> v.contains("Java"))
		           .collect(Collectors.toList());
		
		
	}

	public static void setMethod() {
		//JAVA9		List.of
//		{List<String> v = List.of("Java", "8", "is", "great");}
		
		{String[] arr = {"Java", "8", "is", "great"};
		List<String> v = Arrays.asList(arr);
		v.set(0, "");
		v.add("");// will throw  java.lang.UnsupportedOperationException
		}
		
		
		{
			//JAVA10 List.copyOf
//			List<String> v = List.copyOf(List.of("Java", "8", "is", "great"));
		}
		
		{
//			List<String> v = List.copyOf(new ArrayList<>(List.of("Java", "8", "is","great")));
		}
	}

	public static void sameVariableName() {
		System.out.print(Math.round(1.8));
		{Runnable r = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};}
		
		{Runnable r = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};}
		
		{int a = 10;}
		{int a = 10;}
	}
}

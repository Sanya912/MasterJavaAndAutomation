package linkedlistClass;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		LinkedList<String> placeToVisit = new LinkedList();
		addInOrder(placeToVisit, "Sydney");
		addInOrder(placeToVisit, "Mydney");
		addInOrder(placeToVisit, "Bydney");
		addInOrder(placeToVisit, "Pydney");
		addInOrder(placeToVisit, "Cydney");
		addInOrder(placeToVisit, "Aydney");
		addInOrder(placeToVisit, "Dydney");
		printList(placeToVisit);

		
		addInOrder(placeToVisit, "Alicedney");
		addInOrder(placeToVisit, "Darwin");
		printList(placeToVisit);
		visit(placeToVisit);

	}
	private static void printList(LinkedList<String> linkedlist) {
		Iterator<String> i= linkedlist.iterator();
		while(i.hasNext()) {
			System.out.println("Now visiting " + i.next());
		}
		System.out.println("=================");
	}
	private static boolean addInOrder(LinkedList<String> linkedlist, String newCity) {
		ListIterator<String> stringListIterator = linkedlist.listIterator();
		while (stringListIterator.hasNext()) {
			int comparison = stringListIterator.next().compareTo(newCity);
			if(comparison == 0) {
				System.out.println(newCity + " is already included as a destination");
				return false;
			}else if(comparison>0) {
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			}else if(comparison<0) {
				//move to another city
			}
		}
		stringListIterator.add(newCity);
		return true;
	}
	private static void visit(LinkedList cities) {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean goingForward = true;
		ListIterator<String> listIterator = cities.listIterator();
		
		if(cities.getFirst()=="") {
			System.out.println("No cities in the itenerary");
			return;
		}else {
			System.out.println("New visiting "+ listIterator.next());
			printMenu();
		}
		while(!quit) {
			int action =scanner.nextInt();
			scanner.nextLine();
			switch(action) {
			case 0:
				System.out.println("Holiday over");
				quit = true;
				break;
			case 1:
				if(!goingForward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					goingForward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Nov visiting "+ listIterator.next());
				}else {
					System.out.println("Reached the end of the list");
					goingForward = false;
				}
				break;
			case 2:
				if(goingForward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					goingForward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Nov visiting "+ listIterator.previous());
				}else {
					System.out.println("We at at the start of the list");
					goingForward = true;
				}
				break;
			case 3:
				printMenu();
				break;
			}
		}
	}
	
	
	private static void printMenu() {
		System.out.println("Available actions: \npress");
		System.out.println("0 - to quit\n"
				+ "1 - go to next city\n"+
				  "2 - go to previous city\n"+
				  "3 - print menu options");
	}
}

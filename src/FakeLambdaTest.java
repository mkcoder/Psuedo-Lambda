import static org.junit.Assert.*;

import java.util.*;

import junit.framework.Assert;

import org.junit.Test;


public class FakeLambdaTest {

	// GLOBAL STRING
	@Test
	public void StringOfLessThanFive() {

		List<String> lString = new ArrayList<String>();
		lString.add("Jake");
		lString.add("Jon");
		lString.add("Achliea");
		lString.add("Micheal");
		lString.add("Bob");
		Selector s = new Selector<String, String>(lString, null, new Action<String, String>() {

			@Override
			public boolean invoke(String  item, String statement) {
				
				if (item.length() < 5) {
					return true;
				} else {
					return false;
				}
			}
			
		});
		

		List<String> result = s.invoke();
		assertEquals(3, result.size());
	}
	
	@Test
	public void StringContainsWork()
	{
		List<String> lString = new ArrayList<String>();
		lString.add("A");
		lString.add("B");
		lString.add("AA");
		lString.add("CA");
		lString.add("D");
		lString.add("AD");
		lString.add("AC");
		lString.add("F");
		lString.add("G");
		
		Selector s = new Selector<String, String>(lString,"A", new Action<String, String>() {

			@Override
			public boolean invoke(String  item, String statement) {
				
				if (item.contains(statement)) {
					return true;
				} else {
					return false;
				}
			}
			
		});
		List<String> result = s.invoke();
		
		assertEquals(5, result.size());
	}
	
	@Test
	public void NullActionDefaultsToEquals()
	{
		List<String> lString = new ArrayList<String>();
		lString.add("John");
		lString.add("Blake");
		lString.add("Amy");
		lString.add("Amy");
		lString.add("Amy");
		lString.add("Amy");
		
		Selector s = new Selector<String, String>(lString,"Amy", null);		
		
		List<String> result = s.invoke();
		
		assertEquals(4, result.size());
	}

	// GLOBAL INTEGER
	@Test
	public void GetAllIntegersGreaterThanTen()
	{
		List<Integer> lInteger = new ArrayList<Integer>();
		lInteger.add(10);
		lInteger.add(11);
		lInteger.add(12);
		lInteger.add(15);
		lInteger.add(20);
		lInteger.add(35);
		
		Selector s = new Selector<Integer, Integer>(lInteger,10, new Action<Integer, Integer>(){
			@Override
			public boolean invoke(Integer item, Integer statement)
			{
				if (item > statement) {
					return true;
				} else {
					return false;
				}
			}
		});		
		
		List<Integer> result = s.invoke();
		
		assertEquals(5, result.size());
		
	}
	
	@Test
	public void CusomClassPersonAddSelector()
	{
		List<Person> pList = new ArrayList<Person>();
		pList.add(new Person("Jhon"));
		pList.add(new Person("Amy"));
		pList.add(new Person("Bob"));
		pList.add(new Person("James a"));
		pList.add(new Person("James m"));
		pList.add(new Person("James n"));
		pList.add(new Person("James e"));
		pList.add(new Person("James d"));
		pList.add(new Person("James l"));
		pList.add(new Person("James c"));
		
		Selector s = new Selector<Person, String>(pList, "James", new Action<Person, String> () {
			@Override
			public boolean invoke(Person item, String statement) {
				// TODO Auto-generated method stub
				if (item.GetFullName().contains(statement)) {
					return true;
				} else {
					return false;
				}
			}
		});
		
		List<Person> p = s.invoke();
		for (Person person : p) {
			System.out.println(person.GetFullName());
		}
		
		assertEquals(6, p.size());
	}
	
	@Test
	public void ChangingDifferentActionDoesDifferentThing()
	{
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("John Doe"));
		people.add(	new Person("Amy Doe"));
		people.add(new Person("Bob Hugh"));
		
		Action selectTheTwoMarriedCoupleInTheCompany = new Action<Person, String>() {

			@Override
			public boolean invoke(Person item, String statement) {
				if (item.Lastname(null) == statement) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Action selectPeopleWithNameLongerThanTen = new Action<Person, String>() {

			@Override
			public boolean invoke(Person item, String statement) {
				if (item.Name.length() == 10) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Selector selector = new Selector<Person, String>(people, null, selectTheTwoMarriedCoupleInTheCompany);
		List<Person> person1 = selector.invoke();
		assertSame("They are the smae people", "John Doe", person1.get(0).Name);
	
	}
}


class Person
{
	private Person() {}
	
	public String Name;
	private String firstname;
	private String lastname;
	
	public Person(String name)
	{
		this.Name = name;
		this.firstname = name.split(" ")[0];
		this.lastname = name.split(" ")[1];
	}
	
	public String Firstname(String firstname)
	{
		if (firstname == null) {
			return firstname;
		} else {
			this.firstname = firstname;
			return firstname;
		}
	}
	
	public String Lastname(String lastname)
	{
		if (lastname == null) {
			return lastname;
		} else {
			this.lastname = lastname;
			return lastname;
		}
	}
	
	public String GetFullName()
	{
		return Name;
	}
}
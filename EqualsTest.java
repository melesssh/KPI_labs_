package lab2;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

class EqualsTest {

	@Test
	public void test() {
		Person person=new Person(1,"Child");
		Person person2=new Person(1,"Child");
		Person person3=new Person(400,"NotChild");
		System.out.print(person.toJson());
		
		Assert.assertTrue(person.equals(person));
		Assert.assertFalse(person.equals(person3));
		Assert.assertFalse(person2.equals(person3));
		Assert.assertTrue(person.equals(person3));
	}
	
	public class Person {
		
	    @SerializedName("age")
		public int age;
	    
	    @SerializedName("name")
	    public String name;
		
		public Person(int age,String name) {
			this.age=age;
			this.name=name;
		}
		
		public String toJson() {
			return new Gson().toJson(this);
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj==null) {
				return false;
			}
			// TODO Auto-generated method stub
			return obj==this||((Person)obj).age==this.age&&((Person)obj).name.equals(this.name);
		}
	}

}

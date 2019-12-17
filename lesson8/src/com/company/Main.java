package com.company;

public class Main {

    public static void main(String[] args) {
		User user1 = new User();
		user1.setName("Vasya");
		user1.setAge(16);

		User user2 = new User();
		user2.setName("Vasya");
		user2.setAge(16);

		// user1 не равны user2 поскольку  ссылки user1 и user2
		// указывают разные области памяти
		System.out.println(user1 == user2);
		System.out.println(user1.equals(user2));

		//hashCode()
		System.out.println(user1.hashCode());
		System.out.println(user2.hashCode());
		if (user1.equals(user2)) {
			System.out.println("user1 == user2");
		} else {
			System.out.println("user1 != user2");
		}
		// пример работы фабричного класса

		User user3 = user2;
    	//.!Важно x.equlas (y) == y.equlas (x)
		System.out.println(user3.equals(user2));
		System.out.println(user3.hashCode());

		System.out.println(user1.getClass());

		System.out.println(user1.toString());

		new UserFactory()
				.sigIn("some@mail.ru")
				.sendMessage("helo")
				.deactivate()
				.sendMessage("How are you&")
				.activate()
				.signOut();
	}

}
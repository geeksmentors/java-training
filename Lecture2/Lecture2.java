=============
  
  public class StaticPoly {

    int add(int a, int b){
        return a+b;
    }

    int add(int a, int b, int c)
    {
        return a+b+c;
    }

    String add (String a, String b)
    {
        return a+b;
    }

    public static void main(String[] args) {

        StaticPoly staticPoly = new StaticPoly();

        System.out.println(staticPoly.add(5,20));

        System.out.println(staticPoly.add(5,10,20));

        System.out.println(staticPoly.add("abc","def"));
    }
}


===================
  
  public class AnimalManager {

    public void makeAnimalSound(Animal animal)
    {
        animal.sound();
    }
}


=====
  
  public class Overriding {

    public static void main(String[] args) {
        Lion lion1 = new Lion();
        lion1.sound();

        Cat cat1 = new Cat();
        cat1.sound();

        AnimalManager animalManager = new AnimalManager();
        animalManager.makeAnimalSound(cat1);
        animalManager.makeAnimalSound(lion1);

    }
}

  

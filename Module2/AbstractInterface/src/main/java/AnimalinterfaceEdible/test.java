package AnimalinterfaceEdible;

public class test {
    public static void main(String[] args) {
        Animal[] animal=new Animal[2];
        animal[0]=new Tiger();
        animal[1]=new Chicken();
        for(Animal n:animal){
            System.out.println(n.makeSound());
            if(n instanceof Chicken){
                Edible edibler=(Chicken)n;
                System.out.println(edibler.howToEat());
            }
        }

        System.out.println("------------");
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}

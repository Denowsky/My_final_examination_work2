package Model;

public class AnimalCreate extends Create {

    @Override
    protected Animal createNewAnimal (AnimalType type) {

        switch (type) {
            case Dog:
                return new Dog();
            case Homyak:
                return new Homyak();
            case Cat:
                return new Cat();
            default:
                break;
        }
        return null;
    }
}
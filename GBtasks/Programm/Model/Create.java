package Model;

import java.time.LocalDate;

public abstract class Create {

    protected abstract Animal createNewAnimal(AnimalType type);

    public Animal createPet(AnimalType type, String name, LocalDate date) {

        Animal pet = createNewAnimal(type);
        pet.setName(name);
        pet.setBirthday(date);
        return pet;
    }
}
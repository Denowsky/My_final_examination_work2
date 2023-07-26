package Model;
    
    public enum AnimalType {
    
        Cat,
        Dog,
        Homyak;
    
        public static AnimalType getType (int typeId){
            switch (typeId){
                case 1:
                    return AnimalType.Cat;
                case 2:
                    return AnimalType.Dog;
                case 3:
                    return AnimalType.Homyak;
                default:
                    return null;
            }
        }
}

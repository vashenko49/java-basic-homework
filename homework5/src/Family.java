public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    static {
        System.out.println("Loading a new class Family");
    }
    {
        System.out.println("A new Family object is created");
    }

    public Family(Human mother, Human father) {
        mother.setFamily(this);
        father.setFamily(this);
        this.mother = mother;
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }


    public Human[] getChildren() {
        return children;
    }


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human newChild){

    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Family{");
        stringBuilder.append("mother=");
        stringBuilder.append(mother.toString());
        stringBuilder.append('\'');
        stringBuilder.append("father=");
        stringBuilder.append(father.toString());
        stringBuilder.append('\'');


        stringBuilder.append("children=");
        if(children!=null && children.length>0){
            for (int i = 0; i < children.length; i++) {
                stringBuilder.append("{");
                stringBuilder.append(children[i].toString());
                stringBuilder.append("}");
                if (i != children.length - 1) {
                    stringBuilder.append(", ");
                }
            }
        }
        stringBuilder.append('\'');

        stringBuilder.append("pet=");
        stringBuilder.append(pet.toString());
        stringBuilder.append('\'');

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

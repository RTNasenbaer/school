public class Patient implements Element{

    private String name;
    private int age;

    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getInfo() {
        return "{name: " + name + ", age: " + age + "}";
    }
}

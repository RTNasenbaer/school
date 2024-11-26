public class Test {

    private Queue list = new Queue();
    private String[] names = {
            "Hans",
            "Peter",
            "Christoph",
            "Dieter",
            "Andi",
            "Anna"
    };

    public static void main(String[] args) {
        new Test().run();
    }

    private void run() {

        for (String name : names) {
            list.insertSorted(new Patient(name, (int) (Math.random() * 100)));
        }

        list.removeLast();
        System.out.println((list.removeSpecified(list.search("Andi")).getInfo().isEmpty()) ? "nicht gefunden" : "gefunden");
        System.out.println(list.display());

    }

}

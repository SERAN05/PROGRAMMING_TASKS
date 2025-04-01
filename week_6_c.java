interface Animal {
    void sound();
}

public class week_6_c {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            public void sound() {
                System.out.println("The dog barks.");
            }
        };
        dog.sound();
    }
}

public class week_6_b {
    public static void main(String[] args) {
        try {
            validate(19);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void validate(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age is below 18.");
        }
        else
        {
            System.out.println("age is above 18");
        }
    }
}

public class Admin extends User {
    private final String username;
    private final String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim); // panggil constructor dari User
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Username: " + username);
    }
}

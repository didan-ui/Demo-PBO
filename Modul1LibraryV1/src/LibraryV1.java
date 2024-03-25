import java.util.Scanner;

public class LibraryV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Variabel data pengguna
        String userAdmin = "admin";
        String pwAdmin = "admin";
        String NIM = "";

        boolean exit = false;

        while (!exit) {
            //Tampilan Menu
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");

            //Input Pilihan
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();

            //Proses Pilihan
            switch (option) {
                case 1:
                    // Input NIM Mahasiswa dari Pengguna
                    System.out.print("Enter mahasiswa NIM (15 digits): ");
                    NIM = scanner.next();
                    mahasiswaLogin(scanner, NIM);
                    break;
                case 2:
                    adminLogin(scanner, userAdmin, pwAdmin);
                    break;
                case 3:
                    System.out.println("Goodbye! Have a Nice Day");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        //Tutup Scanner
        scanner.close();
    }

    //Fungsi untuk login mahasiswa
    private static void mahasiswaLogin(Scanner scanner, String NIM) {

        if (NIM.length() == 15 ) {
            System.out.println("Successful Login as Student");
        } else {
            System.out.println("Invalid NIM. Student login failed.");
        }
    }

    //Fungsi untuk login admin
    private static void adminLogin(Scanner scanner, String adminUsername, String adminPassword) {
        System.out.print("Enter username admin: ");
        String inputUsername = scanner.next();
        System.out.print("Enter password admin: ");
        String inputPassword = scanner.next();

        if (inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)) {
            System.out.println("Successful Login as Admin");
        } else {
            System.out.println("Invalid username or password. Admin login failed.");
        }
    }
}

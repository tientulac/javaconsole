import DAO.PriorityQueueDAO;
import Model.PriorityQueue;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws SQLException {
        int choiceNumber;
        Scanner scanner = new Scanner(System.in);
        PriorityQueueDAO priorityQueueDAO = new PriorityQueueDAO();
        for (;;) {
            System.out.println("1. Add reservation");
            System.out.println("2. Modify passenger records");
            System.out.println("3. Display passenger records");
            System.out.println("4. Exit");

            do {
                System.out.println("Input your choice (1/2/3/4): ");
                choiceNumber = scanner.nextInt();
            } while ((choiceNumber < 1) || (choiceNumber > 4));

            switch (choiceNumber) {
                case 1:
                    System.out.println("------INSERT------");
                    PriorityQueue pq = new PriorityQueue();
                    System.out.println("Input Name:");
                    String name = scanner.next();
                    pq.setPassengerName(name);
                    System.out.println("Input Address:");
                    String address = scanner.next();
                    pq.setAddress(address);
                    System.out.println("Input Phone:");
                    scanner.nextLine();
                    String phone = scanner.next();
                    pq.setPhone(phone);

                    System.out.println("Input Date Of Departure (yyyy-mm-dd):");
                    String dateOfDeparture = scanner.next();
                    Date dateOD= Date.valueOf(dateOfDeparture);//converting string into sql date
                    pq.setDateOfDeparture(dateOD);

                    System.out.println("Input Date Of Return (yyyy-mm-dd):");
                    String dateOfReturn = scanner.next();
                    Date dateOR= Date.valueOf(dateOfReturn);//converting string into sql date
                    pq.setDateOfDeparture(dateOR);
                    pq.setDateOfReturn(dateOR);

                    var rsInsert = priorityQueueDAO.save(pq, 1);
                    if (rsInsert != null) {
                        System.out.println("Add successfully !");
                    }
                    else {
                        System.out.println("Add failed !");
                    }
                    break;
                case 2:
                    System.out.println("------MODIFY------");
                    PriorityQueue pqUpdate = new PriorityQueue();
                    System.out.println("Input Name:");
                    String nameFind = scanner.next();
                    if (priorityQueueDAO.findByName(nameFind) > 0) {
                        System.out.println("Input Name to modify:");
                        String nameUpdate = scanner.next();
                        pqUpdate.setPassengerName(nameUpdate);
                        System.out.println("Input Address:");
                        String addressUpdate = scanner.next();
                        pqUpdate.setAddress(addressUpdate);
                        System.out.println("Input Phone:");
                        scanner.nextLine();
                        String phoneUpdate = scanner.next();
                        pqUpdate.setPhone(phoneUpdate);

                        System.out.println("Input Date Of Departure (yyyy-mm-dd):");
                        String dateOfDepartureUpdate = scanner.next();
                        Date dateODUpdate= Date.valueOf(dateOfDepartureUpdate);//converting string into sql date
                        pqUpdate.setDateOfDeparture(dateODUpdate);

                        System.out.println("Input Date Of Return (yyyy-mm-dd):");
                        String dateOfReturnUpdate = scanner.next();
                        Date dateORUpdate= Date.valueOf(dateOfReturnUpdate);//converting string into sql date
                        pqUpdate.setDateOfDeparture(dateORUpdate);
                        pqUpdate.setDateOfReturn(dateORUpdate);

                        pqUpdate.setReservationID(priorityQueueDAO.findByName(nameFind));
                        var rsUpdate = priorityQueueDAO.save(pqUpdate, 2);
                        if (rsUpdate != null) {
                            System.out.println("Modify successfully !");
                        }
                        else {
                            System.out.println("Modify failed !");
                        }
                    }
                    else {
                        System.out.println("Record is not exist !");
                    }
                    break;
                case 3:
                    System.out.println("------DISPLAY ALL------");
                    for (PriorityQueue _pq : priorityQueueDAO.findAll())
                    {
                        System.out.println(
                        String.format("%d. PassengerName: %s - Address: %s - Phone: %s - DateOfDeparture: %s - DateOfReturn: - %s \n",
                                _pq.getReservationID(),_pq.getPassengerName(),_pq.getAddress(),_pq.getPhone(),_pq.getDateOfDeparture().toString(),_pq.getDateOfReturn().toString())
                        );
                    }
                    break;
                case 4:
                    System.out.println("Goodbye !");
                    System.exit(0); // thoát chương trình
                    break;
            }
        }
    }
}

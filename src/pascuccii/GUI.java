package pascuccii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*Визуальное представление телефонной книги – то, что мы видим на экране
компьютера/телефона/планшета. С помощью визуального интерфейса пользователь
общается с объектом «Телефонная книга».
	- может показать нам список всех записей.
	- может показать нам список всех контактов.
	- может показать информацию о конкретной записи.
	- может показать информацию о конкретном контакте.*/

public class GUI extends JFrame {
    private PhoneBook phoneBook;
    private JList<Note> notesList;
    private JList<Contact> contactsList;
    private JButton printAllContactsButton;
    private DefaultListModel<Note> notesModel;
    private DefaultListModel<Contact> contactsModel;
    private String[] myList = {"Ирина",
            "Андрей",
            "Николай",
            "Екатерина",
            "Павел",
    };

    GUI() {
        super("Phone book");
        phoneBook = new PhoneBook();
        phoneBook.addNote("Глеб");
        phoneBook.addContact("Глеб", "+375 (44) 543-53-90", "Козлова 13-25");
        phoneBook.addContact("Глеб", "293-34-55", "Козлова 20-25");
        phoneBook.addContact("Глеб", "555-45-45", "Самоцветная 131");
        phoneBook.addNote("Антон");
        phoneBook.addContact("Антон", "+375 (29) 465-02-85", "Независимости 16");
        phoneBook.addContact("Антон", "266-50-84", "Горького 2");
        phoneBook.addNote("Дмитрий");
        phoneBook.addContact("Дмитрий", "+375 (17) 465-02-75", "Гикало 22");
        phoneBook.addContact("Дмитрий", "295-73-05", "Гикало 20-25");
        phoneBook.addContact("Дмитрий", "265-02-77", "Платонова 131");
        phoneBook.printAll();

       /* phoneBook.removeContactsOf("Глеб"); //удаление всех контактов Глеба (сама запись останется)
        phoneBook.printAll();

        phoneBook.removeNote("Антон"); //удаление запись (удаляться и все контакты)
        phoneBook.printAll();
*/
        System.out.println("\n\nNotes:");
        for (Note n : phoneBook.getNotes())
            System.out.println(n);

        System.out.println("\n\nContacts:");
        for (Contact c : phoneBook.getContacts())
            System.out.println(c);

        System.out.println(phoneBook.findNoteViaContact("295-73-05", "Гикало 20-25"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 360);
        setLocation(360, 240);
        setLayout(null);

        notesModel = new DefaultListModel<>();
        contactsModel = new DefaultListModel<>();
        notesList = new JList<Note>(notesModel);
        contactsList = new JList<Contact>(contactsModel);
        printAllContactsButton = new JButton("Все контакты");

        notesList.setBackground(Color.lightGray);
        contactsList.setBackground(Color.lightGray);
        notesList.setSize(120, 260);
        contactsList.setSize(550, 260);
        notesList.setLocation(20, 30);
        contactsList.setLocation(150, 30);

        printAllContactsButton.setSize(160, 25);
        printAllContactsButton.setLocation(200, 0);
        printAllContactsButton.addActionListener(actionEvent -> printAllContacts());

        notesList.addMouseListener(new ButtonActionListener());

        add(notesList);
        add(contactsList);
        add(printAllContactsButton);

        for (Note n : phoneBook.getNotes())
            notesModel.addElement(n);
    }

    public class ButtonActionListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (notesList.getSelectedValue() != null) {
                contactsModel.clear();
                for (Contact c : notesList.getSelectedValue().getContacts())
                    contactsModel.addElement(c);
            }
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }

    public void printAllContacts() {
        contactsModel.clear();
        for (Contact c : phoneBook.getContacts())
            contactsModel.addElement(c);
    }
}

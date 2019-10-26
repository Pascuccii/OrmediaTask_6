package pascuccii;

import java.util.ArrayList;
import java.util.List;

/*Контактная книга – объект, хранящий в себе данные о записях и контактах.
Из него мы можем получить списки записей и контактов. Так же мы можем добавлять
и удалять записи/контакты.
	- предоставляет возможность получения полного списка записей (ссылок на записи)
	- предоставляет возможность получения полного списка ссылок на контакты.
	- предоставляет возможность добавления записи.
	- предоставляет возможность удаления записи.
	- предоставляет возможность добавления контакта.
	- предоставляет возможность удаления контакта.
	- предоставляет возможность поиска записи по имени.
	- предоставляет возможность поиска записи по контактным данным (контакту).*/
public class PhoneBook {
    private List<Note> notes;
    private List<Contact> contacts;

    public PhoneBook() {
        notes = new ArrayList<>();
        contacts = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public boolean addNote(String name) {
        for (Note n : notes)
            if (n.getName().equals(name))
                return false;
        notes.add(new Note(name));
        return true;
    }

    public boolean addContact(String master) {
        for (Note n : notes)
            if (n.getName().equals(master)) {
                Contact newContact = new Contact(n);
                contacts.add(newContact);
                n.addContact(newContact);
                return true;
            }
        return false;
    }

    public boolean addContact(String master, String phone, String address) {
        for (Note n : notes)
            if (n.getName().equals(master)) {
                Contact newContact = new Contact(n, phone, address);
                contacts.add(newContact);
                n.addContact(newContact);
                return true;
            }
        return false;
    }

    public boolean removeNote(String name) {
        removeContactsOf(name);
        for (Note n : notes)
            if (n.getName().equals(name)) {
                notes.remove(n);
                return true;
            }
        return false;
    }

    public boolean removeNote(int id) {
        for (Note n : notes)
            if (n.getId() == id) {
                notes.remove(n);
                return true;
            }
        return false;
    }

    public boolean removeContactsOf(String name) {
        boolean result = false;
        List<Contact> newList = new ArrayList<>();
        for (Contact c : contacts)
            if (!c.getMaster().getName().equals(name)) {
                newList.add(c);
                result = true;
            }
        contacts = newList;
        findNote(name).clearContacts();
        return result;
    }

    public boolean removeContact(int id) {
        for (Contact c : contacts)
            if (c.getId() == id) {
                contacts.remove(c);
                return true;
            }
        return false;
    }

    public void printAll() {
        System.out.println("\n\n\n\n\n");
        int i = 0;
        for (Note n : notes) {
            i = 0;
            System.out.println("Note(" + n.getName() + "):");
            for (Contact c : n.getContacts())
                System.out.println("\t\t" + ++i + ". Phone: " + c.getPhone() + " Address: " + c.getAddress());
        }
    }

    public void printNotes() {
        for (Note n : notes)
            System.out.println(n);
    }

    public void printContacts() {
        for (Contact c : contacts)
            System.out.println(c);
    }

    public Note findNote(String name) {
        for (Note n : notes)
            if (n.getName().equals(name))
                return n;
        return null;
    }

    public Note findNoteViaContact(Contact contact) {
        for (Note n : notes)
            for (Contact c : n.getContacts())
                if(c.getPhone().equals(contact.getPhone()) && c.getAddress().equals(contact.getAddress()))
                    return n;
        return null;
    }

    public Note findNoteViaContact(String phone, String address) {
        for (Note n : notes)
            for (Contact c : n.getContacts())
                if(c.getPhone().equals(phone.trim()) && c.getAddress().equals(address.trim()))
                    return n;
        return null;
    }
}

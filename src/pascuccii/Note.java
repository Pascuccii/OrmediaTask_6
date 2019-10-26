package pascuccii;
/*Запись в телефонной книге – какая-то абстрактная сущность, из которой можно получить имя человека,
для которого создавалась запись, и список его контактов.
Список контактов может быть пустым или контактов может быть множество.
то есть нам необходимо, чтобы объект этой сущности реализовывал следующие возможности:
- мы можем получить имя человека, которому «посвящена» запись просто как строку.
- мы можем получить список его контактов (список ссылок на его контакты).
- мы можем добавить ему какой-то новый контакт.
- мы можем удалить какой-то его контакт.*/

import java.util.ArrayList;
import java.util.List;

public class Note {
    private static int idCounter = 0;
    private int id;
    private String name;
    private List<Contact> contacts;

    public int getId() {
        return id;
    }

    public Note() {
        id = ++idCounter;
        contacts = new ArrayList<>();
    }

    public Note(String name) {
        id = ++idCounter;
        this.name = name;
        contacts = new ArrayList<>();
    }

    public Note(String name, List<Contact> contacts) {
        id = ++idCounter;
        this.name = name;
        this.contacts = contacts;
        contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public void removeContact(int contactId) {
        contacts.remove(contactId);
    }

    public void clearContacts() {
        contacts.clear();
    }

    @Override
    public String toString() {
        return name;
    }
}

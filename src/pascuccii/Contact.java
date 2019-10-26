package pascuccii;
/*Контакт – телефонный номер или адрес, принадлежащий какому-то человеку.
Из этой сущности мы можем получить строковое представление телефонного номера
или адреса и сущность «Запись в книге», которой принадлежит этот Контакт.
	то есть:
	-мы можем получить телефонный номер, либо адрес просто как строку.
	- мы можем получить ссылку на запись в телефонной книге, откуда этот контакт.*/
public class Contact {
    private static int idCounter = 0;
    private int id;
    private Note master;
    private String phone;
    private String address;

    public Contact(Note master) {
        id = ++idCounter;
        this.master = master;
    }

    public Contact(Note master, String phone, String address) {
        id = ++idCounter;
        this.master = master;
        this.phone = phone;
        this.address = address;
    }

    public void remove() {
        master.removeContact(id);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Note getMaster() {
        return master;
    }

    public void setMaster(Note master) {
        this.master = master;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return getMaster().getName() + ": Номер телефона = " + phone + ", Адрес = " + address;
    }
}


package model;

public enum Gender {
    MALE(1, "Nam"), FEMALE (2, "Nữ"), OTHER(3, "Khác");

    private Gender(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Gender findById(long id) {
        for (Gender e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    private long id;
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

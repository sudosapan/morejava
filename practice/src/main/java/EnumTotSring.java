enum Cities {
    MEERUT("Meerut1"), GURUGRAM("Gurgaon1");

    String cityName;


    Cities(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }


    public static Cities fromValue(String name) {
        for (Cities city : values()) {
            if (city.cityName.equals(name)) return city;
        }
        throw new IllegalArgumentException(
                "No enum constant " + name);
    }


}

public class EnumTotSring {
    public static void main(String[] args) {
        System.out.println(Cities.values());
        System.out.println(Cities.MEERUT);
        System.out.println(Cities.GURUGRAM);
        System.out.println(Cities.fromValue(null));
    }
}

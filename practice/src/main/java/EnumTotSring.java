public class EnumTotSring {
    public static void main(String[] args) {
        System.out.println(Cities.values());
        System.out.println(Cities.MEERUT);
        System.out.println(Cities.GURUGRAM);
    }
}


enum Cities {
    MEERUT("Meerut"), GURUGRAM("Gurgaon");

    String cityName;


    Cities(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }

}

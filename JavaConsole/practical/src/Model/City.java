package Model;

public class City {
    private int CityId;
    private String CityName;

    public City(int cityId, String cityName) {
        CityId = cityId;
        CityName = cityName;
    }

    public City() {

    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }
}

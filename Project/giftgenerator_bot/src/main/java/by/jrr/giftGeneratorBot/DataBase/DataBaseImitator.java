package by.jrr.giftGeneratorBot.DataBase;
import java.util.ArrayList;
import java.util.List;

public class DataBaseImitator {
    static final String MALE = "male";
    static final  String FEMALE = "female";

    public List<String> switcher(String gender, String relation){
        if (gender.equals(MALE) && relation.equals("father")){
            return maleFatherArray();
        } else if (gender.equals(MALE) && relation.equals("husband")){
            return maleHusbandArray();
        } else if (gender.equals(MALE) && relation.equals("son")){
            return maleSonArray();
        } else if (gender.equals(FEMALE) && relation.equals("wife")){
            return femaleWifeArray();
        } else if (gender.equals(FEMALE) && relation.equals("mother")){
            return femaleMotherArray();
        } else if (gender.equals(FEMALE) && relation.equals("daughter")){
            return femaleDaughterArray();
        } else {
            throw new RuntimeException("Wrong parameters"); //make own Exception
        }
    }

    public List<String> maleFatherArray(){
        List<String> maleFather = new ArrayList<>();
        maleFather.add("https://oz.by/toothbrushes/more10947953.html");
        maleFather.add("https://oz.by/breathalyzers/more10960141.html");
        maleFather.add("https://oz.by/tea/more10681087.html");
        return maleFather;
    }

    public List<String> maleHusbandArray(){
        List<String> maleHusband = new ArrayList<>();
        maleHusband.add("https://oz.by/thermoses/more10212198.html");
        maleHusband.add("https://oz.by/headsets/more10742545.html");
        maleHusband.add("https://oz.by/mugs/more10999549.html");
        return maleHusband;
    }

    public List<String> maleSonArray(){
        List<String> maleSon = new ArrayList<>();
        maleSon.add("https://oz.by/moneyboxes/more10626179.html");
        maleSon.add("https://oz.by/boardgames/more1095150.html");
        maleSon.add("https://oz.by/toycars/more10854272.html");
        return maleSon;
    }

    public List<String> femaleWifeArray(){
        List<String> femaleWife = new ArrayList<>();
        femaleWife.add("https://oz.by/eyeshadow/more10991005.html");
        femaleWife.add("https://oz.by/plates/more10940671.html");
        femaleWife.add("https://oz.by/earrings/more10921076.html");
        return femaleWife;
    }

    public List<String> femaleMotherArray(){
        List<String> femaleMother = new ArrayList<>();
        femaleMother.add("https://oz.by/irons/more10956470.html");
        femaleMother.add("https://oz.by/clocks/more10750854.html");
        femaleMother.add("https://oz.by/coffee/more10972706.html");
        femaleMother.add("https://shtuki.ua/podarki/zhvachka-ecogo-anti-fuck-up-/");
        return femaleMother;
    }

    public List<String> femaleDaughterArray(){
        List<String> femaleDaughter = new ArrayList<>();
        femaleDaughter.add("https://oz.by/notebooks/more10546764.html");
        femaleDaughter.add("https://oz.by/accessories/more10941172.html");
        femaleDaughter.add("https://oz.by/books/more1081858.html");
        femaleDaughter.add("https://e-pandora.ua/product/namistina_sestri_nazavzhdi?gclid=Cj0KCQjw9YWDBhDyARIsADt6sGaZyxD9Eadt8K1HD3qETnlbdRyyVDxcjKJoZJuT8kbVUIcFhIeLyq0aAryCEALw_wcB");
        femaleDaughter.add("https://shtuki.ua/podarki/chashka-s-zavarnikom-shtuki-kot-chernaya/?utm_source=google&utm_medium=surfaces&utm_campaign=Main-feed_RU&gclid=Cj0KCQjw9YWDBhDyARIsADt6sGax93exOpLdDLj9fkrb-t6B1Tm25J10vwl2MPRHM-cP4AWrPhXGCw8aAlAiEALw_wcB");
        return femaleDaughter;
    }
}

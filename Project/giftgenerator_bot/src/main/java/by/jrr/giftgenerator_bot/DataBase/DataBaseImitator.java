package by.jrr.giftgenerator_bot.DataBase;
import java.util.ArrayList;

public class DataBaseImitator {
    public ArrayList<String> switcher(String gender, String relation){
        if (gender == "male" && relation == "father"){
            return m_father_array();
        } else if (gender == "male" && relation == "husband"){
            return m_husband_array();
        } else if (gender == "male" && relation == "son"){
            return m_son_array();
        } else if (gender == "female" && relation == "wife"){
            return f_wife_array();
        } else if (gender == "female" && relation == "mother"){
            return f_mother_array();
        } else if (gender == "female" && relation == "daughter"){
            return f_daughter_array();
        } else {
            throw new RuntimeException("Wrong parameters");
        }
    }

    public ArrayList<String> m_father_array(){
        ArrayList<String> m_father = new ArrayList<>();
        m_father.add("https://oz.by/toothbrushes/more10947953.html");
        m_father.add("https://oz.by/breathalyzers/more10960141.html");
        m_father.add("https://oz.by/tea/more10681087.html");
        return m_father;
    }

    public ArrayList<String> m_husband_array(){
        ArrayList<String> m_husband = new ArrayList<>();
        m_husband.add("https://oz.by/thermoses/more10212198.html");
        m_husband.add("https://oz.by/headsets/more10742545.html");
        m_husband.add("https://oz.by/mugs/more10999549.html");
        return m_husband;
    }

    public ArrayList<String> m_son_array(){
        ArrayList<String> m_son = new ArrayList<>();
        m_son.add("https://oz.by/moneyboxes/more10626179.html");
        m_son.add("https://oz.by/boardgames/more1095150.html");
        m_son.add("https://oz.by/toycars/more10854272.html");
        return m_son;
    }

    public ArrayList<String> f_wife_array(){
        ArrayList<String> f_wife = new ArrayList<>();
        f_wife.add("https://oz.by/eyeshadow/more10991005.html");
        f_wife.add("https://oz.by/plates/more10940671.html");
        f_wife.add("https://oz.by/earrings/more10921076.html");
        return f_wife;
    }

    public ArrayList<String> f_mother_array(){
        ArrayList<String> f_mother = new ArrayList<>();
        f_mother.add("https://oz.by/irons/more10956470.html");
        f_mother.add("https://oz.by/clocks/more10750854.html");
        f_mother.add("https://oz.by/coffee/more10972706.html");
        f_mother.add("https://shtuki.ua/podarki/zhvachka-ecogo-anti-fuck-up-/");
        return f_mother;
    }

    public ArrayList<String> f_daughter_array(){
        ArrayList<String> f_daughter = new ArrayList<>();
        f_daughter.add("https://oz.by/notebooks/more10546764.html");
        f_daughter.add("https://oz.by/accessories/more10941172.html");
        f_daughter.add("https://oz.by/books/more1081858.html");
        f_daughter.add("https://e-pandora.ua/product/namistina_sestri_nazavzhdi?gclid=Cj0KCQjw9YWDBhDyARIsADt6sGaZyxD9Eadt8K1HD3qETnlbdRyyVDxcjKJoZJuT8kbVUIcFhIeLyq0aAryCEALw_wcB");
        f_daughter.add("https://shtuki.ua/podarki/chashka-s-zavarnikom-shtuki-kot-chernaya/?utm_source=google&utm_medium=surfaces&utm_campaign=Main-feed_RU&gclid=Cj0KCQjw9YWDBhDyARIsADt6sGax93exOpLdDLj9fkrb-t6B1Tm25J10vwl2MPRHM-cP4AWrPhXGCw8aAlAiEALw_wcB");
        return f_daughter;
    }
}

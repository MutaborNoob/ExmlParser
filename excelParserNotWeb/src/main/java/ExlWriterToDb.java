import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.Record;
import org.hibernate.Session;

public class ExlWriterToDb {

    public void writeTo(HashMap<Integer, List<Object>> data, Session session){
       //PS тут не самое лучшее решение(возможно, лучше через билдер и отдельно класс\метод для маппинга), но решил его оставить, тк тз расчитано на конкретную таблицу в икселе
        for(int i = 3; i < data.keySet().size(); i++){
            System.out.println(data.get(i));
            Record record = new Record(Integer.parseInt(data.get(i).get(0).toString()),
                    (String) data.get(i).get(1), createDate(),
                    Integer.parseInt(data.get(i).get(2).toString()), Integer.parseInt(data.get(i).get(3).toString()),
                    Integer.parseInt(data.get(i).get(4).toString()), Integer.parseInt(data.get(i).get(5).toString()),
                    Integer.parseInt(data.get(i).get(6).toString()), Integer.parseInt(data.get(i).get(7).toString()),
                    Integer.parseInt(data.get(i).get(8).toString()), Integer.parseInt(data.get(i).get(9).toString()));
            session.save(record);
        }

    }

    private Date createDate(){

        Calendar cal = Calendar.getInstance();
        int day = (int) (1 + Math.random()*29);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, 3);
        cal.set(Calendar.YEAR, 2013);

        return cal.getTime();

    }

}

import org.hibernate.Session;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ExlReader exlReader = new ExlReader();
        //Сюда клади путь к файлу
        exlReader.read("D:\\projectsForTestWork\\excelParserNotWeb\\src\\main\\resources\\testTable .xlsx");
        ExlWriterToDb exlWriterToDb = new ExlWriterToDb();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        exlWriterToDb.writeTo(exlReader.getData(), session);

        writeTotal(session);

        session.getTransaction().commit();
        session.close();

    }

    private static void writeTotal(Session session){
        System.out.println("Тотал по фактическим Qoil, сгруппированный по датам");
        String hql = "select rc.date, sum(rc.factQoilData1) + sum(rc.factQoilData2) from Record as rc group by rc.date";
        List<?> list = session.createQuery(hql).list();
        for (Object o : list) {
            Object[] row = (Object[]) o;
            System.out.println(row[0] + ", " + row[1]);
        }

        System.out.println("Тотал по фактическим Qliq, сгруппированный по датам");
        String hql2 = "select rc.date, sum(rc.factQliqData1) + sum(rc.factQliqData2) from Record as rc group by rc.date";
        List<?> list2 = session.createQuery(hql2).list();
        for (Object o : list2) {
            Object[] row = (Object[]) o;
            System.out.println(row[0] + ", " + row[1]);
        }
    }

}

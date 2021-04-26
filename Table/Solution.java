import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{
        private TableInterface ti;

        public TableInterfaceWrapper(TableInterface ti){
            this.ti = ti;
        }
        
        public void setModel(List rows){
            System.out.println(rows.size());
            ti.setModel(rows);
        }

        public String getHeaderText(){
            return ti.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText){
            ti.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}

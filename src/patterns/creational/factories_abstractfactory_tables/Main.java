package patterns.creational.factories_abstractfactory_tables;

import patterns.creational.factories_abstractfactory_tables.table.Table;
import patterns.creational.factories_abstractfactory_tables.tablefactory.KitchenTableFactory;
import patterns.creational.factories_abstractfactory_tables.tablefactory.OfficeTableFactory;
import patterns.creational.factories_abstractfactory_tables.tablefactory.TableFactory;
import patterns.creational.factories_abstractfactory_tables.tableinstruments.TableInstruments;

public class Main {
    public static void main(String[] args) {
        Table table;
        TableInstruments tableInstruments;

        TableFactory kitchenTableFactory = new KitchenTableFactory();
        TableFactory officeTableFactory = new OfficeTableFactory();

        System.out.println("-I work as a cook. I need a kitchen table");
        System.out.println("-Got It! Give me a sec,- Calling to the KitchenTableFactory." +
                " - Bring me the KitchenTable with KitchenTableInstruments");

        table = kitchenTableFactory.makeTable();
        tableInstruments = kitchenTableFactory.makeTableInstruments();

        System.out.println(table.getTable() + "\n" + tableInstruments.getInstrument());
        System.out.println("-There they are!\n");

        System.out.println("-I am office manager. I need an office table");
        System.out.println("-Got It! Give me a sec,- Calling to the OfficeTableFactory. " +
                "- Bring me the OfficeTable with OfficeTableInstruments");

        table = officeTableFactory.makeTable();
        tableInstruments = officeTableFactory.makeTableInstruments();

        System.out.println(table.getTable() + "\n" + tableInstruments.getInstrument());
        System.out.println("-There they are!");
    }
}

package patterns.creational.factories_abstractfactory_tables.tablefactory;

import patterns.creational.factories_abstractfactory_tables.table.KitchenTable;
import patterns.creational.factories_abstractfactory_tables.table.Table;
import patterns.creational.factories_abstractfactory_tables.tablefactory.TableFactory;
import patterns.creational.factories_abstractfactory_tables.tableinstruments.KitchenTableInstrument;
import patterns.creational.factories_abstractfactory_tables.tableinstruments.TableInstruments;

public class KitchenTableFactory implements TableFactory {
    @Override
    public Table makeTable() {
        return new KitchenTable();
    }

    @Override
    public TableInstruments makeTableInstruments() {
        return new KitchenTableInstrument();
    }
}

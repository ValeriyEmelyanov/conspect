package patterns.creational.factories_abstractfactory_tables.tablefactory;

import patterns.creational.factories_abstractfactory_tables.table.OfficeTable;
import patterns.creational.factories_abstractfactory_tables.table.Table;
import patterns.creational.factories_abstractfactory_tables.tablefactory.TableFactory;
import patterns.creational.factories_abstractfactory_tables.tableinstruments.OfficeTableInstrument;
import patterns.creational.factories_abstractfactory_tables.tableinstruments.TableInstruments;

public class OfficeTableFactory implements TableFactory {
    @Override
    public Table makeTable() {
        return new OfficeTable();
    }

    @Override
    public TableInstruments makeTableInstruments() {
        return new OfficeTableInstrument();
    }
}

package patterns.creational.factories_abstractfactory_tables.tablefactory;

import patterns.creational.factories_abstractfactory_tables.table.Table;
import patterns.creational.factories_abstractfactory_tables.tableinstruments.TableInstruments;

public interface TableFactory {
    Table makeTable();
    TableInstruments makeTableInstruments();
}
